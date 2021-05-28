class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class TreeDiameter {
    
    private static int maximumDiameter = Integer.MIN_VALUE;

    public static int findDiameter(TreeNode root){
        if(root == null) return 0;
        calculateHeight(root);
        return maximumDiameter;
    }

    private static int calculateHeight(TreeNode currentNode){
        if(currentNode == null) return 0;

        int leftTreeHeight = calculateHeight(currentNode.left);
        int rightTreeHeight = calculateHeight(currentNode.right);
        
        if(leftTreeHeight != 0 && rightTreeHeight != 0){
            int diameter =  leftTreeHeight + rightTreeHeight + 1;
            maximumDiameter = Math.max(diameter, maximumDiameter);
        }


        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
