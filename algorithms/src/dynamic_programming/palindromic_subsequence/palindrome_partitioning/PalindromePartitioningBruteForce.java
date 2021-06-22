public class PalindromePartitioningBruteForce {
    
    public int findMPPCuts(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        return findMPPCutsRecursive(input, 0, input.length() - 1);
    }

    private int findMPPCutsRecursive(String input, int start, int end){
        if(start >= end || isPalindrome(input, start, end)){
            return 0;
        }

        int minCuts = end - start; // maximum cuts that are possible
        for (int i = start; i <= end; i++) {
            if(isPalindrome(input, start, i)){
                minCuts = Math.min(minCuts, 1 + findMPPCutsRecursive(input, i + 1, end));
            }
        }

        return minCuts;
    }

    private boolean isPalindrome(String input, int start, int end){
        while(start < end){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        
        PalindromePartitioningBruteForce mpp = new PalindromePartitioningBruteForce();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}
