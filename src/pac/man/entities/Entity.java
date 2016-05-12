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
    protected int x;
    protected int y;
    protected int sx;
    protected int sy;
    protected Type id;
    
    public enum Type{
        PACMAN, PELLET, GHOST, FRUIT;
    }
    
    public abstract void update();
    public abstract void render();
    public Type getID(){
        return id;
    }
    
}
