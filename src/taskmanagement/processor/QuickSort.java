package taskmanagement.processor;

import java.util.List;

import taskmanagement.taskinfo.Task;


public class QuickSort {
	public List<Task> quickSort(List<Task> ls, int start, int end) {

		int partition = partition(ls, start, end);

		if (partition - 1 > start) {
			quickSort(ls, start, partition - 1);
		}
		if (partition + 1 < end) {
			quickSort(ls, partition + 1, end);
		}
		return ls;
	}

	public int partition(List<Task> a, int start, int end) {
		Task pivot = a.get(end);

		for (int i = start; i < end; i++) {
			if (a.get(i).getCost() > pivot.getCost()) {
				Task temp = a.get(start);
				a.set(start, a.get(i));
				a.set(i, temp);
				start++;
			}
		}

		Task temp = a.get(start);
		a.set(start, pivot);
		a.set(end, temp);

		return start;
	}

}
