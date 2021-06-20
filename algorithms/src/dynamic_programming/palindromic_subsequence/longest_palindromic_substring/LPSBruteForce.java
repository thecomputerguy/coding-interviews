public class LPSBruteForce {
    
    public int findLPSLength(String input){
        if(input == null || input.length() == 0){
            return 0;
        }
        return findLPSLengthRecursive(input, 0, input.length() - 1);
    }

    public int findLPSLengthRecursive(String input, int start, int end){

        if(start > end){
            return 0;
        }

        if(start == end){
            return 1;
        }

        if(input.charAt(start) == input.charAt(end)){
            int remainingLength = end - start - 1;
            if(remainingLength == findLPSLengthRecursive(input, start + 1, end - 1)){
                return 2 + remainingLength;
            }
        }

        int skipStart = findLPSLengthRecursive(input, start + 1, end);
        int skipEnd = findLPSLengthRecursive(input, start, end - 1);

        return Math.max(skipStart, skipEnd);
    }

    public static void main(String[] args) {
        LPSBruteForce lps = new LPSBruteForce();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
  }
}
