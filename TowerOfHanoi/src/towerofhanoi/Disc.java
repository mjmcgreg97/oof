// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 *
 */
public class Disc extends Shape implements Comparable<Disc> {

    /**
     * Default constructor for the discs.
     * 
     * @param width
     *            The width of the discs
     */
    @SuppressWarnings("unused")
    public Disc(int width) {
        super(0, 0, width, GameWindow.DISC_HEIGHT);
        Random random = new Random();
        int count = random.nextInt(256);
        Color col = new Color(count, count, count);
    }


    /**
     * Compares the widths of the two discs and returns true
     * if they are equal.
     * 
     * @param obj
     *            The object to compare to
     * @return True or false depending on the value of the width
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        else {
            Disc discs = (Disc)obj;
            return this.getWidth() == discs.getWidth();
        }

    }


    /**
     * Returns the width of the disc as a string.
     * 
     * @return A string representing the width
     */
    public String toString() {
        return String.valueOf(getWidth());
    }


    /**
     * Compares the relative sizes of the discs to one another.
     * 
     * @param otherDisc
     *            The disc to compare to
     * @return An int representing the comparison value of the discs
     */
    public int compareTo(Disc otherDisc) {
        if (otherDisc == null) {
            throw new IllegalArgumentException("otherDisc is null");
        }
        if (this.getWidth() < otherDisc.getWidth()) {
            return -1;
        }
        if (this.getWidth() > otherDisc.getWidth()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
