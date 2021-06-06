public class KthSmallestInMatrixAlternateSolution {
    
    public static int findKthSmallest(int[][] matrix, int k){

        return -1;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 4 }, { 2, 5 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 2);
        System.out.println("Kth smallest number is: " + result);

        int matrix1[][] = { { -5 } };
        result = KthSmallestInSortedMatrix.findKthSmallest(matrix1, 1);
        System.out.println("Kth smallest number is: " + result);

        int matrix2[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        result = KthSmallestInSortedMatrix.findKthSmallest(matrix2, 5);
        System.out.println("Kth smallest number is: " + result);

        int matrix3[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        result = KthSmallestInSortedMatrix.findKthSmallest(matrix3, 8);
        System.out.println("Kth smallest number is: " + result);
    }
}
