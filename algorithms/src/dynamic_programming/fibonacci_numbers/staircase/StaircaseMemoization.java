public class StaircaseMemoization {

  public int countWays(int n , Integer[] dp) {
    if(n == 0){
        return 1;
    }
    if(n == 1){
        return 1;
    }
    if(n == 2){
        return 2;
    }
    return countWays(n - 1, dp) + countWays(n - 2, dp) + countWays(n - 3, dp);
  }

  public static void main(String[] args) {
    StaircaseMemoization sc = new StaircaseMemoization();
    System.out.println(sc.countWays(3, new Integer[3 + 1]));
    System.out.println(sc.countWays(4, new Integer[4 + 1]));
    System.out.println(sc.countWays(5, new Integer[5 + 1]));
  }
}
