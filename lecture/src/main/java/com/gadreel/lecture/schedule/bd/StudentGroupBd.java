/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Business delegation layer of {@link StudentGroup} domain.
 */
package com.gadreel.lecture.schedule.bd;

import com.gadreel.lecture.schedule.bd.base.BaseBd;
import com.gadreel.lecture.schedule.domain.StudentGroup;

public interface StudentGroupBd extends BaseBd<StudentGroup>{
	
	/**
	 * Creates a Student group object
	 * @param groupCode Group code
	 * @param groupDesc Description/Name of the group
	 */
	public void createStudentGroup(String groupCode,String groupDesc);
}
