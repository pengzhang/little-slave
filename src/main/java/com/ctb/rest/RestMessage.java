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
		MessageBean msgBean = new MessageBean();
		msgBean.setCode(code);
		msgBean.setMessage(readValue(code));
		return new JsonMapper().toJson(getMessageBean(code)).toString();
	}

	public static MessageBean getMessageBean(String code) {
		MessageBean msgBean = new MessageBean();
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

class MessageBean {
	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
