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
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode curr = root;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int partSize = length / k;
        int extraParts = length % k;
        ListNode[] result = new ListNode[k];
        curr = root;

        for (int i = 0; i < k; i++) {
            result[i] = curr;
            int currentPartSize = partSize + (extraParts-- > 0 ? 1 : 0);

            for (int j = 0; j < currentPartSize - 1; j++) {
                if (curr != null) curr = curr.next;
            }
            if (curr != null) {
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            }
        }   
        return result;
    }
}