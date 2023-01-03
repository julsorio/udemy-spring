package org.app.test.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public interface Test {
	
	public <T> Object get(SessionFactory factory, Class<T> entity, Serializable id) throws Exception;
	
	public <T> List<T> getAll(SessionFactory factory, String queryString);
	
	public <T> List<T> getByCompanyName(SessionFactory factory, String companyName) throws Exception;

	public void save(SessionFactory factory, Object entity) throws Exception;
	
	public void delete(SessionFactory factory, Serializable id) throws Exception;

}
