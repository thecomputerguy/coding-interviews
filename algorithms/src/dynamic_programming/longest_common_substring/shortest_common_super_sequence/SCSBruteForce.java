class SCSBruteForce {

  public int findSCSLength(String s1, String s2) {
    
      return findSCSLengthRecursive(s1, s2, 0, 0);
  }

  private int findSCSLengthRecursive(String s1, String s2, int index1, int index2){
    if(index1 == s1.length())
      return s2.length()-index2;
    if(index2 == s2.length())
      return s1.length()-index1;

    if(s1.charAt(index1) == s2.charAt(index2))
      return 1 + findSCSLengthRecursive(s1, s2, index1+1, index2+1);

    int length1 = 1 + findSCSLengthRecursive(s1, s2, index1, index2+1);
    int length2 = 1 + findSCSLengthRecursive(s1, s2, index1+1, index2);

    return Math.min(length1, length2);
  }

  public static void main(String[] args) {
    SCSBruteForce scs = new SCSBruteForce();
    System.out.println(scs.findSCSLength("abcf", "bdcf"));
    System.out.println(scs.findSCSLength("dynamic", "programming"));
  }
}
