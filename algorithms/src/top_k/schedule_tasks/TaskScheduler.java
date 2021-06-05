import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

class TaskScheduler {

  public static int scheduleTasks(char[] tasks, int k) {
    
    Map<Character, Integer> frequency = new HashMap<Character, Integer>();
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
    for (int i = 0; i < tasks.length; i++) {
      frequency.put(tasks[i], frequency.getOrDefault(tasks[i], 0) + 1);
    }

    maxHeap.addAll(frequency.entrySet());
    int intervalCount = 0;
    while(!maxHeap.isEmpty()) {
      List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
      int n = k + 1;
      for (; n > 0 && !maxHeap.isEmpty(); n--) {
        Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
        intervalCount++;
        if(currentEntry.getValue() > 1){
          currentEntry.setValue(currentEntry.getValue() - 1);
          waitList.add(currentEntry);
        }
      }
      maxHeap.addAll(waitList);
      if(!maxHeap.isEmpty()){
        intervalCount += n;
      }
    }

    return intervalCount;
  }

  public static void main(String[] args) {
    char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

    tasks = new char[] { 'a', 'b', 'a' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
  }
}
