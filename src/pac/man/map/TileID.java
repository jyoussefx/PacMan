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
  
    /* Abreviations:
     * U - Up
     * D - Down
     * R - Right
     * L - Left
     * When three letters are given, first is position, second is direction
     * This is needed for straight tiles
     */
    
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
    S_CORNER_UUL  (17),   //Straights joined with corners outside the maze
    S_CORNER_UUR  (18),
    S_CORNER_DDR  (19),
    S_CORNER_DDL  (20),
    S_CORNER_LUL  (21),
    S_CORNER_RUR  (22),
    S_CORNER_LDR  (23),
    S_CORNER_RDL  (24),
    P_CLOSING     (25),   //Pink closing of the pen
    P_CORNER_UL   (26),   //Corners in the pen
    P_CORNER_UR   (27),
    P_CORNER_DR   (28),
    P_CORNER_DL   (29),
    P_END_L       (30),   //Ends on either side of pen
    P_END_R       (31);

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
        case 17: return S_CORNER_UUL;
        case 18: return S_CORNER_UUR;
        case 19: return S_CORNER_DDR;
        case 20: return S_CORNER_DDL;
        case 21: return S_CORNER_LUL; 
        case 22: return S_CORNER_RUR; 
        case 23: return S_CORNER_LDR; 
        case 24: return S_CORNER_RDL; 
        case 25: return P_CLOSING;
        case 26: return P_CORNER_UL;
        case 27: return P_CORNER_UR;
        case 28: return P_CORNER_DR;
        case 29: return P_CORNER_DL;
        case 30: return P_END_L;
        case 31: return P_END_R;
        default: return BLANK;
        }
    }
}