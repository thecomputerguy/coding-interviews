class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

public class RotateLinkedList {
    
    public static ListNode rotate(ListNode head, int rotations){
        if (rotations == 0 || head == null || head.next == null) return head;
        int listLength = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            listLength++;
        }

        int skipLength = listLength - (rotations % listLength);
        int i = 0;
        current = head;
        ListNode previous = null;
        while (i < skipLength) {
            previous = current;
            current = current.next;
            i++;    
        }

        previous.next = null;
        ListNode temp = current;
        while (temp.next != null) {
            temp = temp.next;            
        }

        temp.next = head;
        head = current;

        return head;
    } 

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateLinkedList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
        System.out.print(result.value + " ");
        result = result.next;
        }
    }
}
