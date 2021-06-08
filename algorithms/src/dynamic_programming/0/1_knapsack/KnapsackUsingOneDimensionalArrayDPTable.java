public class KnapsackUsingOneDimensionalArrayDPTable {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity){

        if(profits == null || weights == null || profits.length != weights.length || capacity == 0){
            return 0;
        }
        
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            if(weights[0] <= capacity){
                dp[i] = profits[0];
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0; int profit2 = 0;
                if(weights[i] <= c){
                    profit1 = profits[i] + dp[c - weights[i]];
                }

                profit2 = dp[c];
                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        KnapsackUsingOneDimensionalArrayDPTable ks = new KnapsackUsingOneDimensionalArrayDPTable();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
