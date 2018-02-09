// Interview Question 1: Linked List Duplicate Removal

public class LinkedListDuplicateRemoval {

    // time complexity: O(n^2)
    // space complexity: O(1)
    public static LinkedListNode linkedListDuplicateRemoval(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode prev, next;
        while (current != null && current.getNext() != null) {
            prev = current;
            next = current.getNext();
            while (next != null) {
                while (next != null && current.getValue().equals(next.getValue())) {
                    prev.setNext(next.getNext());
                    next = next.getNext();
                }
                if (next == null) {
                    break;
                }
                prev = prev.getNext();
                next = next.getNext();
            }
            current = current.getNext();
        }
        return head;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    public static LinkedListNode linkedListDuplicateRemovalBonus(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        Map map = new HashMap();
        map.put(head.getValue(), 1);
        LinkedListNode current = head;
        LinkedListNode prev;
        while (current != null && current.getNext() != null) {
            prev = current;
            current = current.getNext();
            if (map.containsKey(current.getValue())) {
                prev.setNext(current.getNext());
                current = prev;
            } else {
                map.put(current.getValue(), 1);
            }
        }
        return head;
    }

}