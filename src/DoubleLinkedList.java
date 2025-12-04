
public class DoubleLinkedList<T> implements List<T>{
    private class Node<T> {
        T data;
        Node<T> next, prev;

        public Node(T data) {
            this.data = data;
            next = null; prev = null;
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
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
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
     * Time Complexity = O(1)
     * attach to the end of list and change previous and next nodes
     * increment size
     */
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<T>(element);

        Node<T> beforeTail = tail.prev;
        beforeTail.next = newNode;
        newNode.prev = beforeTail;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
        return true;

    }

    /*
     * Time Complexity = O(n)
     * iterate through and find the index by calling current.next
     * attach to list by changing previous and next nodes
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
            current = current.next;
        }

        // current points to node BEFORE where we insert
        Node<T> nextNode = current.next;

        current.next = newNode;
        newNode.prev = current;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;
    }

    /*
     * 
     * iterate through and find the index by calling current.next
     * return value given at that node
     * Time Complexity = O(n)
     */
    @Override
    public T get(int index) throws Exception  {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head.next;
		
		for (int i = 0; i<index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /*
     * Time Complexity = O(n)
     * iterate through and index the index by calling current.next
     * return value of Node at given index
     * remove by setting previous(before) using before.next and next(after) using after.prev
     *      - advantage of using DLList Logic
     * decrement size
     */
    @Override
    public T remove(int index) throws Exception{
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head.next;
		
		for (int i = 0; i < size; i++){
			if (i == index){
				Node<T> before = current.prev;
				Node<T> after = current.next;
				
				before.next = after;
				after.prev = before;
				size--;
				return current.data;
			}
		
			current = current.next;
		}
        size--;
		return null;
    }



}
