public class CPSBottomUp {
    
    public int findCPS(String input){
        if (input == null || input.length() == 0) {
            return 0;            
        }

        int count = 0;
        boolean[][] dp = new boolean[input.length()][input.length()];
        for (int i = 0; i < input.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int start = input.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < input.length(); end++) {
                if(input.charAt(start) == input.charAt(end)) {
                    if(end - start == 1 || dp[start + 1][end - 1] == true){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        CPSBottomUp cps = new CPSBottomUp();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
}
