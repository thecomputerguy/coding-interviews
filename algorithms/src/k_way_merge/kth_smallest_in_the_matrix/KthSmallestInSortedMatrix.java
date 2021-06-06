import java.util.*;

class MatrixElement{
  int rowIndex;
  int columnIndex;

  public MatrixElement(int rowIndex, int columnIndex){
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
  }
}

class KthSmallestInSortedMatrix {

  public static int findKthSmallest(int[][] matrix, int k) {
    
    if(matrix == null || matrix.length == 0) return -1;
    PriorityQueue<MatrixElement> minHeap = new PriorityQueue<MatrixElement>((a, b) -> matrix[a.rowIndex][b.columnIndex] - matrix[b.rowIndex][b.columnIndex]);
    int i = 0;
    for (int[] row : matrix) {
      if(row != null && row.length != 0){
        minHeap.offer(new MatrixElement(i, 0));
      }
      i++;
    }

    int count = 0; int result = 0;
    while(!minHeap.isEmpty()){
      MatrixElement element = minHeap.poll();
      result = matrix[element.rowIndex][element.columnIndex];
      if(++count == k){
        break;
      }
      element.columnIndex++;
      if(matrix[element.rowIndex].length > element.columnIndex){
        minHeap.offer(element);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
    int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}
