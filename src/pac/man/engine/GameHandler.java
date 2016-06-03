/**
 * GameHandler.java		May 11, 2016, 10:59:38 AM
 *
 * -
 */
package pac.man.engine;

import pac.man.entities.Entity;
import pac.man.entities.Pellet;
import pac.man.states.Game;
import pac.man.states.Menu;
import pac.man.states.State;
import pac.man.states.State.States;

/**
 * Handles the Game
 * 
 * @author Aaron Roy
 * @version 
 */
public class GameHandler {

    public static States state;
    
    public static Game game;
    public static Menu menu;
    
    Pellet pellet;
    
    //public Tile test;
    
    //TODO tile map
    public static int[][] map=new int[8][8];
    //TODO entity map
    public static int[][] entityMap=new int[8][8];

    
    public GameHandler(){
       Draw.loadTextures();
       
       game = new Game();
       menu = new Menu();
      
       state = States.GAME;
       
        
       //Loads empty map with border into array
       for(int i:map[0]){
    	   if (i==0)
    		   map[0][i]=1;
    	   else if (i==map.length)
    		   map[0][i]=2;
    	   else
    		   map[0][i]=5;
       }
       
       for(int i:map[map.length-1]){
    	   if (i==0)
    		   map[0][i]=3;
    	   else if (i==map.length-1)
    		   map[0][i]=4;
    	   else
    		   map[0][i]=5;
       }
       
       for (int i=0;i<map.length-1;i++){
    	   map[i][0]=6;
    	   map[i][map.length-1]=6;
       }
       
       //test = new Tile(0,0, TileID.BLANK);
       
       //Loads empty entity map and subs in entity positions
       int pacIndex[]=new int[2];
       pacIndex=game.getPac().getMapLocation(game.getPac().getX(), game.getPac().getY());
       entityMap[pacIndex[0]][pacIndex[1]]=1;
       
       //draws tiles
       
    }
    
    /**
     * 
     */
    public void getInput() {
        switch (state)
        {
		case GAME:
			game.getInput();
			break;
		case MENU:
			menu.getInput();
			break;
		default:
			break;
        
        }
    }

    /**
     * 
     */
    public void update() {
        // TODO Auto-generated method stub
    	switch (state)
        {
 		case GAME:
 			game.update();
 			break;
 		case MENU:
 			menu.update();
 			break;
 		default:
 			break;
         
         }
    }

    /**
     * 
     */
    public void render() {
        // TODO Auto-generated method stub
    	switch (state)
        {
 		case GAME:
 			game.render();
 			break;
 		case MENU:
 			menu.render();
 			break;
 		default:
 			break;
         
         }
       
    }
    
    public static float[] getLoc(Entity entity){
    	return entity.getLocation(entity.getX(), entity.getY());
    }
    
    public static int[] getIndex(Entity entity){
    	return entity.getMapLocation(entity.getX(), entity.getY());
    }
    
    public static int[][] getTileMap(){
    	return map;
    }
    
    public void switchStates(State.States s)
    {
    	state = s;
    	if (s==States.MENU) menu.load();
    }

}
