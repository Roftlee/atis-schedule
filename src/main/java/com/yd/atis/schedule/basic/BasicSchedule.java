package com.yd.atis.schedule.basic;

import com.yd.atis.constant.SysConstant;
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
import com.yd.atis.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author AsiQue
 * @since :2018.01.26 17:28
 */
@Component
public class BasicSchedule {

    private static Logger logger = LoggerFactory.getLogger(BasicSchedule.class);

    private static String username = "D3DDAD5ECF6D0E87";
    private static String password = "6D8A217D88AFBE9F";
    private static String fileName = "";

    private static AtisBasicWebService_PortType basicService;

    private void initService() {
        try {

            logger.info("start init basic atis web service");
            //基础WebService服务
            AtisBasicWebService_ServiceLocator basicLocator = new AtisBasicWebService_ServiceLocator();
            basicService = basicLocator.getAtisBasicWebServicePort();

            logger.info("end init basic atis web service");

        } catch (javax.xml.rpc.ServiceException ex) {

            logger.error("init basic atis web service comes to an exception:" + ex.getMessage());
        }
    }

    @Scheduled(cron = "0/3 * * * * ?")
    private void excuteAtisBasicService() {
//        initService();

        System.out.printf("schedule task run ****************************");

        logger.info("Atis basic task start!");

//        //查询站点信息
//        getStationInfo();
//
//        //查询线路信息
//        getRouteInfo();
//
//        //查询线路单程信息
//        getSegmentByRoute();
//
//        //查询站点线路信息
//        getRouteByStation();
//
//        //查询单程站点列表
//        getStationBySegment();
//
//        //按位置查找站点
//        getStationByGps();

        logger.info("Atis basic task end!");

    }

    /**
     * 查询站点基础信息
     * @return
     */
    private StationInfoEntity[] getStationInfo() {

        try {
            StationRequest stationRequest = StationRequest.builder().stationId("-1").stationName("火车站").build();



            String fileName = PropertyUtils.getProperty(SysConstant.LOG_PATH) + DateUtils.format(new Date(), "yyyyMMdd") + "/getStationInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            logger.info("parameters:" + JsonUtils.toJson(stationRequest));

            //获取站点基础信息
            StationInfoEntity[] stations = basicService.getStationInfo(stationRequest.getStationId(), stationRequest.getStationName(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);
            logger.info("results:" + JsonUtils.toJson(stations));

            return stations;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 查询线路基础信息
     * @return
     */
    private RouteInfoEntity[] getRouteInfo() {
        try {
            RouteRequest routeRequest = RouteRequest.builder().routeId("-1").routeName("-1").build();

            String fileName = PropertyUtils.getProperty(SysConstant.LOG_PATH) + DateUtils.format(new Date(), "yyyyMMdd") + "/getRouteInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(routeRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(routeRequest));

            //获取线路基础信息
            RouteInfoEntity[] routes = basicService.getRouteInfo(routeRequest.getRouteId(), routeRequest.getRouteName(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(routes), true);
            logger.info("results:" + JsonUtils.toJson(routes));

            return routes;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询线路单程基础信息
     * @return
     */
    private SegmentInfoEntity[] getSegmentByRoute() {
        try {
            RouteRequest routeRequest = RouteRequest.builder().routeId("284").build();

            String fileName = PropertyUtils.getProperty(SysConstant.LOG_PATH) + DateUtils.format(new Date(), "yyyyMMdd") + "/getSegmentByRoute" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(routeRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(routeRequest));

            //获取某一线路的单程信息
            SegmentInfoEntity[] segments = basicService.getSegmentByRoute(routeRequest.getRouteId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(segments), true);
            logger.info("results:" + JsonUtils.toJson(segments));

            return segments;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询站点线路列表
     * @return
     */
    private RouteInfoEntity[] getRouteByStation() {
        try {
            StationRequest stationRequest = StationRequest.builder().stationId("03051164").build();

            String fileName = PropertyUtils.getProperty(SysConstant.LOG_PATH) + DateUtils.format(new Date(), "yyyyMMdd") + "/getRouteByStation" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(stationRequest));

            //获取经过某一站点的线路信息
            RouteInfoEntity[] routes = basicService.getRouteByStation(stationRequest.getStationId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(routes), true);
            logger.info("results:" + JsonUtils.toJson(routes));

            return routes;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询线路单程站点列表
     * @return
     */
    private StationInfoEntity[] getStationBySegment() {
        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().segmentId("2731").build();

            String fileName = PropertyUtils.getProperty(SysConstant.LOG_PATH) + DateUtils.format(new Date(), "yyyyMMdd") + "/getStationBySegment" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(segmentRequest));

            //根据单程获取站点信息
            StationInfoEntity[] stations = basicService.getStationBySegment(segmentRequest.getSegmentId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);
            logger.info("results:" + JsonUtils.toJson(stations));

            return stations;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 根据位置查询范围内的站点
     * @return
     */
    private StationInfoEntity[] getStationByGps() {
        try {
            StationRequest stationRequest = StationRequest.builder().longitude(112.979885).latitude(28.201137)
                    .lonRange(0.011).latRange(0.009).build();

            String fileName = PropertyUtils.getProperty(SysConstant.LOG_PATH) + DateUtils.format(new Date(), "yyyyMMdd") + "/getStationByGps" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(stationRequest));

            //查询附近的站点
            StationInfoEntity[] stations = basicService.getStationByGps(stationRequest.getLongitude(),
                    stationRequest.getLatitude(), stationRequest.getLonRange(), stationRequest.getLatRange(), 1000D, username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);
            logger.info("results:" + JsonUtils.toJson(stations));

            return stations;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }
}
