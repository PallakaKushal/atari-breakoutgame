import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable<Block>
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
	{
		super(200,200,10,10);
		xSpeed = 3;
		ySpeed = 1;
	}
	
  //add the other Ball constructors
  public Ball(int x, int y)
	{
		super(x, y,10,10);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int hei)
	{
		super(x, y, wid, hei);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int hei, Color col)
	{
		super(x, y, wid, hei, col);
		xSpeed = 3;
		ySpeed = 1;
	}

  public Ball(int x, int y, int wid, int hei, int xS, int yS)
	{
		super(x, y, wid, hei);
		xSpeed = xS;
		ySpeed = yS;
	}  
	public Ball(int x, int y, int wid, int hei, Color col, int xS, int yS)
	{
		super(x, y, wid, hei, col);
		xSpeed = xS;
		ySpeed = yS;
	}     
        
           
  //add the set & get methods
  public void setXSpeed(int xS)
	{
		xSpeed = xS;
	}
   public void setYSpeed(int yS)
   {
	   ySpeed = yS;
   }
   public void setStuff(int x, int y, int wid, int hei, Color col, int xS, int yS)
   {
	   super.setPos(x, y);
	   super.setSize(wid, hei);
	   super.setColor(col);
	   xSpeed = xS;
	   ySpeed = yS;
   }
   public int getXSpeed()
	{
		return xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}

   public void moveAndDraw(Graphics window)
   {
	   //draw a white ball at old ball location
	   draw(window, Color.white);
	   setX(getX()+xSpeed);
	   //setY
	   setY(getY()+ySpeed);
	   
	   //draw the ball at its new location
	   draw(window, super.getColor());
   }
   
  public boolean equals(Object obj)
	{
		Ball ba = (Ball)obj;
		if(super.equals(ba))
		{
			return true;
		}
    if( xSpeed == ba.xSpeed){
      return true;
    }
    if( ySpeed == ba.ySpeed){
      return true;
    }
		return false;
	}   
  public String toString()
	{
		return super.toString() + " " + xSpeed + " "+ ySpeed;
	}

  @Override
  public boolean didCollideLeft(Block leftPaddle)
  {
   	if(super.getX()<=leftPaddle.getX()+leftPaddle.getWidth() && super.getX() + super.getWidth() >= leftPaddle.getX())
		{
		    if(super.getY()>=leftPaddle.getY() && super.getY() <= leftPaddle.getY() + leftPaddle.getHeight())
		     {
		         return true;
		     }
		}
	return false;
  }
 @Override
  public boolean didCollideRight( Block rightPaddle)
  {
   	if(super.getX()+super.getWidth()>rightPaddle.getX() && super.getX() < rightPaddle.getX() + rightPaddle.getWidth())
		{
		    if(super.getY()>rightPaddle.getY() && super.getY() < rightPaddle.getY() + rightPaddle.getHeight())
		     {
		         return true;
		     }
		}
	return false;
  } 
  @Override
  public boolean didCollideTop(Block wall )
  {
    if(super.getY()<=wall.getY()+wall.getHeight()){
   		if(super.getX()>=wall.getX()&&super.getX()+super.getWidth()<=wall.getX()+wall.getWidth()){
   			return true;
   		}
   	}
   	return false;

  }  
  @Override
  public boolean didCollideBottom(Block wall)
  {
    if(super.getY()+super.getHeight()>=wall.getY()){
   		if(super.getX()>=wall.getX()&&super.getX()+super.getWidth()<=wall.getX()+wall.getWidth()){
   			return true;
   		}
   	}
   	return false;

  }  
}