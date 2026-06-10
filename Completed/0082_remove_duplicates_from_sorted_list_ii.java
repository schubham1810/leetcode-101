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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t1 = head;
        if(t1==null) return null;
        ListNode t2 = t1.next;
        ListNode newHead = new ListNode();
        ListNode t4 = newHead;

        while(t1!=null && t2!=null){
        	System.out.println(t1.val + "," + t2.val);
            if(t1.val!=t2.val){
                t4.next = new ListNode(t1.val);
                t4=t4.next;
                t1=t1.next;
                t2=t2.next;
            }else{
                while(t2!=null && t1.val==t2.val){
                    t2 = t2.next;
                }
                t1=t2;
                t2=t1!=null ? t1.next: null;
            }
        }
        if(t1!=null && t4.val!=t1.val) {
        	t4.next = new ListNode(t1.val);
        }
        return newHead.next;
    }
}