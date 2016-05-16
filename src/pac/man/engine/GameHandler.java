/**
 * GameHandler.java		May 11, 2016, 10:59:38 AM
 *
 * -
 */
package pac.man.engine;

import pac.man.entities.PacMan;
import pac.man.states.Game;
import pac.man.states.State.States;

/**
 * Handles the Game
 * 
 * @author Aaron Roy
 * @version 
 */
public class GameHandler {

    
    private static PacMan pac;
    public static States state;
    public static Game game;
    
    //TODO tile map
    //TODO entity map

    public GameHandler(){
        Draw.loadTextures();
        pac = new PacMan(16,16);
    }
    
    /**
     * 
     */
    public void getInput() {
        // TODO Auto-generated method stub
        pac.getInput();
    }

    /**
     * 
     */
    public void update() {
        // TODO Auto-generated method stub
        pac.update();
    }

    /**
     * 
     */
    public void render() {
        // TODO Auto-generated method stub
        pac.render();
    }
    
    public static float[] getPac(){
    	return pac.getLocation(pac.getX(), pac.getY());
    }

}
