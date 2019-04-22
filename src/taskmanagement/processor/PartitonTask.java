package taskmanagement.processor;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import taskmanagement.taskinfo.Event;
import taskmanagement.taskinfo.Person;
import taskmanagement.taskinfo.PersonRank;
import taskmanagement.taskinfo.Rank;
import taskmanagement.taskinfo.Task;

public class PartitonTask extends DateProcess{

	/**
	 * @param ls
	 *            danh sach task dau vao
	 * @param year
	 *            nam bat dau
	 * @param month
	 *            thang bat dau
	 * @param day
	 *            ngay bat dau
	 * @param listEvent
	 *            danh sach cac su kien
	 * @param listRank 
	 * 			  danh sach cac loai rank
	 * @param listRankPe 
	 * 			  danh sach rank theo person
	 * @return danh sach cac task sau khi phan cong theo ngay
	 */
	public List<Person> assignTask(List<Task> ls, int year, int month, int day, List<Event> listEvent, List<Rank> listRank,List<PersonRank> listRankPe) {
		int count = 0;// dem so project
		int t = 0;// luu tam thu tu project
		
		ProjectProcess proProcess = new ProjectProcess();
		PersonProcess perProcess = new PersonProcess();;
		EventProcess eventDay = new EventProcess();
		
		int c = proProcess.countProject(ls);// so project
		
		List<Person> lsPerson = new ArrayList<>();// list tam luu danh sach person duoc chia theo project
		List<Person> lsPerResult = new ArrayList<>();// danh sach ket qua tra ve
		
		List<Task> endDayOfProject = new LinkedList<>();
		List<Task> endDayOfProjectTmp = new LinkedList<>();
		
		Calendar startDay = Calendar.getInstance();
		
		while (count <= c) {
			lsPerson = perProcess.partitionForPerson(proProcess.PartionForProject(ls, t));// luu danh sach person tra ve

			for (int i = 0; i < lsPerson.size(); i++) {

				if (count < 1) {
					startDay.set(year, month-1, day);// ngay bat dau
					startDay= checkOff(startDay);
				} else {
					for (int k = 0; k < endDayOfProjectTmp.size(); k++) {
						if (lsPerson.get(i).getid() == endDayOfProjectTmp.get(k).getPersonId()) {
							Calendar cal = Calendar.getInstance();
							cal.setTime(endDayOfProjectTmp.get(k).getEnd());
							cal.add(Calendar.DAY_OF_YEAR, 1);
							cal = checkOff(cal);
							startDay = cal;
						}
					}
				}
				for (int j = 0; j < lsPerson.get(i).getTask().size(); j++) {
					DelayProcess delayPro = new DelayProcess();
					
					delayPro.delay(startDay, lsPerson.get(i).getTask().get(j).getDelayStart());// them ngay delay_start
					lsPerson.get(i).getTask().get(j).setStart(startDay.getTime());
					
					Calendar dayEnd = end(lsPerson.get(i).getTask().get(j).getPersonId(), startDay,
							lsPerson.get(i).getTask().get(j).getCost(), listRank, listRankPe);// ngay ket thuc
					delayPro.delay(dayEnd, lsPerson.get(i).getTask().get(j).getDelayEnd());// them ngay delay_end
					
					dayEnd.add(Calendar.DAY_OF_YEAR,
							eventDay.checkEvent(listEvent, lsPerson.get(i).getTask().get(j).getPersonId(),
									lsPerson.get(i).getTask().get(j).getStart(), dayEnd.getTime()));// kiem tra ngay nghi phep
					
					dayEnd = checkOff(dayEnd);

					lsPerson.get(i).getTask().get(j).setEnd(dayEnd.getTime());
					if (j < lsPerson.get(i).getTask().size() - 1) {
						dayEnd.add(Calendar.DAY_OF_YEAR, 1);
						
						dayEnd = checkOff(dayEnd);
						startDay = dayEnd;
					}
					if (j == lsPerson.get(i).getTask().size() - 1) {
						endDayOfProject.add(i, lsPerson.get(i).getTask().get(j));
					}
				}

			}
			endDayOfProjectTmp = new LinkedList<>();
			endDayOfProjectTmp.addAll(endDayOfProject);
			endDayOfProject = new LinkedList<>();
			lsPerResult.addAll(lsPerson);
			t = t + proProcess.PartionForProject(ls, t).size();
			count++;
		}
		return lsPerResult;
	}
	
	

}
