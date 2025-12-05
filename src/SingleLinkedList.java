public class SingleLinkedList<T> implements List<T> {
    private class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }   
    }

    private int size;
    private Node<T> head;
    
    /**
      *  Constructor creates SingleLinkedList object
      *  Instantiates size to 0 and head to null
    */
    public SingleLinkedList () {
        this.size = 0;
        this.head = null;
    }


    /**
      *  Time Complexity = O(1)
      *  returns size of SingleLinkedList
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
      *  If list is empty, set head to new node
      *  else iterate to end of list and add new node
      *  increment size
      *  Time Complexity = Best Case = O(1) Worst Case = O(n)
    */
    @Override
    public boolean add(T element) {
        if (size == 0) {
            head = new Node<T>(element);
            size++;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node<T> end = new Node<T>(element);
        end.next = null;
        current.next = end;
        size++;
        return true;
    }

    /**
      *  Throw exceptions for invalid index
      *  if index is 0, insert at the head
      *  else iterate to index-1, insert new node at index
      *  increment size
      *  Time Complexity: Best Case = O(1) if index = 0, Worst Case = O(n) due to iteration
    */
    @Override
    public void add(int index, T element) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(element);

        // Insert at the head
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /** 
      *  Throw exceptions for invalid index
      *  Iterate to index and return data at that node
      *  Time Complexity = O(n)
    */
    @Override
    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;       
    }

    /** 
      *  Throw exceptions for invalid index
      *  if index is 0, remove head
      *  else iterate to index-1, remove node at index
      *  decrement size
      *  Time Complexity: Best Case = O(1) if index = 0, Worst Case = O(n) due to iteration
    */
    @Override
    public T remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T removedData;

        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }
}
