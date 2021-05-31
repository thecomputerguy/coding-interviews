import java.util.PriorityQueue;

class Interval{
    int start, end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class NextInterval {
    
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>((a, b) -> Integer.compare(intervals[b].start, intervals[a].start));
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>((a, b) -> Integer.compare(intervals[b].end, intervals[a].end));

        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        for (int i = 0; i < intervals.length; i++) {
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;
            
            if(intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                int topStart = maxStartHeap.poll();
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.offer(topStart);
            }
                        
        }

        return result;
    }

    public static void main(String[] args) {
        
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
        System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
        System.out.print(index + " ");

    }
}
