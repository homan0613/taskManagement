package taskmanagement.taskinfo;

public class PersonRank {

	private int id;
	private int personId;
	
	public PersonRank() {
	}
	
	
	/**
	 * @param id
	 * @param personId
	 */
	public PersonRank(int id, int personId) {
		this.id = id;
		this.personId = personId;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}
	
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}
}
