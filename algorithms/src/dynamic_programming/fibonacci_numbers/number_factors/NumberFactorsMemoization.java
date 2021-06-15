public class NumberFactorsMemoization {
    
    public int countWays(int n, Integer[] dp){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        if(dp[n] != null){
            return dp[n];
        }
        
        dp[n] = countWays(n - 1, dp) + countWays(n - 3, dp) + countWays(n - 4, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        NumberFactorsMemoization en = new NumberFactorsMemoization();
        System.out.println(en.countWays(4, new Integer[5]));
        System.out.println(en.countWays(5, new Integer[6]));
        System.out.println(en.countWays(6, new Integer[7]));
    }
}
