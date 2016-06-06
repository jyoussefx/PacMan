/**
 * GameHandler.java		May 11, 2016, 10:59:38 AM
 *
 * -
 */
package pac.man.engine;

import pac.man.entities.PacMan;
import pac.man.map.Map;
import pac.man.map.Tile;
import pac.man.map.TileID;
import pac.man.states.Game;
import pac.man.states.State.States;

/**
 * Handles the Game
 * 
 * @author Aaron Roy
 * @version 
 */
public class GameHandler implements Playable{

    
    private static PacMan pac;
    public static States state;
    public static Game game;
    
    public static Map realMap;
    
    public Tile test;
    
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
        pac = new PacMan(16,16);
       
       test=new Tile(8*9, 8*9, TileID.CORNER_DR);
       
       realMap = new Map("res/Map");
              
       //Loads empty entity map and subs in entity positions
       int pacIndex[]=new int[2];
       pacIndex=pac.getMapLocation(pac.getX(), pac.getY());
       entityMap[pacIndex[0]][pacIndex[1]]=1;
       
    }
    
    /**
     * 
     */
    public void getInput() {
        pac.getInput();
    }

    /**
     * 
     */
    public void update() {
        pac.update();
        test.setType(TileID.CORNER_DL);
    }

    /**
     * 
     */
    public void render() {
        realMap.render();
        pac.render();
//        test.render();
    }
    
    public static float[] getPac(){
    	return pac.getLocation(pac.getX(), pac.getY());
    }
    
    public static int[] getPacIndex(){
    	return pac.getMapLocation(pac.getX(), pac.getY());
    }
    
    public static int[][] getTileMap(){
    	return map;
    }

}
