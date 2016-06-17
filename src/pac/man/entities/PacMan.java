/**
 * PacMan.java		May 11, 2016, 11:17:02 AM
 */
package pac.man.entities;

import java.awt.Rectangle;

import org.lwjgl.input.Keyboard;

import pac.man.engine.Animation;
import pac.man.engine.Draw;
import pac.man.states.Game;

/**
 * The main character, duh
 *
 * @author Aaron Roy
 * @author Jason Chan
 * @version 0.0.1.0
 */
public class PacMan extends Entity{
    
    public Animation pac;
    
    public int score;
    public int prevScore;
	
	private boolean up, down, left, right;
	private boolean isEating;
    
    
    public PacMan(int x, int y){
        super(x, y, 13, 13);
        pac = new Animation(4, 2, sx, sy, 1);
        
        pac.add(58, 21);
        pac.add(71, 21);
        pac.add(84, 21);
        pac.add(71, 21);
        pac.stop();
        
        
        score=0;
       
    }

    public void getInput(){
        up = Keyboard.isKeyDown(Keyboard.KEY_UP);
        down = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
        left = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
        right = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
        
        if(up && !(down || left || right) && clearTop()){
            dir = Direction.UP;
        }
        if(down && !(up || left || right) && clearBottom()){
            dir = Direction.DOWN;
        }
        if(left && !(down || up || right) && clearLeft()){
            dir = Direction.LEFT;
        }
        if(right && !(down || left || up) && clearRight()){
            dir = Direction.RIGHT;
        }
        
        
        if(Keyboard.isKeyDown(Keyboard.KEY_L)){
            System.out.println("X: " + x+
                               "Y: "+  y);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_R)){
            reset();
        }
    }
    
    /* (non-Javadoc)
     * @see pac.man.entities.Entity#update()
     */
    @Override
    public void update() {
    	if(!isEating)move(dir);
//    	System.out.println(Game.realMap.getTileID(getMapLocation()[1], getMapLocation()[0]));
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
     * 
     */
    @Override
    public void move(Direction dir){
        super.move(dir);
        if(dx == 0 && dy == 0){
            stop();
        }else{
            play();
        }
        if (x<-13) setX(x+237);
        if (x>224) setX(x-237);
        
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
    
    
    public void reset(){
        x=106;
        y=70;
        ox = x+radius-1;
        oy = y+radius-1;
    }
    
    public boolean isEating(){
        return isEating;
    }
    
    public void  setEating(boolean e){
        isEating = e;
    }

        
}
