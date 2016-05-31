/**
 * Map.java		May 24, 2016, 11:11:58 AM
 */
package pac.man.map;

import pac.man.engine.Renderable;


/**
 * Represents an array of tiles
 *
 * @author Aaron Roy
 * @version 
 */
public class Map implements Renderable{
    Tile[][] tiles;
    
    
    /**
     * Creates a map from an integer array
     * 
     * @param t The input int[][] array
     */
    public Map(int[][] t){
        tiles = new Tile[t.length][t[0].length];
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                tiles[i][j] = new Tile(j*16, i*16, TileID.getTile(t[i][j]));
            }
        }
    }
    
    
    /**
     * Goes through every tile in the map and renders it
     */
    public void render(){
        for (Tile[] t : tiles) {
            for (Tile tile : t) {
                tile.render();
            }
        }
    }


    /* (non-Javadoc)
     * @see pac.man.engine.Renderable#update()
     */
    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }
}
