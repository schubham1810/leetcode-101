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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(-1);
        ListNode temp = l3;
        while(!(l1==null && l2==null)){
            ListNode newNode = null;
            if(l1==null){
                int te = (l2.val+carry)/10;
                int data = (l2.val+carry)%10;
                newNode = new ListNode(data);
                carry =te;
                l2 = l2.next;
            }
            else if(l2==null){
                int te = (l1.val+carry)/10;
                int data = (l1.val+carry)%10;
                newNode = new ListNode(data);
                carry =te;
                l1 = l1.next;
            }else{
                int te = (l1.val+l2.val+carry)/10;
                int data = (l1.val+l2.val+carry)%10;
                newNode = new ListNode(data);
                carry=te;
                l1 = l1.next;
                l2 = l2.next;
            }
            System.out.println(newNode.val);
            temp.next = newNode;
            temp = newNode;
        }
        if(carry == 1){
            ListNode l4 = new ListNode(1);
            temp.next = l4;
        }
        return l3.next;
    }
}