package com.zzbj.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zzbj.dao.BaseDao;
import com.zzbj.model.User;
import com.zzbj.service.BaseService;

/**
 * 基础的实现
 * 
 * @author zhuhuijun
 *
 * @param <T>
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;

	public BaseServiceImpl() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			clazz = (Class) type.getActualTypeArguments()[0];
		} catch (Exception e) {
		}

	}

	private BaseDao<T> baseDao;

	@Resource
	public void setBaseDao(BaseDao dao) {
		this.baseDao = dao;
	}

	public void saveEntity(T t) {
		baseDao.saveEntity(t);
	}

	public void updateEntity(T t) {
		baseDao.updateEntity(t);
	}

	public void deleteEntity(T t) {
		baseDao.deleteEntity(t);
	}

	public void executeByHql(String hql, Object... objects) {
		baseDao.executeByHql(hql, objects);
	}

	public T getEntity(Integer id) {
		return baseDao.getEntity(id);
	}

	public List<T> findByHql(String hql, Object... objects) {
		return baseDao.findByHql(hql, objects);
	}

	public List<T> findAll() {
		return findByHql("from " + clazz.getName());
	}
}
