package taskmanagement.readwritecsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public abstract class ReadCSV {

	abstract List<?> partionLine( LinkedList<String[]> ls);
	public LinkedList<String[]> readFile(String fileName) {
		LinkedList<String[]> ll = new LinkedList<String[]>();
		int t = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String newLine;
			while ((newLine = br.readLine()) != null) {
				if (t > 0) {
					int d = 0;
					String tt = "";
					String[] st = new String[countComma(newLine) + 1];
					for (int i = 0; i <= newLine.length(); i++) {
						if (i < newLine.length()) {
							if (newLine.charAt(i) != ',') {
								tt = tt + String.valueOf(newLine.charAt(i));
							} else {
								st[d] = tt;
								tt = "";
								d++;
							}
						} else {
							st[countComma(newLine)] = tt;
						}
					}
					ll.add(st);
				}
				t++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ll;
	}

	int countComma(String line) {
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ',') {
				count++;
			}
		}
		return count;
	}

}
