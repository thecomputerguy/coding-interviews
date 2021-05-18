import java.util.HashMap;
import java.util.Map;

public class FruitsIntheBasket {
    
    public static int maxFruits(char[] trees){
        int uniqueBaskets = 2;
        if(trees == null || trees.length == 0) return 0;
        int windowStart = 0, maxFruitsInBasket = Integer.MIN_VALUE;
        Map<Character, Integer> basketMap = new HashMap<>();
        
        for (int windowEnd = 0; windowEnd < trees.length; windowEnd++) {
            char fruit = trees[windowEnd];
            basketMap.put(fruit, basketMap.getOrDefault(fruit, 0) + 1);
            while (basketMap.size() > uniqueBaskets) {
                basketMap.put(trees[windowStart], basketMap.get(trees[windowStart]) - 1);
                if (basketMap.get(trees[windowStart]) == 0) {
                  basketMap.remove(trees[windowStart]);  
                }
                windowStart++;
            }

            maxFruitsInBasket = Math.max(maxFruitsInBasket, windowEnd - windowStart + 1);
        }

        return maxFruitsInBasket == Integer.MIN_VALUE ? 0 : maxFruitsInBasket;
    }

    public static void main(String[] args) {
        int maxFruits = FruitsIntheBasket.maxFruits(new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println("Max fruits " + maxFruits);
        int maxFruits2 = FruitsIntheBasket.maxFruits(new char[]{'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println("Max fruits2 " + maxFruits2);
    }
}
