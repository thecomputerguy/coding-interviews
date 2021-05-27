import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left, right;
    public TreeNode(int value){
        this.value = value;
    }
}

public class MinimumDepthBinaryTree {
    
    public static int findDepth(TreeNode root){
        if(root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int i = 0;
            minDepth++;
            while (i < levelSize) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null) return minDepth;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                i++;
            }
                       
        }

        return -1;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumDepthBinaryTree.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumDepthBinaryTree.findDepth(root));
    }
}
