package taskmanagement.readwritecsv;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import taskmanagement.taskinfo.Task;

public class ReadTaskCSV extends ReadCSV  {

	/**
	 * @param ls
	 *            danh sach du lieu duoc lay tu csv csv
	 * @return list<Task>
	 */
	public List<Task> partionLine(LinkedList<String[]> ls) {
		List<Task> lst = new ArrayList<>();
		for (int i = 0; i < ls.size(); i++) {
			Task t = new Task();
			t.setId(Integer.parseInt(ls.get(i)[0]));
			t.setProjectId(ls.get(i)[1]);
			t.setPersonId(Integer.parseInt(ls.get(i)[2]));
			t.setTaskName(ls.get(i)[3]);
			t.setCost(Integer.parseInt(ls.get(i)[4]));
			if (ls.get(i)[5].equals("")) {
				t.setStart(null);
			} else
				t.setStart(Date.valueOf(ls.get(i)[5]));
			if (ls.get(i)[6] == "") {
				t.setEnd(null);
			} else
				t.setEnd(Date.valueOf(ls.get(i)[6]));
			if (ls.get(i)[7] == "") {
				t.setDelayStart(0);
			} else
				t.setDelayStart(Integer.parseInt(ls.get(i)[7]));
			if (ls.get(i)[8] == "") {
				t.setDelayEnd(0);
			} else
				t.setDelayEnd(Integer.parseInt(ls.get(i)[8]));
			lst.add(t);
		}
		return lst;
	}
}
