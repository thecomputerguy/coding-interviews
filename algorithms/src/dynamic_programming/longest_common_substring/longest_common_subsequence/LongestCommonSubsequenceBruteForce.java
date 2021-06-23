public class LongestCommonSubsequenceBruteForce {
    
    public int findLCSLength(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return 0;
        }

        return findLCSLengthRecursive(s1, s2, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int index1, int index2){
        if(index1 == s1.length() || index2 == s2.length()){
            return 0;
        }
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + findLCSLengthRecursive(s1, s2, index1 + 1, index2 + 1);
        }

        int l1 = findLCSLengthRecursive(s1, s2, index1 + 1, index2);
        int l2 = findLCSLengthRecursive(s1, s2, index1, index2 + 1);

        return Math.max(l1, l2);
    }

    public static void main(String[] args) {
        
        LongestCommonSubsequenceBruteForce lcs = new LongestCommonSubsequenceBruteForce();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    }
}
