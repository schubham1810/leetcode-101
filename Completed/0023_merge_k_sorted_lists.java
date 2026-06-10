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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        for(int i=0; i<lists.length; i++){
            ListNode h1 = lists[i];
            while(h1!=null){
                pq.add(new ListNode(h1.val));
                h1=h1.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp=temp.next;
        }
        return head.next;
    }
}