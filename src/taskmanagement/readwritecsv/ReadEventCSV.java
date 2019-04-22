package taskmanagement.readwritecsv;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import taskmanagement.taskinfo.Event;

public class ReadEventCSV extends ReadCSV{

	/**
	 * @param ls
	 *            danh sach du lieu duoc lay tu csv csv
	 * @return Event
	 */
	public List<Event> partionLine(LinkedList<String[]> ls) {
		List<Event> lst = new ArrayList<>();
		for (int i = 0; i < ls.size(); i++) {
			Event event = new Event();
			event.setId(Integer.parseInt(ls.get(i)[0]));
			event.setPersonId(Integer.parseInt(ls.get(i)[1]));
			event.setEventName(ls.get(i)[2]);
			if (ls.get(i)[3] == "") {
				event.setEventDay(null);
			} else {
				int year = Integer.parseInt(ls.get(i)[3].substring(0, 4));
				int month = Integer.parseInt(ls.get(i)[3].substring(4, 6));
				int day = Integer.parseInt(ls.get(i)[3].substring(6, 8));
				Calendar cal = Calendar.getInstance();
				cal.set(year, month - 1, day);
				event.setEventDay(cal.getTime());
			}
			lst.add(event);
		}
		return lst;
	}
}
