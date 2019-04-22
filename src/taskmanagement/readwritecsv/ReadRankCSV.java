package taskmanagement.readwritecsv;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import taskmanagement.taskinfo.Rank;

public class ReadRankCSV extends ReadCSV {
	
	/**
	 * @param line  dong du lieu trong file csv
	 * @return Rank
	 */
	public List<Rank> partionLine( LinkedList<String[]> ls){
		List<Rank> lst= new ArrayList<>();
		for(int i=0;i<ls.size();i++){
			Rank rank = new Rank();
			rank.setId(Integer.parseInt(ls.get(i)[0]));
			rank.setName(ls.get(i)[1]);
			rank.setPerformance(Float.parseFloat(ls.get(i)[2]));
			lst.add(rank);
		}
		return lst;
	}

}
