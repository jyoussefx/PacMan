/**
 * Game.java		May 11, 2016, 11:13:56 AM
 *
 * -
 */
package pac.man.states;

import org.lwjgl.input.Keyboard;

import pac.man.engine.TextHandler;
import pac.man.entities.BigPellet;
import pac.man.entities.PacMan;
import pac.man.entities.Pellet;
import pac.man.map.Map;
import pac.man.map.Tile;
import pac.man.map.TileID;

/**
 * The Game state
 * 
 * @author Aaron Roy
 * @version 0.0.1.0
 */
public class Game extends State {

	public static PacMan pac;
	
    public static Map realMap;
    
    public Tile test;

	
    public Pellet[] pellets = new Pellet[25];

    private boolean paused = false;

    private boolean wasPaused;
	
	public Game()
	{
		super(States.GAME);
        pac = new PacMan(16,16);
        
        test=new Tile(8*9, 8*9, TileID.CORNER_DR);
        
        realMap = new Map("res/Maze");

        
        for (int i=0; i<25; i++)
        {
     	   
        	if (i==7) pellets[i] = new BigPellet(i*8, i*8, 6, 6);
        	else pellets[i] = new Pellet(i*8, i*8, 2, 2);
        }
        TextHandler.clear();
        TextHandler.write("Paused", 88, 140);
	}
	
	@Override
	public void getInput() {
		if(!paused)pac.getInput();
		
		if(Keyboard.isKeyDown(Keyboard.KEY_P) && !wasPaused){
		    paused = !paused;
		    pac.stop();
		}
		
		wasPaused = Keyboard.isKeyDown(Keyboard.KEY_P);
	}

	@Override
	public void update() {
	    if(!paused){
	        pac.play();
	        pac.update();

	        for (int i=0; i<25; i++)
	        {
	            if (pellets[i].getArea().intersects(pac.area)){
	                pellets[i].eat();
	            }
	        }
	    }		
		
		
	}

	@Override
	public void render() {
		
		pac.render();
		for (int i=0; i<25; i++)
		{
			pellets[i].render();
		}
        realMap.render();
//        test.render();
        
        if(paused)TextHandler.render();
	
		
	}
	
	public PacMan getPac()
	{
		return pac;
	}
    
	
}
