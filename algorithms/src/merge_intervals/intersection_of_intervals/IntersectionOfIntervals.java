import java.util.ArrayList;
import java.util.List;

public class IntersectionOfIntervals {

    public static Interval[] merge(Interval[] array1, Interval[] array2) {
        
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i].start >= array2[j].start && array1[i].start <= array2[j].end 
            || array2[j].start >= array1[i].start && array2[j].start <= array1[i].end) {
                int start = Math.max(array1[i].start, array2[j].start);
                int end = Math.min(array1[i].end, array2[j].end);
                result.add(new Interval(start, end));
            }

            //Move away from interval which finishes first.
            if(array1[i].end < array2[j].end){
                i++;
            }else{
                j++;
            }
        }
        return result.toArray(new Interval[result.size()]);
    }
    
    public static void main(String[] args) {
        
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntersectionOfIntervals.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
        System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntersectionOfIntervals.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
        System.out.print("[" + interval.start + "," + interval.end + "] ");

    }
}

class Interval{
    int start, end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}