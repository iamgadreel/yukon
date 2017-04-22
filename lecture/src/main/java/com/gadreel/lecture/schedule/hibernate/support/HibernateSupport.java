/**
 * Hibernate support class to gain access to common hibernate session
 */
package com.gadreel.lecture.schedule.hibernate.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateSupport {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return  sessionFactory.openSession();
	}
	
	public Transaction getTransaction() {
		return sessionFactory.openSession().getTransaction();
	}
}
