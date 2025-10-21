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
    + boolean add(T element) Time Complexity = O(1) or O(n)
    + void add(int index, T element) Time Complexity = O(n)
    - doubleSize() Time Complexity = O(n)
    + T get(int index) Time Complexity = O(1)
    + T remove(int index) Time Complexity = O(n)
    + int size() Time Complexity = O(1)
    
  SingleLinkedList.java
    - Node<T> class
        + Node(T data)
        + T get()
        + Node<T> getNext() 
        + void setNext(Node<T> node) 
    - int size
    - Node<T> next;
    + SingleLinkedList() Time Complexity = O(1)
    + int size() Time Complexity = O(1)
    + boolean add(T element) Time Complexity = O(n)
    + void add(int index, T element) Time Complexity = O(n)
    + T get(int index) Time Complexity = O(n)
    + T remove(int index) Time Complexity = O(n)
    
  DoubleLinkedList.java
    - Node<T> class
        + T data
        + Node<T> next, prev
        + Node(T data) 
        + T get() 
        + Node<T> getNext() 
        + void setNext(Node<T> node)
        + Node<T> getPrev()
        + void setPrev(Node<T> node) 
    - int size
    - Node<T> head, tail
    + DoubleLinkedList() Time Complexity = O(1)
    + int sized() Time Complexity = O(1)
    + boolean add(T element) Time Complexity = O(n)
    + void add(int index, T element) Time Complexity = O(n)
    + T get(int index) Time Complexity = O(n)
    + T remove(int index) Time Complexity = O(n)
    
  DummyHeadLinkedList.java
      - Node<T> class
          + Node(T data)
          + T get()
          + Node<T> getNext() 
          + void setNext(Node<T> node) 
      - int size
      - Node<T> head
      + DummyHeadLinkedList() Time Complexity = O(1)
      + int size() Time Complexity = O(1)
      + boolean add(T element) Time Complexity = O(n)
      + void add(int index, T element) Time Complexity = O(n)
      + T get(int index) Time Complexity = O(n)
      + T remove(int index) Time Complexity = O(n)

Implementation:
Inside Terminal compile and run by typing
  "javac *.java" 
  "java MassiveMotion MassiveMotion.txt"

CelestialBody.java
  Object to be stored in Lists: "List<CelestialBody>"
  extended by 2 sub classes - Star.java and Comet.java
  + CelestialBody (x, y, xv, xy, size, color)
  + void drawMe(Graphics)
  + void move()
  + boolean isOutOfBounds(int width, int height)
  + abstract void update()

