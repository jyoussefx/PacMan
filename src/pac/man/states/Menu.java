package pac.man.states;

import pac.man.engine.TextHandler;

public class Menu extends State {

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		TextHandler.render();
		
	}
	
	public void load()
	{
		TextHandler.clear();
		TextHandler.write("1 Player", 100, 100, 12);
	}
	

}
