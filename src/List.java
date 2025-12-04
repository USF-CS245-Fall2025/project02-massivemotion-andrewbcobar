public interface List<T> {

    /*
        List Interface methods to be implemented in all list types
        These methods define the basic operations for the following list data structures
            - ArrayList
            - SingleLinkedList
            - DoubleLinkedList
            - DummyHeadLinkedList
    */
    public void add (int index, T element) throws Exception;
    public boolean add (T element);
    public T get (int index) throws Exception;
    public T remove (int index) throws Exception;
    public int size ();
}
