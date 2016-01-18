package com.shanghai.our.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 共通操作dao 
 */
@SuppressWarnings("unchecked")
public class HibernateEntityDao<T>{
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session  getSession(){
		return sessionFactory.getCurrentSession();
	}
	public HibernateEntityDao(){
		entityClass=(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	private Class<T> entityClass;

	public T findByID(Serializable id) {
		return (T)getSession().get(entityClass, id);
	}



	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public T save(T entity) {
		getSession().save(entity);
		return entity;
	}
	public void deleteByID(Serializable id) {
		T t=this.findByID(id);
		getSession().delete(t);
	}

	
	public T loadId(Integer id) {
		return (T) getSession().load(entityClass, id);
	}
	
	public void mergry(T entity){
		getSession().merge(entity);
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	
	/*private static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}*/
	
}
