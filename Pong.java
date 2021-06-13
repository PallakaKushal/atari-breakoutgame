import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage bufferedImage;
  private Score score;
  private int	rightScore;
  private int	leftScore;
  private Wall leftWall;
  private Wall topWall;
  private Wall rightWall;
  private Wall bottomWall;


  public Pong(int width,int height,int ballType)
  {
    //set up all variables related to the game
    
    if(ballType==0)
      ball = new Ball();
    
    if(ballType==1)
      ball = new BlinkyBall();
    
    if(ballType==2)
      ball = new SpeedUpBall();
   
    score = new Score();
    topWall = new Wall(0,0,width,10,Color.BLACK);
		bottomWall = new Wall(10,height-40,width,10,Color.BLACK);
		leftWall = new Wall(0,0,10,height,Color.GREEN);
		rightWall = new Wall(width-25,0,15,height-topWall.getHeight()-bottomWall.getHeight(),Color.GREEN);
   
   
  
    //instantiate a left Paddle
    leftPaddle = new Paddle(leftWall.getWidth()+10,topWall.getHeight(),10,100,Color.RED,5);
    
    //instantiate a right Paddle
    System.out.println(width+"--"+bottomWall.getHeight()+"--"+height+
    "--"+rightWall.getWidth());
    rightPaddle = new Paddle(width-bottomWall.getHeight()-35,height-rightWall.getWidth()-10,10,100,Color.RED,5);
  // rightPaddle = new Paddle(60,60,10,100,Color.RED,5);
   
   

    keys = new boolean[4];

    
    setBackground(Color.WHITE);
    setVisible(true);
                
    new Thread(this).start();
    addKeyListener(this);               //starts the key thread to log key strokes
  }
        
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (bufferedImage==null)
      bufferedImage = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = bufferedImage.createGraphics();


    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);

    topWall.draw(graphToBack);
		bottomWall.draw(graphToBack);
		rightWall.draw(graphToBack);
		leftWall.draw(graphToBack);


    //see if ball hits left wall or right wall
    if (ball.didCollideLeft(leftWall) || ball.didCollideRight(rightWall))
    {
      if(ball.didCollideLeft(leftWall)){
        score.setRightScore(rightScore++);
       	ball.draw(graphToBack,Color.WHITE);
				ball.setX(400);
				ball.setY(300);
			}else{
        score.setLeftScore(leftScore++);
       	ball.draw(graphToBack,Color.WHITE);
				ball.setX(400);
				ball.setY(300);
			}
     graphToBack.setColor(Color.WHITE);
		 graphToBack.fillRect(400,500,200,50);
		 graphToBack.setColor(Color.RED);
		 graphToBack.drawString("Right Score = "+rightScore,340,510);
		 graphToBack.drawString("Left Score = "+leftScore,340,530);
		 ball.setXSpeed(-ball.getXSpeed());
		 if(ball.getXSpeed()<0){
				ball.setXSpeed(3);
				ball.setYSpeed(0);
			}else{
				ball.setXSpeed(-3);
				ball.setYSpeed(0);
			}
		}

                
    //see if the ball hits the top or bottom wall 
    if(leftPaddle.didCollideBottom(bottomWall)){
			leftPaddle.setY(450);
			leftPaddle.draw(graphToBack,Color.RED);
		}else if(leftPaddle.didCollideTop(topWall)){
			leftPaddle.setY(10);
			leftPaddle.draw(graphToBack,Color.RED);
		}
		
		if(rightPaddle.didCollideBottom(bottomWall)){
			rightPaddle.setY(450);
			rightPaddle.draw(graphToBack,Color.RED);
		}else if(rightPaddle.didCollideTop(topWall)){
			rightPaddle.setY(10);
			rightPaddle.draw(graphToBack,Color.RED);
		}

    if(ball.didCollideBottom(bottomWall)||ball.didCollideTop(topWall))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
		


    //see if the ball hits the left paddle
    if(ball.didCollideLeft(leftPaddle)){
			ball.setXSpeed(ball.getXSpeed()*(-1));
			if(Math.abs((leftPaddle.getY()+leftPaddle.getHeight())-ball.getY()+ball.getHeight()/2)>55){
				ball.setYSpeed(-1);
			}else if(Math.abs((leftPaddle.getY()+leftPaddle.getHeight())-ball.getY()+ball.getHeight()/2)<45){
				ball.setYSpeed(1);
			}else{
				ball.setYSpeed(0);
			}
		}
		
    //see if the ball hits the right paddle
		if(ball.didCollideRight(rightPaddle)){
			ball.setXSpeed(ball.getXSpeed()*(-1));
			if(Math.abs((rightPaddle.getY()+rightPaddle.getHeight())-ball.getY()+ball.getHeight()/2)>55){
				ball.setYSpeed(-1);
			}else if(Math.abs((rightPaddle.getY()+rightPaddle.getHeight())-ball.getY()+ball.getHeight()/2)<45){
				ball.setYSpeed(1);
			}else{
				ball.setYSpeed(0);
			}
		}
	
    
    //see if the paddles need to be moved
		
		if(keys[0])
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1])
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2])
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3])
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}

    twoDGraph.drawImage(bufferedImage, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch (toUpperCase(e.getKeyChar()))
    {
      case 'W' : keys[0]=true; break;
      case 'X' : keys[1]=true; break;
      case 'O' : keys[2]=true; break;
      case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
      case 'W' : keys[0]=false; break;
      case 'X' : keys[1]=false; break;
      case 'O' : keys[2]=false; break;
      case 'M' : keys[3]=false; break;
    }
  }
  public void keyTyped(KeyEvent e){}
        
  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(8);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }     
}