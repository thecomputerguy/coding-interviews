import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntervalsOverlapOrNot {


    public static boolean findOverlap(List<Interval> intervals){
        if (intervals.size() < 2) return false;

        
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while(iterator.hasNext()){
            Interval next = iterator.next();
            if (next.start <= end) {
                return true;
            }else{
                start = next.start;
                end = next.end;
            }
        }

        return false;

    }
    

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Overlap ? ");
        boolean result = IntervalsOverlapOrNot.findOverlap(input);
        System.out.println(result);
        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Overlap ? ");
        result = IntervalsOverlapOrNot.findOverlap(input);
        System.out.println(result);
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Overlap ? ");
        result = IntervalsOverlapOrNot.findOverlap(input);
        System.out.println(result);
        System.out.println();
    }
}

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}