package com.yd.atis.schedule.basic;

import com.yd.atis.constant.SysConstant;
import com.yd.atis.dao.RouteInfoMapper;
import com.yd.atis.dao.SegmentInfoMapper;
import com.yd.atis.dao.StationInfoMapper;
import com.yd.atis.dao.StationSegmentRelationMapper;
import com.yd.atis.dto.AtisInvokeLog;
import com.yd.atis.dto.RouteInfo;
import com.yd.atis.dto.SegmentInfo;
import com.yd.atis.dto.StationInfo;
import com.yd.atis.facade.atisInvokeLog.AtisInvokeLogFacade;
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

    private static AtisBasicWebService_PortType basicService;

    @Value("${logback.logdir}")
    private String logPath;

    @Autowired
    private MailFacade mailFacade;

    @Autowired
    private RouteInfoMapper routeInfoMapper;

    @Autowired
    private SegmentInfoMapper segmentInfoMapper;

    @Autowired
    private StationInfoMapper stationInfoMapper;

    @Autowired
    private AtisInvokeLogFacade atisInvokeLogFacade;

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
    @Scheduled(cron = "0 0/30 8-20 * * ?")
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

    /**
     * 查询站点基础信息，与路线关联
     * @return
     */
    private StationInfoEntity[] getStationInfo() {

        log.info("start to excute getStationInfo()");

        StationInfo stationInfo = stationInfoMapper.selectByRandom();
        StationRequest stationRequest = StationRequest.builder().stationName(stationInfo.getStationName()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getStationInfo")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getStationInfo(stationRequest.getStationId(), stationRequest.getStationName(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getStationInfo")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationInfo() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationInfo() error");
            log.error(e.getMessage());

            sendEmail("getStationInfo接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getStationInfo() error");
            log.error(e.getMessage());

            sendEmail("getStationInfo接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询站点基础信息，不关联路线
     * @return
     */
    private StationInfoEntity[] getStationInfoNoRoute() {

        log.info("start to excute getStationInfoNoRoute()");

        StationInfo stationInfo = stationInfoMapper.selectByRandom();
        StationRequest stationRequest = StationRequest.builder().stationName(stationInfo.getStationName()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getStationInfoNoRoute")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {


            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationInfoNoRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getStationInfoNoRoute(stationRequest.getStationId(), stationRequest.getStationName(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getStationInfoNoRoute")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationInfoNoRoute() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationInfoNoRoute() error");
            log.error(e.getMessage());

            sendEmail("getStationInfoNoRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getStationInfoNoRoute() error");
            log.error(e.getMessage());

            sendEmail("getStationInfoNoRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询所有站点基础信息，与路线关联
     * @return
     */
    private StationInfoEntity[] getAllStation() {

        log.info("start to excute getAllStation()");

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getAllStation")
                .invokeTime(new Date()).invokeStatus(0).exceptDesp("").build();

        try {

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getAllStation" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + "null", true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getAllStation(username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getAllStation")
                    .invokeTime(new Date()).invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getAllStation() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getAllStation() error");
            log.error(e.getMessage());

            sendEmail("getAllStation接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getAllStation() error");
            log.error(e.getMessage());

            sendEmail("getAllStation接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询所有站点基础信息，不与路线关联
     * @return
     */
    private StationInfoEntity[] getAllStationNoRoute() {

        log.info("start to excute getAllStationNoRoute()");

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getAllStationNoRoute")
                .invokeStatus(0).exceptDesp("").build();

        try {

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getAllStationNoRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + "null", true);

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getAllStationNoRoute(username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getAllStationNoRoute")
                    .invokeTime(new Date()).invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getAllStationNoRoute() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getAllStationNoRoute() error");
            log.error(e.getMessage());

            sendEmail("getAllStationNoRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getAllStationNoRoute() error");
            log.error(e.getMessage());

            sendEmail("getAllStationNoRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询线路基础信息
     * @return
     */
    private RouteInfoEntity[] getRouteInfo() {

        log.info("start to excute getRouteInfo()");

        RouteRequest routeRequest = RouteRequest.builder().routeId("-1").routeName("-1").build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getRouteInfo")
                .invokeParam(JsonUtils.toJson(routeRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getRouteInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(routeRequest), true);

            //获取线路基础信息
            RouteInfoEntity[] routes = basicService.getRouteInfo(routeRequest.getRouteId(), routeRequest.getRouteName(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (routes == null || routes.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getRouteInfo")
                    .invokeParam(JsonUtils.toJson(routeRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(routes), true);

            log.info("getRouteInfo() end");

            return routes;
        } catch (BusinessException e) {
            log.info("getRouteInfo() error");
            log.error(e.getMessage());

            sendEmail("getRouteInfo接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getRouteInfo() error");
            log.error(e.getMessage());

            sendEmail("getRouteInfo接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询线路单程基础信息
     * @return
     */
    private SegmentInfoEntity[] getSegmentByRoute() {

        log.info("start to excute getSegmentByRoute()");

        RouteInfo routeInfo = routeInfoMapper.selectByRandom();
        RouteRequest routeRequest = RouteRequest.builder().routeId(routeInfo.getRouteId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getSegmentByRoute")
                .invokeParam(JsonUtils.toJson(routeRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getSegmentByRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(routeRequest), true);

            //获取某一线路的单程信息
            SegmentInfoEntity[] segments = basicService.getSegmentByRoute(routeRequest.getRouteId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (segments == null || segments.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getSegmentByRoute")
                    .invokeParam(JsonUtils.toJson(routeRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(segments), true);

            log.info("getSegmentByRoute() end");

            return segments;
        } catch (BusinessException e) {
            log.info("getSegmentByRoute() error");
            log.error(e.getMessage());

            sendEmail("getSegmentByRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getSegmentByRoute() error");
            log.error(e.getMessage());

            sendEmail("getSegmentByRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询站点线路列表
     * @return
     */
    private RouteInfoEntity[] getRouteByStation() {

        log.info("start to excute getRouteByStation()");

        StationInfo stationInfo = stationInfoMapper.selectByRandom();
        StationRequest stationRequest = StationRequest.builder().stationId(stationInfo.getStationId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getRouteByStation")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getRouteByStation" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取经过某一站点的线路信息
            RouteInfoEntity[] routes = basicService.getRouteByStation(stationRequest.getStationId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (routes == null || routes.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getRouteByStation")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(routes), true);

            log.info("getRouteByStation() end");

            return routes;
        } catch (BusinessException e) {
            log.info("getRouteByStation() error");
            log.error(e.getMessage());

            sendEmail("getRouteByStation接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getRouteByStation() error");
            log.error(e.getMessage());

            sendEmail("getRouteByStation接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询线路单程站点列表
     * @return
     */
    private StationInfoEntity[] getStationBySegment() {

        log.info("start to excute getStationBySegment()");

        SegmentInfo segmentInfo = segmentInfoMapper.selectByRandom();
        SegmentRequest segmentRequest = SegmentRequest.builder().segmentId(segmentInfo.getSegmentId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getStationBySegment")
                .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationBySegment" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //根据单程获取站点信息
            StationInfoEntity[] stations = basicService.getStationBySegment(segmentRequest.getSegmentId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getStationBySegment")
                    .invokeParam(JsonUtils.toJson(segmentRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationBySegment() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationBySegment() error");
            log.error(e.getMessage());

            sendEmail("getStationBySegment接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getStationBySegment() error");
            log.error(e.getMessage());

            sendEmail("getStationBySegment接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 根据位置查询范围内的站点，lonRange,latRange单位为米，有线路关联
     * @return
     */
    private StationInfoEntity[] getStationByGps() {

        log.info("start to excute getStationByGps()");

        StationRequest stationRequest = StationRequest.builder().longitude(112.979885).latitude(28.201137)
                .lonRange(1000.0).latRange(1000.0).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getStationByGps")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationByGps" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //查询附近的站点
            StationInfoEntity[] stations = basicService.getStationByGps(stationRequest.getLongitude(),
                    stationRequest.getLatitude(), stationRequest.getLonRange(), stationRequest.getLatRange(), 1000D, username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getStationByGps")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationByGps() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationByGps() error");
            log.error(e.getMessage());

            sendEmail("getStationByGps接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getStationByGps() error");
            log.error(e.getMessage());

            sendEmail("getStationByGps接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 根据位置查询范围内的站点，lonRange,latRange单位为米，无线路关联
     * @return
     */
    private StationInfoEntity[] getStationByGpsNoRoute() {

        log.info("start to excute getStationByGpsNoRoute()");

        StationRequest stationRequest = StationRequest.builder().longitude(112.979885).latitude(28.201137)
                .lonRange(1000.0).latRange(1000.0).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("getStationByGpsNoRoute")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationByGpsNoRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //查询附近的站点
            StationInfoEntity[] stations = basicService.getStationByGps(stationRequest.getLongitude(),
                    stationRequest.getLatitude(), stationRequest.getLonRange(), stationRequest.getLatRange(), 1000D, username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stations == null || stations.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("getStationByGpsNoRoute")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeTime(new Date())
                    .invokeStatus(invokeStatus).exceptDesp(exceptDesp).build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);

            log.info("getStationByGpsNoRoute() end");

            return stations;
        } catch (BusinessException e) {
            log.info("getStationByGpsNoRoute() error");
            log.error(e.getMessage());

            sendEmail("getStationByGpsNoRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("getStationByGpsNoRoute() error");
            log.error(e.getMessage());

            sendEmail("getStationByGpsNoRoute接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 发送邮件
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    private void sendEmail(String subject, String content) {
        mailFacade.sendSimpleEmail(subject, content);
    }

    /**
     * 新增Atis接口调用日志记录
     * @param atisInvokeLog Atis接口调用日志记录
     */
    private void addAtisInvokeLog(AtisInvokeLog atisInvokeLog) {
        atisInvokeLogFacade.insertSelective(atisInvokeLog);
    }
}
