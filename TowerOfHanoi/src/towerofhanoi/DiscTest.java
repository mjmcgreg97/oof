// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

import student.TestCase;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 *
 */
public class DiscTest extends TestCase {
    private Disc disc;
    private Disc newDisc;


    /**
     * Sets up each test method.
     */
    public void setUp() {
        disc = new Disc(10);
        newDisc = new Disc(11);
    }


    /**
     * Tests the toString() method of the Disc class.
     */
    public void testToString() {
        assertEquals("10", disc.toString());
    }


    /**
     * Tests when the disc is compared to itself.
     */
    public void testEquals() {
        assertTrue(disc.equals(disc));
    }


    /**
     * Tests when the disc is compared to an object of another class.
     */
    public void testEquals2() {
        Object obj = new Object();
        assertFalse(disc.equals(obj));
    }


    /**
     * Tests when the disc is compared to a null object.
     */
    public void testEquals3() {
        Object obj = null;
        assertFalse(disc.equals(obj));
    }


    /**
     * Tests when the width of the two discs aren't equal.
     */
    public void testEquals4() {
        assertFalse(disc.equals(newDisc));

    }


    /**
     * Tests when the width of the two discs are equal.
     */
    public void testEquals5() {
        newDisc = new Disc(10);
        assertTrue(disc.equals(newDisc));
    }


    /**
     * Tests for when an IllegalArgumentException is thrown.
     */
    public void testCompareTo() {
        newDisc = null;
        Exception thrown = null;
        try {
            disc.compareTo(newDisc);
        }
        catch (IllegalArgumentException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests for when the disc's width is smaller than the newDisc.
     */
    public void testCompareTo2() {
        assertEquals(-1, disc.compareTo(newDisc));
    }


    /**
     * Tests for when the disc's width is larger than the newDisc.
     */
    public void testCompareTo3() {
        newDisc = new Disc(9);
        assertEquals(1, disc.compareTo(newDisc));
    }


    /**
     * Tests for when the discs widths' are equal.
     */
    public void testCompareTo4() {
        newDisc = new Disc(10);
        assertEquals(0, disc.compareTo(newDisc));
    }


    /**
     * Tests the default constructor of the disc.
     */
    public void testDisc() {
        assertEquals(0, disc.getX());
        assertEquals(0, disc.getY());
        assertEquals(10, disc.getWidth());
        assertEquals(3, disc.getHeight());
    }
}
