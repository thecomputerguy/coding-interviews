public class NumberFactorsBottomUp {
    
    public int countWays(int n){
        if(n < 0){
            return -1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumberFactorsBottomUp en = new NumberFactorsBottomUp();
        System.out.println(en.countWays(4));
        System.out.println(en.countWays(5));
        System.out.println(en.countWays(6));
    }
}
