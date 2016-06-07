/**
 * Pinky.java		May 25, 2016, 10:57 AM
 */
package pac.man.entities;

import pac.man.engine.Draw;
import pac.man.engine.GameHandler;

/**
 * The pink ghost attempts to be 4 places before PacMan,
 * **BUG** if PacMan is moving up, Pinky will move 4 ahead and 4 to the left
 *
 * @author Joey Youssef
 * @version 0.1
 */
public class Pinky extends Ghosts{

	public Pinky(int x, int y){
		this.x = x;
        this.y = y;
	}

	@Override
	public void update() {
		//pull pacman location
		float[] pacLoc=new float[2];
		pacLoc=GameHandler.getLoc(GameHandler.pac);

		float pacX=pacLoc[0];
		float pacY=pacLoc[1];

		float pinkyTargetX = 0;
		float pinkyTargetY = 0;


		if (PacMan.dir == Direction.LEFT)
			pinkyTargetX = pacX -4;
		else if (PacMan.dir == Direction.RIGHT)
			pinkyTargetX = pacX +4;
		else if (PacMan.dir == Direction.UP){
			pinkyTargetX = pacX -4;
			pinkyTargetY = pacY +4;
		}
		else if (PacMan.dir == Direction.DOWN)
			pinkyTargetY = pacY -4;


	}



}



