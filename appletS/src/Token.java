import java.awt.Color;
import java.awt.Graphics;

//java file to count the score
public class Token 
{
    private int x,y,score;
    private Snake snake;
    
    //placing the token
    public Token(Snake s)
    {
        x=(int)(Math.random()*395);
        y=(int)(Math.random()*395);
        snake=s;
    }
    
    //changing the position of token
    public void changePosition()
    {
        x=(int)(Math.random()*395);
        y=(int)(Math.random()*395);
    }
    
    //accessor
    public int getScore()
    {
        return score;
    }
    
    //creating the tokens
    public void draw(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(x, y, 6, 6);
    }
    
    //checking if the snake collide with itself or not
    //if yes, game over
    public boolean snakeCollision()
    {
        int snakeX=snake.getX() +2;
        int snakeY=snake.getY() +2;
        if(snakeX >= x-1 && snakeX <= (x+7))
            if(snakeY >= y-1 && snakeY <= (y+7)){
                changePosition();
                score++;
                snake.setElongate(true);
                return true;
            }
        return false;
        }
    
}
