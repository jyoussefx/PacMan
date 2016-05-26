/**
 * Map.java		May 24, 2016, 11:11:58 AM
 */
package pac.man.map;

/**
 * Represents an array of tiles
 *
 * @author Aaron Roy
 * @version 
 */
public class Map {
    Tile[][] tiles;
    
    public Map(int[][] t){
        tiles = new Tile[t.length][t[0].length];
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                tiles[i][j] = new Tile(j*16, i*16, TileID.getTile(t[i][j]));
            }
        }
    }
    
    public void render(){
        for (Tile[] t : tiles) {
            for (Tile tile : t) {
                tile.render();
            }
        }
    }
}
