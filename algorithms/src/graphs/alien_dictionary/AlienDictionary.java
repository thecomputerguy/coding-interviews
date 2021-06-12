import java.util.*;

class AlienDictionary {
  public static String findOrder(String[] words) {
    
    //initialize graph
    Map<Character, Integer> inDegree = new HashMap<>();
    Map<Character, List<Character>> graph = new HashMap<>();
    Queue<Character> sources = new LinkedList<>();
    
    //Initialize here
    for (String word : words) {
        for (int i = 0; i < word.length(); i++) {
            inDegree.put(word.charAt(i), 0);
            graph.put(word.charAt(i), new ArrayList<>());
        }        
    }

    //build graph
    for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i]; String w2 = words[i + 1];
        for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
            if(w1.charAt(j) != w2.charAt(j)){
                Character parent = w1.charAt(j);
                Character child = w2.charAt(j);
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child) + 1);
                break;
            }
        }        
    }

    //find sources
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
        if(entry.getValue() == 0){
            sources.add(entry.getKey());
        }
    }

    //Topological sort
    StringBuilder sortedOrder = new StringBuilder();
    while(!sources.isEmpty()){
        Character vertex = sources.poll();
        sortedOrder.append(vertex);
        List<Character> children = graph.get(vertex);
        for (Character child : children) {
            inDegree.put(child, inDegree.get(child) - 1);
            if(inDegree.get(child) == 0){
                sources.add(child);
            }          
        }
    }    


    return sortedOrder.toString();
  }

  public static void main(String[] args) {
    String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
    System.out.println("Character order: " + result);
  }

}
