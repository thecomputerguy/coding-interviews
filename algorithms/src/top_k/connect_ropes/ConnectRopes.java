import java.util.*;

class ConnectRopes {

  public static int minimumCostToConnectRopes(int[] ropeLengths) {
    
    if (ropeLengths == null || ropeLengths.length == 0) {
        return -1;        
    }

    if(ropeLengths.length == 1){
        return ropeLengths[0];
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    //Throw all the ropes in the heap
    for (int i = 0; i < ropeLengths.length; i++) {
        minHeap.offer(ropeLengths[i]);
    }

    int result = 0, temp = 0;
    while(minHeap.size() > 1){
        temp = minHeap.poll() + minHeap.poll();
        result = result + temp;
        minHeap.offer(temp);
    }

    return result;
  }

  public static void main(String[] args) {
    int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
    System.out.println("Minimum cost to connect ropes: " + result);
  }
}
