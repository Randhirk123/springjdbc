package com.fss.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.dao.UserDao;
import com.fss.model.UserDetails;
import com.fss.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao dao;
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	@Override
	public boolean save(UserDetails user) {
		boolean check=false;
		int status=dao.save(user);
		if(status>=0)
		{
			check=true;
		}
		else
		{
			check=false;
		}
		return check;
	}

}
