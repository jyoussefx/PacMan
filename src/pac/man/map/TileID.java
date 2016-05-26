/**
 * TileID.java		May 17, 2016, 11:05:52 AM
 */
package pac.man.map;

/**
 * All of the tiles in the game with their IDs
 *
 * @author Aaron Roy
 * @version 
 */
public enum TileID{
    BLANK      (0),
    UL_CORNER  (1),
    UR_CORNER  (2),
    DL_CORNER  (3),
    DR_CORNER  (4),
    LR_STRAIGHT(5),
    UD_STRAIGHT(6),
    UR_PEN     (7),
    UL_PEN     (8),
    DR_PEN     (9),
    DL_PEN     (10),
    OPEN_PEN   (11),
    LR_PEN     (12),
    UD_PEN     (13);
    
    int num;
    
    TileID(int n){
        num = n;
    }
    
    public int getID(){
        return num;
    }
    
    public static TileID getTile(int n){
        switch(n){
        case  0: return BLANK;    
        case  1: return UL_CORNER;
        case  2: return UR_CORNER;
        case  3: return DL_CORNER;
        case  4: return DR_CORNER;
        case  5: return LR_STRAIGHT;
        case  6: return UD_STRAIGHT;
        case  7: return UR_PEN;
        case  8: return UL_PEN;
        case  9: return DR_PEN;
        case 10: return DL_PEN;
        case 11: return OPEN_PEN;
        case 12: return LR_PEN;
        case 13: return UD_PEN;
        default: return BLANK;
        }
    }
}