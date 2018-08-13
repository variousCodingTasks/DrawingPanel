package exercise131;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * a class which specifies the behavior of the painting panel which is attached to the
 * main drawing frame.
 */
public class PaintingPanel extends JPanel{

    private final DrawShapesJFrame drawShapesJFrame;
    /* an array list to store all the shapes instances painted so far.*/
    private final ArrayList<ShapeDrawn> shapesDrawnArray;
    
    /**
     * creates and initializes the panel's different components.
     * 
     * @param drawShapesJFrame the main drawing frame.
     */
    public PaintingPanel(DrawShapesJFrame drawShapesJFrame){
        this.drawShapesJFrame = drawShapesJFrame;
        this.shapesDrawnArray = new ArrayList<ShapeDrawn>();
        this.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    /**
     * returns this panels painting frame, the one it's attached to.
     * 
     * @return this.drawShapesJFrame.
     */
    public DrawShapesJFrame getDrawShapesJFrame(){
        return this.drawShapesJFrame;
    }
    
    /**
     * calls the relevant shape constructor with the parameters, depending on the current
     * parameter selection in the GUI (Color, shape and type...), and stores the instance
     * created in the array list.
     * 
     * @param sourcePoint the point where the mouse was first pressed.
     */
    public void createShape(Point sourcePoint){
        String shapeSelection = TopButtonPane.SHAPES_NAMES[drawShapesJFrame.getCurrentShapeSelection()];
        ShapeDrawn shapeDrawn;
        Color selectedColor = this.drawShapesJFrame.getCurrentColorSelection();
        Color color = new Color(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue());
        if (shapeSelection.equals("Line")) shapeDrawn = new LineShape(sourcePoint, color, this.drawShapesJFrame.isPlainShapeSelected());
        else if (shapeSelection.equals("Sqaure")) shapeDrawn = new SquareShape(sourcePoint, color, this.drawShapesJFrame.isPlainShapeSelected());
        else if (shapeSelection.equals("Rctangle")) shapeDrawn = new RectangleShape(sourcePoint, color, this.drawShapesJFrame.isPlainShapeSelected());
        else if (shapeSelection.equals("Circle")) shapeDrawn = new CircleShape(sourcePoint, color, this.drawShapesJFrame.isPlainShapeSelected());
        else shapeDrawn = new OvalShape(sourcePoint, color, this.drawShapesJFrame.isPlainShapeSelected());
        this.shapesDrawnArray.add(shapeDrawn);
    }
    
    /**
     * update;s the shape's destination point.
     * 
     * @param point the point where the mouse was last dragged to.
     */
    public void updateShape(Point point){
        if (!this.shapesDrawnArray.isEmpty())
            this.shapesDrawnArray.get(this.shapesDrawnArray.size() - 1).setDestPoint(point);
    }
    
    /**
     * removes the last painted shape and repaints the panel with remaining shapoes.
     */
    public void removeLastShape(){
        if (!this.shapesDrawnArray.isEmpty())
            this.shapesDrawnArray.remove(this.shapesDrawnArray.size() - 1);
        this.paint(this.getGraphics());
    }
    
    /**
     * removes all the shapes drawn and repaints the panel (which will be empty).
     */
    public void clearShapesDrawnArray(){
        this.shapesDrawnArray.clear();
        this.paint(this.getGraphics());
    }    
    
    /**
     * repaints all the shapes stored in the array list of this instance.
     * 
     * @param g the panel's current graphics object.
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (ShapeDrawn shape : this.shapesDrawnArray)
            shape.drawShape(g);
    }
    
}
