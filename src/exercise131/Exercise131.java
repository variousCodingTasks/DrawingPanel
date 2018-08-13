package exercise131;

import javax.swing.JFrame;

/**
 * the main class for the shape drawing application. 
 */
public class Exercise131 {
    
    public static final int FRAME_HEIGHT = 800;
    public static final int FRAME_WIDTH = 800;
            

    /**
     * creates a new drawing frame, sets its size and position.
     */
    public static void main(String[] args) {
        DrawShapesJFrame mainFrame = new DrawShapesJFrame();
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
