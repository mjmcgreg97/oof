// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

import java.util.Observable;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 *
 */
public class HanoiSolver extends Observable {
    // ~ Fields ................................................................
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDiscs;


    /**
     * Creates the HanoiSolver object where the game can be played.
     * 
     * @param numDiscs
     *            the number of discs in the game
     */
    public HanoiSolver(int numDiscs) {
        this.numDiscs = numDiscs;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * Returns the number of discs.
     * 
     * @return The number of discs
     */
    public int discs() {
        return numDiscs;
    }


    /**
     * Returns the tower based on the position given.
     * 
     * @param pos
     *            The position given for the tower
     * @return The tower in that position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return left;
        }
    }


    /**
     * Executes the specified move.
     * 
     * @param source
     *            The tower to pop the disc from
     * @param destination
     *            The tower to move the disc to
     */

    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        this.setChanged();
        this.notifyObservers(destination.position());
    }


    /**
     * Recursive method that solves the tower puzzle.
     */
    private void solveTowers(
        int currentDiscs,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDiscs > 0) {
            solveTowers(currentDiscs - 1, startPole, tempPole, endPole);
            this.move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, endPole, startPole);
        }
    }


    /**
     * Makes the call to the recursive method solveTowers().
     */
    public void solve() {
        this.solveTowers(numDiscs, left, middle, right);
    }


    /**
     * Returns the width of the three towers in string format.
     * 
     * @return The string of the towers in [][][] format
     */
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(left.toString());
        build.append(middle.toString());
        build.append(right.toString());
        return build.toString();
    }

}
