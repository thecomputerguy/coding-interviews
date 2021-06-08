package knapsack;
public class KnapsackWithMemoization {

    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        if(profits.length != weights.length) return 0;
        return solveKnapsackRecursive(profits, weights, capacity, 0, new Integer[profits.length][capacity + 1]);
    }

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int index, Integer[][] cache){
        if(capacity <= 0 || index >= profits.length){
            return 0;
        }

        if(cache[index][capacity] != null){    
            return cache[index][capacity];
        }

        int profit1 = 0;
        int profit2 = 0;
        if(weights[index] <= capacity){
            profit1 = profits[index] + solveKnapsackRecursive(profits, weights, capacity - weights[index], index + 1, cache);
        }

        profit2 = solveKnapsackRecursive(profits, weights, capacity, index + 1, cache);

        cache[index][capacity] = Math.max(profit1, profit2);
        return cache[index][capacity];
    }

    public static void main(String[] args) {
        KnapsackWithMemoization ks = new KnapsackWithMemoization();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }
}
