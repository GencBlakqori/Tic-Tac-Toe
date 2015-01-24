package TicTacToe;

/*This class maintains the turn order value and the draw-value, if "value"  is
equals to 0, the Icon will be X, if = 1, the icon will be O, and if =2, there will
be no icon, so the game is over when value=2.*/
public class Value 
{
    public int value =0;
    public int drawValue =0;
    
    public int getValue()
    {
        return value ;
    }
    
    public void increaseValue()
    {
        value = 1;
    }
    
    public void decreaseValue()
    {
        value=0;
    }
    
    public void setWinValue()
    {
        value=2;
    }
    
    public void setValue(int i){
        value = i;
    }
    
    public int getDrawValue()
    {
        return drawValue;
    }
    
    public void increaseDrawValue()
    {
        drawValue++;
    }
    
    public void setDrawValue()
    {
        drawValue=0;
    }
}
