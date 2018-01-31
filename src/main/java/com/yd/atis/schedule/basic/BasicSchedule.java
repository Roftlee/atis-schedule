package com.yd.atis.schedule.basic;

import com.yd.atis.constant.SysConstant;
import com.yd.atis.facade.mail.MailFacade;
import com.yd.atis.model.BusinessException;
import com.yd.atis.model.RouteInfoEntity;
import com.yd.atis.model.SegmentInfoEntity;
import com.yd.atis.model.StationInfoEntity;
import com.yd.atis.request.route.RouteRequest;
import com.yd.atis.request.segment.SegmentRequest;
import com.yd.atis.request.station.StationRequest;
import com.yd.atis.service.basicService.AtisBasicWebService_PortType;
import com.yd.atis.service.basicService.AtisBasicWebService_ServiceLocator;
import com.yd.atis.service.mail.MailFacadeImpl;
import com.yd.atis.utils.DateUtils;
import com.yd.atis.utils.FileUtils;
import com.yd.atis.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Atis基础服务调用
 * @author AsiQue
 * @since :2018.01.26 17:28
 */
@Component
public class BasicSchedule {

    private final Logger log = LoggerFactory.getLogger(BasicSchedule.class);

    private static String username = "D3DDAD5ECF6D0E87";
    private static String password = "6D8A217D88AFBE9F";
    private static String fileName = "";

    private static AtisBasicWebService_PortType basicService;

    @Value("${logback.logdir}")
    private String logPath;

    @Autowired
    private MailFacade mailFacade;

    private void initService() {
        try {
            
            log.info("start init basic atis web service");
            //基础WebService服务
            AtisBasicWebService_ServiceLocator basicLocator = new AtisBasicWebService_ServiceLocator();
            basicService = basicLocator.getAtisBasicWebServicePort();

            log.info("end init basic atis web service");

        } catch (javax.xml.rpc.ServiceException ex) {

            log.error("init basic atis web service comes to an exception:" + ex.getMessage());
        }
    }

