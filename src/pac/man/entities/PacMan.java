/**
 * PacMan.java		May 11, 2016, 11:17:02 AM
 */
package pac.man.entities;

import pac.man.engine.Draw;

/**
 * The main character, duh
 *
 * @author Aaron Roy
 * @version 
 */
public class PacMan extends Entity{
    public PacMan(int x, int y){
        this.x = x;
        this.y = y;
        sx = 16;
        sy = 16;
    }

    public void getInput(){
        
    }
    
    /* (non-Javadoc)
     * @see pac.man.entities.Entity#update()
     */
    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see pac.man.entities.Entity#render()
     */
    @Override
    public void render() {
        Draw.rect(x, y, sx, sy, 0, 0, 16, 16, 0);
        
    }
}
