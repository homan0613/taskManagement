package taskmanagement.taskinfo;

public class Rank {
	private int id;
	private String name;
	private float performance;
	
	
	public Rank() {
	}

	/**
	 * @param id
	 * @param name
	 * @param performance
	 */
	public Rank(int id, String name, float performance) {
		this.id = id;
		this.name = name;
		this.performance = performance;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the performance
	 */
	public float getPerformance() {
		return performance;
	}

	/**
	 * @param performance the performance to set
	 */
	public void setPerformance(float performance) {
		this.performance = performance;
	}
}
