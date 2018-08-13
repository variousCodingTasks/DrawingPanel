package exercise131;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * the main drawing frame which holds all the components together.
 */
public class DrawShapesJFrame extends JFrame {
    
    public static final int GAP = 5;
    
    private final BorderLayout mainLayout;
    private final PaintingPanel paintingPanel;
    private final BottomButtonPane bottomButtonPane;
    private final TopButtonPane topButtonPane;
    
    private Color currentColorSelection;
    private boolean isPlainShapeSelected;
    private int currentShapeSelection;
    
    /**
     * creates and sets the different components attached to the frame.
     */
    public DrawShapesJFrame(){
        super("Shape Drawing Thing");        
        this.mainLayout = new BorderLayout(GAP, GAP);
        setLayout(this.mainLayout);        
        this.paintingPanel = new PaintingPanel(this);
        PaintingPanelMouseHandler mouseHander = new PaintingPanelMouseHandler(this.paintingPanel);
        paintingPanel.addMouseListener(mouseHander);
        paintingPanel.addMouseMotionListener(mouseHander);        
        add(this.paintingPanel, BorderLayout.CENTER);        
        this.bottomButtonPane = new BottomButtonPane(this);
        add(this.bottomButtonPane, BorderLayout.SOUTH);        
        this.topButtonPane = new TopButtonPane(this);
        add(this.topButtonPane, BorderLayout.NORTH);        
        this.isPlainShapeSelected = true;
        add(new JLabel("  "), BorderLayout.WEST);
        add(new JLabel("  "), BorderLayout.EAST);
        this.currentColorSelection = Color.BLACK;
    }

    /**
     * returns the current color selection last set by the user (black by default).
     * 
     * @return this.currentColorSelection.
     */
    public Color getCurrentColorSelection() {
        return this.currentColorSelection;
    }
    
    /**
     * sets the current color selection obtained from the dialog opened by the user.
     * 
     * @param currentColorSelection the color selection.
     */
    public void setCurrentColorSelection(Color currentColorSelection) {
        this.currentColorSelection = currentColorSelection;
    }    
    
    /**
     * returns the painting panel for the different components methods usage.
     * 
     * @return this.paintingPanel.
     */
    public PaintingPanel getPaintingPanel(){
        return this.paintingPanel;
    }

    /**
     * returns the GUI current shape type selection: true for plain, false otherwise.
     * 
     * @return this.isPlainShapeSelected.
     */
    public boolean isPlainShapeSelected(){
        return this.isPlainShapeSelected;
    }

    /**
     * sets the shape's type selection.
     * 
     * @param plainShapeSelected the user selection.
     */
    public void setPlainShapeSelected(boolean plainShapeSelected){
        this.isPlainShapeSelected = plainShapeSelected;
        /* fopr debugging purposes*/
        System.out.printf("Selected %b\n", this.isPlainShapeSelected);
    }

    /**
     * gets the current GUI shape selection.
     * 
     * @return this.currentShapeSelection.
     */
    public int getCurrentShapeSelection(){
        return this.currentShapeSelection;
    }

    /**
     * used by the combo box listener to set the current shape selected in the GUI.
     * 
     * @param currentShapeSelection the current shape selection.
     */
    public void setCurrentShapeSelection(int currentShapeSelection){
        this.currentShapeSelection = currentShapeSelection;
        /* used for debugging purposes.*/
        System.out.printf("Selected %s\n", TopButtonPane.SHAPES_NAMES[this.currentShapeSelection]);
    }
    
}
