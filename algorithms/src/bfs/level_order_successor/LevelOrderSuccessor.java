import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int val) {

        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int i = 0;
            while(i < levelSize) {
                TreeNode node = queue.poll();
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                
                if (node.value == val) {
                    if (!queue.isEmpty()) {
                        return queue.peek();                     
                    }
                }

                i++;
            }
        }

        return null;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
        System.out.println(result.value + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.value + " ");
    }
}
