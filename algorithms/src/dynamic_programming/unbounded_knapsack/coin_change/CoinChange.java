public class CoinChange {

  public int countChange(int[] denominations, int total) {
    if(denominations == null || denominations.length == 0 || total == 0){
        return 0;
    }

    return countChangeRecursive(denominations, total, 0);
  }

  private int countChangeRecursive(int[] denominations, int total, int currentIndex){
      if(currentIndex >= denominations.length){
        return 0;
      }

      if(total == 0){
        return 1;
      }

      int count1 = 0;
      int count2 = 0;
      if(denominations[currentIndex] <= total){
        count1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);
      }

      count2 = countChangeRecursive(denominations, total, currentIndex + 1);

      return count1 + count2;
  }
  
  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }

}
