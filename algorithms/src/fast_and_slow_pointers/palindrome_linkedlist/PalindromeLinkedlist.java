public class PalindromeLinkedlist {
    
    public static boolean isPalindrome(ListNode head){
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedHead = reverse(slow);
        ListNode first = head;
        ListNode second = reversedHead;
        while (first != null && second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        ListNode newHead = reverse(reversedHead);
        if (first == null && second == null) {
            return true;
        }
        return false;
    }

    public static ListNode reverse(ListNode slow){
        ListNode current = slow;
        ListNode previous = null;
        while (current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromeLinkedlist.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromeLinkedlist.isPalindrome(head));
    }
}

class ListNode{

    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}
