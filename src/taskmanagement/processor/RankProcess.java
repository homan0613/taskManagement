package taskmanagement.processor;

import java.util.List;

import taskmanagement.taskinfo.PersonRank;
import taskmanagement.taskinfo.Rank;

public class RankProcess {

	/**
	 * @param idPerson id person can lay thong tin event 
	 * @param cost so gio lam cua task
	 * @param listRank danh sach rank
	 * @param listRankPe danh sach rank theo person 
	 * @return
	 */
	int getNumberDayToComplete(int idPerson, int cost, List<Rank> listRank, List<PersonRank> listRankPe) {
		float numDay = 0;
		for (int i = 0; i < listRankPe.size(); i++) {
			if (idPerson == listRankPe.get(i).getPersonId()) {
				switch (listRankPe.get(i).getId()) {
				case 1:
					numDay = cost * (1 + 1 - listRank.get(0).getPerformance()) / 8;
					break;
				case 2:
					numDay = cost * (1 + 1 - listRank.get(1).getPerformance()) / 8;
					break;
				case 4:
					numDay = cost * (1 + 1 - listRank.get(3).getPerformance()) / 8;
					break;
				case 5:
					numDay = cost * (1 + 1 - listRank.get(4).getPerformance()) / 8;
					break;

				default:
					numDay = cost / 8;
					break;
				}
			}
		}

		return Math.round(numDay);
	}
}
