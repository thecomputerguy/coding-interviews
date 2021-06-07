public class KnapsackWithBottomUpApproach {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        if(profits == null || weights == null || profits.length != weights.length || capacity <= 0){
            return 0;
        }
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            if(weights[0] <= capacity){
                dp[0][i] = profits[0];
            }
        }

        for (int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0, profit2 = 0;
                if(weights[i] <= j){
                    profit1 = profits[i] + dp[i-1][j - weights[i]];
                }
                profit2 = dp[i-1][j];
                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        return dp[profits.length-1][capacity];
    }

    public static void main(String[] args) {
        KnapsackWithBottomUpApproach ks = new KnapsackWithBottomUpApproach();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
