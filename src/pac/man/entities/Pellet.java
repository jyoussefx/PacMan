package pac.man.entities;

import java.awt.Rectangle;

import pac.man.engine.Draw;

public class Pellet extends Entity {
	
	private boolean isEaten;
	
	
	public Pellet(int x, int y, int sx, int sy) {
		super(x, y, sx, sy);
	    isEaten = false;
	}
	
   public Pellet(int x, int y) {
        super(x, y, 2, 2);
        isEaten = false;
        radius = 4;
    }

	
	@Override
	public void update() {
		
		
	}

	@Override
	public void render() {
		if (!isEaten) Draw.rect(x, y, sx, sy, 58, 12, 60, 14, 0, 1);
	}
	
	public void eat()
	{
		if (!isEaten) isEaten = true;
	}
	
	
	public boolean isEaten()
	{
		return isEaten;
	}
	
	public boolean isBig(){
	    return false;
	}

}
