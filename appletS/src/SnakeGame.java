import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//java file to start game, create frame and handle movement input from keyboard

public class SnakeGame extends Applet implements Runnable,KeyListener {
    
    Graphics gfx;
    Image img, GOimg;
    Thread thread;
    Snake snake;
    boolean gameOver;
    Token token;
    
    public void init(){
        this.resize(400,400);
        gameOver=false;
        img=createImage(400,400);
        gfx=img.getGraphics();
        this.addKeyListener(this);
        snake=new Snake();
        token=new Token(snake);
        thread=new Thread(this);
        thread.start();
    }
    
    //creating the appletviewer
    public void paint(Graphics g){
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 0, 400, 400);

        //if still not game over, will keep drawing the snake (from methods in Snake.java file)
        if(!gameOver){
            snake.draw(gfx);
            token.draw(gfx);
        }
        else{ 
            //displaying the game over page
            gfx.setColor(Color.red);
            GOimg=getImage(getDocumentBase(), "gameover.jpg");
            gfx.drawImage(GOimg, 150, 150, this);
            gfx.drawString("HELLO!",180,150);
            gfx.drawString("Score : "+token.getScore(),180,170);
        }
        g.drawImage(img,0,0,null);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void repaint(Graphics g){
        paint(g);
    }

    //to handle movement of the snake
    public void run() {
        for(;;) //infinite loop
        {
            //to let the snake move, at the same time check for collions (to game over) and counting scores
           if(!gameOver)
           {
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
           }
           this.repaint();
           try 
           {
                Thread.sleep(40);
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    //the three conditions for the game to be over
    public void checkGameOver()
    {
        //when the snake gets out of the frame, horizontally
        if(snake.getX() < 0 || snake.getX() > 396)
        {
            gameOver=true;
        }
        //when the snake gets out of the frame, vertically
        if(snake.getY() < 0 || snake.getY() > 396)
        {
            gameOver=true;
        }
        //when snake makes collision with itself
        if(snake.snakeColl())
        {
            gameOver=true;
        }
    }

    public void keyTyped(KeyEvent e) 
    {
       
    }

    //handling movement of snake based on keyboard movements by user
    public void keyPressed(KeyEvent e) 
    {
        
        if(!snake.isMoving())
        {
            if(e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode()== KeyEvent.VK_RIGHT || e.getKeyCode()== KeyEvent.VK_DOWN){
                snake.setIsMoving(true);
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
           if(snake.getYDir() != 1){
               snake.setYDir(-1);
               snake.setXDir(0);
           }
       }
       
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
           if(snake.getYDir() != -1){
               snake.setYDir(1);
               snake.setXDir(0);
           }
       }
       
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(snake.getXDir() != 1){
               snake.setXDir(-1);
               snake.setYDir(0);
           }      
       }
       
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(snake.getXDir() != -1){
               snake.setXDir(1);
               snake.setYDir(0);
           }      
       }
    }

    public void keyReleased(KeyEvent e) 
    {
        
    }
    
}
