// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 *
 */
public class Tower extends LinkedStack<Disc> {
    private Position position;


    /**
     * Creates the stack and sets the tower's position.
     * 
     * @param position
     *            The position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Returns the tower's position.
     * 
     * @return The position
     */
    public Position position() {
        return position;
    }


    /*
     * (non-Javadoc)
     * 
     * @see arraystack.StackADT#push(java.lang.Object)
     */
    @Override
    public void push(Disc disc) {
        if (disc == null) {
            throw new IllegalArgumentException("disc is null");
        }
        if (!this.isEmpty() && this.peek().compareTo(disc) != 1) {
            throw new IllegalStateException();
        }
        if (!this.isEmpty() && this.peek().compareTo(disc) != 1) {
            throw new IllegalStateException();
        }
        if (!this.isEmpty() && this.peek().compareTo(disc) != 1) {
            throw new IllegalStateException();
        }
        else {
            super.push(disc);
        }
    }
}
