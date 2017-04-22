/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Business delegation implementation layer of {@link Schedule} domain.
 */
package com.gadreel.lecture.schedule.bd.impl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gadreel.lecture.schedule.bd.ModuleBd;
import com.gadreel.lecture.schedule.bd.ScheduleBd;
import com.gadreel.lecture.schedule.bd.StudentGroupBd;
import com.gadreel.lecture.schedule.dao.ScheduleDao;
import com.gadreel.lecture.schedule.domain.Module;
import com.gadreel.lecture.schedule.domain.Schedule;
import com.gadreel.lecture.schedule.domain.StudentGroup;
import com.gadreel.lecture.schedule.util.DateUtil;

public class ScheduleBdImpl implements ScheduleBd {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private ModuleBd moduleBd;
	
	@Autowired
	private StudentGroupBd studentGroupBd;

	@Override
	public Schedule getByCode(String code) throws Exception {
		return scheduleDao.getByCode(code);
	}

	@Override
	public Schedule getById(int id) throws Exception {		
		return scheduleDao.getById(id);
	}

	@Override
	public List<Schedule> searchScheduleList(String studentGroupCode, String moduleCode, String scheduleStartDateTime,
			String scheduleEndDateTime) throws Exception {
		
		return scheduleDao.searchScheduleList(studentGroupCode, moduleCode,DateUtil.stringToDate(scheduleStartDateTime), DateUtil.stringToDate(scheduleEndDateTime));
	}

	@Override
	public void deleteSchedule(int scheduleId) throws Exception {
		Schedule schedule = getById(scheduleId);
		scheduleDao.delete(schedule);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<JSONObject> createOrUpdateSchedule(int scheduleId, String studentGroupCode, String moduleCode,
			String scheduleStartDateTime, String scheduleEndDateTime, String remark) throws Exception {

		boolean isCreating = scheduleId == 0;
		JSONObject jsonObject = new JSONObject();
		
		try{
			
			Module module 				= moduleBd.getByCode(moduleCode);
			StudentGroup  studentGroup 	= studentGroupBd.getByCode(studentGroupCode);
			
			if(studentGroup == null){
				jsonObject.put("msg", "Student group not found!");
				return new ResponseEntity<>(jsonObject,HttpStatus.NO_CONTENT);
			} else if(module == null){
				jsonObject.put("msg", "Module not found!");
				return new ResponseEntity<>(jsonObject,HttpStatus.NO_CONTENT);
			}
			
			Schedule schedule = null;
			
			if(isCreating){				
				schedule = new Schedule();
				setProperties(schedule, studentGroup, module, scheduleStartDateTime, scheduleEndDateTime, remark);
				scheduleDao.create(schedule);
			} else{
				schedule = getById(scheduleId);
				if(schedule == null){
					jsonObject.put("msg", "Schedule not found!");
					return new ResponseEntity<>(jsonObject,HttpStatus.NO_CONTENT);
				}
				setProperties(schedule,  studentGroup, module, scheduleStartDateTime, scheduleEndDateTime, remark);
				scheduleDao.update(schedule);
			}
			
			jsonObject.put("msg", "Schedule "+(isCreating ? "created" : "updated")+" successfully!");
			return new ResponseEntity<>(jsonObject,HttpStatus.OK);
			
		}catch (Exception e) {
			jsonObject.put("msg", "An unexpected error occurred while updating the schedule!");
			return new ResponseEntity<>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public void setProperties(Schedule schedule,StudentGroup studentGroup,Module module, String scheduleStartDateTime,
			String scheduleEndDateTime, String remark) throws Exception {
		
		schedule.setModule(module);
		schedule.setRemark(remark);
		schedule.setScheduleEndDateTime(DateUtil.stringToDate(scheduleEndDateTime));
		schedule.setScheduleStartDateTime(DateUtil.stringToDate(scheduleStartDateTime));
		schedule.setStudentGroup(studentGroup);
		
	}

}
