package com.rajat.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.rajat.entities.UrlEntity;

public class UrlDAO {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(UrlEntity.class)
			.buildSessionFactory();
	
	public List getShortKey(String url) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.enableFilter("urlFilter").setParameter("url",url);
		List<String> list = session.createQuery("select shortKey from UrlEntity").getResultList();
		return list;
	}
	public void increaseUsageCount(String url) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createNativeQuery("UPDATE url_data set usage_count = usage_count +1 where url=:url").setParameter("url", url).executeUpdate();
		session.getTransaction().commit();		
	}
	public void addUrl(UrlEntity urlEntity) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(urlEntity);
		session.getTransaction().commit();
	}

	public List<Integer> getCount(String url) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.enableFilter("urlFilter").setParameter("url",url);
		
		List<Integer> list = session.createQuery("select usageCount from UrlEntity").getResultList();
		return list;
	}

	

}
