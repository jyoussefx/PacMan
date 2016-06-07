/**
 * GameHandler.java		May 11, 2016, 10:59:38 AM
 *
 * -
 */
package pac.man.engine;

import pac.man.entities.Blinky;
import pac.man.entities.Entity;

import pac.man.entities.Pellet;

import pac.man.entities.Entity.Direction;
import pac.man.entities.Inky;
import pac.man.entities.PacMan;
import pac.man.map.Map;
import pac.man.map.Tile;
import pac.man.map.TileID;

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
public class GameHandler implements Playable{


    
    public static PacMan pac;
    public static Blinky red;
    public static Inky blue;
    /*public static Pinky pink;
    public static Clyde orange;
    */

    public static States state;
    
    public static Game game;
    public static Menu menu;
    
    Pellet pellet;
    
    //public Tile test;
    
    //TODO tile map
    public static int[][] map= {{ 9,13,13,13,13,13,13,10},
                                {16, 0, 0, 0, 0, 0, 0,14},
                                {16, 0, 0, 0, 0, 0, 0,14},
                                {16, 0, 0, 0, 0, 0, 0,14},
                                {16, 0, 0, 0, 0, 0, 0,14},
                                {16, 0, 0, 0, 0, 0, 0,14},
                                {16, 0, 0, 0, 0, 0, 0,14},
                                {12,15,15,15,15,15,15,11}};
    //TODO entity map
    public static int[][] entityMap=new int[8][8];

    /**
     * 
     */
    public GameHandler(){
       Draw.loadTextures();
       
       game = new Game();
       menu = new Menu();
      
       state = States.GAME;
       
              
       //Loads empty entity map and subs in entity positions
       int pacIndex[]=new int[2];
       pacIndex=game.getPac().getMapLocation(game.getPac().getX(), game.getPac().getY());
       entityMap[pacIndex[0]][pacIndex[1]]=1;       
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
    
    public static Direction getDir(Entity entity){
    	return entity.dir;
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
