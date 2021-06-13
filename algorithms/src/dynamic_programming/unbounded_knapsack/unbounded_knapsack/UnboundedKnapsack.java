public class UnboundedKnapsack {
    
  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if(capacity <= 0 || profits == null || weights == null || weights.length == 0 || profits.length == 0 || weights.length != profits.length){
        return 0;
    }

    return solveKnapsackRecursive(profits, weights, capacity, 0);
  }

  private int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex){
    if (currentIndex >= weights.length) {
        return 0;        
    }

    int profit1 = 0; int profit2 = 0;
    if(weights[currentIndex] <= capacity) {
        profit1 = profits[currentIndex] + solveKnapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);
    }

    profit2 = solveKnapsackRecursive(profits, weights, capacity, currentIndex + 1);

    return Math.max(profit1, profit2);
  }

  public static void main(String[] args) {
    UnboundedKnapsack ks = new UnboundedKnapsack();
    int[] profits = { 15, 50, 60, 90 };
    int[] weights = { 1, 3, 4, 5 };
    int maxProfit = ks.solveKnapsack(profits, weights, 8);
    System.out.println(maxProfit);
  }
}
