// Add two numbers
// https://www.interviewbit.com/problems/add-two-numbers-as-lists/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode A, ListNode B) {
	    ListNode node;
	    ListNode prev = null;
	    ListNode first = null;
	    int carry = 0;
	    int sum = 0;

	    while (A != null || B != null || carry != 0) {

	        node = new ListNode(0);
	        sum = carry;

	        if (first == null)
	            first = node;

	        if (prev != null)
	            prev.next = node;

	        if (A != null) {
	            sum += A.val;
	            A = A.next;
	        }

	        if (B != null) {
	            sum += B.val;
	            B = B.next;
	        }

	        node.val = sum % 10;

	        sum /= 10;
	        carry = sum;
	        prev = node;
	    }

	    return first;

	}
}
