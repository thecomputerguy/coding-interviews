public class UnboundedKnapsackSpaceOptimized {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if(profits == null || weights == null || profits.length != weights.length || capacity == 0){
            return 0;
        }
        int[] dp = new int[capacity + 1];
        
        for (int i = 0; i <= capacity; i++) {
            if(weights[0] == i){
                dp[i] = 1;
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = capacity; j >= 0; j++) {
                //if we choose an item
                int profit1 = 0;
                int profit2 = 0;

                if(weights[i] <= j){
                    profit1 = profits[i] + dp[j - weights[i]];
                }
                //we don't choose an item
                profit2 = dp[j];
                dp[j] = Math.max(profit1, profit2);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsackBottomUp ks = new UnboundedKnapsackBottomUp();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
  }

}
