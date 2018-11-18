package myPack;

import java.io.Serializable;

/**
 *
 * @author Rohit
 */
public class Calculator implements Serializable
{
    int x, y;
    
    public Calculator(){}
    
    public int getX()
    {
        return x;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int add()
    {
        return x+y;
    }
    
    public int sub()
    {
        return x-y;
    }
    
    public int mul()
    {
        return x*y;
    }
    
    public float div()
    {
        return y!=0? (x/y) : (float)(x/y);
    }
    
    public int mod()
    {
        return x%y;
    }
}
