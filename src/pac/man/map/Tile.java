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
        
        switch(id){
        case BLANK      :texX = 112;break;
        case UL_CORNER  :
        case UR_CORNER  :
        case DL_CORNER  :
        case DR_CORNER  :texX =   0;break;
        case LR_STRAIGHT:
        case UD_STRAIGHT:texX =  96;break;
        case UR_PEN     :
        case UL_PEN     :
        case DR_PEN     :
        case DL_PEN     :texX =  48;break;
        case OPEN_PEN   :texX =  96;break;
        case LR_PEN     :
        case UD_PEN     :texX =  16;break;
        default:         texX = 112;break;
        }

        Draw.rect(x, y, SIZE, SIZE, texX, 0, 1);
    }
}
