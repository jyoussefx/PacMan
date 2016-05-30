/**
 * Tile.java		May 16, 2016, 11:18:07 AM
 */
package pac.man.map;

import pac.man.engine.Draw;

/**
 * Represents a tile in the game
 *
 * @author Aaron Roy
 * @version 
 */
public class Tile {
    private TileID id; 
    
    int x, y;
    
    public final static int SIZE = 16;
    
    public Tile(int x, int y, TileID id){
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    public void render(){
        int texX;
        
        int rot = 0;
        
        switch(id){
        case BLANK     :texX =   0;break;
        case M_CORNER  :texX =   0;break;
        case M_STRAIGHT:texX =   0;break;
        case CORNER    :texX =   0;break;
        case STRAIGHT  :texX =   0;break;
        case P_CORNER  :texX =   0;break;
        case P_STRAIGHT:texX =   0;break;
        case P_END     :texX =   0;break;
        case P_CLOSING :texX =   0;break;
        default        :texX =   0;break;
        }
        
        Draw.rect(x, y, SIZE, SIZE, texX, 0, 1);
    }
}
