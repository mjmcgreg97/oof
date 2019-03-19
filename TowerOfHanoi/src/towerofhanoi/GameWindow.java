// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Michael McGregor (mjm06)
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author <Michael McGregor> <mjm06>
 * @version 2019.03.19
 *
 */
public class GameWindow implements Observer {
    // ~ Fields ................................................................
    private Window window;
    private Shape left;
    private Shape middle;
    private Shape right;
    private HanoiSolver game;
    // private final int DISC_GAP = 3;
    public static final int DISC_HEIGHT = 3;


    /**
     * 
     */
    public GameWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        left = new Shape(100, 100, 4, 100, Color.BLUE);
        middle = new Shape(275, 100, 4, 100, Color.RED);
        right = new Shape(450, 100, 4, 100, Color.GREEN);
        for (int i = game.discs(); i > 0; i--) {
            Disc newDisc = new Disc(8 * i);
            window.addShape(newDisc);
            game.getTower(Position.LEFT).push(newDisc);
            moveDisc(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button button = new Button("solve");
        button.onClick(this, "clickedSolve");
        window.addButton(button, WindowSide.SOUTH);
    }


    /**
     * Decides where to correctly move the disc.
     */
    private void moveDisc(Position position) {
        Shape currentPole = new Shape(2, 2, Color.BLUE);
        Disc currentDisc = game.getTower(position).peek();
        switch (position) {
            case LEFT:
                currentPole = left;
            case MIDDLE:
                currentPole = middle;
            case RIGHT:
                currentPole = right;
            default:
                currentPole = left;
        }
        // currentDisc.moveTo();
    }


    /**
     * Pauses between Disc movements.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Supports the solve method.
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Updates the game with the current position of the disc.
     * 
     * @param o
     *            The observable object
     * @param arg
     *            The position of the disc
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position pos = (Position)arg;
            this.moveDisc(pos);
            sleep();
        }
    }

}
