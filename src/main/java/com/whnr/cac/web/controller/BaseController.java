package com.whnr.cac.web.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.whnr.cac.common.Constants;
import com.whnr.cac.utils.WebUtil;
import com.whnr.cac.web.model.UserModel;
import com.whnr.cac.web.result.Result;
import com.whnr.cac.web.service.UserService;


public class BaseController {
	protected final Logger logger=Logger.getLogger(this.getClass());

	protected void redirect(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
			response.flushBuffer();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	protected void doResponse(HttpServletResponse response, Result result) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			if (null != result) {
				response.getWriter().write(WebUtil.toJsonString(result));
			}
			response.flushBuffer();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	protected void doResponse(HttpServletResponse response, String jsonString) {
		response.setContentType("text/html;charset=UTF-8");
		try {
				response.getWriter().write(jsonString);
			response.flushBuffer();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Autowired
	UserService userService;
	public UserModel getCurrentUser(HttpServletRequest request) {
		String loginName="";
//		Cookie[] cookies= request.getCookies();
		UserModel user=null;
//		for(Cookie c:cookies)
//		{
//			if(c.getName().equals(Constants.USER_KEY_IN_COOKIE))
//			{
//				loginName=c.getValue();
//				break;
//			}
//		}
		if(StringUtils.isBlank(loginName))
		{
			Object o = request.getSession().getAttribute(Constants.USER_KEY_IN_SESSION);
			if (null != o) {	
				String cookie = o.toString();
				if (!StringUtils.isBlank(cookie)) {					
					String[] tmp = cookie.split("\\|");
					loginName = tmp[0];
				}
			}
		}
		if(!StringUtils.isBlank(loginName))
		{
			user = userService.getUserByUserName(loginName);
		}
//		if (null == user) {
//			throw new RuntimeException("user has not login!");
//		}
		return user;
	}
}
