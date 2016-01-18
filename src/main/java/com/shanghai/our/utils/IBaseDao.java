
package com.shanghai.our.utils;

import java.io.Serializable;

import org.hibernate.Query;

/**
 * @author code0
 *
 */
public interface IBaseDao<T> {
	public Query findAllWhereQuery(String hqlHead,T model);
	public T findByID(Serializable id);
	public T saveOrUpdate(T entity);
	public T save(T entity);
	public void deleteByID(Serializable id);
	public T loadId(Integer id);
	public void mergry(T entity);

}
