public class StaircaseWithFeeBottomUp {

    public int findMinFee(int[] fee){
        if(fee == null || fee.length == 0){
            return 0;
        }
        
        int[] dp = new int[fee.length + 1];
        dp[0] = 0;
        dp[1] = fee[0];
        dp[2] = dp[3] = fee[0];

        for (int i = 3; i < fee.length; i++) {
            dp[i + 1] = Math.min(fee[i] + dp[i], Math.min(fee[i - 1] + dp[i - 1], fee[i - 2] + dp[i - 2]));
        }

        return dp[fee.length];
    }

    public static void main(String[] args) {
        StaircaseWithFeeBottomUp sc = new StaircaseWithFeeBottomUp();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    
    }
}
