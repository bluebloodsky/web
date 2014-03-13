package com.whnr.cac.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whnr.cac.utils.WebUtil;
import com.whnr.cac.web.service.DataService;


@Controller
@RequestMapping("/page/data")
public class DataController extends BaseController{

	@Autowired
	DataService dataService;
	@RequestMapping("/loadTreeNode.htm")
	public void loadTreeNode(HttpServletRequest request, HttpServletResponse response) 
	{
		String result = "";
		try {
			Object tree = dataService.loadTree();
			//System.out.println(WebUtil.toJsonString(tree));
			result = WebUtil.toJsonString(tree);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
//         String jsonString="[{'id':'01','text':'系统设置','leaf':false},{'id':'02','text':'全局配置','leaf':false},{'id':'03','text':'商户管理','leaf':false}]";
			doResponse(response, result);
		}
	}
	
	@RequestMapping("/loadSubDevices.htm")
	public void LoadBasicData(String deviceType,String deviceId,HttpServletRequest request, HttpServletResponse response)
	{
		String result = "";
		try{
			Object tabPanels=dataService.loadSubDevice(deviceType, deviceId);
			result = WebUtil.toJsonString(tabPanels);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
//         String jsonString="[{'id':'01','text':'系统设置','leaf':false},{'id':'02','text':'全局配置','leaf':false},{'id':'03','text':'商户管理','leaf':false}]";
			doResponse(response, result);
		}
	}
}
