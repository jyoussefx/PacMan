package pac.man.entities;

import java.awt.Rectangle;

import pac.man.engine.Draw;

public class BigPellet extends Pellet {

	private boolean isEaten;
	
	private Rectangle area;
	
	public BigPellet(int x, int y, int sx, int sy) {
		super(x, y, sx, sy);
		// TODO Auto-generated constructor stub
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
    	if (!isEaten) Draw.rect(x, y, sx, sy, 62, 16, 70, 24, 0, 1);
        
    }

}