
class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class PathWithGivenSequence {
    
    public static boolean findPath(TreeNode root, int[] sequence){
        if(root == null) return sequence.length == 0;

        return findPathRecursive(root, sequence, 0);
    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int index){
        if(currentNode == null) return false;

        if (index >= sequence.length || currentNode.value != sequence[index]) {
            return false;
        }
        
        if(index == sequence.length - 1 && currentNode.left == null && currentNode.right == null){
            return true;
        }

        return findPathRecursive(currentNode.left, sequence, index+1) || findPathRecursive(currentNode.right, sequence, index+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
