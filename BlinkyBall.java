import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{
  private float temp;
  //constructors
  public BlinkyBall()
  {
    super();
    temp=0;
  }

  public BlinkyBall(int x, int y)
  {
    super(x,y);
    temp=0;
 }

  public BlinkyBall(int x, int y, int wid, int ht)
  {
    super(x,y,wid,ht);
  }

  public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,xSpd,ySpd);
    temp=0;
  }

  public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col,xSpd,ySpd);
    temp=0;
  }
  @Override
  public void setXSpeed( int xSpd )
  {
   	super.setXSpeed(xSpd);
    temp = 0;
  }
  @Override
  public void setYSpeed( int ySpd )
  {
   	super.setYSpeed(ySpd);
    temp = 0;
  }


  public Color randomColor()
  {
    //use Math.random()
    int r = (int)(Math.random() * ((255 - 0) + 1));          
    int g = (int)(Math.random() * ((255 - 0) + 1));
    int b = (int)(Math.random() * ((255 - 0) + 1));
    return new Color(r,g,b);
  }

   @Override
  public void moveAndDraw(Graphics window)
  {
    super.setColor(randomColor());
    super.moveAndDraw(window);
  }
}