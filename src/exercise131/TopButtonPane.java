package exercise131;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

/**
 * this class implements a JPanel to hold the components in the upper side
 * of the drawing application.
 */
public class TopButtonPane extends JPanel{

    /* the names of the available shapes for drawing to be used in the JCombobox*/
    public static final String[] SHAPES_NAMES = {"Line", "Sqaure", "Rctangle", "Circle", "Oval"};
    
    private final JButton colorButton;
    private final ButtonGroup radioGroup;
    private final JRadioButton plainRadioButton;
    private final JRadioButton emptyRadioButton;
    private final JComboBox<String> shapesJComboBox;
    private final DrawShapesJFrame drawShapesJFrame;
    
    /**
     * creates and initializes the panel's different components. the instance
     * should store a reference to the main window for the use of some of the
     * components.
     * 
     * @param drawShapesJFrame the amin drawing frame onto which this panel is
     * attached.
     */
    public TopButtonPane(DrawShapesJFrame drawShapesJFrame) {
        super(new FlowLayout());
        this.drawShapesJFrame = drawShapesJFrame;        
        this.colorButton = new JButton("Color");
        colorButton.addActionListener(new ColorButtonHandler());
        add(this.colorButton);        
        this.plainRadioButton = new JRadioButton("Plain", true);
        plainRadioButton.addItemListener(new RadioButtonHandler(true));
        add(this.plainRadioButton);        
        this.emptyRadioButton = new JRadioButton("Empty", false);
        emptyRadioButton.addItemListener(new RadioButtonHandler(false));
        add(this.emptyRadioButton);        
        this.radioGroup = new ButtonGroup();
        radioGroup.add(this.plainRadioButton);
        radioGroup.add(this.emptyRadioButton);        
        this.shapesJComboBox = new JComboBox<String>(SHAPES_NAMES);
        shapesJComboBox.setMaximumRowCount(3);
        shapesJComboBox.addItemListener(new ShapesComboBoxListener());
        add(this.shapesJComboBox);
    }
    
    /**
     * an action listener for the color button, which opens a color choosing
     * dialogue and stores the users choice (black by default) in this instance
     * color variable.
     */
    private class ColorButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            Color color;
            color = JColorChooser.showDialog(TopButtonPane.this.drawShapesJFrame , "Choose a color", TopButtonPane.this.drawShapesJFrame.getCurrentColorSelection());
            if (color != null){
                TopButtonPane.this.colorButton.setBackground(color);
                TopButtonPane.this.drawShapesJFrame.setCurrentColorSelection(color);                
            }
            /* this is hefre for debugging purposes*/
            System.out.printf("Color Selected: %s\n", TopButtonPane.this.drawShapesJFrame.getCurrentColorSelection());
        }
    }
    
    /**
     * an item listener for the radio buttons which sets the boolean variable
     * corresponding to whether the user selected a plain or empty shape in
     * the "drawShapesJFrame" instance of this class. (true for plain, false
     * for empty).
     */
    private class RadioButtonHandler implements ItemListener{

        private boolean selection;
        
        public RadioButtonHandler(boolean selection){
            this.selection = selection;
        }
        
        @Override
        public void itemStateChanged(ItemEvent e){
            if (e.getStateChange() == ItemEvent.SELECTED)
                TopButtonPane.this.drawShapesJFrame.setPlainShapeSelected(this.selection);
        }
        
    }

    /**
     * an item listener for the JCombobox which holds the user's shape selection, also changes
     * the corresponding variable in the main drawing frame object.
     */
    private class ShapesComboBoxListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if (e.getStateChange() == ItemEvent.SELECTED)
                TopButtonPane.this.drawShapesJFrame.setCurrentShapeSelection(shapesJComboBox.getSelectedIndex());
        }
        
    }    
    
}
