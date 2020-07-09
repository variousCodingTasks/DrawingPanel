package exercise131;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * a class which defines a square shape and how it should be painted.
 */
public class SquareShape extends ShapeDrawn{

    /**
     * simply calls the super class constructor.
     * 
     * @param sourcePoint
     * @param color
     * @param isPlain 
     */
    public SquareShape(Point sourcePoint, Color color, boolean isPlain){
        super(sourcePoint, color, isPlain);
    }

    /**
     * defines how a square should be painted depending on the source point, makes sure
     * the sides are equal in size, works best when the user draws to the right and
     * downwards from the source point.
     * 
     * @param g the graphics object of the drawing panel
     */
    @Override
    void drawShape(Graphics g){
        int sourceX = (int)super.getSourcePoint().getX();
        int sourceY = (int)super.getSourcePoint().getY();
        int destX = (int)super.getDestPoint().getX();
        int destY = (int)super.getDestPoint().getY();
        int sideLength = (int)(Math.hypot(Math.abs(sourceX - destX), Math.abs(sourceY - destY))/Math.sqrt(2));        
        g.setColor(super.getColor());
        if (super.isPlain())
            g.fillRect(Math.min(sourceX, destX), Math.min(sourceY, destY), sideLength, sideLength);
        else
            g.drawRect(Math.min(sourceX, destX), Math.min(sourceY, destY), sideLength, sideLength);
    }
        
}
