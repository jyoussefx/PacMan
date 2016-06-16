package pac.man.engine;

import pac.man.entities.Entity;
import pac.man.entities.PacMan;
import pac.man.entities.Entity.Direction;
import pac.man.map.Map;


public class Physics {	
	
	/**
	 * Checks if Entity hits Player
	 * 
	 * @param play Player Class
	 * @param e
	 * @return true if entity hit player
	 */
	public static boolean checkPlayer(PacMan play, Entity e)
	{
		
			float distance = (float)Math.sqrt(Math.pow((play.getOx()-e.getOx()), 2)+Math.pow((play.getOy()-e.getOy()), 2));
			if (e.getRadius()>distance)
			{
				return true;
			}
		
		return false;
		
	}
	
	/**
     * Checks if Entity hits Player using tiles
     * 
     * @param play Player Class
     * @param e
     * @return true if entity hit player
     */
    public static boolean checkPlayer2(PacMan play, Entity e){
        int[] pLoc = play.getMapLocation(Direction.NONE);
        int[] eLoc = e.getMapLocation(Direction.NONE);
        if(pLoc[0]==eLoc[0] && pLoc[1]==eLoc[1]){
            return true;
        }
        
        return false;
        
    }
	
   /**
    * Checks the walls and sees if Pac-Man can turn
    * 
    * @param play
    * @param map
    * @return
    */
   public static boolean checkWall(PacMan play, Map map){
       int pacX = map.getX(play);
       int pacY = map.getY(play);
       switch (play.getDirection()) {
       case UP:case DOWN:
           break;
       case RIGHT:case LEFT:
           break;
        default:
            break;
        }
       
       
       
        return false;
        
    }

}
