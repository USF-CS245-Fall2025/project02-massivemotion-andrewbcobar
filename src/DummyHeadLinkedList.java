public class DummyHeadLinkedList<T> implements List<T> {

    /** Node class (inner) */
    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // dummy head node
    private int size;

    /** Constructor — always creates a dummy head */
    public DummyHeadLinkedList() {
        head = new Node<>(null); // dummy head node
        size = 0;
    }

    /** Returns number of elements (not counting dummy head) */
    @Override
    public int size() {
        return size;
    }

    /** Adds element to the end of the list */
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

    /** Adds element at specific position */
    @Override
    public void add(int index, T element){
        // if (index < 0 || index > size) {
        //     throw new Exception("Index out of bounds");
        // }

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

    /** Returns element at index */
    @Override
    public T get(int index) {
        // if (index < 0 || index >= size) {
        //     throw new Exception("Index out of bounds");
        // }

        Node<T> current = head.next; // skip dummy
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /** Removes and returns element at index */
    @Override
    public T remove(int index) {
        // if (index < 0 || index >= size) {
        //     throw new Exception("Index out of bounds");
        // }

        Node<T> prev = head;

        // Move to node before the one to remove
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<T> toRemove = prev.next;
        prev.next = toRemove.next;
        size--;
        return toRemove.data;
    }
}
