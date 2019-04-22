package taskmanagement.taskinfo;

import java.util.Date;

public class Task {
	private int id;
	private String projectId;
	private int personId;
	private String taskName;
	private int cost;
	private Date start;
	private Date end;
	private int delayStart;
	private int delayEnd;

	public Task() {
	}

	/**
	 * @param id
	 * @param projectId
	 * @param personId
	 * @param taskName
	 * @param cost
	 * @param start
	 * @param end
	 * @param delay_start
	 * @param delay_end
	 */
	public Task(int id, String projectId, int personId, String taskName, int cost, Date start, Date end,
			int delayStart, int delayEnd) {
		this.id = id;
		this.projectId = projectId;
		this.personId = personId;
		this.taskName = taskName;
		this.cost = cost;
		this.start = start;
		this.end = end;
		this.delayStart = delayStart;
		this.delayEnd = delayEnd;
	}

	/**
	 * @return the delay_start
	 */
	public int getDelayStart() {
		return delayStart;
	}

	/**
	 * @param delay_start
	 *            the delay_start to set
	 */
	public void setDelayStart(int delayStart) {
		this.delayStart = delayStart;
	}

	/**
	 * @return the delay_end
	 */
	public int getDelayEnd() {
		return delayEnd;
	}

	/**
	 * @param delay_end
	 *            the delay_end to set
	 */
	public void setDelayEnd(int delayEnd) {
		this.delayEnd = delayEnd;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
