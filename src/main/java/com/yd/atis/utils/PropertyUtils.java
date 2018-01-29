package com.yd.atis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author AsiQue
 * @since :2018.01.16 10:25
 */
public class PropertyUtils {

    private static Logger logger = LoggerFactory.getLogger(PropertyUtils.class);

    private static Properties properties = null;

    private static void loadProperties() {

        properties = new Properties();
        InputStream is = null;

        try {

            logger.info("开始读取配置文件：/config/server.properties");
            is = PropertyUtils.class.getResourceAsStream("/config/server.properties");

            properties.load(is);
            logger.info("配置文件读取结束");
        } catch (FileNotFoundException e) {
            logger.error("未找到配置文件");
        } catch (IOException e) {
            logger.error("io异常");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("文件流关闭异常");
                }
            }
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }

        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (properties == null) {
            loadProperties();
        }

        return properties.getProperty(key, defaultValue);
    }

    public static Properties getAll() {
        if (properties == null) {
            loadProperties();
        }

        return properties;
    }
}
