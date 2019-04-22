package taskmanagement.processor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DelayProcess {

	/**
	 * @param dl ngay ket thuc neu khong bi delay
	 * @param numOfDays so ngay delay
	 * @return tra ve ngay ket thuc sau khi bi delay
	 */
	Calendar delay (Calendar dl, int numOfDays) {
		String dayOfWeek = new SimpleDateFormat("EEE").format(dl.getTime());
		if(dayOfWeek.equals("Fri")){
			numOfDays+=2;
		}else if(dayOfWeek.equals("Sat")){
			numOfDays+=1;
		}
		dl.add(Calendar.DAY_OF_YEAR, numOfDays );
		return dl;
	}
}
