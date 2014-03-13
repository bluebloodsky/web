package com.whnr.cac.web.dao;

import org.springframework.stereotype.Repository;

import com.whnr.cac.web.model.UserModel;

@Repository("userDao")
public class UserDao {
	public UserModel getUserbyName(String userName)
	{		
		if(userName.equals("admin"))
		{		
			UserModel user = new UserModel();
			user.setUserName("admin");
			user.setPassword("admin");
			user.setRole("administrator");
			return user;
		}else{
			return null;
		}
		
	}

}
