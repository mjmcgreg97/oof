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
public class TowerTest extends TestCase {
    private Tower tower;
    private Position middle;
    private Position right;
    private Disc disc;


    /**
     * Sets up each test method.
     */
    public void setUp() {
        tower = new Tower(middle);
        disc = new Disc(1);
    }


    /**
     * Tests the Tower() constructor of the Tower class.
     */
    public void testTower() {
        tower = new Tower(right);
        assertEquals(middle, right);
    }


    /**
     * Tests that the position of the tower is correctly returned.
     */
    public void testPosition() {
        assertEquals(middle, tower.position());
    }


    /**
     * Tests that an exception is thrown when the disc is null.
     */
    public void testPush() {
        disc = null;
        Exception thrown = null;
        try {
            tower.push(disc);
        }
        catch (IllegalArgumentException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests that an exception is thrown when the push is invalid.
     */
    public void testPush2() {
        Disc newDisc = new Disc(69);
        tower.push(disc);
        Exception thrown = null;
        try {
            tower.push(newDisc);
        }
        catch (IllegalStateException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
    }


    /**
     * Tests that the tower is initially empty.
     */
    public void testPush3() {
        assertTrue(tower.isEmpty());
    }


    /**
     * Tests that the disc is added when the tower isn't empty.
     */
    public void testPush4() {
        Disc newDisc = new Disc(5);
        tower.push(newDisc);
        assertFalse(tower.isEmpty());
    }


    /**
     * Tests for when the discs have equal values.
     */
    public void testPush5() {
        Disc newDisc = new Disc(5);
        tower.push(newDisc);
        Disc newerDisc = new Disc(1);
        tower.push(newerDisc);
        assertFalse(tower.isEmpty());
    }

}
