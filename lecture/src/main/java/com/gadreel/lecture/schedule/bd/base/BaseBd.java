/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * General operations of the Business delegation layer
 */
package com.gadreel.lecture.schedule.bd.base;

public interface BaseBd <T>{
	/**
	 * Get the Type by the object code
	 * @param code code of the object
	 * @return a <T> type object
	 * @throws Exception
	 */
	public T getByCode(String code)throws Exception;
	
	/**
	 * Get the Type by the object id
	 * @param id Id of the object
	 * @return a <T> type object
	 * @throws Exception
	 */
	public T getById(int id)throws Exception;
}
