package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    JPanel p ;
    MenuBar menubar ;
    Menu menu1;
    Menu menu2;
    XOButton buttons[] ;
    Value v ;
    int field_size;
    int win_value;
    ImageIcon X,O ;
    
    
    public TicTacToe(int size, int value) {
        super("Tic, tac, toe ");
        field_size=size;
        win_value = value;
        p = new JPanel();
        
        //Menu - construction
        menubar = new MenuBar();
        menu1 = new Menu("File");
        menu2 = new Menu("Help");
        
        MenuItem item1 =  new MenuItem("New game");
        MenuItem item2 =  new MenuItem("New dimensions");
        MenuItem item3 =  new MenuItem("Exit");
        MenuItem item4 =  new MenuItem("Help");
        item1.addActionListener(new Item1Handler(this));
        item2.addActionListener(new Item2Handler(this));
        item3.addActionListener(new Item3Handler());
        
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        item4.addActionListener(new Menu2Handler());
        menu2.add(item4);
        menubar.add(menu1);
        menubar.add(menu2);
        setMenuBar(menubar);
        
        // Buttons - cunstruction
        buttons = new XOButton[field_size*field_size];
        p.setLayout(new GridLayout(field_size, field_size));
        v = new Value();
        X = new ImageIcon(getClass().getResource("..//img//"+path1(field_size)+".png"));
        O = new ImageIcon(getClass().getResource("..//img//"+path2(field_size)+".png"));
        
        for (int i = 0; i < field_size * field_size; i++) {
            buttons[i] = new XOButton(v, this,i);
            buttons[i].setName(i+"");
            p.add(buttons[i]);
        }
        setIconImage(new ImageIcon(getClass().getResource("..//img//icon.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width-400)/2, (dim.height-400)/2);
        setResizable(false);
        add(p);
        setVisible(true);
    }

    /*This method checks if the player in the clicked button has won
    input :  int i  ( clicked button index )
    return :  true if won, false if not.
    */
    public boolean checkWinner(int i)
    {
/*********************************************************************************/
/*First part :Horizontal search : */
        int checker=1;
        int next_button = i+1;
        int circle = 0;
        boolean ok = true;
        while(ok){
                    if(((i%field_size==(field_size-1))&&circle<1)|| next_button==field_size*field_size) 
                    {
                            next_button=next_button-win_value;
                            circle++;
                    } 
                    if(next_button<0)
                    {
                        ok = false;
                    }
                    if(ok){
                        if(!(buttons[next_button].getName()).equals(buttons[i].getName())||((next_button%field_size)==0&&circle<1))
                        {


                            if(circle<1)
                            {
             
                                if((next_button-win_value)%field_size>i%field_size|| next_button-win_value<0) 
                                {
                                    ok = false;  
                                }
                                else
                                {next_button=next_button-win_value;circle++;}
                            }
                            else
                            {
                                ok=false;
                            }
                        }
                        else{ 
                            if((buttons[next_button].getName()).equals(buttons[i].getName()))
                                {
                                  checker++;next_button++;
                                  if(checker==win_value)
                                  {ok =false;}
                                
                                }
                        }
                    }
            
        }

        if(checker ==win_value)
        {
            return true;
        }

/*********************************************************************************/
/*Second part :1st Diagonal search : */
        
        checker=1;
        next_button = i+field_size-1;
        circle = 0;
        ok = true;
        while(ok){
                if((next_button%field_size==field_size-1||next_button>=field_size*field_size)&&circle<1)
                {
                    next_button=next_button-win_value*(field_size-1);
                    circle++;
                    if(next_button<0||next_button%field_size<(win_value-1)){
                        ok =false;
                    }
                }
                
                if(ok){
                        if(!(buttons[next_button].getName()).equals(buttons[i].getName()))
                        {
                            if(circle<1)
                            {
                                next_button=next_button-win_value*(field_size-1);
                                if(next_button<0||next_button%field_size<(win_value-1)) 
                                {
                                    ok = false;  
                                }
                                else
                                {circle++;}
                            }
                            else
                            {
                                ok=false;
                            }
                        }
                        else{ 
                            if((buttons[next_button].getName()).equals(buttons[i].getName()))
                                {
                                  checker++;next_button=next_button+field_size-1;
                                  if(checker==win_value)
                                  {ok =false;}
                                

                                }

                        }
                    }
            
        }
        if(checker ==win_value)
        {
            return true;
        }
        
/*********************************************************************************/
/*Third part :2nd Diagonal search : */
        
        checker=1;
        next_button = i+field_size+1;
        circle = 0;
        ok = true;
        while(ok){
                if((next_button%field_size==0||next_button>=field_size*field_size)&&circle<1)
                {
                    next_button=next_button-win_value*(field_size+1);
                    circle++;
                    if(next_button<0||next_button%field_size>=field_size-(win_value-1)){
                        ok =false;
                    }
                }
                
                if(ok){
                        if(!(buttons[next_button].getName()).equals(buttons[i].getName()))
                        {
                            if(circle<1)
                            {
                                next_button=next_button-win_value*(field_size+1);
                                if(next_button<0||next_button%field_size>=field_size-(win_value-1)) 
                                {
                                    ok = false;  
                                }
                                else
                                {circle++;}
                            }
                            else
                            {
                                ok=false;
                            }
                        }
                        else{ 
                            if((buttons[next_button].getName()).equals(buttons[i].getName()))
                                {
                                  checker++;next_button=next_button+field_size+1;
                                  if(checker==win_value)
                                  {ok =false;}
                                

                                }

                        }
                    }
            
        }
        if(checker ==win_value)
        {
            return true;
        }
        
        /*********************************************************************************/
/*Fourth part :Vertical search : */
        
        checker=1;
        next_button = i+field_size;
        circle = 0;
        ok = true;
        while(ok){
                if((next_button>=field_size*field_size)&&circle<1)
                {
                    next_button=next_button-win_value*field_size;
                    circle++;
                    if(next_button<0){
                        ok =false;
                    }
                }
                
                if(ok){
                        if(!(buttons[next_button].getName()).equals(buttons[i].getName()))
                        {
                            if(circle<1)
                            {
                                next_button=next_button-win_value*field_size;
                                if(next_button<0) 
                                {
                                    ok = false;  
                                }
                                else
                                {circle++;}
                            }
                            else
                            {
                                ok=false;
                            }
                        }
                        else{ 
                            if((buttons[next_button].getName()).equals(buttons[i].getName()))
                                {
                                  checker++;next_button=next_button+field_size;
                                  if(checker==win_value)
                                  {ok =false;}
                                

                                }

                        }
                    }
            
        }
        if(checker ==win_value)
        {
            return true;
        }
        
        return false;
    }
    
    /*this method checks if the game is a draw
    return - true if yes, false if not
    */
    public boolean checkDraw()
    {
        if(v.getDrawValue()==field_size*field_size)
        {
            v.setWinValue();
            return true;
        }
        return false;
    }
    
    /*updates the clicked button with icon X and name X*/
    public void update1(int i)
    {
        buttons[i].setIcon(X);
        buttons[i].setName("X");
        v.increaseValue();
        v.increaseDrawValue();
    }
    
    /*updates the clicked button with icon O and name O*/
    public void update2(int i)
    {
        buttons[i].setIcon(O);
        buttons[i].setName("O");
        v.decreaseValue();
        v.increaseDrawValue();
    }
    
    /*gets the winner*/
    public String getWinner(int i)
    {
        v.setWinValue();
        return buttons[i].getName();
    }
    
    /*gets the name of a button*/
    public String getButtonName(int i)
    {
        return buttons[i].getName();
    }
    
    /*resets the buttons to start a new game*/
    public void newGame()
    {
        for (int i = 0; i < field_size * field_size; i++) {
            buttons[i].setIcon(null);
            buttons[i].setName(i+"");
        }
        v.setValue(0);
        v.setDrawValue();
    }
    
    /*this method is to choose wich icons will be on the buttons for X*/
    public String path1 (int n)
    {
        if(n<5)
        {
            return "X1";
        }
        if(n<8 && n>=5)
        {
            return "X2";
        }
        if(n>=8)
        {
            return "X3";
        }
        return "";
    }
    
    /*this method is to choose wich icons will be on the buttons for O*/
    public String path2 (int n)
    {
        if(n<5)
        {
            return "O1";
        }
        if(n<8 && n>=5)
        {
            return "O2";
        }
        if(n>=8)
        {
            return "O3";
        }
        return "";
    }
}
