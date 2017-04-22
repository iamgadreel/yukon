/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Business delegation implementation layer of Module domain.
 */
package com.gadreel.lecture.schedule.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gadreel.lecture.schedule.bd.ModuleBd;
import com.gadreel.lecture.schedule.dao.ModuleDao;
import com.gadreel.lecture.schedule.domain.Module;

public class ModuleBdImpl implements ModuleBd{
	
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public Module getByCode(String code) throws Exception {
		return moduleDao.getByCode(code);
	}

	@Override
	public Module getById(int id) throws Exception{
		return moduleDao.getById(id);
	}

	@Override
	public void createModule(String moduleCode, String moduleName, int credits, String moduleLeader)throws Exception {
		Module module = new Module();
		module.setCredits(credits);
		module.setModuleCode(moduleCode);
		module.setModuleLeader(moduleLeader);
		module.setModuleName(moduleName);
		
		moduleDao.create(module);
	}
	
}
