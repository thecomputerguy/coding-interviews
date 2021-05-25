public class CycleInCircularArray {
    
    public static boolean loopExists(int[] array){
        if(array == null || array.length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            boolean isForward = array[i] >= 0;
            int slow = i, fast = i;
            do{
                slow = findNextIndex(array, isForward, slow);
                fast = findNextIndex(array, isForward, fast);
                if(fast != -1){
                    fast = findNextIndex(array, isForward, fast);
                }
            }while(slow != -1 && fast != -1 && slow != fast);

            if(slow != -1 && slow == fast){
                return true;
            }
        }

        return false;
    }

    public static int findNextIndex(int[] array, boolean isForward, int currentIndex){
        boolean direction = array[currentIndex] >= 0;
        if(direction != isForward){
            return -1;
        }

        int nextIndex = (currentIndex + array[currentIndex]) % array.length;
        if (nextIndex < 0) {
            nextIndex = nextIndex + array.length;
        }

        //one element cycle
        if (nextIndex == currentIndex) {
            return -1;
        }

        return nextIndex;
    }


    public static void main(String[] args) {
        System.out.println(CycleInCircularArray.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CycleInCircularArray.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CycleInCircularArray.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
