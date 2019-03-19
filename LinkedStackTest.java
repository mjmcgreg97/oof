// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 *
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> stack;
    private String anEntry;


    /**
     * Sets up each test method.
     */
    public void setUp() {
        stack = new LinkedStack<>();
        anEntry = "yes";
    }


    /**
     * Tests the size of the stack/
     */
    public void testSize() {
        stack.push(anEntry);
        assertEquals(1, stack.size());
    }


    /**
     * Tests that the stack is cleared.
     */
    public void testClear() {
        stack.push(anEntry);
        stack.push("no");
        stack.clear();
        assertEquals(0, stack.size());
    }


    /**
     * Returns the string in brackets.
     * 
     */
    public void testToString() {
        stack.push("yes");
        stack.push("no");
        stack.push("maybe");
        assertEquals("[maybe, no, yes]", stack.toString());
    }


    /**
     * Tests that the string is empty.
     */
    public void testToString2() {
        assertEquals("", stack.toString());
    }


    /**
     * Tests when the stack is and isn't empty.
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(anEntry);
        assertFalse(stack.isEmpty());
    }


    /**
     * Tests that the element at the top of the stack is returned.
     */
    public void testPeek() {
        stack.push(anEntry);
        assertEquals("yes", stack.peek());
    }


    /**
     * Tests that an exception is thrown when the stack is empty.
     */
    public void testPeek2() {
        Exception thrown = null;
        try {
            stack.peek();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Tests that the element is removed from the stack and that the
     * size decreases.
     */
    public void testPop() {
        stack.push(anEntry);
        assertEquals("yes", stack.pop());
        assertEquals(0, stack.size());
    }


    /**
     * Tests that pop() throws an exception when the stack is empty.
     */
    public void testPop2() {
        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Tests that the size increments when items are added to it.
     */
    public void testPush() {
        stack.push(anEntry);
        stack.push("no");
        assertEquals(2, stack.size());
    }
}
