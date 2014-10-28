package com.ctb.rest;

import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Jersey 异常处理
 * 
 * @author zp
 */
public class JerseyException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public JerseyException(ReturnMessageBean error) {
		super(Response.serverError().entity(error).status(200).build());
	}

	public JerseyException(String code) {
		super(Response.serverError().entity(getMessageBean(code)).status(200).build());
	}

	public static ReturnMessageBean getMessageBean(String code) {
		ReturnMessageBean errorBean = new ReturnMessageBean();
		errorBean.setCode(code);
		errorBean.setMessage(readValue(code));
		return errorBean;
	}

	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/error.properties");
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
