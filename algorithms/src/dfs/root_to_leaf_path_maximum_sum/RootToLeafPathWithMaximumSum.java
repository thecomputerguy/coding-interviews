
class TreeNode{
    int value;
    TreeNode left, right;
    
    public TreeNode(int value){
        this.value = value;
    }
}
public class RootToLeafPathWithMaximumSum {
    
    public static int maximumSum = Integer.MIN_VALUE;

    public static int findPathWithMaximumSum(TreeNode root){
        findPathWithMaximumSumRecursive(root, 0);
        return maximumSum;
    }

    public static void findPathWithMaximumSumRecursive(TreeNode root, int currentSum){
        if(root == null) return;
        currentSum += root.value;
        if(root.left == null && root.right == null){
            maximumSum = Math.max(currentSum, maximumSum);
        }else{
            findPathWithMaximumSumRecursive(root.left, currentSum);
            findPathWithMaximumSumRecursive(root.right, currentSum);
        }

        currentSum -= root.value; 
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(4);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            int result = RootToLeafPathWithMaximumSum.findPathWithMaximumSum(root);
            System.out.println("Tree paths with sum " + ": " + result);
    }
}
