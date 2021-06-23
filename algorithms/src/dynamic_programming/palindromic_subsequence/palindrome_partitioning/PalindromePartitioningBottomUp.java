public class PalindromePartitioningBottomUp {
    
    public int findMPPCuts(String input){   
        if(input == null || input.length() == 0){
            return 0;
        }
        boolean[][] dpIsPalindrome = new boolean[input.length()][input.length()];
        for (int i = 0; i < input.length(); i++) {
            dpIsPalindrome[i][i] = true;
        }

        for (int start = input.length() - 1; start >= 0 ; start--) {
            for (int end = start + 1; end < input.length(); end++) {
                if(input.charAt(start) == input.charAt(end)) {
                    if(end - start == 1 || dpIsPalindrome[start + 1][end - 1]){

                        dpIsPalindrome[start][end] = true;
                    }
                }
            }
        }

        //dp for minCuts
        //it will store min cuts starting from the index till the end
        int[] cuts = new int[input.length()];
        for (int start = dpIsPalindrome.length - 1; start >= 0; start--) {
            int minCuts = input.length() - 1;
            for (int end = dpIsPalindrome.length - 1; end >= start; end--) {
                if(dpIsPalindrome[start][end]){
                    minCuts = (end == input.length() - 1) ? 0 : Math.min(minCuts, 1 + cuts[end + 1]);
                }
            }
            cuts[start] = minCuts;
        }

        return cuts[0];
    }

    public static void main(String[] args) {   
        PalindromePartitioningBottomUp mpp = new PalindromePartitioningBottomUp();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}
