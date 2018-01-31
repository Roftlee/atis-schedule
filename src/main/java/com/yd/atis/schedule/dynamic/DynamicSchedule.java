package com.yd.atis.schedule.dynamic;

import com.yd.atis.constant.SysConstant;
import com.yd.atis.facade.mail.MailFacade;
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
import org.springframework.beans.factory.annotation.Autowired;
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
    private final Logger log = LoggerFactory.getLogger(DynamicSchedule.class);

    private static String username = "D3DDAD5ECF6D0E87";
    private static String password = "6D8A217D88AFBE9F";

    private static AtisDynamicWebService_PortType dynamicService;

    @Value("${logback.logdir}")
    private String logPath;

    @Autowired
    private MailFacade mailFacade;

    private void initService() {
        try {

            log.info("start init dynamic atis web service");

            //实时WebService服务
            AtisDynamicWebService_ServiceLocator basicLocator = new AtisDynamicWebService_ServiceLocator();
            dynamicService = basicLocator.getAtisDynamicWebServicePort();

            log.info("end init dynamic atis web service");
        } catch (javax.xml.rpc.ServiceException ex) {
            log.error("init dynamic atis web service comes to an exception:" + ex.getMessage());
        }
    }

    /**
     * 定时调度任务 每天9点到18点之间每30分钟调用一次
     */
    @Scheduled(cron = "0 0/30 9-18 * * ?")
    public void excuteAtisDynamicService() {

        log.info("Atis dynamic task start!");

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

        log.info("Atis dynamic task end!");
    }

    /**
     * 查询车辆实时到站信息
     * routeId=-1时返回所有开往stationId对应车站的车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] queryByStationID() {

        log.info("start to excute queryByStationID()");

        try {
            StationRequest stationRequest = StationRequest.builder().routeId("-1").segmentId("").stationId("7072190").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryByStationID" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //按站点唯一编号查询
            ArriveStationBusEntity[] arriveStationBusEntities = dynamicService.queryByStationID(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), username, password);

            if (arriveStationBusEntities == null || arriveStationBusEntities.length == 0) {
                mailFacade.sendSimpleEmail("queryByStationID接口返回null", "queryByStationID接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(arriveStationBusEntities), true);

            log.info("queryByStationID() end");

            return arriveStationBusEntities;
        } catch (BusinessException e) {
            log.info("queryByStationID() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryByStationID接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("queryByStationID() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryByStationID接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询车辆实时到站信息
     * routeId=-1时返回所有开往stationId对应车站的车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] queryByStationID2() {

        log.info("start to excute queryByStationID2()");

        try {
            StationRequest stationRequest = StationRequest.builder().routeId("-1").segmentId("1981").stationId("7072287").arrLftType(new Random().nextInt(2) + 1).build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryByStationID2" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //按站点唯一编号查询
            ArriveStationBusEntity[] arriveStationBusEntities = dynamicService.queryByStationID2(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), stationRequest.getArrLftType(), username, password);

            if (arriveStationBusEntities == null || arriveStationBusEntities.length == 0) {
                mailFacade.sendSimpleEmail("queryByStationID2接口返回null", "queryByStationID2接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(arriveStationBusEntities), true);

            log.info("queryByStationID2() end");

            return arriveStationBusEntities;
        } catch (BusinessException e) {
            log.info("queryByStationID2() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryByStationID2接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("queryByStationID2() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryByStationID2接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询指定线路车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] requireBusPosition() {

        log.info("start to excute requireBusPosition()");

        try {
            StationRequest stationRequest = StationRequest.builder().routeId("198").segmentId("1981").stationId("7072287").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/requireBusPosition" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //车辆到站提醒请求
            ArriveStationBusEntity[] requireBusPositions = dynamicService.requireBusPosition(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), username, password);

            if (requireBusPositions == null || requireBusPositions.length == 0) {
                mailFacade.sendSimpleEmail("requireBusPosition接口返回null", "requireBusPosition接口返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(requireBusPositions), true);

            log.info("requireBusPosition() end");

            return requireBusPositions;
        } catch (BusinessException e) {
            log.info("requireBusPosition() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("requireBusPosition接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("requireBusPosition() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("requireBusPosition接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询线路车辆实时运行明细
     * @return
     */
    private RealTimeInfo[] queryDetailByRouteId() {

        log.info("start to excute queryDetailByRouteId()");

        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().routeId("284").segmentId("2842").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryDetailByRouteID" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //按线路ID查询线路运行明细
            RealTimeInfo[] realTimeInfos = dynamicService.queryDetailByRouteID(
                    segmentRequest.getRouteId(), segmentRequest.getStationId(), segmentRequest.getSegmentId(), username, password);

            if (realTimeInfos == null || realTimeInfos.length == 0) {
                mailFacade.sendSimpleEmail("queryDetailByRouteId接口返回null", "queryDetailByRouteId接口返回null，请求参数：" + JsonUtils.toJson(segmentRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(realTimeInfos), true);

            log.info("queryDetailByRouteId() end");

            return realTimeInfos;
        } catch (BusinessException e) {
            log.info("queryDetailByRouteId() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryDetailByRouteId接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("queryDetailByRouteId() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryDetailByRouteId接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询线路车辆实时运行明细
     * @return
     */
    private RealTimeInfo[] queryDetailByRouteID2() {

        log.info("start to excute queryDetailByRouteID2()");

        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().routeId("284").segmentId("2842").arrLftType(new Random().nextInt(2) + 1).build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryDetailByRouteID2" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //按线路ID查询线路运行明细
            RealTimeInfo[] realTimeInfos = dynamicService.queryDetailByRouteID2(
                    segmentRequest.getRouteId(), segmentRequest.getStationId(), segmentRequest.getSegmentId(), segmentRequest.getArrLftType(), username, password);

            if (realTimeInfos == null || realTimeInfos.length == 0) {
                mailFacade.sendSimpleEmail("queryDetailByRouteID2接口返回null", "queryDetailByRouteID2接口返回null，请求参数：" + JsonUtils.toJson(segmentRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(realTimeInfos), true);

            log.info("queryDetailByRouteID2() end");

            return realTimeInfos;
        } catch (BusinessException e) {
            log.info("queryDetailByRouteID2() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryDetailByRouteID2接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("queryDetailByRouteID2() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("queryDetailByRouteID2接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }

    /**
     * 查询线路车辆路段速度信息
     * @return
     */
    private StationInfoEntity[] requireRouteSpeed() {

        log.info("start to excute requireRouteSpeed()");

        try {
            SegmentRequest segmentRequest = SegmentRequest.builder().routeId("198").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/requireRouteSpeed" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //查询线路路段速度
            StationInfoEntity[] stationInfoEntities =
                    dynamicService.requireRouteSpeed(segmentRequest.getRouteId(), username, password);

            if (stationInfoEntities == null || stationInfoEntities.length == 0) {
                mailFacade.sendSimpleEmail("requireRouteSpeed接口返回null", "requireRouteSpeed接口返回null，请求参数：" + JsonUtils.toJson(segmentRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stationInfoEntities), true);

            log.info("requireRouteSpeed() end");

            return stationInfoEntities;
        } catch (BusinessException e) {
            log.info("requireRouteSpeed() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("requireRouteSpeed接口请求异常", "异常信息：" + e.getStackTrace());
        } catch (RemoteException e) {
            log.info("requireRouteSpeed() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("requireRouteSpeed接口请求异常", "异常信息：" + e.getStackTrace());
        }

        return null;
    }
}
