import java.util.PriorityQueue;

public class MaximizeCapital {
    
    public static int findMaximumCapital(int[] capitals, int[] profits, int noOfProjects, int initialCapital){

        PriorityQueue<Integer> capitalMinHeap = new PriorityQueue<>((a, b) -> capitals[a] - capitals[b]);
        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        
        for (int i = 0; i < capitals.length; i++) {
            capitalMinHeap.offer(i);
        }

        int availableCapital = initialCapital;

        for (int i = 0; i < noOfProjects; i++) {
            while (!capitalMinHeap.isEmpty() && capitals[capitalMinHeap.peek()] <= availableCapital) {
                profitMaxHeap.offer(capitalMinHeap.poll());          
            }

            if(profitMaxHeap.isEmpty()) break;

            availableCapital += profits[profitMaxHeap.poll()];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
