package TicTacToe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*Action listener for the second menu-item*/
public class Item2Handler implements ActionListener
{
    TicTacToe tic;
    public Item2Handler(TicTacToe tac)
    {
        tic = tac;
    }
    public void actionPerformed(ActionEvent ae) {
       tic.dispose();
       new DimensionsSetter();
    }
}
