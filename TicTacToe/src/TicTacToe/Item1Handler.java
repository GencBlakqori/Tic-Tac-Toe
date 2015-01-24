package TicTacToe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*Action listener for the first menu-item*/
public class Item1Handler implements ActionListener {

    TicTacToe tic;
    public Item1Handler(TicTacToe tac)
    {
        tic = tac;
    }
    public void actionPerformed(ActionEvent ae) {
        tic.newGame();
    }
    
}
