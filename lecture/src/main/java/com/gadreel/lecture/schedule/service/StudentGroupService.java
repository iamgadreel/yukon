package com.gadreel.lecture.schedule.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gadreel.lecture.schedule.bd.StudentGroupBd;

@Controller
@RequestMapping("/group")
public class StudentGroupService {

	@Autowired
	private StudentGroupBd studentGroupBd;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<JSONObject> createGroup(@RequestParam("groupCode") String groupCode,
																@RequestParam("groupDesc") String groupDesc) {
		JSONObject jsonObject = new JSONObject();
		try{
					
			studentGroupBd.createStudentGroup(groupCode, groupDesc);
			
			jsonObject.put("msg", "Group, "+groupCode+" created successfully!");
			return new ResponseEntity<>(jsonObject,HttpStatus.OK);
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while creating group, "+groupCode+"!");
			return new ResponseEntity<>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
