package com.zzbj.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.zzbj.dao.BaseDao;

/**
 * 抽象类的实现
 * 
 * @author zhuhuijun
 *
 * @param <T>
 */
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	/**
	 * SessionFactory
	 */
	@Resource(name = "sessionFactory")
	private SessionFactory sf;
	/***
	 * 获得类的真实名称
	 */
	private Class clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}

	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);

	}

	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);

	}

	public void executeByHql(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}

	public T getEntity(Integer id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	public List<T> findByHql(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

}
