package com.yd.atis.schedule.statistics;

import com.yd.atis.dto.AtisInvokeStat;
import com.yd.atis.facade.atis.AtisInvokeStatFacade;
import com.yd.atis.facade.mail.MailFacade;
import com.yd.atis.utils.DateUtils;
import com.yd.atis.utils.FileUtils;
import com.yd.atis.utils.JsonUtils;
import com.yd.atis.utils.ZipUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

/**
 * @author AsiQue
 * @since :2018.02.07 10:24
 */
@Component
public class AtisInvokeStatSchedule {

    private final Logger log = LoggerFactory.getLogger(AtisInvokeStatSchedule.class);

    @Value("${logback.logdir}")
    private String logPath;

    @Value("${atis.empty.rate.max}")
    private Integer maxEmptyRate;

    @Value("${atis.except.rate.max}")
    private Integer maxExceptRate;

    @Autowired
    private AtisInvokeStatFacade atisInvokeStatFacade;

    @Autowired
    private MailFacade mailFacade;

    /**
     * 每天22:10发送接口调用统计邮件
     */
    @Scheduled(cron = "0 10 22 * * ?")
    public void excuteAtisInvokeStat() {
        String zipFilePath = null;

        try {
            log.info("start atis invoke statistics");

            List<AtisInvokeStat> atisInvokeStatList = atisInvokeStatFacade.queryAtisInvokeStatList(AtisInvokeStat.builder().build());

            String subject = "Atis接口调用统计(" + DateUtils.format(new Date(), "yyyy-MM-dd") + ")";
            String content = getContent(atisInvokeStatList);
            String attachPath = logPath + DateUtils.format(new Date(), "yyyyMMdd");
            zipFilePath = attachPath + ".zip";
            ZipUtils.zipFiles(attachPath, zipFilePath);
//        sendHtmlEmail(subject, content);
            sendAttachmentsEmail(subject, content, zipFilePath);

            log.info("end atis invoke statistics");
        } catch (Exception e) {
            log.error("aits invoke statistic error, message:" + e.getMessage());
        } finally {
//            if (zipFilePath != null) {
//                File zipFile = new File(zipFilePath);
//                if (zipFile.exists()) {
//                    zipFile.delete();
//                }
//            }
        }
    }

    private String getContent(List<AtisInvokeStat> atisInvokeStatList) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<th>接口名称</th>");
        sb.append("<th>调用次数(当天)</th>");
        sb.append("<th>返回空(当天)</th>");
        sb.append("<th>调用异常(当天)</th>");
        sb.append("<th>调用次数(全部)</th>");
        sb.append("<th>返回空(全部)</th>");
        sb.append("<th>调用异常(全部)</th>");
        sb.append("<th>返回空比率(当天)</th>");
        sb.append("<th>调用异常率(当天)</th>");
        sb.append("<th>返回空比率(全部)</th>");
        sb.append("<th>调用异常率(全部)</th>");
        sb.append("</tr>");

        for (AtisInvokeStat stat : atisInvokeStatList) {
            //当天接口返回空的比率
            double todayEmptyRate = new BigDecimal((double)stat.getTodayEmpty() / stat.getTodayInvoke() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            //当天接口调用异常率
            double todayExceptRate = new BigDecimal((double)stat.getTodayExcept() / stat.getTodayInvoke() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            //全部调用接口返回空的比率
            double totalEmptyRate = new BigDecimal((double)stat.getTotalEmpty() / stat.getTotalInvoke() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            //全部调用接口异常率
            double totalExceptRate = new BigDecimal((double)stat.getTotalExcept() / stat.getTotalInvoke() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            sb.append("<tr>");
            sb.append("<td style='color:#00F'>" + stat.getInvokeFunc() + "</td>");
            sb.append("<td>" + stat.getTodayInvoke() + "</td>");
            sb.append("<td>" + stat.getTodayEmpty() + "</td>");
            sb.append("<td>" + stat.getTodayExcept() + "</td>");
            sb.append("<td>" + stat.getTotalInvoke() + "</td>");
            sb.append("<td>" + stat.getTotalEmpty() + "</td>");
            sb.append("<td>" + stat.getTotalExcept() + "</td>");

            if (todayEmptyRate > maxEmptyRate) {
                sb.append("<td style='color:#F00'>" + todayEmptyRate + "%</td>");
            } else {
                sb.append("<td>" + todayEmptyRate + "%</td>");
            }
            if (todayExceptRate > maxExceptRate) {
                sb.append("<td style='color:#F00'>" + todayExceptRate + "%</td>");
            } else {
                sb.append("<td>" + todayExceptRate + "%</td>");
            }
            if (totalEmptyRate > maxEmptyRate) {
                sb.append("<td style='color:#F00'>" + totalEmptyRate + "%</td>");
            } else {
                sb.append("<td>" + totalEmptyRate + "%</td>");
            }
            if (totalExceptRate > maxExceptRate) {
                sb.append("<td style='color:#F00'>" + totalExceptRate + "%</td>");
            } else {
                sb.append("<td>" + totalExceptRate + "%</td>");
            }

            sb.append("</tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }

    private void sendHtmlEmail(String subject, String content) {
        try {
            mailFacade.sendHtmlMail(subject, content);
        } catch (Exception e) {
            log.error("email send error, message:" + e.getMessage());
        }
    }

    private void sendAttachmentsEmail(String subject, String content, String attachPath) {
        try {
            mailFacade.sendAttachmentsMail(subject, content, attachPath);
        } catch (Exception e) {
            log.error("email send error, message:" + e.getMessage());
        }
    }
}
