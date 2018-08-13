package exercise131;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * a class which specifies the bottom button panel and their functions.
 */
public class BottomButtonPane extends JPanel{
    
    private final DrawShapesJFrame drawShapesJFrame;    
    private final JButton undoButton;
    private final JButton clearButton;
    private final JButton exitButton;
    
    /**
     * creates and sets the different components of this panel.
     * 
     * @param drawShapesJFrame the main drawing frame to which this panel
     * will be attached.
     */
    public BottomButtonPane(DrawShapesJFrame drawShapesJFrame){
        super(new FlowLayout());
        this.undoButton = new JButton("Undo");
        undoButton.addActionListener(new UndoButtonHandler());
        add(this.undoButton);        
        this.drawShapesJFrame = drawShapesJFrame;        
        this.clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonHandler());
        add(this.clearButton);        
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonHandler());
        add(this.exitButton);
    }
    
    /**
     * an action listener for the exit button, simply stops the whole program.
     */
    private class ExitButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }
    }
    
    /**
     * an action listener for the undo button,an action listener for the exit button, simply stops the whole program. removes the last painted shape
     * and repaints the other shapes stored in memory.
     */
    private class UndoButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            BottomButtonPane.this.drawShapesJFrame.getPaintingPanel().removeLastShape();
        }
    }
    
    /**
     * an action listener for the clear button, removes all shapes painted up this point.
     */
    private class ClearButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            BottomButtonPane.this.drawShapesJFrame.getPaintingPanel().clearShapesDrawnArray();
        }
    }    
    
}
