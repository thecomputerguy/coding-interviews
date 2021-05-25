import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class EmployeeInterval{
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex){
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}

public class EmployeesFreeTime {


    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule){
        List<Interval> result = new ArrayList<>();
        if (schedule == null || schedule.size() == 0)  return result;

        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(schedule.size(), (a, b) -> Integer.compare(a.interval.start, b.interval.start));
        int i = 0;
        while (i < schedule.size()) {
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
            i++;
        }

        Interval previousInterval  = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            //Non overlapping case
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            }else{ //overlapping case
                if(previousInterval.end < queueTop.interval.end){
                    previousInterval = queueTop.interval;
                }
            }

            List<Interval> intervals = schedule.get(queueTop.employeeIndex);
            if (queueTop.intervalIndex + 1 < intervals.size()) {
                    
                    minHeap.offer(new EmployeeInterval(schedule.get(queueTop.employeeIndex).get(queueTop.intervalIndex + 1), queueTop.employeeIndex, queueTop.intervalIndex + 1));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeesFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
        System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeesFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
        System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeesFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
        System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
