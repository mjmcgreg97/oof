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
public class HanoiSolverTest extends TestCase {
    private HanoiSolver solver;


    /**
     * Sets up each test method.
     */
    public void setUp() {
        solver = new HanoiSolver(5);
    }


    /**
     * Tests that the number of discs are returned.
     */
    public void testDiscs() {
        assertEquals(5, solver.discs());
    }


    /**
     * Tests the left position of the tower.
     */
    public void testGetTower() {
        Tower tester = solver.getTower(Position.LEFT);
        assertEquals(Position.LEFT, tester.position());
    }


    /**
     * Tests the middle position of the tower.
     */
    public void testGetTower2() {
        Tower tester = solver.getTower(Position.MIDDLE);
        assertEquals(Position.MIDDLE, tester.position());
    }


    /**
     * Tests the right position of the tower.
     */
    public void testGetTower3() {
        Tower tester = solver.getTower(Position.RIGHT);
        assertEquals(Position.RIGHT, tester.position());
    }


    /**
     * Tests the other position of the tower.
     */
    public void testGetTower4() {
        Tower tester = solver.getTower(Position.OTHER);
        assertEquals(Position.LEFT, tester.position());
    }


    /**
     * Tests the toString() method of the HanoiSolver class.
     */
    public void testToString() {
        Disc disc = new Disc(3);
        Disc newDisc = new Disc(4);
        Disc newerDisc = new Disc(5);
        solver.getTower(Position.LEFT).push(disc);
        solver.getTower(Position.MIDDLE).push(newDisc);
        solver.getTower(Position.RIGHT).push(newerDisc);
        assertEquals("[3][4][5]", solver.toString());
    }


    /**
     * Tests for when multiple discs are on multiple towers.
     */
    public void testToString2() {
        Disc disc = new Disc(6);
        Disc disc2 = new Disc(5);
        Disc disc3 = new Disc(4);
        Disc disc4 = new Disc(3);
        Disc disc5 = new Disc(2);
        Disc disc6 = new Disc(1);
        solver.getTower(Position.LEFT).push(disc);
        solver.getTower(Position.MIDDLE).push(disc2);
        solver.getTower(Position.RIGHT).push(disc3);
        solver.getTower(Position.LEFT).push(disc4);
        solver.getTower(Position.MIDDLE).push(disc5);
        solver.getTower(Position.RIGHT).push(disc6);
        assertEquals("[3, 6][2, 5][1, 4]", solver.toString());
    }


    public void testToString3() {
        Disc disc = new Disc(6);
        Disc disc2 = new Disc(5);
        Disc disc3 = new Disc(6);
        solver.getTower(Position.LEFT).push(disc);
        solver.getTower(Position.MIDDLE).push(disc2);
        solver.getTower(Position.RIGHT).push(disc3);
        assertEquals("[6][5][]", solver.toString());
    }


    /**
     * Tests the solve method.
     */
    public void testSolve() {
        Disc disc = new Disc(3);
        Disc disc2 = new Disc(2);
        Disc disc3 = new Disc(1);
        solver.getTower(Position.LEFT).push(disc);
        solver.getTower(Position.LEFT).push(disc2);
        solver.getTower(Position.LEFT).push(disc3);
        solver.solve();
        assertEquals("[][][1, 2, 3]", solver.toString());
    }
}
