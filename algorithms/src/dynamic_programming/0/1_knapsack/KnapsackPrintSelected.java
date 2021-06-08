public class KnapsackPrintSelected {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= capacity; i++) {    
            if(weights[0] <= i){
                dp[0][i] = profits[0];
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0; int profit2 = 0;
                if(weights[i] <= j) {
                    profit1 = profits[i] + dp[i-1][j - weights[i]];
                }
                profit2 = dp[i - 1][j];
                dp[i][j] = Math.max(profit1, profit2);             
            }
        }

        printSelected(profits, weights, capacity, dp);
        return dp[profits.length-1][capacity];
    }


   private void printSelected(int[] profits, int[] weights, int capacity, int[][] dp){
        int totalProfit = dp[weights.length-1][capacity];
        System.out.println("Selected weights : ");
        for (int i = weights.length - 1; i > 0; i--) {
            
            if(totalProfit != dp[i - 1][capacity]){
                System.out.print(" " + weights[i]);
                totalProfit -= profits[i];
                capacity -= weights[i]; 
            }
        }
        System.out.println();

    }


    public static void main(String[] args) {
        KnapsackPrintSelected ks = new KnapsackPrintSelected();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
