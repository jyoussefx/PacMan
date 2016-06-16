package pac.man.engine;

import pac.man.entities.Entity;
import pac.man.entities.PacMan;
import pac.man.map.Map;


public class Physics {	
	
	/**
	 * Checks if Bullet hits Player
	 * 
	 * @param play Player Class
	 * @param e
	 * @return true if bullet hit player
	 */
	public static boolean checkPlayer(PacMan play, Entity e)
	{
		
			float distance = (float)Math.sqrt(Math.pow((play.getOx()-e.getOx()), 2)+Math.pow((play.getOy()-e.getOy()), 2));
			if (play.getRadius()>distance)
			{
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
