import java.util.*;

class SequenceReconstruction {
  public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
    if(originalSeq == null || originalSeq.length == 0) return false;
    
    //Initialize graph
    Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    Queue<Integer> sources = new LinkedList<Integer>();
    List<Integer> sortedOrder = new ArrayList<Integer>();
    for (int[] seq : sequences) {
        for (int i = 0; i < seq.length; i++) {
            inDegree.put(seq[i], 0);
            graph.put(seq[i], new ArrayList<Integer>());
        }
    }

    //Build graph
    for (int[] sequence : sequences) {
        for (int i = 1; i < sequence.length; i++) {
            int parent = sequence[i-1]; int child = sequence[i];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
    }

    if(inDegree.size() != originalSeq.length){
        return false;
    }

    //Find sources
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
        if(entry.getValue() == 0){
            sources.add(entry.getKey());
        }
    }

    //Topological sort
    while(!sources.isEmpty()){
        if(sources.size() > 1){
            return false;
        }
        if(sources.peek() != originalSeq[sortedOrder.size()]){
            return false;
        }
        int vertex = sources.poll();
        sortedOrder.add(vertex);
        List<Integer> children = graph.get(vertex);
        for (Integer child : children) {
            inDegree.put(child, inDegree.get(child) - 1);
            if(inDegree.get(child) == 0){
                sources.add(child);
            }
        }
    }

    return sortedOrder.size() == originalSeq.length;
  }

  public static void main(String[] args) {
    boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
        new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
    System.out.println("Can we uniquely construct the sequence: " + result);

    result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
        new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
    System.out.println("Can we uniquely construct the sequence: " + result);

    result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
        new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
    System.out.println("Can we uniquely construct the sequence: " + result);
  }
}