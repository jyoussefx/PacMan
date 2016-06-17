/**
 * GameHandler.java		May 11, 2016, 10:59:38 AM
 *
 * -
 */
package pac.man.engine;

import pac.man.entities.Blinky;
import pac.man.entities.Clyde;
import pac.man.entities.Entity;
import pac.man.entities.Entity.Direction;
import pac.man.entities.Inky;
import pac.man.entities.PacMan;
import pac.man.entities.Pellet;
import pac.man.entities.Pinky;
import pac.man.states.Game;
import pac.man.states.Menu;
import pac.man.states.State;
import pac.man.states.State.States;

/**
 * Handles the Game
 * 
 * @author Aaron Roy
 * @version 
 */
public class GameHandler implements Playable{


    
    public static PacMan pac;
    

    public static States state;
    
    public static Game game;
    public static Menu menu;

    
    Pellet pellet;    

    /**
     * 
     */
    public GameHandler(){
       Draw.loadTextures();
       
       game = new Game();
       menu = new Menu();
      
       state = States.GAME;
       
              
    }
    
    /**
     * 
     */
    public void getInput() {
        switch (state)
        {
		case GAME:
			game.getInput();
			break;
		case MENU:
			menu.getInput();
			break;
		default:
			break;
        
        }
    }

    /**
     * 
     */
    public void update() {
        // TODO Auto-generated method stub
    	switch (state)
        {
 		case GAME:
 			game.update();
 			break;
 		case MENU:
 			menu.update();
 			break;
 		default:
 			break;
         
         }
    }

    /**
     * 
     */
    public void render() {
        // TODO Auto-generated method stub
    	switch (state)
        {
 		case GAME:
 			game.render();
 			TextHandler.render();
 			break;
 		case MENU:
 			menu.render();
 			break;
 		default:
 			break;
         
         }
       
    }
    
    public static float[] getLoc(Entity entity){
    	return entity.getLocation();
    }
    
    public static int[] getIndex(Entity entity){
    	return entity.getMapLocation(entity.dir);
    }
    
    public static Direction getDir(Entity entity){
    	return entity.dir;
    }
    
    
    public void switchStates(State.States s)
    {
    	state = s;
    	if (s==States.MENU) menu.load();
    }

}
