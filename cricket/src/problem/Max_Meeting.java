package problem;
import java.util.*;

public class Max_Meeting {
	
	// ---------- Method 1: Using TreeMap ----------
	public static int calcmeeTreeMap(int[] start, int[] end) {
		Map<Integer, int[]> endbassor = new TreeMap<>();
		
		for (int i = 0; i < start.length; i++) {
			int[] stpos = new int[2];
			stpos[0] = start[i];
			stpos[1] = i;
			endbassor.put(end[i], stpos);
		}
		
		int count = 0;
		int lastEnd = -1;
		
		for (Map.Entry<Integer, int[]> entry : endbassor.entrySet()) {
			int endTime = entry.getKey();
			int startTime = entry.getValue()[0];
			
			if (startTime > lastEnd) {
				count++;
				lastEnd = endTime;
			}
		}
		return count;
	}
	
	// ---------- Method 2: Using Sorting ----------
	static class Meeting {
		int start, end, index;
		Meeting(int s, int e, int i) {
			start = s;
			end = e;
			index = i;
		}
	}
	
	public static int calcmeeSort(int[] start, int[] end) {
		int n = start.length;
		Meeting[] meetings = new Meeting[n];
		
		for (int i = 0; i < n; i++) {
			meetings[i] = new Meeting(start[i], end[i], i);
		}
		
		Arrays.sort(meetings, (a, b) -> a.end - b.end);
		
		int count = 0;
		int lastEnd = -1;
		
		for (Meeting m : meetings) {
			if (m.start > lastEnd) {
				count++;
				lastEnd = m.end;
			}
		}
		return count;
	}
	
	// ---------- Main to test both ----------
	public static void main(String[] args) {
		int[] start = {0,3,1,5,5,8};
		int[] end   = {5,4,2,9,7,9};
		
		System.out.println("TreeMap method → Max meetings: " + calcmeeTreeMap(start, end));
		System.out.println("Sorting method → Max meetings: " + calcmeeSort(start, end));
	}
}
