/**
 * State.java		May 12, 2016, 10:52:07 AM
 */
package pac.man.states;

import pac.man.engine.GameHandler;

/**
 * A general State
 *
 * @author Aaron Roy
 * @version 
 */
public abstract class State {

    protected static States state;
    
    public enum States{
        GAME,
    	MENU;
    }
    
    public abstract void getInput();
    public abstract void update();
    public abstract void render();
    
    public States getState(){
        return state;
    }
    
    public static void switchState(States state){
        GameHandler.state = state;
    }
    
}
