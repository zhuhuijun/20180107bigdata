package com.zzbj.dao;

import java.util.List;
/***
 * 数据访问对象
 * @author zhuhuijun
 *
 * @param <T>
 */
public interface BaseDao<T> {
	public void saveEntity(T t);

	public void updateEntity(T t);

	public void deleteEntity(T t);
	/***
	 * 执行hql
	 * @param hql
	 * @param objects
	 */
	public void executeByHql(String hql, Object... objects);

	// 读操作
	public T getEntity(Integer id);

	public List<T> findByHql(String hql, Object... objects);
}
