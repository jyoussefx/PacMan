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
  
    BLANK         ( 0),   //Where Pac-Man, pellets, and ghosts can move
    CORNER_UL     ( 1),   //Corners in the maze
    CORNER_UR     ( 2),
    CORNER_DR     ( 3),
    CORNER_DL     ( 4),
    STRAIGHT_ULR  ( 5),   //Straights in the maze
    STRAIGHT_RUD  ( 6),
    STRAIGHT_DLR  ( 7),
    STRAIGHT_LUD  ( 8),
    M_CORNER_UL   ( 9),   //Corners outside the maze
    M_CORNER_UR   (10),
    M_CORNER_DR   (11),                      
    M_CORNER_DL   (12),                      
    M_STRAIGHT_ULR(13),   //Straights outside the maze      
    M_STRAIGHT_RUD(14),
    M_STRAIGHT_DLR(15),
    M_STRAIGHT_LUD(16),
    P_CLOSING     (17),   //Pink closing of the pen
    P_CORNER_UL   (18),   //Corners in the pen
    P_CORNER_UR   (19),
    P_CORNER_DR   (20),
    P_CORNER_DL   (21),
    P_END_L       (22),   //Ends on either side of pen
    P_END_R       (23);

    int num;
    
    TileID(int n){
        num = n;
    }
    
    public int getID(){
        return num;
    }
    
    /**
     * Returns the tile with the specified ID
     * 
     * @param n id you are looking for
     * @return tile with id n
     */
    public static TileID getTile(int n){
        switch(n){
        case  0: return BLANK;        
        case  1: return CORNER_UL;    
        case  2: return CORNER_UR;    
        case  3: return CORNER_DR;    
        case  4: return CORNER_DL;    
        case  5: return STRAIGHT_ULR;  
        case  6: return STRAIGHT_RUD;  
        case  7: return STRAIGHT_DLR;  
        case  8: return STRAIGHT_LUD;  
        case  9: return M_CORNER_UL;  
        case 10: return M_CORNER_UR;  
        case 11: return M_CORNER_DR;  
        case 12: return M_CORNER_DL;  
        case 13: return M_STRAIGHT_ULR;
        case 14: return M_STRAIGHT_RUD;
        case 15: return M_STRAIGHT_DLR;
        case 16: return M_STRAIGHT_LUD;
        case 17: return P_CLOSING;    
        case 18: return P_CORNER_UL;  
        case 19: return P_CORNER_UR;  
        case 20: return P_CORNER_DR;  
        case 21: return P_CORNER_DL;  
        case 22: return P_END_L;     
        case 23: return P_END_R;     
        default: return BLANK;
        }
    }
}