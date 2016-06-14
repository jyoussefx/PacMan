/**
 * Ghosts.java		June 2, 2016 11:16 am 
 */
package pac.man.entities;

import pac.man.engine.GameHandler;
import java.util.Timer;
/**
 * Adds degree of separation for ghosts when dying and adds 4 modes
 * @author Chan, Carlos Valencia
 *
 */
public abstract class Ghosts extends Entity {

	/* (non-Javadoc)
	 * @see pac.man.entities.Entity#update()
	 */
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pac.man.entities.Entity#render()
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
		//pink
		Draw.rect(105,137,14,14,0,40,14,26,0,1);
		//blue
		Draw.rect(91,123,14,14,0,54,14,40,0,1);
		//orange
		Draw.rect(119,151,14,14,0,68,14,64,0,1);
		//red 
		Draw.rect(105,122)
	}
	
	
	public boolean isDecision(){
		if(GameHandler.map[index[0]-1][index[1]]==0||
			GameHandler.map[index[0]+1][index[1]]==0||
			GameHandler.map[index[0]][index[1]-1]==0){
			return true;
		}
		return false;
	}
	
	public int[] calcChoice(int[] tile1, int [] tile2, int[] tile3, int[] target){
		float x;
		float y;
		float z;
		
		float distance1;
		float distance2;
		float distance3;
		
		if(tile1[0]==-1){
			distance1=-1;
		}else{
			x=Math.abs(tile1[0]-target[0]);
			y=Math.abs(tile1[1]-target[1]);
			z=(float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
			distance1=z;
		}
		
		x=Math.abs(tile2[0]-target[0]);
		y=Math.abs(tile2[1]-target[1]);
		z=(float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		distance2=z;
		
		x=Math.abs(tile3[0]-target[0]);
		y=Math.abs(tile3[1]-target[1]);
		z=(float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		distance3=z;
		
		if(distance1<0){
			if(distance2<distance3){
				return tile2;
			}else if(distance3<distance2){
				return tile3;
			}else{
				int[] nTile=new int[2];
				nTile=getMapLocation(x, y);
				return nTile;
			}
		}else{
			if(distance1<distance2&&distance1<distance3){
				return tile1;
			}else if(distance3<distance1&&distance3<distance2){
				return tile3;
			}else{
				return getMapLocation(x,y);
			}
		}
	}
	
	public boolean isHunting(BigPellet any){ //assume time is lost if more than one is eaten
		if (isEaten=true){
			for (int counter=0; counter<180; count++)
			{
				return true;
			
			}
		}
	}

	//this will shuffle the Ghosts between Scatter, Chase, RespawnInbox, and RunAway modes
	public void chooseMode(){
		if (Game.pacIsHunting==true)
		{
			//select vulnerable blue sprite and Runaway
		}
		else if (//dead and needs to respawn)
		{
		
		}
		else (//do the targeting logic)
	
		//*Start*InBox in beginning of Game will need to be different for each Ghost 
		//because Red is never in box and Clyde is always last
	}

}
