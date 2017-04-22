/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Data access object layer of {@link Schedule} domain.
 */

package com.gadreel.lecture.schedule.dao;

import java.util.Date;
import java.util.List;

import com.gadreel.lecture.schedule.dao.base.DaoBase;
import com.gadreel.lecture.schedule.domain.Schedule;

public interface ScheduleDao extends DaoBase<Schedule> {
	
	/**
	 * Get a list of schedules based on the search criteria
	 * @param studentGroupCode Student group code
	 * @param moduleCode Module code
	 * @param startDateTime Schedule start date and time
	 * @param endDateTime Schedule end date and time
	 * @return A List of {@link Schedule}
	 */
	public List<Schedule> searchScheduleList(String studentGroupCode,String moduleCode,Date startDateTime,Date endDateTime);
	
}
