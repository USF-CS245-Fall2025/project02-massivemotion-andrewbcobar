public class DummyHeadLinkedList<T> implements List<T> {

    /** Node class (inner) */
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // dummy head node
    private int size;

    /*
     * Constructor creates DoubleLinkedList object
     * using dummy head logic, set head and tail to null
    */
    public DummyHeadLinkedList() {
        head = new Node<>(null); // dummy head node
        size = 0;
    }

    /*
     * Time Complexity = O(1)
     * returns size of DoubleLinkedList
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the tail
     * attach to the end of list and change previous and next noeds
     * increment size
     */
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> current = head;

        // Traverse to last node (before null)
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
        return true;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the index using getNext() an index amount of times
     * attach to the end of list and change previous and next noeds
     * increment size
     */
    @Override
    public void add(int index, T element) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Index out of bounds");
        }

        Node<T> newNode = new Node<>(element);
        Node<T> prev = head;

        // Move to node before insertion point
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the index by calling current.next
     * account for head being null (current = head.next)
     * return value given at that node
     */
    @Override
    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Index out of bounds");
        }

        Node<T> current = head.next; // skip dummy
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and index the index by calling current.next
     * return value of Node at given index
     * remove by setting prev.next to current.next
     *      - advantage of using DLList Logic
     * decrement size
     */
    @Override
    public T remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Index out of bounds");
        }

        Node<T> prev = head;

        // Move to node before the one to remove
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<T> current = prev.next;
        prev.next = current.next;
        size--;
        return current.data;
    }
}
