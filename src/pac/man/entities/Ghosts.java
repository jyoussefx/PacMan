/**
 * Ghosts.java		June 2, 2016 11:16 am 
 */
package pac.man.entities;

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

	}
	
	public boolean isDecision(){
		int[] index=new int[2];
		index=getMapLocation(x,y);
		if(GameHandler.map[index[0]-1][index[1]]==0||
			GameHandler.map[index[0]+1][index[1]]==0||
			GameHandler.map[index[0]][index[1]-1]==0){
			return true;
		}
		return false;
	}
	
	public int[] calcChoice(int[] tile1, int [] tile2, int[] tile3, int[] target){
		float distance1;
		float distance2;
		float distance3;
		
		
	}
	
	//this will shuffle the Ghosts between Scatter, Chase, RespawnInbox, and RunAway modes
	public void chooseMode(){
	
		//*Start*InBox in beginning of Game will need to be different for each Ghost 
		//because Red is never in box and Clyde is always last
	}

}
