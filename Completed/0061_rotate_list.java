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
    public ListNode reverse(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || head.next ==null) return head;
        ListNode temp = head;
        int size = 1;
        while(temp.next!=null){
           temp=temp.next;
           size++;
        }
        k = k%size;
        int rotations = size-k;
        if(rotations ==0) return head;
        else{
            temp = head;
            for(int i=1;i<rotations;i++){
                temp = temp.next;
            }
            ListNode next = temp.next;
            temp.next = null;
            ListNode rev1 = reverse(head);
            ListNode rev2 = reverse(next);
            head.next = rev2;
            head = rev1;
            return reverse(head);
        }        
    }
}