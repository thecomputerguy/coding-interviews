import java.util.*;

class MinimumHeightTrees {
  public static List<Integer> findTrees(int nodes, int[][] edges) {
    List<Integer> minHeightTrees = new ArrayList<>();
    
    if (nodes <= 0) {
        return minHeightTrees;        
    }

    if(nodes == 1){
      minHeightTrees.add(0);  
    }

    //Initialize graph
    Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    Queue<Integer> leaves = new LinkedList<Integer>();
    for (int i = 0; i < nodes; i++) {
        inDegree.put(i, 0);
        graph.put(i, new ArrayList<>());
    }

    //Build graph
    for (int i = 0; i < edges.length; i++) {
        int n1 = edges[i][0]; int n2 = edges[i][1];
        graph.get(n1).add(n2);
        graph.get(n2).add(n1);
        inDegree.put(n1, inDegree.get(n1) + 1);
        inDegree.put(n2, inDegree.get(n2) + 1);
    }

    //Find leaves
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
        if(entry.getValue() == 1){
            leaves.add(entry.getKey());
        }
    }

    //Topological sort
    int totalNodes = nodes;
    while(totalNodes > 2){
        int leavesSize = leaves.size();;
        totalNodes -= leavesSize;
        for (int i = 0; i < leavesSize; i++) {
            int node = leaves.poll();
            List<Integer> children = graph.get(node);
            for (Integer child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 1){
                    leaves.add(child);
                }              
            }
        }
    }

    minHeightTrees.addAll(leaves);
    return minHeightTrees;
  }

  public static void main(String[] args) {
    List<Integer> result = MinimumHeightTrees.findTrees(5,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
    System.out.println("Roots of MHTs: " + result);

    result = MinimumHeightTrees.findTrees(4,
        new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
    System.out.println("Roots of MHTs: " + result);

    result = MinimumHeightTrees.findTrees(4,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
    System.out.println("Roots of MHTs: " + result);
  }
}