public class CycleInLinkedList {
    
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast != slow){
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast == slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + CycleInLinkedList.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + CycleInLinkedList.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + CycleInLinkedList.hasCycle(head));
    }
}

class ListNode{
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
    }
}