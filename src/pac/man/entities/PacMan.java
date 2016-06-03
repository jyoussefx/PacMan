/**
 * PacMan.java		May 11, 2016, 11:17:02 AM
 */
package pac.man.entities;

import java.awt.Rectangle;

import org.lwjgl.input.Keyboard;

import pac.man.engine.Draw;

/**
 * The main character, duh
 *
 * @author Aaron Roy
 * @version 0.0.1.0
 */
public class PacMan extends Entity{
    
    public Rectangle area;
	
    public PacMan(int x, int y){
        this.x = x;
        this.y = y;
        sx = 16;
        sy = 16;
        
        this.area = new Rectangle(x, y, (int) sx, (int) sy);
       
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
    	move(dir);
    	area.setLocation((int) x, (int) y); 
    }

    /* (non-Javadoc)
     * @see pac.man.entities.Entity#render()
     */
    @Override
    public void render() {
        Draw.rect(x, y, sx, sy, 0, 0, 16, 16, 0);
        
    }
    
}
