/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Data access object implementation layer of Module domain.
 */
package com.gadreel.lecture.schedule.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gadreel.lecture.schedule.dao.ModuleDao;
import com.gadreel.lecture.schedule.domain.Module;
import com.gadreel.lecture.schedule.hibernate.support.HibernateSupport;

public class ModuleDaoImpl extends HibernateSupport implements ModuleDao{

	@Override
	public void create(Module t) {
		getSession().save(t);
	}

	@Override
	public void delete(Module t) {
		getSession().delete(t);
	}

	@Override
	public void update(Module t) {
		getSession().update(t);
	}

	@Override
	public Module getById(int id) {
		Criteria criteria = getSession().createCriteria(Module.class);
		criteria.add(Restrictions.eq("moduleId", id));
		Module module = (Module) criteria.uniqueResult();
		return module;
	}

	@Override
	public Module getByCode(String code) {
		Criteria criteria = getSession().createCriteria(Module.class);
		criteria.add(Restrictions.eq("moduleCode", code));
		Module module = (Module) criteria.uniqueResult();
		return module;
	}

}
