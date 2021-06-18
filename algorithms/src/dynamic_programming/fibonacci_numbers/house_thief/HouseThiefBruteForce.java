public class HouseThiefBruteForce {
    
  public int findMaxSteal(int[] wealth) {
    if(wealth == null || wealth.length == 0){
        return 0;
    }
    return findMaxStealRecursive(wealth, 0);
  }

  private int findMaxStealRecursive(int[] wealth, int currentIndex){
    if(currentIndex >= wealth.length){
        return 0;
    }

    int robHouse = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2);
    int skipHouse = findMaxStealRecursive(wealth, currentIndex + 1);

    return Math.max(robHouse, skipHouse);
  }

  public static void main(String[] args) {
    HouseThiefBruteForce ht = new HouseThiefBruteForce();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }

}
