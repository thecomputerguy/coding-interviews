public class NumberFactors {
    
    public int countWays(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        
        return countWays(n - 1) + countWays(n - 3) + countWays(n - 4);
    }

    public static void main(String[] args) {
        NumberFactors en = new NumberFactors();
        System.out.println(en.countWays(4));
        System.out.println(en.countWays(5));
        System.out.println(en.countWays(6));
    }
}
