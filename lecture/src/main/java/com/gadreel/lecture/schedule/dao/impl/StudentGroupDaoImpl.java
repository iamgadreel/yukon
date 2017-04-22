/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Data access object implementation layer of {@link StudentGroup} domain.
 */
package com.gadreel.lecture.schedule.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gadreel.lecture.schedule.dao.StudentGroupDao;
import com.gadreel.lecture.schedule.domain.StudentGroup;
import com.gadreel.lecture.schedule.hibernate.support.HibernateSupport;

public class StudentGroupDaoImpl extends HibernateSupport implements StudentGroupDao {

	@Override
	public void create(StudentGroup t) {
		getSession().save(t);
	}

	@Override
	public void delete(StudentGroup t) {
		getSession().delete(t);
	}

	@Override
	public void update(StudentGroup t) {
		getSession().update(t);
	}

	@Override
	public StudentGroup getById(int id) {
		Criteria criteria = getSession().createCriteria(StudentGroup.class);
		criteria.add(Restrictions.eq("groupId", id));
		StudentGroup studentGroup = (StudentGroup) criteria.uniqueResult();
		return studentGroup;
	}

	@Override
	public StudentGroup getByCode(String code) {
		Criteria criteria = getSession().createCriteria(StudentGroup.class);
		criteria.add(Restrictions.eq("groupCode", code));
		StudentGroup studentGroup = (StudentGroup) criteria.uniqueResult();
		return studentGroup;
	}

}
