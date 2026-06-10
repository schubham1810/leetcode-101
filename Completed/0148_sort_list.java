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
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        } 
        return slow;
    }

    public ListNode mergeLists(ListNode head1, ListNode head2){
        ListNode list1 = head1;
        ListNode list2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1!=null) temp.next = list1;
        else temp.next = list2;

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode midEle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = midEle.next;
        midEle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        head = mergeLists(leftHead,rightHead);
        return head;
    }
}