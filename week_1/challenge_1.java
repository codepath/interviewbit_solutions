// Challenge 1 - Implement a Linked List

public interface LinkedListNode<E> {

    /* getter/setter for this node's value */
    E getValue();
    void setValue(E value);

    /* getter/setter for the subsequent node, or null if this is the last node */
    LinkedListNode<E> getNext();
    void setNext(LinkedListNode<E> next);

    /**
     * Initialize this node and all of its subsequent nodes from
     * an array of values, starting with the head value at index 0
     *
     * @param listValues - the ordered values for the whole list
     */
    void setValuesFromArray(E[] listValues);

    /* prints this node's value and all of its subsequent nodes */
    void printNode();

}

// Implementation

class LinkedListNodeImpl<E> implements LinkedListNode<E> {

    private E value;
    private LinkedListNode next;

    public LinkedListNodeImpl(E value) {
        this.value = value;
        next = null;
    }

    public LinkedListNodeImpl() {
        value = null;
        next = null;
    }

    @Override
    public E getValue() {
        return this.value;
    }

    @Override
    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public LinkedListNode<E> getNext() {
        return this.next;
    }

    @Override
    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }

    @Override
    public void setValuesFromArray(E[] listValues) {
        this.value = listValues[0];
        LinkedListNode current = this;
        for (int i = 1; i < listValues.length; i++) {
            E value = listValues[i];
            LinkedListNode node = new LinkedListNodeImpl<E>(value);
            current.setNext(node)
            current = node;
        }
    }

    @Override
    public void printNode() {
        System.out.print(this.getValue() + " ");
        LinkedListNode next = this.getNext();
        while (next != null) {
            System.out.print(next.getValue() + " ");
            next = next.getNext();
        }
        System.out.print("\n");
    }

}