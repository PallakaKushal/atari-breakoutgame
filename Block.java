import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
     this.xPos =100;
     this.yPos =150;
     this.width =10;
     this.height =10;
     this.color = Color.RED;

  }//add other Block constructors - x , y , width, height, color
  public Block(int x, int y)
	{
		this.xPos = x;
		this.yPos = y;
		this.width = 10;
		this.height = 10;
    this.color = Color.RED;
	}
  public Block(int x, int y, int wid, int hei)
	{
		this.xPos = x;
		this.yPos = y;
		this.width = wid;
		this.height = hei;
    this.color = Color.RED;
	}
  public Block(int xPos,int yPos,int width, int height, Color col ) 
  {
    this.xPos = xPos;
    this.yPos = yPos;
    this.width = width;
    this.height = height;
    this.color = col;
  }     

//SET AND GET METHODS(ACTIVITY 1)
public void setWidth(int width){
    this.width=width;
}
public int getWidth(){
  return width;

}
public void setHeight(int height){
  this.height=height;
}
public int getHeight(){
  return height;
}
public void setSize(int width, int height)
{
	   setWidth(width);
	   setHeight(height);
}
  
public void setX(int x)
{
  this.xPos = x;
}
public int getX()
{
  return xPos;
}
public void setY(int y)
{
	this.yPos = y;
}
public int getY(){
    return yPos;
  }
public void setPos(int x, int y){
    setX(x);
    setY(y);
}
public void setColor(Color col)
{
  this.color =col ;
}
public Color getColor(){
  return color;
}

public void draw(Graphics window)
{

  window.setColor(color);
  window.fillRect(getX(), getY(), getWidth(), getHeight());
}

public void draw(Graphics window, Color col)
{
  window.setColor(col);
  window.fillRect(getX(), getY(), getWidth(), getHeight());
}
   
public boolean equals(Object obj)
{
  if(this == obj){
    return true;
  }
  if(obj == null){
    return false;
  }
  Block b = (Block)obj;
  if(color == null){
    if(b.color != null){
        return false;
    }
    else if(!color.equals(b.color)){
      return false;
    }
  }
  if(height != b.height){
  return false;
}
if(width != b.width){
  return false;
}
if(xPos != b.xPos){
  return false;
}
if(yPos != b.yPos){
  return false;
}  
return true;
}


  //add a toString() method  - x  y  width height color

public String toString() {
  
  return  xPos + "," + yPos + "," + width + "," + height + "," + color ;

}
}