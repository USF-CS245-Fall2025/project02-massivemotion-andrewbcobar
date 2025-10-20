public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public void add (int index, T element){
        // if (index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException();
        // }

        if (size == arr.length-1) {
            doubleSize();
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
    }
    public boolean add (T element) {
        if (size == arr.length-1) {
            doubleSize();
        }
        arr[size++] = element;
        return true;
    }

    
    @SuppressWarnings("unchecked")
    private void doubleSize() {
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    @Override
    public T get(int index)  {
        // if (index < 0 || index >= size) {
        //     throw new IndexOutOfBoundsException();
        // }
        return arr[index];
    }


    public T remove (int index){
        // if(index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException();
        // }
        T temp = arr[index];
        for (int i = index; i<size; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return temp;
    }

    @Override
    public int size (){ 
        return size;
    }
}
