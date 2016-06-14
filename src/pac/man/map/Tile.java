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
        this.x = x*SIZE;
        this.y = y*SIZE;
    }
    
    public void render(){
        int texX;
        
        int rot;
        
        switch(id){
        case BLANK         :texX = 72;rot = 0;break;
        case CORNER_UL     :texX = 16;rot = 0;break;
        case CORNER_UR     :texX = 16;rot = 3;break;
        case CORNER_DR     :texX = 16;rot = 2;break;
        case CORNER_DL     :texX = 16;rot = 1;break;
        case STRAIGHT_ULR  :texX = 24;rot = 0;break;
        case STRAIGHT_RUD  :texX = 24;rot = 3;break;
        case STRAIGHT_DLR  :texX = 24;rot = 2;break;
        case STRAIGHT_LUD  :texX = 24;rot = 1;break;
        case M_CORNER_UL   :texX =  0;rot = 0;break;
        case M_CORNER_UR   :texX =  0;rot = 3;break;
        case M_CORNER_DR   :texX =  0;rot = 2;break;
        case M_CORNER_DL   :texX =  0;rot = 1;break;
        case M_STRAIGHT_ULR:texX =  8;rot = 0;break;
        case M_STRAIGHT_RUD:texX =  8;rot = 3;break;
        case M_STRAIGHT_DLR:texX =  8;rot = 2;break;
        case M_STRAIGHT_LUD:texX =  8;rot = 1;break;
        case S_CORNER_UUL  :texX = 32;rot = 0;break;
        case S_CORNER_UUR  :texX = 40;rot = 0;break;
        case S_CORNER_DDR  :texX = 32;rot = 3;break;
        case S_CORNER_DDL  :texX = 40;rot = 3;break;
        case S_CORNER_LUL  :texX = 32;rot = 2;break;
        case S_CORNER_RUR  :texX = 40;rot = 2;break;
        case S_CORNER_LDR  :texX = 32;rot = 1;break;
        case S_CORNER_RDL  :texX = 40;rot = 1;break;
        case P_CLOSING     :texX = 64;rot = 0;break;
        case P_CORNER_UL   :texX = 48;rot = 0;break;
        case P_CORNER_UR   :texX = 48;rot = 3;break;
        case P_CORNER_DR   :texX = 48;rot = 2;break;
        case P_CORNER_DL   :texX = 48;rot = 1;break;
        case P_END_L       :texX = 56;rot = 0;break;
        case P_END_R       :texX = 56;rot = 4;break;
        default            :texX =  0;rot = 0;break;
        }
        
        switch(rot){
        case 0:
          Draw.rect(x, y, SIZE, SIZE, texX, 0, 1);
          break;
        case 1:
          Draw.rect(x+SIZE, y, SIZE, SIZE, texX, 0, 1, 1);
          break;
        case 2:
          Draw.rect(x+SIZE, y+SIZE, SIZE, SIZE, texX, 0, 2, 1);
          break;
        case 3:
          Draw.rect(x, y+SIZE, SIZE, SIZE, texX, 0, 3, 1);
          break;
        case 4:
          Draw.rect(x+SIZE, y+SIZE-4, SIZE, SIZE, texX, 0, 2, 1);
          break;
        }
    }
    
    public void setType(TileID id){
      this.id = id;
    }
    
}
