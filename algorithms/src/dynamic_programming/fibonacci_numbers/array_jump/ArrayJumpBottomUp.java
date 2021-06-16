public class ArrayJumpBottomUp {
    
    public int countMinJumps(int[] jumps){
        int[] dp = new int[jumps.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int start = 0; start < jumps.length; start++) {
            for (int end = start + 1; end <= start + jumps[start] && end < jumps.length; end++) {
                dp[end] = Math.min(dp[start] + 1, dp[end]);
            }
        }

        return dp[jumps.length - 1];
    }


    public static void main(String[] args) {
        ArrayJumpBottomUp aj = new ArrayJumpBottomUp();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
  }
}
