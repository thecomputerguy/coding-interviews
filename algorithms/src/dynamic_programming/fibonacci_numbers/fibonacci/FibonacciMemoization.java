public class FibonacciMemoization {

  public int CalculateFibonacci(int n, Integer[] dp) {
    if(n < 2){
        return n;
    }

    if(dp[n] != null){
        return dp[n];
    }
     dp[n] = CalculateFibonacci(n - 1, dp) + CalculateFibonacci(n - 2, dp);
     return dp[n];
  }

  public static void main(String[] args) {
    FibonacciMemoization fib = new FibonacciMemoization();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5, new Integer[6]));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6, new Integer[7]));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7, new Integer[8]));
  }
}
