public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int size;

    //Constructor initializes an array of size 10
    @SuppressWarnings("unchecked")
    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    /*
     * Time Complexity = O(1) or O(n)
     * coule be O(n) if you need to double array size
     * double the size of the array is the size is equal to size of the T array
     * Set the given index to the passed in element
     * increment size
     */
    public boolean add (T element) {
        if (size == arr.length-1) {
            doubleSize();
        }
        arr[size++] = element;
        return true;
    }
    
    /*
     * Time Complexity = O(n)
     * double the size of the array is the size is equal to size of the T array
     *  iterate through array backwards to move every element from the end of the array 
     *  until the given index moving every element up one index
     * set the given/now open index to the given index
     * increment size
     */
    @Override
    public void add (int index, T element) throws Exception{
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == arr.length-1) {
            doubleSize();
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
    }


    /*
     * Time Complexity = O(n)
     * Set T array to a new array of double size
     * iterate through and copy elements over new array
     */
    @SuppressWarnings("unchecked")
    private void doubleSize() {
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    /*
     * Time Complexity = O(1)
     *  Return T object at given index
     */
    @Override
    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }


    /*
     * Time Complexity = O(n)
     * Return the object at the index removed from list
     * increment starting at given index and move every element down 1 index
     * decrement size
     */
    public T remove (int index) throws Exception {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        T temp = arr[index];
        for (int i = index; i<size; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return temp;
    }

    /*
     * Time Complexity = O(1)
     * return size of arraylist
     */
    @Override
    public int size (){ 
        return size;
    }
}
