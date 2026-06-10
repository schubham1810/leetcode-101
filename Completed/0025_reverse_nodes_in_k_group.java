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
    public ListNode reverse(ListNode head){
        if(head.next==null){
            return head;
        }

        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null) return head;
        ListNode temp = head;
        ListNode kNode = head;
        ListNode prev = head;
        ListNode next = head;
        boolean flag = true;
        while(flag && kNode!=null){
            for(int i=1;i<k;i++){
                kNode = kNode.next;
                if(kNode == null){
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                prev.next = temp;
                break;
            }
            next = kNode.next;
            kNode.next = null;
            ListNode revHead = reverse(temp);
            if(temp==head){
                prev = temp;
                head = revHead;
            }else{
                prev.next = revHead; 
                prev = temp;
            }
            temp = next;
            kNode = temp;
        }
        return head;
    }
}