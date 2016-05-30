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
    M_CORNER   (1),
    M_STRAIGHT (2),
    CORNER     (3),
    STRAIGHT   (4),
    P_CORNER   (5),
    P_STRAIGHT (6),
    P_END      (7),
    P_CLOSING  (8);
    
    enum Rotation{
        UR, DR, UL, DL;
    }
    
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
        case  1: return M_CORNER;
        case  2: return M_STRAIGHT;
        case  3: return CORNER;
        case  4: return STRAIGHT;
        case  5: return P_CORNER;
        case  6: return P_STRAIGHT;
        case  7: return P_END;
        case  8: return P_CLOSING;
        default: return BLANK;
        }
    }
}