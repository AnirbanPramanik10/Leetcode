class MyHashMap {
    private static final int CAPACITY = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[CAPACITY];
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);
        }
        Node prev = findPreviousNode(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }
        Node prev = findPreviousNode(buckets[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }
        Node prev = findPreviousNode(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    private Node findPreviousNode(Node head, int key) {
        Node prev = null;
        Node current = head;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */