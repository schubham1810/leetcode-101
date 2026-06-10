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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        int pos = count - n;
        if(count==1 && n==1) return null;
        else if(pos == 0){
            head = head.next;
        }else{
            ListNode prev = head;
            temp = prev.next;
            for(int i=0;i<pos-1;i++){
                prev = prev.next;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
        return head;
    }
}