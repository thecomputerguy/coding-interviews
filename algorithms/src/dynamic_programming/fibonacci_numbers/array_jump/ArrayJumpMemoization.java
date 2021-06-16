public class ArrayJumpMemoization {
    

    public int countMinJumps(int[] jumps) {
        if(jumps == null || jumps.length == 0){
            return Integer.MAX_VALUE;
        }
        return countMinJumpsRecursive(jumps, 0, new int[jumps.length]);
    }

    private int countMinJumpsRecursive(int[] jumps, int currentIndex, int[] dp){
        if(jumps.length - 1 == currentIndex){
            return 0;
        }

        if(jumps[currentIndex] == 0){
            return Integer.MAX_VALUE;
        }

        if(dp[currentIndex] != 0){
            return dp[currentIndex];
        }
        
        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];
        while (start < jumps.length && start <= end) {
            int minJumps = countMinJumpsRecursive(jumps, start++, dp);
            if(minJumps != Integer.MAX_VALUE){
                totalJumps = Math.min(minJumps + 1, totalJumps);
            }
        }
        dp[currentIndex] = totalJumps;
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        ArrayJumpMemoization aj = new ArrayJumpMemoization();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
