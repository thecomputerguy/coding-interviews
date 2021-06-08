public class KnapsackMaintaining1PreviousRowForDPTable {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        if(profits == null || weights == null || profits.length != weights.length || capacity == 0){
            return 0;
        }

        int[][] dp = new int[2][capacity + 1];
        
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= capacity; i++) {
            if(weights[0] <= i){
                dp[0][i] = profits[0];
            }
        }

        for (int i = 1; i < profits.length; i++) {
            
            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0; int profit2 = 0;    
                if(weights[i] <= j){
                    profit1 = profits[i] + dp[(i-1)%2][j - weights[i]];
                }
                profit2 = dp[(i-1) % 2][j];
                dp[i%2][j] = Math.max(profit1, profit2);
            }
        }

        return dp[(profits.length-1) % 2][capacity];
    }

    public static void main(String[] args) {
        
        KnapsackMaintaining1PreviousRowForDPTable ks = new KnapsackMaintaining1PreviousRowForDPTable();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
