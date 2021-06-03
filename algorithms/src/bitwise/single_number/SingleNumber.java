class SingleNumber {
  public static int findSingleNumber(int[] arr) {
    int x1 = arr[0];

    for (int i = 1; i < arr.length; i++) {
        x1 = x1 ^ arr[i];
    }

    return x1;
  }

  public static void main( String args[] ) {
    System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
  }
}