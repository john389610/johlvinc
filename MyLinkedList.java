public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
       if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
        {
            tail = head;
        }

    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }

    /** Add a new element at the specified index in this list
     * The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }

    }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }
    
    /**
     * @param e
     * @Return true if this list contains the element
     */
    public boolean contains(E e){
        Node<E> temp = head;
        while(temp.next !=null){
            if(temp.element.equals(e)){
                return true;
            }//if
            temp=temp.next;
        }//while
        return false;
    }//contains 
    /**
     * overloaded
     * @param e
     * @param comps compares counter 
     * @return true if this list contains the element and counts compares
     */
    public boolean contains( int[] count,E e){
        Node<E> temp = head;
        int i=0;
        while(temp.next !=null){
            i++;
            if(temp.element.equals(e)){
                count[0]+=i;
                return true;
            }//if
            temp=temp.next;
        }//while
        count[0]+=i;
        //System.out.println(comps[0]);
        return false;
    }//contains ovarload
    
    /** @return the element from this list at the specified index
     * @param index */
    public E get(int index){
        if(index>0&&index<size){
            Node<E> temp=head;
            for (int i = 1; i < index; i++) {
                temp=temp.next;
            }//for
            return temp.element;
        }//if
        return null;
    }//get
  /** @param e 
   *  @Return the index of the first matching element in this list.
   *  @Return -1 if no match. */
    public int indexOf(E e){
        Node<E> temp=head;
        int i=1;
        while(temp.next !=null){
            if(e.equals(temp.next.element)){                
                return i;                
            }//if
            i++;
            temp=temp.next;
        }//while
        return -1;
    }//indexOf
    
  /** @param e 
   *  @Return the index of the last matching element in this list.
   *  @Return -1 if no match. */
    public int lastIndexOf(E e){
        Node<E> temp=head;
        int i=1; int t=-1;
        while(temp.next !=null){
            if(e.equals(temp.next.element)){
                t=i;
            }//if
            i++;
            temp=temp.next;
        }//while
        return t;
    }//lastIndexOf    
  
    /** Replace the element at the specified position in this list
     *  with the specified element and returns the new set.
     * @param index
     * @param e
     * @return specified element  */
  public E set(int index, E e){
      if(index>0&&index<size){
         Node<E> temp=head;
         for (int i = 0; i < index; i++) {
                temp=temp.next;
      }//for
         E t =temp.element;
         temp.element=e;
         return t;
  }//if
      return null;
  }//set
    
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
}
    
    
