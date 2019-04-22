package taskmanagement.taskinfo;

import java.util.Date;

public class Event {
	private int id;
	private String eventName;
	private int personId;
	private Date eventDay;

	public Event() {
	}

	/**
	 * @param id
	 * @param eventName
	 * @param personId
	 * @param eventDay
	 */
	public Event(int id, String eventName, int personId, Date eventDay) {
		this.id = id;
		this.eventName = eventName;
		this.personId = personId;
		this.eventDay = eventDay;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the eventDay
	 */
	public Date getEventDay() {
		return eventDay;
	}

	/**
	 * @param eventDay
	 *            the eventDay to set
	 */
	public void setEventDay(Date eventDay) {
		this.eventDay = eventDay;
	}
}
