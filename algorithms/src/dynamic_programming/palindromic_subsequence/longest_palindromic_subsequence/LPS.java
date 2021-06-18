/**
 * Brute force solution
 */
public class LPS {
   
    public int findLPSLength(String input){
        if(input == null || input.length() == 0) return 0;
        
        return findLPSLengthRecursive(input, 0, input.length() - 1);
    }

    private int findLPSLengthRecursive(String input, int startIndex, int endIndex){
        if (startIndex > endIndex) {
            return 0;
        }

        if(startIndex == endIndex){
            return 1;
        }

        if(input.charAt(startIndex) == input.charAt(endIndex)){
            return 2 + findLPSLengthRecursive(input, startIndex + 1, endIndex - 1);
        }

        int skipBeginning = findLPSLengthRecursive(input, startIndex + 1, endIndex);
        int skipEnding = findLPSLengthRecursive(input, startIndex, endIndex - 1);
        return Math.max(skipBeginning, skipEnding);
    }
    
    public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }
}
