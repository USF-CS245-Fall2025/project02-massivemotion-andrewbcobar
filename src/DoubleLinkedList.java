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
    
    public DoubleLinkedList() {
        this.size = 0;
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrev(head);
        head.setPrev(null);
        tail.setNext(null);
    }

    @Override
    public int size() {
        return this.size;
    }

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

    @Override
    public void add(int index, T element) {
        // if (index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException();
        // }
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
    @Override
    public T get(int index)  {
        // if (index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException();
        // }
        Node<T> current = head.getNext();
		
		for (int i = 0; i<index; i++) {
            current = current.getNext();
        }

        return current.get();
    }

    @Override
    public T remove(int index){
        // if(index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException();
        // }
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
