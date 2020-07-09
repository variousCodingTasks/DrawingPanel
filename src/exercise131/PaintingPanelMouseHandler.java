package exercise131;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * a class which implements a mouse adapter for the painting panel, separated
 * from the original PaintingPanel class to make it less dense.
 */
public class PaintingPanelMouseHandler extends MouseAdapter{

    private final PaintingPanel paintingPanel;

    /**
     * sets the paintingPanel variable to which this adapter belongs.
     * 
     * @param paintingPanel the paintingPanel to which this adapter is attached.
     */
    public PaintingPanelMouseHandler(PaintingPanel paintingPanel){
        this.paintingPanel = paintingPanel;
    }
    
    /**
     * what happens when a mouse is pressed on the panel, the shape creating
     * method of this painting panel will be called top start painting an object.
     * 
     * @param e the mouse event.
     */
    @Override
    public void mousePressed(MouseEvent e){
        /* for debuggind purposes*/
        System.out.printf("Pressed at [%d, %d]\n", e.getX(), e.getY());
        this.paintingPanel.createShape(e.getPoint());
    }
    
    /**
     * should call the pane's updateShape method to set the point where the
     * mouse button was released and finalize the objects state.
     * 
     * @param e the mouse event.
     */
    @Override
    public void mouseReleased(MouseEvent e){
        /* used for debugging purposes*/
        System.out.printf("Released at [%d, %d]\n", e.getX(), e.getY());
        this.paintingPanel.updateShape(e.getPoint());
    }
    
    /**
     * makes sure that the shape is repainted each time the mouse is dragged
     * based on the source and current position of the mouse.
     * 
     * @param e the mouse event.
     */
    @Override
    public void mouseDragged(MouseEvent e){
        /*System.out.printf("Dragged at [%d, %d]\n", e.getX(), e.getY());*/
        Graphics g = this.paintingPanel.getGraphics();
        this.paintingPanel.updateShape(e.getPoint());
        this.paintingPanel.paint(g);
    }

}
