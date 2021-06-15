class Staircase {

  public int countWays(int n) {
    if (n == 0) {
        return 1;        
    }
    if(n == 1){
        return 1;
    }
    if(n == 2){
        return 2;
    }

    return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
  }

  public static void main(String[] args) {
    Staircase sc = new Staircase();
    System.out.println(sc.countWays(3));
    System.out.println(sc.countWays(4));
    System.out.println(sc.countWays(5));
  }
}
