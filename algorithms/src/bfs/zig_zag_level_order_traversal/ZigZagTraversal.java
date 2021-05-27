import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value = value;
    }
}

public class ZigZagTraversal {
    
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        boolean forward = true;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>();
            int i = 0;
            while (i < levelSize){
                TreeNode node = queue.poll();
                if (forward) {
                    currentLevel.add(node.value);
                }else{
                    currentLevel.add(0, node.value);
                }

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                i++;
            }
            forward = !forward;
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigZagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
