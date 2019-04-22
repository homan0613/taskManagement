package taskmanagement.processor;

import java.util.ArrayList;
import java.util.List;

import taskmanagement.taskinfo.Task;

public class ProjectProcess {
	// tach task theo project

	/**
	 * @param lst
	 *            danh sach cac task
	 * @param t
	 *            vi tri cua project dang xet
	 * @return danh sach task duoc chia theo project
	 */
	List<Task> PartionForProject(List<Task> lst, int t) {
		List<Task> ls = new ArrayList<>();
		String fp = lst.get(t).getProjectId();
		for (int i = 0; i < lst.size(); i++) {
			if (fp.equals(lst.get(i).getProjectId())) {
				ls.add(lst.get(i));
			}
		}
		return ls;
	}

	// dem so project

	/**
	 * @param ls
	 *            danh sach cac task
	 * @return so project trong do
	 */
	int countProject(List<Task> ls) {
		int count = 0;
		int t = 0;
		for (int i = 0; i < ls.size(); i++) {
			String name = ls.get(t).getProjectId();
			if (!name.equals(ls.get(i).getProjectId())) {
				count++;
				t += i;
			}
		}
		return count;
	}

}
