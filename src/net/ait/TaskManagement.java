package net.ait;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import taskmanagement.processor.PartitonTask;
import taskmanagement.readwritecsv.ReadEventCSV;
import taskmanagement.readwritecsv.ReadRankCSV;
import taskmanagement.readwritecsv.ReadRankPersonCSV;
import taskmanagement.readwritecsv.ReadTaskCSV;
import taskmanagement.readwritecsv.WriteCSV;
import taskmanagement.taskinfo.Event;
import taskmanagement.taskinfo.Person;
import taskmanagement.taskinfo.PersonRank;
import taskmanagement.taskinfo.Rank;
import taskmanagement.taskinfo.Task;

public class TaskManagement {
	public static void main(String[] args) throws IOException {
//		 int y = Integer.parseInt(args[1].substring(0, 4));
//		 int m = Integer.parseInt(args[1].substring(4, 6));
//		 int d = Integer.parseInt(args[1].substring(6, 8));
//		
//		 String readFile = args[2];
//		 String writeFile = args[6];
//		 String eventFile = args[3];
//		String ranktFile = args[4];
//		String rankPertFile = args[5];
		
		String writeFile = "output.csv";
		String readFile = "sample.csv";
		String eventFile = "event.csv";		 
		String ranktFile = "Rank.csv";
		String rankPertFile = "person_rank.csv";
		
		int y = 2019;
		int m = 02;
		int d = 14;

		ReadTaskCSV rTask = new ReadTaskCSV();
		ReadEventCSV rEvent = new ReadEventCSV();
		PartitonTask pTask  = new PartitonTask();
		ReadRankCSV rank= new ReadRankCSV();
		ReadRankPersonCSV ranPer= new ReadRankPersonCSV();

		//LinkList duoc lay ra tu file csv
		LinkedList<String[]> taskLinkList = rTask.readFile(readFile);
		LinkedList<String[]> eventLinkList = rEvent.readFile(eventFile);
		LinkedList<String[]> rankPerLinkList= ranPer.readFile(rankPertFile);
		LinkedList<String[]> rankLinkList= rank.readFile(ranktFile);

		List<Task> lsTask = rTask.partionLine(taskLinkList);
		List<Event> lsEvent = rEvent.partionLine(eventLinkList);
		List<PersonRank> listRankPer= ranPer.partionLine(rankPerLinkList);
		List<Rank> listRank= rank.partionLine(rankLinkList);
		
		List<Person> lsp = pTask.assignTask(lsTask, y, m, d,lsEvent,listRank,listRankPer);
		

		String fileName = writeFile;
		WriteCSV w = new WriteCSV();
		w.writeCsvFile(fileName, lsp);
	}
}
