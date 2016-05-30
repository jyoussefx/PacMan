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
public class GameHandler {

    
    private static PacMan pac;
    public static States state;
    public static Game game;
    
    public static Map realMap;
    
    public Tile test;
    
    //TODO tile map
    public static int[][] map=new int[8][8];
    //TODO entity map
    public static int[][] entityMap=new int[8][8];

    public GameHandler(){
        Draw.loadTextures();
        pac = new PacMan(16,16);
       
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
       
       realMap = new Map(map);
              
       //Loads empty entity map and subs in entity positions
       int pacIndex[]=new int[2];
       pacIndex=pac.getMapLocation(pac.getX(), pac.getY());
       entityMap[pacIndex[0]][pacIndex[1]]=1;
       
    }
    
    /**
     * 
     */
    public void getInput() {
        // TODO Auto-generated method stub
        pac.getInput();
    }

    /**
     * 
     */
    public void update() {
        // TODO Auto-generated method stub
        pac.update();
    }

    /**
     * 
     */
    public void render() {
        // TODO Auto-generated method stub
        realMap.render();
        pac.render();
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
