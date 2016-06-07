/**
 * Inky.java		June 2, 2016, 11:17:02 AM
 */
package pac.man.entities;

import pac.man.engine.Draw;
import pac.man.engine.GameHandler;
import pac.man.entities.Entity.Direction;

/**
 * The blue ghost.
 * 
 * @author Jason Chan
 *
 */
public class Inky extends Ghosts {

/* He needs Pac-Man's current tile/orientation and Blinky's current tile to calculate
   his final target. */
	
	
// an intermediate offset two tiles 
// away from Pac-Man's tile in the direction Pac-Man is moving (shown as the dashed, green
// tile in the picture above), then draw a line from Blinky's tile to that offset. Now 
// double the line length by extending the line out just as far again, and you will have 
// Inky's target tile as shown above.
	
//For the same reasons already discussed in Pinky's case, Inky's offset calculation 
//from Pac-Man is two tiles up and two tiles left when Pac-Man is moving up 
//(shown above). The other three orientations have the expected offset of two tiles 
//in the direction Pac-Man is moving.
//Inky's targeting logic will keep him away from Pac-Man when Blinky is far away 
//from Pac-Man, but as Blinky draws closer, so will Inky's target tile. This explains 
//why Inky's behavior seems more variable as Pac-Man moves away from Blinky. 
//Like Pinky, Inky's course can often be altered by Pac-Man changing direction or 
//"head-faking". How much or how little effect this will have on Inky's decisions is 
//directly related to where Blinky is at the time.
	public Inky(int x, int y ){
		this.x = x;
		this.y = y;
		sx = 14;
		sy = 14;
	}
	
	public void render() {
		Draw.rect(x, y, sx, sy, 0, 0, 16, 16, 0);
	}

	public void update() {
		//pull pacman location
		float[] pacLoc=new float[2];
		pacLoc=GameHandler.getLoc(GameHandler.pac);
		
		float pacX=pacLoc[0];
		float pacY=pacLoc[1];
		
		int[] pacIndex=new int[2];
		pacIndex=GameHandler.getIndex(GameHandler.pac);
		
		// pull direction PacMan is facing (needs a dedicated method)
		
		
		// pull Blinky location
		float[] redLoc=new float[2];
		redLoc=GameHandler.getLoc(GameHandler.red);
		
		float redX=redLoc[0];
		float redY=redLoc[1];
		
		
		//calculate Blinky's offset 
		
		
		float blueTargetX = 0;
		float blueTargetY = 0;
		float pacOffsetX = 0;
		float pacOffsetY = 0;
		
		if (PacMan.dir==Direction.LEFT)//if pacman is facing left
		{pacOffsetX = pacX-2;
		pacOffsetY= pacY;}
		else if (PacMan.dir==Direction.RIGHT)//else if pacman is facing right
		{pacOffsetX = pacX+2;
		pacOffsetY= pacY;}
		else if (PacMan.dir==Direction.DOWN)//else if pacman is facing down
		{pacOffsetX = pacX;
		pacOffsetY= pacY-2;}
		else if (PacMan.dir==Direction.UP)//else if pacman is facing up
		{pacOffsetX = pacX-2;
		pacOffsetY= pacY+2;}
		
		
		
		// Calculate actual target's coordinates
		if (pacOffsetX>redX)
		{
			if (pacOffsetY>redY)
			{
				blueTargetX=pacOffsetX+Math.abs(pacOffsetX-redX);
				blueTargetY=pacOffsetY+Math.abs(pacOffsetY-redY);
			}
			else if (pacOffsetY<redY)
			{
				blueTargetX=pacOffsetX+Math.abs(pacOffsetX-redX);
				blueTargetY=pacOffsetY-Math.abs(pacOffsetY-redY);
			}
			else //pacOffsetY==redY
			{
				blueTargetX=pacOffsetX+Math.abs(pacOffsetX-redX);
				blueTargetY=pacOffsetY;
			}	
		}
		else if (pacOffsetX<redX)
		{
			if (pacOffsetY>redY)
			{
				blueTargetX=pacOffsetX-Math.abs(pacOffsetX-redX);
				blueTargetY=pacOffsetY+Math.abs(pacOffsetY-redY);
			}
			else if (pacOffsetY<redY)
			{
				blueTargetX=pacOffsetX-Math.abs(pacOffsetX-redX);
				blueTargetY=pacOffsetY-Math.abs(pacOffsetY-redY);
			}
			else //pacOffsetY==redY
			{
				blueTargetX=pacOffsetX-Math.abs(pacOffsetX-redX);
				blueTargetY=pacOffsetY;
			}
		}
		else //pacOffsetX==redX
		{
			if (pacOffsetY>redY)
			{
				blueTargetX=pacOffsetX;
				blueTargetY=pacOffsetY+Math.abs(pacOffsetY-redY);
			}
			else if (pacOffsetY<redY)
			{
				blueTargetX=pacOffsetX;
				blueTargetY=pacOffsetY-Math.abs(pacOffsetY-redY);
			}
			else //pacOffsetY==redY
			{
				blueTargetX=pacOffsetX;
				blueTargetY=pacOffsetY;
			}
		}
		
		//choose move
		
		//execute
		}
	}