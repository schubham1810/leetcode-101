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
        ListNode tempHead = head;
        if(head==null) return head;
        ListNode temp = tempHead.next;

        while(tempHead!=null && tempHead.next!=null){
            while(temp!=null && tempHead.val==temp.val){
                temp=temp.next;
            }
            tempHead.next = temp;
            tempHead = temp;
            temp = (temp!=null) ? temp.next:null;
        }
        return head;
    }
}