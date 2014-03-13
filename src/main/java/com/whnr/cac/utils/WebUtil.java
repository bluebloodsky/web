package com.whnr.cac.utils;

import com.alibaba.fastjson.JSON;

public class WebUtil {
	
	public static String toJsonString(Object object)
	{
		return JSON.toJSONString(object);
	}
}
