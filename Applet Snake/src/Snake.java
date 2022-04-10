import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
public class Snake {
    List<Point>snakePoints;

    int xDir,yDir;//snake direction

    boolean isMoving;//check snake move or not 
    boolean elongate;//increase snake body
    final int STARTSIZE=20,STARTX=150,STARTY=150;//this for snake body
    public Snake(){
        snakePoints=new ArrayList<Point>();
        xDir=0;//snake not moving
        yDir=0;
        isMoving=false;
        elongate=false;
        snakePoints.add(new Point(STARTX,STARTY));//to make the snake body
        for(int i=0;i<STARTSIZE;i++){
            snakePoints.add(new Point(STARTX-i*4,STARTY));
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        for(Point p:snakePoints){
            //to connect all points basically for snake body
            g.fillRect(p.getX(), p.getY(), 4, 4);
        }
    }
    public void move(){
        if(isMoving){
        //this function is for the snake to move
        Point temp=snakePoints.get(0);//record start of the snake
        Point last=snakePoints.get(snakePoints.size()-1);//to get last point of the snake
        Point newStart=new Point(temp.getX()+ xDir *4,temp.getY()+ yDir *4);//it will add 4 or not doing anything(reason why 4 because snakebody is square)
        for(int i=snakePoints.size()-1;i>=1;i--){
            snakePoints.set(i,snakePoints.get(i-1));//to update snake body
        }
        snakePoints.set(0, newStart);
            if (elongate) {
                snakePoints.add(last);
                elongate=false;
            }
        }
    }
    public boolean snakeCollision() {
        int x=this.getX();
        int y=this.getY();

        for(int i=1; i<snakePoints.size(); i++)
        {
            if (snakePoints.get(i).getX()==x && snakePoints.get(i).getY()==y)
                return true;//snake collision occured
        }
        return false;
    }
    public boolean isMoving(){
        return isMoving;
    }
    public void setIsMoving(boolean b){
        isMoving=b;
    }
    public int getXDir(){
        return xDir;
    }
    public int getYDir(){
        return yDir;
    }
    public void setXDir(int x){
        xDir=x;
    }
    public void setYDir(int y){
        yDir=y;
    }
    public int getX(){
        //head position of the snake
        return snakePoints.get(0).getX();
    }
    public int getY(){
        //head position of the snake
        return snakePoints.get(0).getY();
    }
    public void setElongate(boolean b) {
        elongate=b;
    }
}
