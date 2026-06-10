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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(temp!=null && temp.next!=null){
            ListNode n1 = temp;
            ListNode n2 = temp.next;
            ListNode n3 = temp.next.next;

            res.next = n2;
            n2.next = n1;
            n1.next = n3;
            res = n1;
            temp = n3;
        }
        return dummy.next;
    }
}