package com.fss.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fss.dao.UserDao;
import com.fss.model.UserDetails;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	@Override
	public int save(UserDetails user) {
	
		String sql="insert into userdetails values('"+user.getFieldName()+"','"+user.getType()+"','"+user.getCateogry()+"')";  
		//String sql="insert into userDetails values('"+user.getFieldName()+"''"+user.getType()+"''"+user.getCateogry()+"')";
		int status=template.update(sql);
		if(status>=0)
		{
			return status;
		}
		else
		{
			return -1;
		}
	}

}
