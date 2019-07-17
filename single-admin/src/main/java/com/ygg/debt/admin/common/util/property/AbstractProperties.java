package com.ygg.debt.admin.common.util.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xuezl on 2017/9/12.
 */
public abstract class AbstractProperties {
    private static final Logger logger = LoggerFactory.getLogger(AbstractProperties.class);
    private Properties props;


    protected void loadProps() {
        logger.info("开始加载" + this.getName() + "文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
            in = AbstractProperties.class.getClassLoader().getResourceAsStream(this.getFilePath());
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error(this.getName() + "文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error(this.getName() + "文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.debug("properties文件内容：" + props);
    }

    public String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

    public abstract String getFilePath();

    public abstract String getName();

}
