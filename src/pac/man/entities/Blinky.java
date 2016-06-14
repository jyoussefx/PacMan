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
	
		switch(chooseMode())
		{
		case CHASE
			chase(int[] target, enum Mode pastState);
			break;
		case SCATTER
			scatter;
	
		}
	}
	
	public void chase(int[] target){
		float[] pacLoc=new float[2];
		pacLoc=GameHandler.getLoc(GameHandler.pac);
		
		float pacX=pacLoc[0];
		float pacY=pacLoc[1];
		
		int[] pacIndex=new int[2];
		pacIndex=GameHandler.getIndex(GameHandler.pac);
		
		//compare locations
		if(isDecision()){
			int[] tile1=new int[2];
			int[] tile2=new int[2];
			int[] tile3=new int[2];
			tile1=index;
			tile2=index;
			tile3=index;
			
			if(clearLeft){
				tile1[0]--;
			}else{
				tile1[0]=-1;
			}
			
			if(clearFront){
				tile2[1]++;
			}else{
				tile[0]=-1
			}
			
			if(clearRight){
				tile3[0]++;
			}else{
				tile3[0]=-1;
			}
			
			int[] choice=new int[2];
			choice=calcChoice(tile1,tile2,tile3,target);
			
			if(choice==tile1){
				dir=Direction.LEFT;
				move(dir);
			}elseif(choice=tile2){
				dir=Direction.RIGHT;
				move(dir);
			}else{
				move(dir);
			}
		}else{
	        move(dir);
		}
	}
	
	public void scatter();

}