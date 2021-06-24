public class MDIBruteForce {

  public void findMDI(String s1, String s2) {
    
    int c1 = findMDI(s1, s2, 0, 0);
    System.out.println("Minimum deletions needed: " + (s1.length() - c1));
    System.out.println("Minimum insertions needed: " + (s2.length() - c1));
  }
  
  private int findMDI(String s1, String s2, int index1, int index2){
    if(index1 == s1.length() || index2 == s2.length()){
        return 0;
    }

    if(s1.charAt(index1) == s2.charAt(index2)){
        return 1 + findMDI(s1, s2, index1 + 1, index2 + 1);
    }

    int c1 = findMDI(s1, s2, index1 + 1, index2);
    int c2 = findMDI(s1, s2, index1, index2 + 1);
    return Math.max(c1, c2);
  }
 
  public static void main(String[] args) {
    MDIBruteForce mdi = new MDIBruteForce();
    mdi.findMDI("abc", "fbc");
    mdi.findMDI("abdca", "cbda");
    mdi.findMDI("passport", "ppsspt");
  }

}
