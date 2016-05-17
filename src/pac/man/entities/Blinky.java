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
public class Blinky extends Entity{

	public Blinky(int x, int y){
		this.x = x;
        this.y = y;
        sx = 14;
        sy = 14;
	}

	@Override
	public void render() {
		Draw.rect(x, y, sx, sy, 0, 0, 16, 16, 0);
	}

	@Override
	public void update() {
		//pull pacman location
		float[] pacLoc=new float[2];
		pacLoc=GameHandler.getPac();
		
		float pacX=pacLoc[0];
		float pacY=pacLoc[1];
		
		//compare locations
		
		//choose move
		//execute
		
	}

}
