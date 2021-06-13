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

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys = new boolean[4]; //keeps track of what keys are pressed
  int count=0;

  public PaddleTestTwo()
  {
    //set up all game variable
   //instantiate a Ball
    ball = new Ball();
    //instantiate a left Paddle
    leftPaddle = new Paddle(10,0,10,100,Color.blue,5);
    //instantiate a right Paddle
    rightPaddle = new Paddle(780,0,10,100,Color.black,5);
    //set up the Canvas
    setBackground(Color.WHITE);
    setVisible(true);
    this.addKeyListener(this);
    
    new Thread(this).start();
  }
        
  public void update(Graphics window)
  {
     paint(window);
  }

  public void paint(Graphics window)
  {
  
    ball.moveAndDraw(window);
    leftPaddle.draw(window);
    //move right paddle to right side (hint use the getWidth() method from the Canvas class) then draw
    rightPaddle.draw(window);

   // System.out.println("getwidth() method :: " + getWidth());
    if (!(ball.getX()>=10 && ball.getX()<=550))
    {
      ball.setXSpeed(-ball.getXSpeed());
    }

    if (!(ball.getY()>=10 && ball.getY()<=450))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }

    if (keys[0] )
    {
      //move left paddle up and draw it on the window
      //check to make sure the paddle is not allowed to move off of the screen (hint: use the getHeight() method from +"-----"+count++);
      if (leftPaddle.getY() - leftPaddle.getSpeed() > 0) 
      {
        leftPaddle.moveUpAndDraw(window);
      }
    }
    if (keys[1])
    {

      //move left paddle down and draw it on the window
      //check to make sure the paddle is not allowed to move off of the screen (hint: use the getHeight() method from the Canvas and Paddle class)
     // System.out.println(leftPaddle.getHeight()+":"+leftPaddle.getY() +":"+ leftPaddle.getSpeed());
     // System.out.println(getHeight());
      if((leftPaddle.getHeight()+leftPaddle.getY() + leftPaddle.getSpeed())<getHeight())
      {
        leftPaddle.moveDownAndDraw(window);
      }
        
     
    }
    if (keys[2])
    {
     // System.out.println("Get Y position:"+leftPaddle.getY());
      //move right paddle up and draw it on the window
      //check to make sure the paddle is not allowed to move off of the screen (hint: use the getHeight() method from the Canvas and Paddle class)
      if (rightPaddle.getY() - rightPaddle.getSpeed() > 0) 
      {
        rightPaddle.moveUpAndDraw(window);
      }
     
    }
    if (keys[3])
    {
      //move right paddle down and draw it on the window
      //check to make sure the paddle is not allowed to move off of the screen (hint: use the getHeight() method from the Canvas and Paddle class)
      if((rightPaddle.getHeight()+rightPaddle.getY() + rightPaddle.getSpeed())< getHeight())
      {
        rightPaddle.moveDownAndDraw(window);
      }
       
    }
  }

  public void keyPressed(KeyEvent e)
  {
    //System.out.println("*** keyPressed *****"+e.getKeyChar());
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

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }
        
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