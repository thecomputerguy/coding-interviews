public class PalindromePartitioningMemoization {
    
    public int findMPPCuts(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        Integer[][] dp = new Integer[input.length()][input.length()];
        Boolean[][]  dpIsPalindrome = new Boolean[input.length()][input.length()];

        return findMPPCutsRecursive(input, 0, input.length() - 1, dp, dpIsPalindrome);
    }

    private int findMPPCutsRecursive(String input, int start, int end, Integer[][] dp, Boolean[][] dpIsPalindrome){
        if(start >= end || isPalindrome(input, start, end, dpIsPalindrome)){
            return 0;
        }
        if(dp[start][end] != null){
            return dp[start][end];
        }

        int minCuts = end - start; // maximum cuts that are possible
        for (int i = start; i <= end; i++) {
            if(isPalindrome(input, start, i, dpIsPalindrome)){
                minCuts = Math.min(minCuts, 1 + findMPPCutsRecursive(input, i + 1, end, dp, dpIsPalindrome));
            }
        }

        dp[start][end] = minCuts;
        return dp[start][end];
    }

    private boolean isPalindrome(String input, int start, int end, Boolean[][] dpIsPalindrome){
        int x = start, y = end;
        if(dpIsPalindrome[x][y] != null){
            return dpIsPalindrome[x][y];
        }
        while(start < end){
            if(input.charAt(start) != input.charAt(end)){
                dpIsPalindrome[x][y] = false;
                return dpIsPalindrome[x][y];
            }
            start++;
            end--;
        }
        dpIsPalindrome[x][y] = true;
        return dpIsPalindrome[x][y];
    }

    public static void main(String[] args) {
        
        PalindromePartitioningMemoization mpp = new PalindromePartitioningMemoization();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}
