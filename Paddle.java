import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block implements Collidable<Block>
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10,30,20,Color.blue);
    this.speed =5;
  }

  //add the other Paddle constructors
public Paddle(int x,int y, int wid,int hei,int speed){
  super(x,y,wid,hei);
  this.speed =speed;
}
public Paddle(int x, int y, int wid, int hei, Color col, int speed){
  super(x,y,wid,hei,col);
  this.speed =speed;
}

 //add set & get methods
public void setSpeed(int s){
  this.speed= s;
}
public int getSpeed(){
	return speed;
}
public void setMeasurements(int x, int y, int wid, int hei, Color col, int s){
  super.setPos(x, y);
	super.setSize(wid, hei);
	super.setColor(col);
  this.speed =s;

}

public void moveUpAndDraw(Graphics window){
    //draw a white paddle at old paddle location
    draw(window,Color.white);
    //move
   // System.out.println("getY()--before"+super.getY());
    super.setY(super.getY()-getSpeed());
   // System.out.println("getY()--after"+super.getY());
    //draw the paddle at its new location
    draw(window, super.getColor());
}

public void moveDownAndDraw(Graphics window){
  draw(window,Color.white);
	setY(getY()+getSpeed());
  draw(window, super.getColor());
}
   
  //add equals method
public boolean equals(Object obj){
	Paddle p = (Paddle)obj;
  if(super.equals(p))
  {
    return true;
  }
  if( this.speed == p.speed){
    return true;
  }
    
return false;
}  

  //add a toString() method
public String toString(){
	return super.toString() + " " + speed;
}

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
public boolean didCollideRight(Block rightPaddle)
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
public boolean didCollideTop(Block thing){
  if(super.getY()<=thing.getY()+thing.getHeight()){
    if(super.getX()>=thing.getX()&&super.getX()+super.getWidth()<=thing.getX()+thing.getWidth()){
      return true;
    }
  }
  return false;
}
public boolean didCollideBottom(	Block thing)
{
  if(super.getY()+super.getHeight()>=thing.getY()){
    if(super.getX()>=thing.getX()&&super.getX()+super.getWidth()<=thing.getX()+thing.getWidth()){
      return true;
    }
  }
  return false;
}  
}