package taskmanagement.processor;

import java.util.ArrayList;
import java.util.List;

import taskmanagement.taskinfo.Person;
import taskmanagement.taskinfo.Task;

public class PersonProcess {
	// kiem tra person da ton tai hay chua

	/**
	 * @param idPersion
	 *            id cua person can kiem tra
	 * @param ls
	 *            danh sach id person
	 * @return neu da ton tai false
	 */
	boolean hasPersonInTasks(int idPersion, List<Integer> ls) {
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) == idPersion) {
				return false;
			}
		}
		return true;
	}

	// tach list theo person

	/**
	 * @param ls
	 *            danh sach task
	 * @return danh sach cac task theo person
	 */
	List<Person> partitionForPerson(List<Task> ls) {
		List<Person> lsPer = new ArrayList<>();
		List<Task> lsTemp = ls;
		List<Integer> t = new ArrayList<>();
		for (int i = 0; i < lsTemp.size(); i++) {
			if (hasPersonInTasks(lsTemp.get(i).getPersonId(), t) == true) {
				t.add(lsTemp.get(i).getPersonId());
			}
		}
		for (int i = 0; i < t.size(); i++) {
			List<Task> lsTask = new ArrayList<>();
			Person p = new Person();
			lsTemp = ls;
			p.setid(t.get(i));
			for (int j = 0; j < lsTemp.size(); j++) {
				if (lsTemp.get(j).getPersonId() == t.get(i)) {
					lsTask.add(ls.get(j));
					lsTemp.remove(j);
				}
			}
			QuickSort q = new QuickSort();
			q.quickSort(lsTask, 0, lsTask.size() - 1);
			p.setTask(lsTask);
			lsPer.add(p);
		}
		return lsPer;
	}

}
