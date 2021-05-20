package alternate_approach_using_hashmap;

import java.util.HashMap;
import java.util.Map;

public class AlternateApproachUsingHashMap {
   
public static int[] search(int[] array, int target){
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] result = new int[]{-1, -1};
    
    //Throw each element in the hashmap.
    for (int i = 0; i < array.length; i++) {
        int leftElement = array[i];
        int remaining = target - leftElement;
        if(map.containsKey(remaining)){
            int j = map.get(remaining);
            result[0] = Math.min(i, j);
            result[1] = Math.max(i, j);
            return result;
        }
        map.put(leftElement, i);
    }

    return result;
}
    
     public static void main(String[] args) {
    int[] result = AlternateApproachUsingHashMap.search(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = AlternateApproachUsingHashMap.search(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }
}
