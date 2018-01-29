package com.yd.atis.schedule.dynamic;

import com.yd.atis.constant.SysConstant;
import com.yd.atis.model.ArriveStationBusEntity;
import com.yd.atis.model.BusinessException;
import com.yd.atis.model.RealTimeInfo;
import com.yd.atis.model.StationInfoEntity;
import com.yd.atis.request.segment.SegmentRequest;
import com.yd.atis.request.station.StationRequest;
import com.yd.atis.service.dynamicService.AtisDynamicWebService_PortType;
import com.yd.atis.service.dynamicService.AtisDynamicWebService_ServiceLocator;
import com.yd.atis.utils.DateUtils;
import com.yd.atis.utils.FileUtils;
import com.yd.atis.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Random;

/**
 * Atis动态服务调用
 * @author AsiQue
 * @since :2018.01.29 09:35
 */
@Component
public class DynamicSchedule {
    private static Logger logger = LoggerFactory.getLogger(DynamicSchedule.class);

    private static String username = "D3DDAD5ECF6D0E87";
    private static String password = "6D8A217D88AFBE9F";

    private static AtisDynamicWebService_PortType dynamicService;

    @Value("${log.path}")
    private String logPath;

    private void initService() {
        try {

            logger.info("start init dynamic atis web service");

            //实时WebService服务
            AtisDynamicWebService_ServiceLocator basicLocator = new AtisDynamicWebService_ServiceLocator();
            dynamicService = basicLocator.getAtisDynamicWebServicePort();

            logger.info("end init dynamic atis web service");
        } catch (javax.xml.rpc.ServiceException ex) {
            logger.error("init dynamic atis web service comes to an exception:" + ex.getMessage());
        }
    }

    /**
     * 定时调度任务 每天22：00调用一次
     */
    @Scheduled(cron = "0 0 22 * * ?")
    public void excuteAtisDynamicService() {

        logger.info("Atis dynamic task start!");

        initService();

        //按站点查询车辆实时到站信息
        queryByStationID();

        queryByStationID2();

        //车辆到站提醒请求
        requireBusPosition();

        //按线路ID查询线路运行明细
        queryDetailByRouteId();

        queryDetailByRouteID2();

        //查询线路路段速度
        requireRouteSpeed();

        logger.info("Atis dynamic task end!");
    }

    /**
     * 查询车辆实时到站信息
     * routeId=-1时返回所有开往stationId对应车站的车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] queryByStationID() {
        try {
            StationRequest stationRequest = StationRequest.builder().routeId("-1").segmentId("2452").stationId("7072190").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryByStationId" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(stationRequest));

            //按站点唯一编号查询
            ArriveStationBusEntity[] arriveStationBusEntities = dynamicService.queryByStationID(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(arriveStationBusEntities), true);
            logger.info("results:" + JsonUtils.toJson(arriveStationBusEntities));

            return arriveStationBusEntities;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询车辆实时到站信息
     * routeId=-1时返回所有开往stationId对应车站的车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] queryByStationID2() {
        try {
            StationRequest stationRequest = StationRequest.builder().routeId("-1").segmentId("2452").stationId("7072190").arrLftType(new Random().nextInt(2) + 1).build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryByStationID2" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(stationRequest));

            //按站点唯一编号查询
            ArriveStationBusEntity[] arriveStationBusEntities = dynamicService.queryByStationID2(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), stationRequest.getArrLftType(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(arriveStationBusEntities), true);
            logger.info("results:" + JsonUtils.toJson(arriveStationBusEntities));

            return arriveStationBusEntities;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询指定线路车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] requireBusPosition() {
        try {
            StationRequest stationRequest = StationRequest.builder().routeId("245").segmentId("2452").stationId("03051201").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/requireBusPosition" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(stationRequest));

            //车辆到站提醒请求
            ArriveStationBusEntity[] requireBusPositions = dynamicService.requireBusPosition(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(requireBusPositions), true);
            logger.info("results:" + JsonUtils.toJson(requireBusPositions));

            return requireBusPositions;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询线路车辆实时运行明细
     * @return
     */
    private RealTimeInfo[] queryDetailByRouteId() {
        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().routeId("284").segmentId("2842").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryDetailByRouteID" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(segmentRequest));

            //按线路ID查询线路运行明细
            RealTimeInfo[] realTimeInfos = dynamicService.queryDetailByRouteID(
                    segmentRequest.getRouteId(), segmentRequest.getStationId(), segmentRequest.getSegmentId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(realTimeInfos), true);
            logger.info("results:" + JsonUtils.toJson(realTimeInfos));

            return realTimeInfos;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询线路车辆实时运行明细
     * @return
     */
    private RealTimeInfo[] queryDetailByRouteID2() {
        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().routeId("284").segmentId("2842").arrLftType(new Random().nextInt(2) + 1).build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryDetailByRouteID2" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(segmentRequest));

            //按线路ID查询线路运行明细
            RealTimeInfo[] realTimeInfos = dynamicService.queryDetailByRouteID2(
                    segmentRequest.getRouteId(), segmentRequest.getStationId(), segmentRequest.getSegmentId(), segmentRequest.getArrLftType(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(realTimeInfos), true);
            logger.info("results:" + JsonUtils.toJson(realTimeInfos));

            return realTimeInfos;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 查询线路车辆路段速度信息
     * @return
     */
    private StationInfoEntity[] requireRouteSpeed() {
        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().routeId("198").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/requireRouteSpeed" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);
            logger.info("parameters:" + JsonUtils.toJson(segmentRequest));

            //查询线路路段速度
            StationInfoEntity[] stationInfoEntities =
                    dynamicService.requireRouteSpeed(segmentRequest.getRouteId(), username, password);

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stationInfoEntities), true);
            logger.info("results:" + JsonUtils.toJson(stationInfoEntities));

            return stationInfoEntities;
        } catch (BusinessException e) {
            logger.error(e.getMessage());
        } catch (RemoteException e) {
            logger.error(e.getMessage());
        }

        return null;
    }
}
