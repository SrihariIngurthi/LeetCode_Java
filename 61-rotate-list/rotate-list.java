/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        temp.next = head;
        k = k % len;
        int stepsToNewHead = len - k;
        ListNode newTail = temp;
        while(stepsToNewHead > 0){
            newTail = newTail.next;
            stepsToNewHead--;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}