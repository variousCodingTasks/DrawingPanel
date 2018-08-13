package exercise131;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * a class which specifies how an line is painted on the drawing panel.
 */
public class LineShape extends ShapeDrawn{

    /**
     * simply calls the super class constructor.
     * 
     * @param sourcePoint
     * @param color
     * @param isPlain 
     */     
    public LineShape(Point sourcePoint, Color color, boolean isPlain) {
        super(sourcePoint, color, isPlain);
    }

    /**
     * defines how aline should be painted on the drawing panel. unlike other shapes,
     * the plain/empty selection does not matter in this case.
     * 
     * @param g the graphics object of the drawing panel.
     */      
    @Override
    public void drawShape(Graphics g) {
        int sourceX = (int)super.getSourcePoint().getX();
        int sourceY = (int)super.getSourcePoint().getY();
        int destX = (int)super.getDestPoint().getX();
        int destY = (int)super.getDestPoint().getY();
        g.setColor(super.getColor());
        g.drawLine(sourceX, sourceY, destX, destY);
    }
    
}
