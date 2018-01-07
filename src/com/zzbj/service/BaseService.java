package com.zzbj.service;

import java.util.List;
/***
 * service的基础
 * @author zhuhuijun
 *
 * @param <T>
 */
public interface BaseService<T> {
	public void saveEntity(T t);

	public void updateEntity(T t);

	public void deleteEntity(T t);

	/***
	 * 执行hql
	 * 
	 * @param hql
	 * @param objects
	 */
	public void executeByHql(String hql, Object... objects);

	// 读操作
	public T getEntity(Integer id);

	public List<T> findByHql(String hql, Object... objects);
	/**
	 * 查询全部
	 * @return
	 */
	public List<T> findAll();
}
