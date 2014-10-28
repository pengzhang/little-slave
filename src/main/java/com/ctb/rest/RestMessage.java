package com.ctb.rest;

import java.io.InputStream;
import java.util.Properties;

import org.springside.modules.mapper.JsonMapper;

/**
 * Rest消息处理
 * 
 * @author zp
 */
public class RestMessage {

	public RestMessage() {
	}

	public static String getMessageBeanToString(String code) {
		ReturnMessageBean msgBean = new ReturnMessageBean();
		msgBean.setCode(code);
		msgBean.setMessage(readValue(code));
		return new JsonMapper().toJson(getMessageBean(code)).toString();
	}

	public static ReturnMessageBean getMessageBean(String code) {
		ReturnMessageBean msgBean = new ReturnMessageBean();
		msgBean.setCode(code);
		msgBean.setMessage(readValue(code));
		return msgBean;
	}

	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/message.properties");
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}


