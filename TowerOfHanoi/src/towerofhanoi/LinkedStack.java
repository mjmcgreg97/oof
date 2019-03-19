// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 * 
 * @param <T>
 *            the data type
 *
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size;


    /**
     * Initializes the two fields and creates the default constructor.
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Returns the size of the stack
     * 
     * @return the size
     */
    public int size() {
        return size;
    }


    /*
     * (non-Javadoc)
     * 
     * @see stack.StackInterface#clear()
     */
    @Override
    public void clear() {
        for (int i = 0; i <= this.size(); i++) {
            this.pop();
        }

    }


    /*
     * (non-Javadoc)
     * 
     * @see stack.StackInterface#toString()
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node<T> current = topNode;
        builder.append("[");
        while (current != null) {
            builder.append(current.getData());
            if (current.getNextNode() != null) {
                builder.append(", ");
            }
            current = current.getNextNode();
        }
        builder.append("]");
        return builder.toString();
    }


    /*
     * (non-Javadoc)
     * 
     * @see stack.StackInterface#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see stack.StackInterface#peek()
     */
    @Override
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return topNode.data;
    }


    /*
     * (non-Javadoc)
     * 
     * @see stack.StackInterface#pop()
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T top = topNode.data;
        topNode = topNode.next;
        size--;
        return top;

    }


    /*
     * (non-Javadoc)
     * 
     * @see stack.StackInterface#push(java.lang.Object)
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = topNode;
        topNode = new Node<T>(anEntry);
        topNode.data = anEntry;
        topNode.setNextNode(newNode);
        size++;
    }


    private class Node<G> {
        private Node<G> next;
        private G data;


        /**
         * Default constructor for the node. Sets the data field equal
         * to the given parameter.
         * 
         * @param value
         *            The data to be changed
         */
        public Node(G value) {
            this.data = value;
            next = null;
        }


        /**
         * Returns the next node in the stack.
         * 
         * @return the next node
         */
        public Node<G> getNextNode() {
            return next;
        }


        /**
         * Returns the data of the given item in the stack.
         * 
         * @return the data of the item
         */
        public G getData() {
            return data;
        }


        /**
         * Sets the value of the next node to the value provided.
         * 
         * @param nextNode
         *            The value to change
         */
        public void setNextNode(Node<G> nextNode) {
            this.next = nextNode;
        }
    }
}
