package com.yd.atis.schedule.dynamic;

import com.yd.atis.constant.SysConstant;
import com.yd.atis.dao.RouteInfoMapper;
import com.yd.atis.dao.SegmentInfoMapper;
import com.yd.atis.dao.StationInfoMapper;
import com.yd.atis.dao.StationSegmentRelationMapper;
import com.yd.atis.dto.*;
import com.yd.atis.facade.atisInvokeLog.AtisInvokeLogFacade;
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
    private RouteInfoMapper routeInfoMapper;

    @Autowired
    private SegmentInfoMapper segmentInfoMapper;

    @Autowired
    private StationInfoMapper stationInfoMapper;

    @Autowired
    private StationSegmentRelationMapper stationSegmentRelationMapper;

    @Autowired
    private AtisInvokeLogFacade atisInvokeLogFacade;

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
    @Scheduled(cron = "0 0/30 8-20 * * ?")
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

        StationInfo stationInfo = stationInfoMapper.selectByRandom();
        StationRequest stationRequest = StationRequest.builder().routeId("-1").segmentId("").stationId(stationInfo.getStationId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("queryByStationID")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {


            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryByStationID" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //按站点唯一编号查询
            ArriveStationBusEntity[] arriveStationBusEntities = dynamicService.queryByStationID(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (arriveStationBusEntities == null || arriveStationBusEntities.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("queryByStationID")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(arriveStationBusEntities), true);

            log.info("queryByStationID() end");

            return arriveStationBusEntities;
        } catch (BusinessException e) {
            log.info("queryByStationID() error");
            log.error(e.getMessage());

            sendEmail("queryByStationID接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("queryByStationID() error");
            log.error(e.getMessage());

            sendEmail("queryByStationID接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
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

        StationSegmentRelation ssr = stationSegmentRelationMapper.selectByRandom();
        StationRequest stationRequest = StationRequest.builder().routeId("-1").segmentId(ssr.getSegmentId())
                .stationId(ssr.getStationId()).arrLftType(new Random().nextInt(2) + 1).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("queryByStationID2")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {


            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryByStationID2" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //按站点唯一编号查询
            ArriveStationBusEntity[] arriveStationBusEntities = dynamicService.queryByStationID2(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), stationRequest.getArrLftType(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (arriveStationBusEntities == null || arriveStationBusEntities.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("queryByStationID2")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(arriveStationBusEntities), true);

            log.info("queryByStationID2() end");

            return arriveStationBusEntities;
        } catch (BusinessException e) {
            log.info("queryByStationID2() error");
            log.error(e.getMessage());

            sendEmail("queryByStationID2接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("queryByStationID2() error");
            log.error(e.getMessage());

            sendEmail("queryByStationID2接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询指定线路车辆实时到站信息
     * @return
     */
    private ArriveStationBusEntity[] requireBusPosition() {

        log.info("start to excute requireBusPosition()");

        StationSegmentRelation ssr = stationSegmentRelationMapper.selectByRandom();
        StationRequest stationRequest = StationRequest.builder().routeId(ssr.getRouteId())
                .segmentId(ssr.getSegmentId()).stationId(ssr.getStationId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("requireBusPosition")
                .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {


            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/requireBusPosition" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //车辆到站提醒请求
            ArriveStationBusEntity[] requireBusPositions = dynamicService.requireBusPosition(
                    stationRequest.getRouteId(), stationRequest.getSegmentId(), stationRequest.getStationId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (requireBusPositions == null || requireBusPositions.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("requireBusPosition")
                    .invokeParam(JsonUtils.toJson(stationRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(requireBusPositions), true);

            log.info("requireBusPosition() end");

            return requireBusPositions;
        } catch (BusinessException e) {
            log.info("requireBusPosition() error");
            log.error(e.getMessage());

            sendEmail("requireBusPosition接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("requireBusPosition() error");
            log.error(e.getMessage());

            sendEmail("requireBusPosition接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询线路车辆实时运行明细
     * @return
     */
    private RealTimeInfo[] queryDetailByRouteId() {

        log.info("start to excute queryDetailByRouteId()");

        SegmentInfo segmentInfo = segmentInfoMapper.selectByRandom();
        SegmentRequest segmentRequest = SegmentRequest.builder().routeId(segmentInfo.getRouteId()).segmentId(segmentInfo.getSegmentId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("queryDetailByRouteId")
                .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryDetailByRouteID" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //按线路ID查询线路运行明细
            RealTimeInfo[] realTimeInfos = dynamicService.queryDetailByRouteID(
                    segmentRequest.getRouteId(), segmentRequest.getStationId(), segmentRequest.getSegmentId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (realTimeInfos == null || realTimeInfos.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("queryDetailByRouteId")
                    .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(realTimeInfos), true);

            log.info("queryDetailByRouteId() end");

            return realTimeInfos;
        } catch (BusinessException e) {
            log.info("queryDetailByRouteId() error");
            log.error(e.getMessage());

            sendEmail("queryDetailByRouteId接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("queryDetailByRouteId() error");
            log.error(e.getMessage());

            sendEmail("queryDetailByRouteId接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询线路车辆实时运行明细
     * @return
     */
    private RealTimeInfo[] queryDetailByRouteID2() {

        log.info("start to excute queryDetailByRouteID2()");

        SegmentInfo segmentInfo = segmentInfoMapper.selectByRandom();
        SegmentRequest segmentRequest = SegmentRequest.builder().routeId(segmentInfo.getRouteId())
                .segmentId(segmentInfo.getSegmentId()).arrLftType(new Random().nextInt(2) + 1).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("queryDetailByRouteID2")
                .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {


            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/queryDetailByRouteID2" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //按线路ID查询线路运行明细
            RealTimeInfo[] realTimeInfos = dynamicService.queryDetailByRouteID2(
                    segmentRequest.getRouteId(), segmentRequest.getStationId(), segmentRequest.getSegmentId(), segmentRequest.getArrLftType(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (realTimeInfos == null || realTimeInfos.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("queryDetailByRouteID2")
                    .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(realTimeInfos), true);

            log.info("queryDetailByRouteID2() end");

            return realTimeInfos;
        } catch (BusinessException e) {
            log.info("queryDetailByRouteID2() error");
            log.error(e.getMessage());

            sendEmail("queryDetailByRouteID2接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("queryDetailByRouteID2() error");
            log.error(e.getMessage());

            sendEmail("queryDetailByRouteID2接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        }

        return null;
    }

    /**
     * 查询线路车辆路段速度信息
     * @return
     */
    private StationInfoEntity[] requireRouteSpeed() {

        log.info("start to excute requireRouteSpeed()");

        RouteInfo routeInfo = routeInfoMapper.selectByRandom();
        SegmentRequest segmentRequest = SegmentRequest.builder().routeId(routeInfo.getRouteId()).build();

        AtisInvokeLog exceptLog = AtisInvokeLog.builder().invokeFunc("requireRouteSpeed")
                .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(0).exceptDesp("")
                .invokeTime(new Date()).build();

        try {
            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/dynamic/requireRouteSpeed" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(segmentRequest), true);

            //查询线路路段速度
            StationInfoEntity[] stationInfoEntities =
                    dynamicService.requireRouteSpeed(segmentRequest.getRouteId(), username, password);

            Integer invokeStatus = 1;
            String exceptDesp = "";
            if (stationInfoEntities == null || stationInfoEntities.length == 0) {
                invokeStatus = 0;
                exceptDesp = "接口返回结果为空";
            }

            addAtisInvokeLog(AtisInvokeLog.builder().invokeFunc("requireRouteSpeed")
                    .invokeParam(JsonUtils.toJson(segmentRequest)).invokeStatus(invokeStatus).exceptDesp(exceptDesp)
                    .build());

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stationInfoEntities), true);

            log.info("requireRouteSpeed() end");

            return stationInfoEntities;
        } catch (BusinessException e) {
            log.info("requireRouteSpeed() error");
            log.error(e.getMessage());

            sendEmail("requireRouteSpeed接口请求异常", "异常信息：" + e.getMessage());

            addAtisInvokeLog(exceptLog);
        } catch (RemoteException e) {
            log.info("requireRouteSpeed() error");
            log.error(e.getMessage());

            sendEmail("requireRouteSpeed接口请求异常", "异常信息：" + e.getMessage());

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
