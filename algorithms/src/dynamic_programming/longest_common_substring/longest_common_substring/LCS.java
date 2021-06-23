public class LCS {

  public int findLCSLength(String s1, String s2) {
    if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
      return 0;
    }
    return findLCSLengthRecursive(s1, s2, 0, 0, 0);
  }

  private int findLCSLengthRecursive(String s1, String s2, int index1, int index2, int count){
    if(index1 == s1.length() || index2 == s2.length()){
      return count;
    }

    
    if(s1.charAt(index1) == s2.charAt(index2)){
      count = findLCSLengthRecursive(s1, s2, index1 + 1, index2 + 1, count + 1);
    }

    int c1 =  findLCSLengthRecursive(s1, s2, index1 + 1, index2, 0);
    int c2 = findLCSLengthRecursive(s1, s2, index1, index2 + 1, 0);

    return Math.max(count, Math.max(c1, c2));
  }

  public static void main(String[] args) {
    LCS lcs = new LCS();
    System.out.println(lcs.findLCSLength("abdca", "cbda"));
    System.out.println(lcs.findLCSLength("passport", "ppsspt"));
  }
}
