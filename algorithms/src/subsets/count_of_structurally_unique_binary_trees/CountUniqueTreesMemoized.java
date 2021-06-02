import java.util.HashMap;
import java.util.Map;

public class CountUniqueTreesMemoized {

    private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    
    public int countTrees(int n) {
    
        if(cache.containsKey(n)){
            return cache.get(n);
        }
    if(n <= 1) return 1;

    int count = 0;
    for (int i = 1; i <= n; i++) {
        
        int leftCount = countTrees(i-1);
        int rightCount = countTrees(n-i);
        count += (leftCount * rightCount);
    }
    cache.put(n, count);
    return count;
  }
  
  public static void main(String[] args) {
   CountUniqueTreesMemoized ct = new CountUniqueTreesMemoized();
    int count = ct.countTrees(3);
    System.out.print("Total trees: " + count);
    System.out.println();
    int count1 = ct.countTrees(2);
    System.out.print("Total trees: " + count1);
  }

}
