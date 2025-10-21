
public class DoubleLinkedList<T> implements List<T>{
    private class Node<T> {
        T data;
        Node<T> next, prev;

        public Node(T data) {
            this.data = data;
            next = null; prev = null;
        }

        public T get() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public void setPrev(Node<T> node) {
            this.prev = node;
        }
    }

    private int size;
    private Node<T> head, tail;
    
    /*
     * Constructor creates DoubleLinkedList object
     * using dummy head logic, set head and tail to null
     */
    public DoubleLinkedList() {
        this.size = 0;
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrev(head);
        head.setPrev(null);
        tail.setNext(null);
    }

    /*
     * Time Complexity = O(1)
     * returns size of DoubleLinkedList
     */
    @Override
    public int size() {
        return this.size;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the tail
     * attach to the end of list and change previous and next noeds
     * increment size
     */
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<T>(element);
        Node<T> current = head;

        for (int i = 0; i<size+1; i++) {
            if (current.getNext().equals(tail)) {
                current.setNext(newNode);
                newNode.setPrev(current);
                newNode.setNext(tail);
                tail.setPrev(newNode);
            }

            current = current.getNext();
        }

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
    public void add(int index, T element) throws Exception{
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<T>(element);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        // current points to node BEFORE where we insert
        Node<T> nextNode = current.getNext();

        current.setNext(newNode);
        newNode.setPrev(current);
        newNode.setNext(nextNode);
        nextNode.setPrev(newNode);

        size++;

    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the index by calling .getNext()
     * return value given at that node
     */
    @Override
    public T get(int index) throws Exception  {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head.getNext();
		
		for (int i = 0; i<index; i++) {
            current = current.getNext();
        }

        return current.get();
    }

    /*
     * Time Complexity = O(n)
     * iterate through and index the index by calling .getNext()
     * return value of Node at given index
     * remove by setting previous(before) using .setNext() and next(after) using .setPrev()
     *      - advantage of using DLList Logic
     * decrement size
     */
    @Override
    public T remove(int index) throws Exception{
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head.getNext();
		
		for (int i = 0; i < size; i++){
			if (i == index){
				Node<T> before = current.getPrev();
				Node<T> after = current.getNext();
				
				before.setNext(after);
				after.setPrev(before);
				size--;
				return current.get();
			}
		
			current = current.getNext();
		}
        size--;
		return null;
    }



}
