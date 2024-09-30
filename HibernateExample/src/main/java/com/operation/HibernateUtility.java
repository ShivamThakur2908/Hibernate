package com.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private SessionFactory factory;
	private Session session;
	public Session getSession()
	{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		
		return session;
		
	}
}
