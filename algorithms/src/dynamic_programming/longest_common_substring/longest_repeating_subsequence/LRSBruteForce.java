public class LRSBruteForce {

  public int findLRSLength(String str) {
    if(str == null || str.length() == 0) return 0;
    return findLRSLengthRecursive(str, 0, 0);
  }

  private int findLRSLengthRecursive(String str, int index1, int index2){
    if(index1 == str.length() || index2 == str.length()){
        return 0;
    }

    if(index1 != index2 && str.charAt(index1) == str.charAt(index2)){
        return 1 + findLRSLengthRecursive(str, index1 + 1, index2 + 1);
    }

    int c1 = findLRSLengthRecursive(str, index1 + 1, index2);
    int c2 = findLRSLengthRecursive(str, index1, index2 + 1);
    return Math.max(c1, c2);
  }

  public static void main(String[] args) {
    LRSBruteForce lrs = new LRSBruteForce();
    System.out.println(lrs.findLRSLength("tomorrow"));
    System.out.println(lrs.findLRSLength("aabdbcec"));
    System.out.println(lrs.findLRSLength("fmff"));
}

}
