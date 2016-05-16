/**
 * PacMan.java		May 11, 2016, 11:17:02 AM
 */
package pac.man.entities;

import org.lwjgl.input.Keyboard;

import pac.man.engine.Draw;

/**
 * The main character, duh
 *
 * @author Aaron Roy
 * @version 0.0.1.0
 */
public class PacMan extends Entity{
    
    private enum Direction{UP, DOWN, LEFT, RIGHT, NONE;}//controls direction presses
    
    Direction dir = Direction.NONE;
    float dx, dy;
    
    private float SPEED = 1.5f;
    
    
    public PacMan(int x, int y){
        this.x = x;
        this.y = y;
        sx = 16;
        sy = 16;
       
    }

    public void getInput(){
        if(Keyboard.isKeyDown(Keyboard.KEY_UP)&&
                !(Keyboard.isKeyDown(Keyboard.KEY_DOWN) ||
                        Keyboard.isKeyDown(Keyboard.KEY_LEFT) ||
                        Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))
            dir = Direction.UP;
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)&&
                !(Keyboard.isKeyDown(Keyboard.KEY_UP) ||
                        Keyboard.isKeyDown(Keyboard.KEY_LEFT) ||
                        Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))
            dir = Direction.DOWN;
        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)&&
                !(Keyboard.isKeyDown(Keyboard.KEY_UP) ||
                        Keyboard.isKeyDown(Keyboard.KEY_DOWN) ||
                        Keyboard.isKeyDown(Keyboard.KEY_RIGHT)))
            dir = Direction.LEFT;
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)&&
                !(Keyboard.isKeyDown(Keyboard.KEY_UP) ||
                        Keyboard.isKeyDown(Keyboard.KEY_DOWN) ||
                        Keyboard.isKeyDown(Keyboard.KEY_LEFT)))
            dir = Direction.RIGHT;
    }
    
    /* (non-Javadoc)
     * @see pac.man.entities.Entity#update()
     */
    @Override
    public void update() {        
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

    /* (non-Javadoc)
     * @see pac.man.entities.Entity#render()
     */
    @Override
    public void render() {
        Draw.rect(x, y, sx, sy, 0, 0, 16, 16, 0);
        
    }
    
  public float[] getLocation(float x,float y){
	  float[] location=new float[2];
	  location[0]=x;
      location[1]=y;
	  return location;
  }
    
}
