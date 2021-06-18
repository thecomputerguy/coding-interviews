public class HouseThiefBottomUpSpaceOptimized {
    
  public int findMaxSteal(int[] wealth) {
    if(wealth == null || wealth.length == 0){
        return 0;
    }

    int n1 = 0;
    int n2 = wealth[0];
    for (int i = 1; i < wealth.length; i++) {
        int temp = Math.max(n1 + wealth[i], n2);
        n1 = n2;
        n2 = temp;
    }

    return n2;
  }

  public static void main(String[] args) {
    HouseThiefBottomUpSpaceOptimized ht = new HouseThiefBottomUpSpaceOptimized();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }

}
