[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/J_c8sizy)
# MassiveMotion
CS 245 Project 02 Massive Motion
Andrew Cobar
Github @andrewbcobar


Implementation Video: Youtube Video Link Below:
https://www.youtube.com/watch?v=QVUFaiRpwoc


LIST INTERFACE - 
  ArrayList.java
    + ArrayList()
    + boolean add(T element) = Time Complexity = O(1)
    + void add(int index, T element) = Time Complexity = O(n)
    - doubleSize() = Time Complexity = O(n)
    + T get(int index) = Time Complexity = O(1)
    + T remove(int index) = Time Complexity = O(n)
    + int size() = Time Complexity = O(1)
    
  SingleLinkedList.java
    - Node<T> class
        + T data
        + Node(T data)
    - int size
    - Node<T> next;
    + SingleLinkedList() = Time Complexity = O(1)
    + int size() = Time Complexity = O(1)
    + boolean add(T element) = Time Complexity = O(n)
    + void add(int index, T element) = Time Complexity = O(n)
    + T get(int index) = Time Complexity = O(n)
    + T remove(int index) = Time Complexity = O(n)
    
  DoubleLinkedList.java
    - Node<T> class
        + T data
        + Node<T> next, prev
        + Node(T data) 
    - int size
    - Node<T> head, tail
    + DoubleLinkedList() = Time Complexity = O(1)
    + int sized() = Time Complexity = O(1)
    + boolean add(T element) = Time Complexity = O(n)
    + void add(int index, T element) = Time Complexity = O(n)
    + T get(int index) = Time Complexity = O(n)
    + T remove(int index) = Time Complexity = O(n)
    
  DummyHeadLinkedList.java
      - Node<T> class
          + T data
          + Node(T data)
      - int size
      - Node<T> head
      + DummyHeadLinkedList() = Time Complexity = O(1)
      + int size() = Time Complexity = O(1)
      + boolean add(T element) = Time Complexity = O(n)
      + void add(int index, T element) = Time Complexity = O(n)
      + T get(int index) = Time Complexity = O(n)
      + T remove(int index) = Time Complexity = O(n)

Implementation:
Inside Terminal compile and run by typing...
  "javac *.java" 
  "java MassiveMotion MassiveMotion.txt"

Removal of Celestial Objects:
  - all OutOfBounds(OOB) comets are removed from the bodies list
  - within actionPerformed() in MassiveMotion.txt, through the use of a for-loop all objects are being checked by   CelestialBody.java's helper boolean method isOutOfBounds(int x, int y). If the object is detected out of bounds, it returns true, and the object by index is removed from bodies. 

CelestialBody.java
  Object to be stored in Lists: "List<CelestialBody>"
  + CelestialBody (x, y, xv, xy, size, color)
  + void drawMe(Graphics)
  + void move()
  + boolean isOutOfBounds(int width, int height)


Efficiency
  In terms of efficiency, double linked list is the most efficient due to the constant adding and removal of Celestial Objects.
  - Due to objects constantly being added to the end of the list, the double linked list's efficiency of O(1) make it the best choice of implementation. The head and tail nodes allow for no loops needed to add to the end of the list. Unlike single linked list, or arraylist, no loops or iteration is needed. Of course ArrayLists also could have an add efficiency of O(1), if the array is full, growing the array would take O(n) time. Therefore, double linked list is the fastest implementation of add()
  - For removal, all lists have a remove() of time O(n), unless the program is removing at index 0, which is never doing to happen in this program due to index 0 of list bodies is the central star that is not going to be removed due to it not moving out of bounds.
  
  Therefore overall, double linked list is most efficient list to implement for this program. 

Changes Made for Regrading and Resubmission
  - Comments given for fixing - "Remove OOB comets", "Please use Javadoc consistently", and "README file appropriately"
  - My original implementation did correctly remove all out of bounds comets. I went more in-depth in explain it in the readme file
  - I added more camel/snake case comments for consitently. All classes and methods now have java doc comments
  - I slightly enhanced readme file and also included which list implementation is the most efficient and why