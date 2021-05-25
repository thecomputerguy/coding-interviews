public class RearrangeLinkedList {
    
    public static void reorder(ListNode head){

        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while(fast != null && fast.next != null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedHead = reverse(slow);
        previous.next = null;
        ListNode headFirstHalf = head;
        ListNode headSecondHalf = reversedHead;

        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        //Set last node's next to null.
        if (headFirstHalf != null) {
            headFirstHalf.next = null;
        }
        
    }

    public static ListNode reverse(ListNode node){
        ListNode previous = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;            
        }
        return previous;
    }

    public static void main(String[] args) {
    
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeLinkedList.reorder(head);
        while (head != null) {
        System.out.print(head.data + " ");
        head = head.next;
        }
    }
}

class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}