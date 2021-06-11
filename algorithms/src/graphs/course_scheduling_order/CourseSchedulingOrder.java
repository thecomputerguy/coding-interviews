import java.util.*;

public class CourseSchedulingOrder {
    
  public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
    if(tasks <= 0) return new ArrayList<>();
    
    //Initialize graph
    Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    Queue<Integer> sources = new LinkedList<Integer>();
    List<Integer> sortedOrder = new ArrayList<Integer>();
    for (int i = 0; i < tasks; i++) {
        inDegree.put(i, 0);
        graph.put(i, new ArrayList<Integer>());
    }
    
    //Create graph
    for (int i = 0; i < prerequisites.length; i++) {
        int parent = prerequisites[i][0]; int child = prerequisites[i][1];
        graph.get(parent).add(child);
        inDegree.put(child, inDegree.get(child) + 1);
    }

    //find sources
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
        if(entry.getValue() == 0){
            sources.add(entry.getKey());
        }
    }

    //Topological sort
    while(!sources.isEmpty()){
        int element = sources.poll();
        sortedOrder.add(element);
        List<Integer> children = graph.get(element);
        for (Integer child : children) {
            inDegree.put(child, inDegree.get(child) - 1);
            if(inDegree.get(child) == 0){
                sources.add(child);
            }
        }
    }

    if(sortedOrder.size() != tasks){
        return new ArrayList<>();
    }
    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = CourseSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println(result);

    result = CourseSchedulingOrder.findOrder(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
    System.out.println(result);

    result = CourseSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
        new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println(result);
  }



}
