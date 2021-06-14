class RodCutting {

  public int solveRodCutting(int[] lengths, int[] prices, int n) {
    if(lengths == null || prices == null || prices.length == 0 || lengths.length == 0 || prices.length != lengths.length || n == 0){
        return 0;
    }
    return solveRodCuttingRecursive(lengths, prices, n , 0);
  }

  private int solveRodCuttingRecursive(int[] lengths, int[] prices, int n, int currentIndex){
    if(currentIndex >= prices.length){
        return 0;
    }

    int profit1 = 0;
    int profit2 = 0;

    if(lengths[currentIndex] <= n){
        profit1 = prices[currentIndex] + solveRodCuttingRecursive(lengths, prices, n - lengths[currentIndex], currentIndex);
    }
    profit2 = solveRodCuttingRecursive(lengths, prices, n, currentIndex + 1);
    return Math.max(profit1, profit2);
  }

  public static void main(String[] args) {
    RodCutting rc = new RodCutting();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }
}
