/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Business delegation layer of {@link Module} domain.
 */
package com.gadreel.lecture.schedule.bd;

import com.gadreel.lecture.schedule.bd.base.BaseBd;
import com.gadreel.lecture.schedule.domain.Module;

public interface ModuleBd extends BaseBd<Module>{	
	
	/**
	 * Creates a module
	 * @param moduleCode Code name of the module
	 * @param moduleName Name of the module
	 * @param credits Credits allocated to the module
	 * @param moduleLeader Name of the module leader
	 */
	public void createModule(String moduleCode,String moduleName,int credits,String moduleLeader)throws Exception;
}
