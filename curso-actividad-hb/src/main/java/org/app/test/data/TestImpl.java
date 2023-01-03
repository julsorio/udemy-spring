package org.app.test.data;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestImpl implements Test {

	@Override
	public <T> Object get(SessionFactory factory, Class<T> entity, Serializable id) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		return session.get(entity, id);
	}
	
	public <T> List<T> getAll(SessionFactory factory, String queryString) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		return session.createQuery(queryString).list();
	}
	
	@Override
	public <T> List<T> getByCompanyName(SessionFactory factory, String companyName) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		return session.createQuery("from Employee e where e.company = '" + companyName + "'").list();
	}

	@Override
	public void save(SessionFactory factory, Object entity) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();

	}

	@Override
	public void delete(SessionFactory factory, Serializable id) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Employee e where e.id = " + id).executeUpdate();
	}

}
