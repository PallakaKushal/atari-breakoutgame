import static java.lang.System.*;
import java.awt.Color;

class BallTestOne
{
  public static void main( String args[] )
  {
    Ball one = new Ball();
    out.println(one);
                
    Ball two = new Ball(100,100,30,50);
    out.println(two);
                
    Ball three = new Ball(100,100,30,50,Color.BLUE);
    out.println(three);
                
    Ball four = new Ball(100,100,30,50,Color.BLUE,5,6);
    out.println(four);
                
    //x, y, wid, ht, color, xSpd, ySpd
    Ball five = new Ball(100,100,30,50,Color.blue,5,6);
    out.println(five);           
                
    out.println(four.equals(three));             
                
    out.println(four.equals(four));                                                                            
  }
}