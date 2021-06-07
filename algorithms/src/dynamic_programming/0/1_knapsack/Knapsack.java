public class Knapsack {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity){

        int maxProfit = solveKnapsackRecursive(profits, weights, capacity, 0);
        return maxProfit;
    }

    private int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int index){
        
        if(index >= profits.length || capacity <= 0){
            return 0;
        }

        int profit1 = 0;
        int profit2 = 0;
        if(weights[index] <= capacity){

            profit1 = profits[index] + solveKnapsackRecursive(profits, weights, capacity - weights[index], index + 1);
        }
        profit2 = solveKnapsackRecursive(profits, weights, capacity, index + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
