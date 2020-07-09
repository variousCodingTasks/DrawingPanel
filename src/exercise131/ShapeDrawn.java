package exercise131;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * an abstract class which defines the main characteristics of shape top be drawn.
 */
public abstract class ShapeDrawn{
    
    private final Point sourcePoint;
    private Point destPoint;
    private final Color color;
    private final boolean plain;

    /**
     * initializes and sets the different fields of this object.
     * 
     * @param sourcePoint where the user first clicked while drawing the shape.
     * @param color the color choice at the moment when the user drew the shape.
     * @param isPlain whether the plain or empty shape method should be called,
     *          depending on user selection.
     */
    public ShapeDrawn(Point sourcePoint, Color color, boolean isPlain){
        this.sourcePoint = sourcePoint;
        this.destPoint = sourcePoint;
        this.color = color;
        this.plain = isPlain;
    }

    /**
     * getter for the point where the user first clicked drawing the shape.
     * 
     * @return this.sourcePoint.
     */
    public Point getSourcePoint(){
        return this.sourcePoint;
    }

    /**
     * getter for the point where the user moved the mouse last time.
     * 
     * @return this.destPoint.
     */
    public Point getDestPoint(){
        return this.destPoint;
    }

    /**
     * setter for this.destPoint.
     * 
     * @param destPoint the last mouse location.
     */
    public void setDestPoint(Point destPoint){
        this.destPoint = destPoint;
    }
    
    /**
     * getter for the shape's color.
     * 
     * @return this.color.
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * true if the plain drawing method should be called, false otherwise.
     * 
     * @return this.plain.
     */
    public boolean isPlain(){
        return this.plain;
    }
    
    /**
     * an abstract method which defines how the shape will be painted on the panel.
     * 
     * @param g the graphics object (of the drawing panel)on which the shape
     * shall be painted.
     */
    abstract void drawShape(Graphics g);    
}
