public class EditDistance {
    
  public int findMinOperations(String s1, String s2) {
    if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
        return 0;
    }
    return findMinOperationsRecursive(s1, s2, 0, 0);
  }

  private int findMinOperationsRecursive(String s1, String s2, int index1, int index2) {
    if(index1 == s1.length()) return s2.length() - index2;
    if(index2 == s2.length()) return s1.length() - index1;
    if(s1.charAt(index1) == s2.charAt(index2)){
        return findMinOperationsRecursive(s1, s2, index1 + 1, index2 + 1);
    }
    int c1 = 1 + findMinOperationsRecursive(s1, s2, index1 + 1, index2);//delete operation
    int c2 = 1 + findMinOperationsRecursive(s1, s2, index1 + 1, index2 + 1);//replace operation
    int c3 = 1 + findMinOperationsRecursive(s1, s2, index1, index2 + 1);//insert operation

    return Math.min(c1, Math.min(c2, c3));
  }

  public static void main(String[] args) {
    EditDistance editDisatnce = new EditDistance();
    System.out.println(editDisatnce.findMinOperations("bat", "but"));
    System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
    System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
  }

}
