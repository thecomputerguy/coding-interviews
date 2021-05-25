public class DuplicateNumberAlternateSolution {
    
    public static int findNumber(int[] numbers){
        int slow = 0;
        int fast = 0;
        do{
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        }while(slow != fast);

        int cycleLength = 0;
        int current = numbers[slow];
        do{
            current = numbers[current];
            cycleLength++;
        }while(cycleLength != numbers[slow]);

        return findStart(numbers, cycleLength);
    }

    private static int findStart(int[] numbers, int cycleLength){
        int pointer1 = numbers[0];
        int pointer2 = numbers[0];
        while (cycleLength > 0) {
            pointer2 = numbers[pointer2];
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = numbers[pointer1];
            pointer2 = numbers[pointer2];
        }

        return pointer1;
    }

    public static void main(String[] args) {
         System.out.println(DuplicateNumberAlternateSolution.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(DuplicateNumberAlternateSolution.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(DuplicateNumberAlternateSolution.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
