package pac.man.entities;

import java.awt.Rectangle;

import pac.man.engine.Draw;

public class BigPellet extends Pellet {

	private boolean isEaten;
	
	private Rectangle area;
	
	public BigPellet(int x, int y, int sx, int sy) {
		super(x, y, sx, sy);
	}
	
	@Override
	public void eat()
	{
		if (!isEaten) {
			isEaten = true;
			System.out.println("Make ghosts vulnerable");
		}
		
	}
	

    
    @Override
    public void render() {
    	if (!isEaten) Draw.rect(x, y, sx, sy, 62, 12, 70, 20, 0, 1);
        
    }
    
    public boolean isBig()
    {
        return true;
    }
    
    public boolean isEaten()
    {
        return isEaten;
    }

}
