import static java.lang.System.*;
import java.awt.Color;

class PaddleTestOne
{
  public static void main( String args[] )
  {
    Paddle one = new Paddle();
    out.println(one);
                
    Paddle two = new Paddle(100,100,30,20, Color.GREEN,6);
    out.println(two);
                          
    out.println(two.equals(one));             
                
    out.println(two.equals(two));                                                                              
  }
}