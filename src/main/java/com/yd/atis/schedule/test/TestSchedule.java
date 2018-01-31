package com.yd.atis.schedule.test;

import com.yd.atis.constant.SysConstant;
import com.yd.atis.dao.RouteInfoMapper;
import com.yd.atis.dao.SegmentInfoMapper;
import com.yd.atis.dao.StationInfoMapper;
import com.yd.atis.dao.StationSegmentRelationMapper;
import com.yd.atis.dto.RouteInfo;
import com.yd.atis.dto.SegmentInfo;
import com.yd.atis.dto.StationInfo;
import com.yd.atis.dto.StationSegmentRelation;
import com.yd.atis.facade.mail.MailFacade;
import com.yd.atis.model.StationInfoEntity;
import com.yd.atis.request.station.StationRequest;
import com.yd.atis.schedule.basic.BasicSchedule;
import com.yd.atis.utils.DateUtils;
import com.yd.atis.utils.FileUtils;
import com.yd.atis.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author AsiQue
 * @since :2018.01.31 15:57
 */
@Component
public class TestSchedule {

    private final Logger log = LoggerFactory.getLogger(BasicSchedule.class);

    private static String username = "D3DDAD5ECF6D0E87";
    private static String password = "6D8A217D88AFBE9F";

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
    private StationSegmentRelationMapper stationSegmentRelationMapper;

    @Scheduled(cron = "*/10 * * * * ?")
    private void test() {
        try {
            log.info("start to excute test()");

            StationInfo stationInfo = stationInfoMapper.selectByRandom();
            log.info("stationInfo:" + JsonUtils.toJson(stationInfo));

            RouteInfo routeInfo = routeInfoMapper.selectByRandom();
            log.info("routeInfo:" + JsonUtils.toJson(routeInfo));

            SegmentInfo segmentInfo = segmentInfoMapper.selectByRandom();
            log.info("segmentInfo:" + JsonUtils.toJson(segmentInfo));

            StationSegmentRelation ssr = stationSegmentRelationMapper.selectByRandom();
            log.info("ssr:" + JsonUtils.toJson(ssr));

            StationRequest stationRequest = StationRequest.builder().stationId("-1").stationName("火车站").build();

            String fileName = logPath + DateUtils.format(new Date(), "yyyyMMdd") + "/basic/getStationInfo" + SysConstant.LOG_FILE_SUFFIX;
            FileUtils.writeFile(fileName, SysConstant.REQ_DESC_PREFIX + JsonUtils.toJson(stationRequest), true);

            //获取站点基础信息
            StationInfoEntity[] stations = new StationInfoEntity[1];

            if (stations == null || stations.length == 0) {
                mailFacade.sendSimpleEmail("test方法返回null", "test方法返回null，请求参数：" + JsonUtils.toJson(stationRequest));
            }

            FileUtils.writeFile(fileName, SysConstant.RES_DESC_PREFIX + JsonUtils.toJson(stations), true);


            log.info("excute test() end");

//            throw new Exception("this is a manual exception");

        } catch (Exception e) {
            log.info("excute test() error");
            log.error(e.getMessage());

            mailFacade.sendSimpleEmail("test方法请求异常", "异常信息：" + e.getMessage());
        }
    }
}
