public class StaircaseWithFeeMemoization{

    public int findMinFee(int[] fee){
        if(fee == null || fee.length == 0){
            return 0;
        }
        return findMinFeeRecursive(fee, 0, new Integer[fee.length]);
    }

    private int findMinFeeRecursive(int[] fee, int currentIndex, Integer[] dp){
        if(currentIndex >= fee.length){
            return 0;
        }
        if(dp[currentIndex] != null){
            return dp[currentIndex];
        }
        int fee1 = findMinFeeRecursive(fee, currentIndex + 1, dp);
        int fee2 = findMinFeeRecursive(fee, currentIndex + 2, dp);
        int fee3 = findMinFeeRecursive(fee, currentIndex + 3, dp);

        int minFee = Math.min(fee1, Math.min(fee2, fee3));
        dp[currentIndex] = minFee + fee[currentIndex];
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        StaircaseWithFeeMemoization sc = new StaircaseWithFeeMemoization();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    
    }
}