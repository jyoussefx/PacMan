/**
 * Entity.java		May 11, 2016, 11:20:03 AM
 */
package pac.man.entities;

import pac.man.engine.GameHandler;
import pac.man.engine.Renderable;
import pac.man.map.TileID;
import pac.man.states.Game;

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
        radius = sx/2f;
        
        ox = x+radius-1;
        oy = y+radius-1;
    }
    
    
    public enum Type{
        PACMAN, PELLET, BLINKY, INKY, PINKY, CLYDE, FRUIT;
    }
    
    public enum Direction{UP, DOWN, LEFT, RIGHT, NONE;}
    
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

        dx = 0;
        dy = 0;
        
        switch(dir){
        case DOWN:
            if(clearBottom()){
                dy=-speed;
                dx=  0;
            }
            break;
        case LEFT:
            if(clearLeft()){
                dx=-speed;
                dy=0;
            }
            break;
        case RIGHT:
            if(clearRight()){
                dx=speed;
                dy=0;
            }
            break;
        case UP:
            if(clearTop()){
                dy=speed;
                dx=0;
            }
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
    
    public boolean clearTop(){
        int[] index=getMapLocation(Direction.UP);
        fixBounds(index);
//        System.out.println(Game.realMap.getTileID(index[1], index[0]));
        if (Game.realMap.getTileID(index[1], index[0])==TileID.BLANK){
            return true && (int)getOx() == getCenterX();
        }
    	return false;
    }
    
    public boolean clearBottom(){
        int[] index={getMapLocation(Direction.DOWN)[0], getMapLocation(Direction.DOWN)[1]-2};
        fixBounds(index);
//        System.out.println(Game.realMap.getTileID(index[1]-1, index[0]));
        if (Game.realMap.getTileID(index[1], index[0])==TileID.BLANK){
            return true && (int)getOx() == getCenterX();
        }
        return false;
    }

    
    public boolean clearRight() throws ArrayIndexOutOfBoundsException{
        int[] index={getMapLocation(Direction.RIGHT)[0]+1, getMapLocation(Direction.RIGHT)[1]-1};
        fixBounds(index);
//        System.out.println(Game.realMap.getTileID(index[1]-1, index[0]+1));
        if (Game.realMap.getTileID(index[1], index[0])==TileID.BLANK){
            return true && (int)getOy() == getCenterY();
        }
    	return false;
    }
    
    public boolean clearLeft(){
    	 int[] index= {getMapLocation(Direction.LEFT)[0]-1, getMapLocation(Direction.LEFT)[1]-1};
    	 fixBounds(index);
//         System.out.println(Game.realMap.getTileID(index[1]-1, index[0]-1));
    	if (Game.realMap.getTileID(index[1], index[0])==TileID.BLANK){
    		return true && (int)getOy() == getCenterY();
    	}
    	return false;
    }
    
    public void fixBounds(int[] fix){
        if(fix[0] < 0){
            fix[0] = Game.realMap.getWidth()-1;
        }
        if(fix[0] >= Game.realMap.getWidth()){
            fix[0] = 0;
        }
    }
    
    
    public float[] getLocation(){
  	  float[] location=new float[2];
  	  location[0]=ox;
        location[1]=oy;
  	  return location;
    }
    
    public int[] getMapLocation(Direction newDir){  
      float x = 0;
      float y = 0;
      
      switch(newDir){
    case DOWN:
        x = ox;
        y = oy+4;
        break;
    case LEFT:
        x = ox+4;
        y = oy;
        break;
    case RIGHT:
        x = ox-3;
        y = oy;
        break;
    case UP:
        x = ox;
        y = oy-3;
        break;
    default:
        x = ox;
        y = oy;
        break;
          
      }
        
  	  int xIndex=(int)(x/8);
  	  int yIndex=(int)((y)/8);
  	  
  	  int[]mapLocation= {xIndex, yIndex-1};
  	  return mapLocation;
    }
    
    public int[] getMapLocation(float x, float y){  
        int xIndex=(int)(x/8);
        int yIndex=(int)((y)/8);
        
        int[]mapLocation= {xIndex, yIndex-1};
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
    
    public int getCenterX(){
        return ((int)ox/8)*8+3;
    }
    
    public int getCenterY(){
        return ((int)oy/8)*8+3;
    }


    /**
     * Returns the direction this entity is moving
     */
    public Direction getDirection(){
        return dir;
    }
    
    public void setX(float i)
    {
        this.x = i;
        ox = i+radius-1;
    }


}
