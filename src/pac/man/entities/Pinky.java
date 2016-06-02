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
public class Pinky extends Entity{

	public Pinky(int x, int y){
		this.x = x;
        this.y = y;
	}

	@Override
	public void update() {
		//pull pacman location
		float[] pacLoc=new float[2];
		pacLoc=GameHandler.getPac();
		
		float pacX=pacLoc[0];
		float pacY=pacLoc[1];

		/*if (Direction.LEFT)
			Pinky.setX(pacX - 4);
		else if (Direction.RIGHT)
			Pinky.setX(pacX + 4);
		else if (Direction.UP)
			Pinky.setX(pacX - 4);
			Pinky.setY(pacX + 4);
		else if (Direction.DOWN)
			Pinky.setY(pacX - 4);*/


	}

	public void setX(int x){
		/*sets x to new val*/
	}

	public void setY(int y){
		/*sets y to new val*/
	}


}



