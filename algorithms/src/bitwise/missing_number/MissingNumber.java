public class MissingNumber {
    
    public static int findMissingNumber(int[] arr){
        int x1 = 1;
        int n = arr.length + 1;
        for (int i = 2; i <= n; i++) {
            x1 = x1 ^ i;            
        }

        int x2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            x2 = x2 ^ arr[i];
        }

        int x3 = x1 ^ x2;

        return x3;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 2, 6, 4 };
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
  }
}
