public class SingleLinkedList<T> implements List<T> {
    private class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T get() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }
    }

    private int size;
    private Node<T> head;

    public SingleLinkedList () {
        this.size = 0;
        this.head = null;
    }


    //size() Time Complexity = O(1)
    @Override
    public int size() {
        return this.size;
    }

    //Time Complexity = Best Case = O(1) Worst Case = O(n)
    @Override
    public boolean add(T element) {
        if (size == 0) {
            head = new Node<T>(element);
            size++;
            return true;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        Node<T> end = new Node<T>(element);
        end.setNext(null);
        current.setNext(end);
        size++;
        return true;
    }

    //Time Complexity = O(n)
    @Override
    public void add(int index, T element) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(element);

        // Insert at the head
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    //Time Complexity = O(n)
    @Override
    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.get();
    }

    //Time Complexity Best Case(index = 0) = O(1) Worst Case(index!=0)= O(n)
    @Override
    public T remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T removedData;

        if (index == 0) {
            removedData = head.get();
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedData = current.getNext().get();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removedData;
    }
}
