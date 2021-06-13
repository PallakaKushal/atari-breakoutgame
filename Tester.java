import javax.swing.JFrame;
import java.awt.Component;

public class Tester extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public Tester()
  {
    super("PONG Tester");
    setSize(WIDTH,HEIGHT);
    //uncomment for activity 1 then add comment for future tests
    //getContentPane().add(new BlockTestTwo());

    //uncomment for activity 2 then add comment for future tests
    //getContentPane().add(new BallTestTwo());

    //uncomment for activity 3 then add comment for future tests
    /*PaddleTestTwo padTest = new PaddleTestTwo();
    ((Component)padTest).setFocusable(true);
    getContentPane().add(padTest);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
     

  }

  public static void main( String args[] )
  {
    
    Tester run = new Tester();
  }
}