/**
 * Entity.java		May 11, 2016, 11:20:03 AM
 */
package pac.man.entities;

import pac.man.engine.GameHandler;
import pac.man.engine.Renderable;

/**
 * Represents things that move or are on the screen
 *
 * @author Aaron Roy
 * @version 0.0.1.0
 */
public abstract class Entity implements Renderable{
    protected float x;
    protected float y;
    protected float sx;
    protected float sy;
    protected float ox;
    protected float oy;
    protected float radius;
    
    protected float dx, dy;
    protected Type id;

    
    private float pacSpeed = 1;
    private float ghostSpeed = 0.8f;
    
    public Entity(float x, float y, float sx, float sy){
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        radius = sx/2;
        
        ox = x+radius;
        oy = y+radius;
    }
    
    
    public enum Type{
        PACMAN, PELLET, BLINKY, INKY, PINKY, CLYDE, FRUIT;
    }
    
    public enum Direction{UP, DOWN, LEFT, RIGHT;}
    
    public static Direction dir = Direction.LEFT;
    
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
        float speed = 0;
        if(this instanceof PacMan)speed = pacSpeed;
        if(this instanceof Ghosts)speed = ghostSpeed;
        
    	switch(dir){
        case DOWN:
            dy=-speed;
            dx=  0;
            break;
        case LEFT:
            dx=-speed;
            dy=0;
            break;
        case RIGHT:
            dx=speed;
            dy=0;
            break;
        case UP:
            dy=speed;
            dx=0;
            break;
        default:
            break;
        }
        x += dx;
        y += dy;
        ox+= dx;
        oy+= dy;
    }
    public void turnRight(){
    	dir=Direction.RIGHT;
    	move(dir);
    }
    public void turnLeft(){
    	dir=Direction.LEFT;
    	move(dir);
    }
    
    public boolean clearFront(){
    	int[] index=new int[2];
    	index=getMapLocation(x,y);
    	if (GameHandler.map[index[0]][index[1]-1]==0){
    		return true;
    	}
    	return false;
    }
    
    public boolean clearRight(){
    	int[] index=new int[2];
    	index=getMapLocation(x,y);
    	if (GameHandler.map[index[0]+1][index[1]]==0){
    		return true;
    	}
    	return false;
    }
    
    public boolean clearLeft(){
    	int[] index=new int[2];
    	index=getMapLocation(x,y);
    	if (GameHandler.map[index[0]-1][index[1]]==0){
    		return true;
    	}
    	return false;
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

    /**
     * Returns the radius
     * 
     * @return radius
     */
    public float getRadius() {
        return radius;
    }
    
    public float getOx() {
        return ox;
    }

    public float getOy() {
        return oy;
    }


}
