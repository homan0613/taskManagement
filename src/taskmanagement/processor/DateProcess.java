package taskmanagement.processor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import taskmanagement.taskinfo.PersonRank;
import taskmanagement.taskinfo.Rank;


public abstract class DateProcess {
	/**
	 * @param start ngay bat dau
	 * @param cost khoi luong gio lam
	 * @return ngay ket thuc
	 */
	Calendar end(int idPerson, Calendar start, int cost,List<Rank> listRank,List<PersonRank> listRankPe) {
		Calendar dayEnd = Calendar.getInstance();
		//int n = Math.round(cost / 8);
		RankProcess rank= new RankProcess();
		int n = rank.getNumberDayToComplete(idPerson, cost, listRank, listRankPe);// so ngay lam viec
		int t = (start.get(Calendar.DAY_OF_WEEK) + n) / 7;// co bao nieu ngay thu 7, cn trong chuoi lam viec do				
		if (t > 5) {
			t += 1;
		}
		if (n !=0 ) {
			// so ngay can de hoan thanhtask+so ngay nghi-1ngay vi ngay kt va ngay bd deu lam
			start.add(Calendar.DAY_OF_YEAR, n + t * 2-1);
			dayEnd= start;
		} else {
			dayEnd = start;
		}
		
		return checkOff(dayEnd);
	}

	// kiem tra ngay bat dau

	/**
	 * @param d ngay bat dau
	 * @param m thang bat dau
	 * @param y nam bat dau
	 * @return ngay bat dau
	 */
	Calendar checkOff(Calendar cal) {
		
		String dayOfWeek = new SimpleDateFormat("EEE").format(cal.getTime());
		if (dayOfWeek.equals("Sat")) {
			cal.add(Calendar.DAY_OF_YEAR, 2); // ngay mot
		} else if (dayOfWeek.equals("Sun")) {
			cal.add(Calendar.DAY_OF_YEAR, 1);// ngay mai
		}
		return cal;
	}

	/**
	 * @param st kieu chuoi can lay vd: dd, MM, yyyy
	 * @param date ngay can lay
	 * @return du lieu theo kieu int
	 */
	int getDate(String st, Date date){
		return Integer.parseInt(new SimpleDateFormat(st).format(date));
	}
}
