package exercise131;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * a class which specifies how a rectangle shape should be painted on the drawing panel.
 */
public class RectangleShape extends ShapeDrawn{

    /**
     * simply calls the super class constructor.
     * 
     * @param sourcePoint
     * @param color
     * @param isPlain 
     */
    public RectangleShape(Point sourcePoint, Color color, boolean isPlain){
        super(sourcePoint, color, isPlain);
    }       

    /**
     * defines how a rectangle should be painted makes sure that the rectangle is drawn
     * regardless of source and destination points and their relative places.
     * 
     * @param g the graphics object of the drawing panel.
     */    
    @Override
    void drawShape(Graphics g){
        int sourceX = (int)super.getSourcePoint().getX();
        int sourceY = (int)super.getSourcePoint().getY();
        int destX = (int)super.getDestPoint().getX();
        int destY = (int)super.getDestPoint().getY();
        g.setColor(super.getColor());
        if (super.isPlain())
            g.fillRect(Math.min(sourceX, destX), Math.min(sourceY, destY),
                                                        Math.abs(sourceX - destX), Math.abs(sourceY - destY));
        else
            g.drawRect(Math.min(sourceX, destX), Math.min(sourceY, destY),
                                                        Math.abs(sourceX - destX), Math.abs(sourceY - destY));
    }
    
}
