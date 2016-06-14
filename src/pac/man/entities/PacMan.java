/**
 * PacMan.java		May 11, 2016, 11:17:02 AM
 */
package pac.man.entities;

import java.awt.Rectangle;

import org.lwjgl.input.Keyboard;

import pac.man.engine.Animation;
import pac.man.engine.Draw;

/**
 * The main character, duh
 *
 * @author Aaron Roy
 * @author Jason Chan
 * @version 0.0.1.0
 */
public class PacMan extends Entity{
    
    public boolean hunting=false;
    public Rectangle area;
    public Animation pac;
	
    public PacMan(int x, int y){
        this.x = x;
        this.y = y;
        sx = 13;
        sy = 13;
        pac = new Animation(4, 2, sx, sy, 1);
        
        pac.add(58, 21);
        pac.add(71, 21);
        pac.add(84, 21);
        pac.add(71, 21);
        
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

        switch (dir) {
        case UP   :pac.play(x, y, 1); break;
        case RIGHT:pac.play(x, y, 0); break;
        case DOWN :pac.play(x, y, 3); break;
        case LEFT :pac.play(x, y, 2); break;
        default:
            break;
        }
    }
    
    /**
     * After Pacman eats a power pellet, for a timer of ~3 seconds, 
     * he will be in an invincible mode signaling to the ghosts to 
     * enter their vulnerable mode
     */
    public void goInvulnerable()
    {
    	
    }

    /**
     * Stops PacMan's animation
     */
    public void stop() {
        pac.stop();        
    }

    /**
     * Plays PacMan's animation
     */
    public void play() {
        pac.resume();
    }

    
}
