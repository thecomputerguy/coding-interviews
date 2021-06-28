public class SIBruteForce {

  public boolean findSI(String m, String n, String p) {

    return findSIRecursive(m, n, p, 0, 0, 0);
  }

  private boolean findSIRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex){    
    if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length()) return true;
    if(pIndex == p.length()) return false;

    boolean b1 = false;
    boolean b2 = false;
    if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex)){
        b1 = findSIRecursive(m, n, p, mIndex + 1, nIndex, pIndex + 1);
    }
    if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex)){
        b2 = findSIRecursive(m, n, p, mIndex, nIndex + 1, pIndex + 1);
    }

    return b1 || b2;

  }

  public static void main(String[] args) {
    SIBruteForce si = new SIBruteForce();
    System.out.println(si.findSI("abd", "cef", "abcdef"));
    System.out.println(si.findSI("abd", "cef", "adcbef"));
    System.out.println(si.findSI("abc", "def", "abdccf"));
    System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
  }


}
