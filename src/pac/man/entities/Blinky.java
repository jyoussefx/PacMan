/**
 * Blinky.java		May 11, 2016, 11:17:02 AM
 */
package pac.man.entities;

import pac.man.engine.Draw;
import pac.man.engine.GameHandler;

/**
 * The red ghost, follows Pac-Man like a bee after honey
 *
 * @author Carlos Valencia
 * @version 0.1
 */
public class Blinky extends Ghosts{
	
	public Blinky(int x, int y){
	    super(x, y);
	}

	@Override
	public void render() {
		Draw.rect(x, y, sx, sy, 0, 0, 16, 16, 0);
	}

	@Override
	public void update() {
		//pull pacman location
		float[] pacLoc=new float[2];
		pacLoc=GameHandler.getLoc(GameHandler.pac);
		
		float pacX=pacLoc[0];
		float pacY=pacLoc[1];
		
		// ERRORS int[] pacIndex=new int[2];
		//pacIndex=GameHandler.getIndex(GameHandler.pac);
		
		//compare locations
		if(isDecision()){
			if(pacX>x){
				
			}else if(pacX<x){
				
			}
		}else{
	        move(dir);
		}
		
		//choose move
		
		//execute
		
	}
	
	

}