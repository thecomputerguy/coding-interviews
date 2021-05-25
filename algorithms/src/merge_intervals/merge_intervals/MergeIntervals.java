import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals){
        if(intervals.size() < 2) return intervals;
        
        List<Interval> result = new LinkedList<>();
        
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> iter = intervals.iterator();
        Interval interval = iter.next();

        int start = interval.start;
        int end = interval.end;
        
        while (iter.hasNext()) {
            Interval next = iter.next();
            if (next.start <= end) {
                end = Math.max(end, next.end);
            }else{
                result.add(new Interval(start, end));
                start = next.start;
                end = next.end;
            }
        }
        
        result.add(new Interval(start, end));

        return result;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
    
    }
}

class Interval{
    int start, end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}