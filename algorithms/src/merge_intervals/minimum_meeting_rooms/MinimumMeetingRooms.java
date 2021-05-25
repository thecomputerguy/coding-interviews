import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings){
        int maxMeetingRooms = Integer.MIN_VALUE;
        if (meetings == null || meetings.size() == 0) {
            return 0;
        }
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        Iterator<Meeting> iter = meetings.iterator();
        minHeap.add(iter.next());

        while(iter.hasNext()){
            Meeting next = iter.next();
            while (!minHeap.isEmpty() && minHeap.peek().end <= next.start) {
                minHeap.poll();
            }
            minHeap.offer(next);
            maxMeetingRooms = Math.max(maxMeetingRooms, minHeap.size());
        }

        return maxMeetingRooms;
    }
    
    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 5));
        add(new Meeting(7, 9));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(6, 7));
        add(new Meeting(2, 4));
        add(new Meeting(8, 12));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 3));
        add(new Meeting(3, 6));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);


    }
}

class Meeting{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}