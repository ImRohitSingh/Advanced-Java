package packageCal;

import java.io.Serializable;

/**
 *
 * @author Rohit
 */
public class Calculator implements Serializable
{
    private int x, y;
    public Calculator(){}
    
    public int getX(){ return x; }
    public void setX(int x){ this.x = x; }
    
    public int getY(){ return y; }
    public void setY(int y){ this.y = y; }
    
    public int add(){ return x+y; }
    public int minus(){ return x-y; }
    public int multiply(){ return x*y; }
    public float divide(){ return (y!=0?(float)x/y:(float)(x/y)); }
    public int modulus(){ return x%y; }
}
