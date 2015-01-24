package TicTacToe;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener{
    
    Value value1;
    Icon icon1;
    Icon icon2;
    int index;
    String button_name;
    TicTacToe tic;
    
    public XOButton(Value k, TicTacToe tac, int button_index){
        
        index = button_index;
        tic = tac;
        value1 = k;
        addActionListener(this);
        setBackground(Color.white);
    }
    
    /*The buttons action listener*/
    public void actionPerformed(ActionEvent e )
    {
        if(value1.getValue()==2 || tic.getButtonName(index).equals("X")||tic.getButtonName(index).equals("O"))
        {}
         else
        {
            if ( value1.getValue() == 0 )
            {
                tic.update1(index);
                
            }
            else{
                tic.update2(index);
                
            }
            if(tic.checkWinner(index))
            {
                JOptionPane.showMessageDialog(null, "Player \"" + tic.getWinner(index)+"\" won!!!");
                
            }
            else{ 
                if(tic.checkDraw())
                {
                    JOptionPane.showMessageDialog(null, "It's draw!!!");
                }
            }
        }    
    }
    
}
