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
}