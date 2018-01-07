package com.zzbj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zzbj.dao.BaseDao;
import com.zzbj.model.User;
import com.zzbj.service.UserService;

@Service("userService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class UserServiceImpl extends BaseServiceImpl<User>implements UserService {

	@Resource(name = "userDao")
	public void setBaseDao(BaseDao dao) {
		super.setBaseDao(dao);
	}

}
