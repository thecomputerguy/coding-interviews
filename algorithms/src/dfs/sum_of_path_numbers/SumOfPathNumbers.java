class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class SumOfPathNumbers {
    
    public static int findSumOfPathNumbers(TreeNode root){
        int sum = findSumOfPathNumbersRecursive(root, 0);
        return sum;
    }

    private static int findSumOfPathNumbersRecursive(TreeNode root, int pathSum){

        if(root == null) return 0;
        pathSum = 10 * pathSum + root.value;
        if (root.left == null && root.right == null){
            return pathSum;
        }

        return findSumOfPathNumbersRecursive(root.left, pathSum) + findSumOfPathNumbersRecursive(root.right, pathSum);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
