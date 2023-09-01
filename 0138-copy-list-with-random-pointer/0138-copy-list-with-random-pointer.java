class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)return null;
       
        duplicateNodes(head);
        copyRandomPointers(head);
        
        return splitLists(head);
    }

    private void duplicateNodes(Node head) {
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = temp;
            curr = temp;
        }
    }

    private void copyRandomPointers(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            curr = (curr.next != null) ? curr.next.next : curr.next;
        }
    }

    private Node splitLists(Node head) {
        Node original = head, copy = head.next;
        Node result = copy;

        while (original != null && copy != null) {
            original.next = (original.next != null) ? original.next.next : original.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return result;
    }
}
