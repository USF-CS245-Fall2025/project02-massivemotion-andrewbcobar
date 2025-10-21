public class DummyHeadLinkedList<T> implements List<T> {

    /** Node class (inner) */
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        private T get() {
            return data;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> node) {
            this.next = node;
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
            prev = prev.getNext();
        }

        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        size++;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the index by calling .getNext()
     * account for head being null (current = head.getNext())
     * return value given at that node
     */
    @Override
    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Index out of bounds");
        }

        Node<T> current = head.getNext(); // skip dummy
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.get();
    }

    /*
     * Time Complexity = O(n)
     * iterate through and index the index by calling .getNext()
     * return value of Node at given index
     * remove by setting prev.setNext(current.current)
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
            prev = prev.getNext();
        }

        Node<T> current = prev.getNext();
        prev.setNext(current.getNext());
        size--;
        return current.get();
    }
}
