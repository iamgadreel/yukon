/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Business delegation implementation layer of {@link StudentGroup} domain.
 */
package com.gadreel.lecture.schedule.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gadreel.lecture.schedule.bd.StudentGroupBd;
import com.gadreel.lecture.schedule.dao.StudentGroupDao;
import com.gadreel.lecture.schedule.domain.StudentGroup;

public class StudentGroupBdImpl implements StudentGroupBd{
	
	@Autowired
	private StudentGroupDao studentGroupDao;

	@Override
	public StudentGroup getByCode(String code) throws Exception {
		return studentGroupDao.getByCode(code);
	}

	@Override
	public StudentGroup getById(int id) throws Exception {
		return studentGroupDao.getById(id);
	}

	@Override
	public void createStudentGroup(String groupCode, String groupDesc) {
		StudentGroup group = new StudentGroup();
		group.setGroupCode(groupCode);
		group.setGroupDesc(groupDesc);
		
		studentGroupDao.create(group);
	}
	
	
}
