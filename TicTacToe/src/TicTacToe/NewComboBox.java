package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*This class constructs the ComboBoxes in the Dialog*/
public class NewComboBox extends JComboBox implements ItemListener
{
    int index;
    DimensionsSetter gui;
    
    public NewComboBox(String[] array,DimensionsSetter g, int i){
        super(array);
        gui = g;
        index = i;
        addItemListener(this);
        setBackground(Color.white);
    }
    
    public void itemStateChanged(ItemEvent e) {
        if(index==0){
            if(e.getStateChange()==ItemEvent.SELECTED)
            {
                gui.update((String)getSelectedItem());
            }
        }
        else{
            if(e.getStateChange()==ItemEvent.SELECTED)
            {
                gui.update2((String)getSelectedItem());
            }
        }
        
    }
    
}
