/**
 * Ghosts.java		June 2, 2016 11:16 am 
 */
package pac.man.entities;

import pac.man.engine.GameHandler;
import pac.man.map.TileID;
import pac.man.states.Game;

/**
 * Adds degree of separation for ghosts when dying and adds 4 modes
 * @author Chan, Carlos Valencia
 *
 */
public abstract class Ghosts extends Entity {

	/* (non-Javadoc)
	 * @see pac.man.entities.Entity#update()
	 */
	
	/**
     * @param x
     * @param y
     * @param sx
     * @param sy
     * @param radius
     */
    public Ghosts(float x, float y) {
        super(x, y, 14, 14);
    }

    @Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void renderGhostEyes()
	{
		
		
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
		index=getMapLocation();
		if(Game.realMap.getTileID(index[1],index[0]-1)==TileID.BLANK||
		   Game.realMap.getTileID(index[1],index[0]+1)==TileID.BLANK||
		   Game.realMap.getTileID(index[1]+1,index[0])==TileID.BLANK)
		{
			return true;
		}
		return false;
	}
	
	public int[] calcChoice(int[] tile1, int[] tile2, int[] tile3, int[] target){
		float distance1;
		float distance2;
		float distance3;
		return target;
		
		
	}
	
	//this will shuffle the Ghosts between Scatter, Chase, RespawnInbox, and RunAway modes
	public void chooseMode(){
	
		//*Start*InBox in beginning of Game will need to be different for each Ghost 
		//because Red is never in box and Clyde is always last
	}

}
