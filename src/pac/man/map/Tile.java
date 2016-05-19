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
    
    public final static int SIZE = 8;
    
    public Tile(int x, int y, TileID id){
        this.id = id;
    }
    
    public void render(){
        int texX;
        int texY;
        
        switch(id){
        case BLANK:
            texX = 0;
            texY = 0;
            break;       
        case DL_CORNER:
            break;       
        case DL_PEN:     
            break;       
        case DR_CORNER:  
            break;       
        case DR_PEN:     
            break;       
        case LR_PEN:     
            break;       
        case LR_STRAIGHT:
            break;       
        case OPEN_PEN:   
            break;       
        case UD_PEN:
            break;       
        case UD_STRAIGHT:
            break;       
        case UL_CORNER:  
            break;       
        case UL_PEN:     
            break;
        case UR_CORNER:  
            break;       
        case UR_PEN:     
            break;
        default:
            break;
        }
        
        Draw.rect(x, y, SIZE, SIZE);
    }
}
