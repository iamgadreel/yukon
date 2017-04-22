/**
 * @author Hasun Rathnayake
 * Date : 22/04/2017
 * General operations of the Data access object layer
 */
package com.gadreel.lecture.schedule.dao.base;

public interface DaoBase<T> {
	
	
	/**
	 * Creates an object in the database
	 * @param t a <T> type object
	 */
	public void create(T t);
	
	/**
	 * Deletes an object in the database
	 * @param t a <T> type object
	 */
	public void delete(T t);
	
	/**
	 * Updates an object in the database
	 * @param t a <T> type object
	 */
	public void update(T t);
	
	/**
	 * Get a particular object by its ID
	 * @param id Id of the object
	 * @return a <T> type object
	 */
	public T getById(int id);
	
	/**
	 * Get a particular object by its code
	 * @param code a code of the <T> type object
	 * @return a <T> type object
	 */
	public T getByCode(String code);
}
