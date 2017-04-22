/**
 * @author Hasun Rathnayake
 * Date 22/04/2017
 * Schedule service class which handles Schedule related services
 */
package com.gadreel.lecture.schedule.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gadreel.lecture.schedule.bd.ScheduleBd;
import com.gadreel.lecture.schedule.domain.Schedule;
@Controller
@RequestMapping("/schedule")
public class ScheduleService {
	
	@Autowired
	private ScheduleBd scheduleBd;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseEntity<JSONObject> createShedule(@RequestParam("studentGroup") String studentGroupCode,
																  @RequestParam("module") String moduleCode,
																  @RequestParam("scheduleStartDateTime") String scheduleStartDateTime,
																  @RequestParam("scheduleEndDateTime") String scheduleEndDateTime,
																  @RequestParam("remark") String remark) {
		try{
			
			return scheduleBd.createOrUpdateSchedule(0, studentGroupCode, moduleCode, scheduleStartDateTime, scheduleEndDateTime, remark);
		} catch(Exception exception){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("msg", "An unexpected error occurred while updating the schedule!");
			return new ResponseEntity<>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/publish", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json", consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<List<Schedule>> publishSchedule(@RequestParam("studentGroup") String studentGroupCode,
																 	@RequestParam("module") String moduleCode,
																 	@RequestParam("scheduleStartDateTime") String scheduleStartDateTime,
																 	@RequestParam("scheduleEndDateTime") String scheduleEndDateTime,
																 	HttpServletResponse servletResponse,
																	HttpServletRequest request) {
		List<Schedule> scheduleList= null;
		try{
			scheduleList = scheduleBd.searchScheduleList(studentGroupCode, moduleCode, scheduleStartDateTime, scheduleEndDateTime);
			return new ResponseEntity<>(scheduleList,HttpStatus.OK);
		} catch(Exception exception){
			return new ResponseEntity<>(scheduleList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json", consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<JSONObject> updateSchedule( @RequestParam("scheduleId") int scheduleId,
																  @RequestParam("studentGroup") String studentGroupCode,
																  @RequestParam("module") String moduleCode,
																  @RequestParam("scheduleStartDateTime") String scheduleStartDateTime,
																  @RequestParam("scheduleEndDateTime") String scheduleEndDateTime,
																  @RequestParam("remark") String remark,HttpServletResponse servletResponse,
																  HttpServletRequest request) {
		try{
			
			return scheduleBd.createOrUpdateSchedule(scheduleId, studentGroupCode, moduleCode, scheduleStartDateTime, scheduleEndDateTime, remark);
		} catch(Exception exception){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("msg", "An unexpected error occurred while updating the schedule!");
			return new ResponseEntity<>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delete", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json", consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<JSONObject> deleteSchedule( @RequestParam("scheduleId") int scheduleId){
		JSONObject jsonObject = new JSONObject();
		try{
			scheduleBd.deleteSchedule(scheduleId);
			jsonObject.put("msg", "Schedule deleted successfully!");
			return new ResponseEntity<>(jsonObject,HttpStatus.OK);
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while deleting the schedule!");
			return new ResponseEntity<>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
