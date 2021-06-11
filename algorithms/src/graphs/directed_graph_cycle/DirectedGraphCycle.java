import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DirectedGraphCycle {
 
  public static boolean sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
        if(vertices < 0) return false;

        //initialize graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> sources = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());            
        }
        //create a graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0]; int child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        //find all sources
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) sources.add(entry.getKey());
        }

        //Topological sort or BFS
        while(!sources.isEmpty()) {
            Integer element = sources.poll();
            sortedOrder.add(element);
            List<Integer> children = graph.get(element);
            for(Integer child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0){
                    sources.add(child);
                }
            }
        }

        if(sortedOrder.size() != vertices){
            return true;
        }

    return false;
  }

  public static void main(String[] args) {
    boolean result = DirectedGraphCycle.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = DirectedGraphCycle.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = DirectedGraphCycle.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }

}
