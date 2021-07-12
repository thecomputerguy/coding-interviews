
public class ReverseLinkedListIterative {
       
  public static LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode previous = null;
    LinkedListNode current = head;
    while (current != null){
        LinkedListNode next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }
    return previous;
  }

  public static void main(String[] args) {
    LinkedListNode listHead = null;
    int [] arr = {7,14,21,28};
    listHead = LinkedList.createLinkedList(arr);
    
    System.out.print("Original: ");
    LinkedList.display(listHead);
    
    listHead = reverse(listHead);
    System.out.print("After Reverse: ");
    LinkedList.display(listHead);      
  }
}
