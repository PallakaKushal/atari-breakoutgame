import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;
public class TheGame extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private static Scanner scanner = new Scanner(System.in);

  public TheGame(int width,int height,int ballType)
  {
    super("PONG");
    setSize(width,height);

    Pong game = new Pong(width,height,ballType);

    ((Component)game).setFocusable(true);
    getContentPane().add(game);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main( String args[] )
  {
    int ballType = -1;
    System.out.println("Welcome to Pong!");
    System.out.print("Choose a ball,0-regular,1-blinky,2-speedup:");
    ballType = scanner.nextInt();
 
    if(ballType<0 || ballType >2 )
    {
       System.out.println("Restarting Game , please enter correct ball type!");
       System.exit(0);
    }
    System.out.print("Enter width:("+ballType+"-default):");
    int width = scanner.nextInt();
    System.out.print("Enter height:("+ballType+"-default):");
    int height = scanner.nextInt();
    TheGame run = new TheGame(width,height,ballType);
  }
}