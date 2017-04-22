/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Business delegation layer of {@link Schedule} domain.
 */
package com.gadreel.lecture.schedule.bd;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;

import com.gadreel.lecture.schedule.bd.base.BaseBd;
import com.gadreel.lecture.schedule.domain.Module;
import com.gadreel.lecture.schedule.domain.Schedule;
import com.gadreel.lecture.schedule.domain.StudentGroup;

public interface ScheduleBd extends BaseBd<Schedule>{
	
	/**
	 * Searches for a List of {@link Schedule}s
	 * @param studentGroupCode Student group code
	 * @param moduleCode Module code
	 * @param scheduleStartDateTime Schedule start date and time
	 * @param scheduleEndDateTime Schedule end date and time
	 * @return A List of {@link Schedule}s
	 */
	public List<Schedule> searchScheduleList(String studentGroupCode,String moduleCode,String scheduleStartDateTime,String scheduleEndDateTime) throws Exception;
	
	/**
	 * Deletes a {@link Schedule}
	 * @param scheduleId {@link Schedule} Id to be deleted
	 */
	public void deleteSchedule(int scheduleId) throws Exception;
	
	/**
	 * Creates or updates a {@link Schedule} 
	 * @param scheduleId Id of the {@link Schedule}
	 * @param studentGroupCode Student group code
	 * @param moduleCode Module code
	 * @param scheduleStartDateTime Schedule start date and time
	 * @param scheduleEndDateTime Schedule end date and time
	 * @param remark Remarks
	 * @return A {@link ResponseEntity} object containing json result and the Http error code
	 */
	public ResponseEntity<JSONObject> createOrUpdateSchedule( int scheduleId,String studentGroupCode, String moduleCode,
										 String scheduleStartDateTime,String scheduleEndDateTime, String remark) throws Exception;
	
	/**
	 * Set properties of a {@link Schedule}
	 * @param schedule {@link Schedule} object which the properties need to be set
	 * @param studentGroup {@link StudentGroup} object
	 * @param module {@link Module} object
	 * @param scheduleStartDateTime Schedule start date and time
	 * @param scheduleEndDateTime Schedule end date and time
	 * @param remark Remarks
	 */
	public void setProperties(Schedule schedule,StudentGroup studentGroup, Module module,
			 String scheduleStartDateTime,String scheduleEndDateTime, String remark) throws Exception;
}