    /**
     * 定时调度任务 每天9点到18点之间每30分钟调用一次
     */
    @Scheduled(cron = "0 0/30 9-18 * * ?")
    public void excuteAtisBasicService() {

        log.info("Atis basic task start!");

        initService();

        //查询站点信息，关联线路
        getStationInfo();

        //查询站点信息，不关联线路
        getStationInfoNoRoute();

        getAllStation();

        getAllStationNoRoute();

        //查询线路信息
        getRouteInfo();

        //查询线路单程信息
        getSegmentByRoute();

        //查询站点线路信息
        getRouteByStation();

        //查询单程站点列表
        getStationBySegment();

        //按位置查找站点
        getStationByGps();

        log.info("Atis basic task end!");

    }

//    @Scheduled(cron = "*/10 * * * * ?")
    private void test() {
        try {
            log.info("start to excute test()");

            StationRequest stationRequest = StationRequest.builder().stationId("-1").stationName("火车站").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取站点基础信息
            StationInfoEntity[] stations = new StationInfoEntity[0];

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("test方法返回null", "test方法返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);


            log.info("excute test() end");

            throw new Exception("this is a manual exception");

        } catch (Exception e) {
            log.info("excute test() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("test方法请求异常", "异常信息：" + e.getStackTrace());
        }
    }

    /**
     * 查询站点基础信息，与路线关联
     * @return
     */
    private StationInfoEntity[] getStationInfo() {

        log.info("start to excute getStationInfo()");

        try {
            StationRequest stationRequest = StationRequest.builder().stationName("高升村").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getStationInfo(stationRequest.getStationId(), stationRequest.getStationName(), username, password);

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("getStationInfo接口返回null", "getStationInfo接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationInfo() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationInfo() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationInfo接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getStationInfo() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationInfo接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询站点基础信息，不关联路线
     * @return
     */
    private StationInfoEntity[] getStationInfoNoRoute() {

        log.info("start to excute getStationInfoNoRoute()");

        try {
            StationRequest stationRequest = StationRequest.builder().stationName("高升村").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationInfoNoRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getStationInfoNoRoute(stationRequest.getStationId(), stationRequest.getStationName(), username, password);

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("getStationInfoNoRoute接口返回null", "getStationInfoNoRoute接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationInfoNoRoute() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationInfoNoRoute() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationInfoNoRoute接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getStationInfoNoRoute() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationInfoNoRoute接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询所有站点基础信息，与路线关联
     * @return
     */
    private StationInfoEntity[] getAllStation() {

        log.info("start to excute getAllStation()");

        try {

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getAllStation" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + "null", true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getAllStation(username, password);

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("getAllStation接口返回null", "getAllStation接口返回null");
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getAllStation() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getAllStation() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getAllStation接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getAllStation() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getAllStation接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询所有站点基础信息，不与路线关联
     * @return
     */
    private StationInfoEntity[] getAllStationNoRoute() {

        log.info("start to excute getAllStationNoRoute()");

        try {

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getAllStationNoRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + "null", true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getAllStationNoRoute(username, password);

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("getAllStationNoRoute接口返回null", "getAllStationNoRoute接口返回null");
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getAllStationNoRoute() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getAllStationNoRoute() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getAllStationNoRoute接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getAllStationNoRoute() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getAllStationNoRoute接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询线路基础信息
     * @return
     */
    private RouteInfoEntity[] getRouteInfo() {

        log.info("start to excute getRouteInfo()");

        try {
            RouteRequest routeRequest = RouteRequest.builder().routeId("-1").routeName("-1").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getRouteInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(routeRequest), true);

            //获取线路基础信息
            RouteInfoEntity[] routes = basicService.getRouteInfo(routeRequest.getRouteId(), routeRequest.getRouteName(), username, password);

            if (routes == null || routes.length == 0) {
                mailFacade.sendSimpleEmail("getRouteInfo接口返回null", "getRouteInfo接口返回null，请求参数：" + JsonUtils.toJson(routeRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(routes), true);

            log.info("getRouteInfo() end");

            return routes;
        } catch (BusinessException e) {
            log.info("getRouteInfo() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getRouteInfo接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getRouteInfo() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getRouteInfo接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询线路单程基础信息
     * @return
     */
    private SegmentInfoEntity[] getSegmentByRoute() {

        log.info("start to excute getSegmentByRoute()");

        try {
            RouteRequest routeRequest = RouteRequest.builder().routeId("284").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getSegmentByRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(routeRequest), true);

            //获取某一线路的单程信息
            SegmentInfoEntity[] segments = basicService.getSegmentByRoute(routeRequest.getRouteId(), username, password);

            if (segments == null || segments.length == 0) {
                mailFacade.sendSimpleEmail("getSegmentByRoute接口返回null", "getSegmentByRoute接口返回null，请求参数：" + JsonUtils.toJson(routeRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(segments), true);

            log.info("getSegmentByRoute() end");

            return segments;
        } catch (BusinessException e) {
            log.info("getSegmentByRoute() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getSegmentByRoute接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getSegmentByRoute() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getSegmentByRoute接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询站点线路列表
     * @return
     */
    private RouteInfoEntity[] getRouteByStation() {

        log.info("start to excute getRouteByStation()");

        try {
            StationRequest stationRequest = StationRequest.builder().stationId("03051164").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getRouteByStation" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取经过某一站点的线路信息
            RouteInfoEntity[] routes = basicService.getRouteByStation(stationRequest.getStationId(), username, password);

            if (routes == null || routes.length == 0) {
                mailFacade.sendSimpleEmail("getRouteByStation接口返回null", "getRouteByStation接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(routes), true);

            log.info("getRouteByStation() end");

            return routes;
        } catch (BusinessException e) {
            log.info("getRouteByStation() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getRouteByStation接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getRouteByStation() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getRouteByStation接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询线路单程站点列表
     * @return
     */
    private StationInfoEntity[] getStationBySegment() {

        log.info("start to excute getStationBySegment()");

        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().segmentId("2731").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationBySegment" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //根据单程获取站点信息
            StationInfoEntity[] stations = basicService.getStationBySegment(segmentRequest.getSegmentId(), username, password);

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("getStationBySegment接口返回null", "getStationBySegment接口返回null，请求参数：" + JsonUtils.toJson(segmentRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationBySegment() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationBySegment() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationBySegment接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getStationBySegment() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationBySegment接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 根据位置查询范围内的站点
     * @return
     */
    private StationInfoEntity[] getStationByGps() {

        log.info("start to excute getStationByGps()");

        try {
            StationRequest stationRequest = StationRequest.builder().longitude(112.979885).latitude(28.201137)
                    .lonRange(0.011).latRange(0.009).build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationByGps" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //查询附近的站点
            StationInfoEntity[] stations = basicService.getStationByGps(stationRequest.getLongitude(),
                    stationRequest.getLatitude(), stationRequest.getLonRange(), stationRequest.getLatRange(), 1000D, username, password);

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("getStationByGps接口返回null", "getStationByGps接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationByGps() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationByGps() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationByGps接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("getStationByGps() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("getStationByGps接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }
}
