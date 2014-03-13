package com.whnr.cac.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page/frame")
public class ValidController extends BaseController{
	@RequestMapping("/main.html")
	public void valid(HttpServletRequest request,HttpServletResponse response)
	{
		redirect(response, "/page/login/login.html");
	}
	
}