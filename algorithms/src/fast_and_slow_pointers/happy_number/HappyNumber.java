public class HappyNumber {
    
    public static boolean find(int number){
        int slow = number, fast = number;

        do{
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        }while(slow != fast);

        return slow == 1;
    }

    private static int findSquareSum(int number){

        int sum = 0;
        while(number > 0){
            int digit = number % 10;

            sum = sum + digit * digit;
            number = number / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
