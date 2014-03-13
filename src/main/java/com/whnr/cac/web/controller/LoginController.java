package com.whnr.cac.web.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whnr.cac.common.Constants;
import com.whnr.cac.web.model.UserModel;
import com.whnr.cac.web.result.Result;
import com.whnr.cac.web.service.UserService;

@Controller
@RequestMapping("/page/login")
public class LoginController extends BaseController{

	@Autowired
	UserService userService;
	@RequestMapping("/login.htm")
	public void login(String loginName,String password,HttpServletRequest request,HttpServletResponse response)
	{		
		Result result=new Result();
		try
		{
			UserModel user =  userService.login(loginName, password);
			request.getSession().setAttribute(Constants.USER_KEY_IN_SESSION, user.getUserName()+"|3324");
			result.setSuccess(true);
		}catch(Exception e){
			result.setSuccess(false);
			result.setInfo(e.getMessage());
			logger.error(e.getMessage(),e);
		}finally{
		doResponse(response, result);
		}
	}
	@RequestMapping("/getUser.htm")
	public void getUser(HttpServletRequest request,HttpServletResponse response)
	{
		Result result = new Result();
		try {
			UserModel user = getCurrentUser(request);
			result.setData(Arrays.asList(user));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setInfo(e.getMessage());
			logger.error(e.getMessage(), e);
		} finally {
			doResponse(response, result);
		}

	}

}
