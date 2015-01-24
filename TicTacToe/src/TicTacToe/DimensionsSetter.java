package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*This class shows up a Dialog that lets the user choose the dimensions of the 
and the win-value*/
public class DimensionsSetter extends JPanel implements ActionListener  {
   
    private int field_size=3;
    private int win_value =3;
    private Image foto; // Dialog background
    NewComboBox[] box ;
    JLabel l,l2;
    JButton button;
    private JDialog f;
    
    public DimensionsSetter() 
    {
            f = new JDialog();
            foto = new ImageIcon(getClass().getResource("..//img//foto.jpg")).getImage();
            setLayout(null);
            setSize(450,253);
            
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            f.setLocation((dim.width-450)/2, (dim.height-253)/2);
            
            // Label construction
            l  = new JLabel("Choose the dimension :");
            l2 = new JLabel("Choose the win value : ");
            l.setForeground(Color.white);
            l2.setForeground(Color.white);
            l.setBounds(20, 100, 170, 25);
            l2.setBounds(20, 150, 170, 25);
            add(l);
            add(l2);
            
            // JComboBox construction
            box = new NewComboBox[2];
            String[] k = {"3","4","5","6","7","8","9","10","11","12","13"};
            String[] k1 = {"3"};
            box[0] = new NewComboBox(k,this,0);
            box[1] = new NewComboBox(k1,this,1);
            box[0].setBounds(180, 100, 50, 20);
            box[1].setBounds(180, 150, 50, 20);
            add(box[0]);
            add(box[1]);
            
            // OK button construction
            button = new JButton("OK");
            button.setBackground(Color.white);
            button.setBounds(20, 200, 60, 20);
            button.addActionListener(this);
            add(button);
            
            //Dialog construction
            f.addWindowListener(new ExitController());
            f.getContentPane().add(this);
            f.setSize(456, 282);
            f.setVisible(true);
            f.setResizable(false);
            f.setIconImage(new ImageIcon(getClass().getResource("..//img//icon.png")).getImage());
           
    }
    
    public void paintComponent(Graphics g)
    {
        g.drawImage(foto, 0, 0, null);
    }
    
    /*this method updates the second ComboBox, just to keep always the winValue
    smaller or equals to the fieldsize*/
    public void update(String index)
    {
        int id = new Integer(index).intValue();
        
        if(box[1].getItemCount()==0)
        {}
        else
        {
            box[1].removeAllItems(); 
        }
        
        for(int i=3;i<=id;i++)
        {
            box[1].addItem(i+"");
        }
        field_size =id;
    }
    
    public void update2(String index)
    {
        win_value = new Integer(index).intValue();
    }
    
    // OK button  Action Listener
    public void actionPerformed(ActionEvent ae) {
        new TicTacToe(field_size,win_value);
        f.dispose();
    }

}
