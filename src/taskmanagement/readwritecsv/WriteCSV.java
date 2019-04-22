package taskmanagement.readwritecsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import taskmanagement.taskinfo.Person;
import taskmanagement.taskinfo.Task;

public class WriteCSV {

	public void writeCsvFile(String fileName, List<Person> lsp) throws IOException {

		try (FileWriter writer = new FileWriter("output.csv");
		BufferedWriter buffer = new BufferedWriter(writer)){
		
			buffer.write("id,projectid,PersonId,Taskname,cost,start,end,Delay_start,Delay_end");
			buffer.write("\n");
			for (int i = 0; i < lsp.size(); i++) {
				for (Task t : lsp.get(i).getTask()) {
					buffer.write(String.valueOf(t.getId()) + ',');
					buffer.write(String.valueOf(t.getProjectId()) + ',');
					buffer.write(String.valueOf(t.getPersonId()) + ',');
					buffer.write(String.valueOf(t.getTaskName()) + ',');
					buffer.write(String.valueOf(t.getCost()) + ',');
					String st = new SimpleDateFormat("yyyy/MM/dd").format(t.getStart());
					buffer.write(st + ',');
					String end = new SimpleDateFormat("yyyy/MM/dd").format(t.getEnd());
					buffer.write(end + ',');
					buffer.write(String.valueOf(t.getDelayStart()) + ',');
					buffer.write(String.valueOf(t.getDelayEnd()) + '\n');
				}
			}
	} catch (IOException e) {
		e.printStackTrace();
	}
		System.out.println("Success...");
	}

}
