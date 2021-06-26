public class SPMBruteForce {

  public int findSPMCount(String str, String pat) {
    if(str == null || pat == null || str.length() == 0 || pat.length() == 0) return 0;
    return findSPMCountRecursive(str, pat, 0, 0);
  }

  private int findSPMCountRecursive(String str, String pat, int strIndex, int patIndex){
      if(patIndex == pat.length()){
        return 1; 
      }
      if(strIndex == str.length()){
        return 0;
      }
      int c1 = 0;
      if(str.charAt(strIndex) == pat.charAt(patIndex)){
        c1 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex + 1);
      }
      int c2 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex);

      return c1 + c2;
  }

  public static void main(String[] args) {
    SPMBruteForce spm = new SPMBruteForce();
    System.out.println(spm.findSPMCount("baxmx", "ax"));
    System.out.println(spm.findSPMCount("tomorrow", "tor"));
  }
}
