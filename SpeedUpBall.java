import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{



  public SpeedUpBall()
  {
    super();

  }

  public SpeedUpBall(int x, int y)
  {
    super(x,y);

  }


  public SpeedUpBall(int x, int y, int xSpd, int ySpd)
  {
    super(x,y,xSpd,ySpd);
   }  

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,xSpd,ySpd);

  }


  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col,xSpd,ySpd);
  }

  public void setXSpeed( int xSpd )
  {
    super.setXSpeed(xSpd);
  }

  public void setYSpeed( int ySpd )
  {
    super.setYSpeed(ySpd);
  }
  @Override
  public boolean didCollideLeft(	Block leftPaddle){
   	if(super.didCollideLeft(leftPaddle)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-1);
			}else{
				super.setXSpeed(super.getXSpeed()+1);
			}
   		return true;
   	}
   	return false;
   } 
  @Override 
  public boolean didCollideRight(Block rightPaddle){
   	if(super.didCollideRight(rightPaddle)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-1);
			}else{
				super.setXSpeed(super.getXSpeed()+1);
			}
   		return true;
   	}
   	return false;
   } 
  @Override 
  public boolean didCollideTop(Block thing){
   	if(super.didCollideTop(thing)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-1);
			}else{
				super.setXSpeed(super.getXSpeed()+1);
			}
   		return true;
   	}
   	return false;
  }
 @Override 
 public boolean didCollideBottom(Block thing){
   	if(super.didCollideBottom(thing)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-1);
			}else{
				super.setXSpeed(super.getXSpeed()+1);
			}
   		return true;
   	}
   	return false;
   }  
}

