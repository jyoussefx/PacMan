/**
 * Entity.java		May 11, 2016, 11:20:03 AM
 */
package pac.man.entities;

/**
 * Represents things that move or are on the screen
 *
 * @author Aaron Roy
 * @version 0.0.1.0
 */
public abstract class Entity {
    protected float x;
    protected float y;
    protected float sx;
    protected float sy;
    float dx, dy;
    protected Type id;
    
    private float SPEED = 1.5f;
    
    public enum Type{
        PACMAN, PELLET, BLINKY, INKY, PINKY, CLYDE, FRUIT;
    }
    
    public enum Direction{UP, DOWN, LEFT, RIGHT, NONE;}
    
    Direction dir = Direction.NONE;
    
    public abstract void update();
    public abstract void render();
    public Type getID(){
        return id;
    }
    
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getSx() {
        return sx;
    }
    public float getSy() {
        return sy;
    }
    public void move(Direction dir){
    	switch(dir){
        case DOWN:
            dy=-SPEED;
            dx=  0;
            break;
        case LEFT:
            dx=-SPEED;
            dy=0;
            break;
        case RIGHT:
            dx=SPEED;
            dy=0;
            break;
        case UP:
            dy=SPEED;
            dx=0;
            break;
        default:
            break;
        
        }
        x += dx;
        y += dy;
    }
    public int turnRight(Entity ent){
    	return 0;
    }
    
    public float[] getLocation(float x,float y){
  	  float[] location=new float[2];
  	  location[0]=x;
        location[1]=y;
  	  return location;
    }
    
    public int[] getMapLocation(float x, float y){
  	  int xIndex; 
  	  int yIndex;
  	  
  	  xIndex=(int)x/16;
  	  yIndex=(int)y/16;
  	  
  	  int[]mapLocation=new int[2];
  	  mapLocation[0]=xIndex;
  	  mapLocation[1]=yIndex;
  	  return mapLocation;
    }

}
