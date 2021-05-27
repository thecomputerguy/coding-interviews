import java.util.LinkedList;
import java.util.Queue;

class TreeNodeWithNext{
    int value;
    TreeNodeWithNext left, right, next;

    public TreeNodeWithNext(int value){
        this.value = value;
    }

    //Level order traversal using next pointer
    public void printLevelOrder(){
        TreeNodeWithNext nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeWithNext current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.value + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null){ 
                        nextLevelRoot = current.left;
                    }else if (current.right != null){
                        nextLevelRoot = current.right;
                    }
                }
                current = current.next;
            }
            System.out.println();
        }
    } 
}

public class ConnectLevelOrderSiblings {
    
    public static void connect(TreeNodeWithNext root){
        if(root == null) return;

        Queue<TreeNodeWithNext> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int i = 0;
            TreeNodeWithNext previous = null;
            TreeNodeWithNext currentNode = null;
            while (i < levelSize) {
                 currentNode = queue.poll();
                if (previous != null) {
                    previous.next = currentNode;                    
                }
                previous = currentNode;
                
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);

                i++;
            }

            if(currentNode != null ) currentNode.next = null;
        }
    }

    public static void main(String[] args) {
        TreeNodeWithNext root = new TreeNodeWithNext(12);
        root.left = new TreeNodeWithNext(7);
        root.right = new TreeNodeWithNext(1);
        root.left.left = new TreeNodeWithNext(9);
        root.right.left = new TreeNodeWithNext(10);
        root.right.right = new TreeNodeWithNext(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
