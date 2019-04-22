package taskmanagement.readwritecsv;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import taskmanagement.taskinfo.PersonRank;

public class ReadRankPersonCSV extends ReadCSV  {
	// doc file csv
	/**
	 * @param ls mang du lieu duoc lay ra tu csv
	 * @return Rank
	 */
	public List<PersonRank> partionLine( LinkedList<String[]> ls){
		List<PersonRank> lst= new ArrayList<>();
		for(int i=0;i<ls.size();i++){
			PersonRank rank = new PersonRank();
			rank.setPersonId(Integer.parseInt(ls.get(i)[0]));
			if (ls.get(i)[1] == "") {
				rank.setId(Integer.parseInt(ls.get(i)[1]));
			} else
				rank.setId(Integer.parseInt(ls.get(i)[1]));
			lst.add(rank);
		}
		return lst;
	}
}
