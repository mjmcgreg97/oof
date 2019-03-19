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
public class ProjectRunner {

    /**
     * Default constructor
     */
    public ProjectRunner() {
        // Nothing to initalize
    }


    /**
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int discs = 5;
        if (args.length == 1) {
            discs = Integer.parseInt(args[0]);
        }
        GameWindow window = new GameWindow(new HanoiSolver(discs));
    }

}
