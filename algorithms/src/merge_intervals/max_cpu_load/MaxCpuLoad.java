import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCpuLoad {
    
    public static int findMaxCPULoad(List<Job> jobs){
        int maxLoad = Integer.MIN_VALUE;
        int currentLoad = 0;
        if (jobs == null || jobs.size() == 0) {
            return 0;
        }

        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Job job : jobs) {

            while (!minHeap.isEmpty() && minHeap.peek().end < job.start) {
                Job jobGoingOut = minHeap.poll();
                currentLoad -= jobGoingOut.load;
            }
            minHeap.offer(job);
            currentLoad += job.load;
            maxLoad = Math.max(maxLoad, currentLoad);
        }

        return maxLoad;
    }

    public static void main(String[] args) {
        
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaxCpuLoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaxCpuLoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaxCpuLoad.findMaxCPULoad(input));
    }
}


class Job{
    int start;
    int end;
    int load;
    public Job(int start, int end, int load){
        this.start = start;
        this.end = end;
        this.load = load;
    }
}