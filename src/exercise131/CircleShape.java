package exercise131;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * a class which specifies how a circle should be painted on the drawing panel.
 * test line
 */
public class CircleShape extends ShapeDrawn{

    /**
     * simply calls the super class constructor.
     * 
     * @param sourcePoint
     * @param color
     * @param isPlain 
     */      
    public CircleShape(Point sourcePoint, Color color, boolean isPlain){
        super(sourcePoint, color, isPlain);
    }

    /**
     * defines how a circle shape should be painted. makes sure that a circle
     * is drawn regardless of the source and destination points relative positions,
     * similar idea to how a square is painted.
     * 
     * @param g the graphics object of the drawing panel.
     */       
    @Override
    void drawShape(Graphics g){
        int sourceX = (int)super.getSourcePoint().getX();
        int sourceY = (int)super.getSourcePoint().getY();
        int destX = (int)super.getDestPoint().getX();
        int destY = (int)super.getDestPoint().getY();
        int circleRadius = (int)(Math.hypot(Math.abs(sourceX - destX), Math.abs(sourceY - destY)) / Math.sqrt(2));        
        g.setColor(super.getColor());
        if (super.isPlain())
            g.fillOval(Math.min(sourceX, destX), Math.min(sourceY, destY), circleRadius, circleRadius);
        else
            g.drawOval(Math.min(sourceX, destX), Math.min(sourceY, destY), circleRadius, circleRadius);
    }
        
}
