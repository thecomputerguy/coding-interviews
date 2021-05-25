import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllConflictingAppointments {
    

    public static List<Interval> conflictingAppointments(Interval[] intervals){
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return result;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        Interval interval = intervals[0];
        int start = interval.start;
        int end = interval.end;

        int i = 1;
        while(i < intervals.length) {
            Interval nextInterval  = intervals[i];
            if (end > nextInterval.start) {
                result.add(new Interval(start, end));
                result.add(new Interval(nextInterval.start, nextInterval.end));
                start = Math.min(start, nextInterval.start);
                end = Math.max(end, nextInterval.end);
            }else{
                start = nextInterval.start;
                end = nextInterval.end;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        List<Interval> result = AllConflictingAppointments.conflictingAppointments(intervals);
        System.out.println("Conflicting appointments are ");
        result.stream().forEach(interval -> {
            System.out.println(interval.start + "  : " + interval.end);
        });

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = AllConflictingAppointments.conflictingAppointments(intervals1);
        System.out.println("Conflicting appointments are ");
        result.stream().forEach(interval -> {
            System.out.println(interval.start + "  : " + interval.end);
        });

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = AllConflictingAppointments.conflictingAppointments(intervals2);
        System.out.println("Conflicting appointments are ");
        result.stream().forEach(interval -> {
            System.out.println(interval.start + "  : " + interval.end);
        });

        Interval[] intervals3 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6), new Interval(5, 7), new Interval(7, 8) };
        result = AllConflictingAppointments.conflictingAppointments(intervals3);
        System.out.println("Conflicting appointments are ");
        result.stream().forEach(interval -> {
            System.out.println(interval.start + "  : " + interval.end);
        });
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