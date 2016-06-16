package pac.man.entities;

import java.awt.Rectangle;

import pac.man.engine.Draw;

public class Pellet extends Entity {
	
	private boolean isEaten;
	
	private Rectangle area;
	
	public Pellet(int x, int y, int sx, int sy) {
		isEaten = false;
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		
		this.area = new Rectangle(x, y, sx, sy);
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
	
	public Rectangle getArea()
	{
		return area;
	}
	
	public boolean isEaten()
	{
		return isEaten;
	}
	
	public boolean isBig(){
	    return false;
	}

}
