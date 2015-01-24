package TicTacToe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/*Action listener for the fourth menu-item*/
public class Menu2Handler implements ActionListener
{

    
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "Everybody knows TicTacToe, you don't need help !");
    }
    
}
