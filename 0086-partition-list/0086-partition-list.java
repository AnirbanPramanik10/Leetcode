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
    public ListNode partition(ListNode head, int x) {
        ListNode Small = new ListNode(0);
        ListNode Higher = new ListNode(0);

        ListNode smallHead = Small;
        ListNode higherHead = Higher;

        while(head != null){
            if(head.val < x){
                //Small List
                smallHead.next = head;
                smallHead = smallHead.next; 
            }else{
                //Higher List
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head = head.next;
        }
        smallHead.next = Higher.next;
        higherHead.next = null;
        return Small.next;
    }
}