package com.whnr.cac.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.whnr.cac.web.dao.UserDao;
import com.whnr.cac.web.model.UserModel;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public UserModel login(String loginName,String password)
	{
		Assert.hasText(loginName,"loginName is blank");
		Assert.hasText(password,"password is blank");
		UserModel user=userDao.getUserbyName(loginName);
		if(user==null)
		{
			throw new RuntimeException("user not exist,userName:"+loginName);
		}
		else if(!password.equals(user.getPassword()))
		{
			throw new RuntimeException("password is wrong,userName:"+loginName);
		}
		return user;
	}
	public UserModel getUserByUserName(String loginName)
	{
		UserModel user=userDao.getUserbyName(loginName);
		return user;
	}
}
