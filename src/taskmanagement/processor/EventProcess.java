package taskmanagement.processor;

import java.util.Date;
import java.util.List;

import taskmanagement.taskinfo.Event;

public class EventProcess {

	/**
	 * @param idPerson id cua person can kiem tra
	 * @param start ngay bat dau task
	 * @param end ngay ket thuc cua task
	 * @return so ngay nghi co trong task
	 */
	int checkEvent(List<Event> listEvent, int idPerson, Date start, Date end) {
		int numberDayOfEvents = 0;
		for (int i = 0; i < listEvent.size(); i++) {
			if (listEvent.get(i).getPersonId() == idPerson) {
				if (listEvent.get(i).getEventDay().after(start) && listEvent.get(i).getEventDay().before(end)) {
					numberDayOfEvents++;
				}
			}
		}
		return numberDayOfEvents;
	}

}
