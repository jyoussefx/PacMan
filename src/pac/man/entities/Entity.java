/**
 * Entity.java		May 11, 2016, 11:20:03 AM
 */
package pac.man.entities;

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
    protected Type id;
    
    public enum Type{
        PACMAN, PELLET, BLINKY, INKY, PINKY, CLYDE, FRUIT;
    }
    
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

}
