package taskmanagement.taskinfo;

import java.util.List;

public class Person {
	private int id;
	private List<Task> task;

	public Person(int id, List<Task> task) {
		this.id = id;
		this.task = task;
	}

	public Person() {
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

}
