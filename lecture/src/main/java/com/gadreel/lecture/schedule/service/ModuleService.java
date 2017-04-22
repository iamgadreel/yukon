/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * Service class to handle module related requests
 */
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

import com.gadreel.lecture.schedule.bd.ModuleBd;

@Controller
@RequestMapping("/module")
public class ModuleService {
	
	@Autowired
	private ModuleBd moduleBd;
	
	/**
	 * Creates a Module
	 * @param moduleCode Module code
	 * @param moduleName Module name
	 * @param credits Credits allocated to the Module
	 * @param moduleLeader Name of the leader
	 * @return A json string containing the result
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseEntity<JSONObject> createModule(@RequestParam("moduleCode") String moduleCode,
																 @RequestParam("moduleName") String moduleName,
																 @RequestParam("credits") int credits,
																 @RequestParam("moduleLeader") String moduleLeader) {
		JSONObject jsonObject = new JSONObject();
		try{
			
			moduleBd.createModule(moduleCode, moduleName, credits, moduleLeader);
			
			
			jsonObject.put("msg", "Module, "+moduleCode+" created successfully!");
			return new ResponseEntity<>(jsonObject,HttpStatus.OK);
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while creating module, "+moduleCode+"!");
			return new ResponseEntity<>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
