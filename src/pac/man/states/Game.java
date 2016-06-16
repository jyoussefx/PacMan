/**
 * Game.java		May 11, 2016, 11:13:56 AM
 *
 * -
 */
package pac.man.states;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.w3c.dom.css.Counter;

import pac.man.engine.HUD;
import pac.man.engine.NonexistentStringException;
import pac.man.engine.Physics;
import pac.man.engine.TextHandler;
import pac.man.entities.BigPellet;
import pac.man.entities.Blinky;
import pac.man.entities.Clyde;
import pac.man.entities.Fruit;
import pac.man.entities.Fruits;
import pac.man.entities.Inky;
import pac.man.entities.PacMan;
import pac.man.entities.Pellet;
import pac.man.entities.Pinky;
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
	public static int numLives;
	public static int level;
	
    public static Map realMap;
    
    public static Fruit fruit;
    public static int fruitNum;
    
    public static int fruitTimer;
    public static boolean hasFruit;
    
    public Tile test;
    public static HUD hud;
    
    public static Blinky red;
    public static Inky blue;
    public static Pinky pink;
    public static Clyde orange;
	
    public ArrayList<Pellet> pellets = new ArrayList<Pellet>();

    private boolean paused = false;
   

    private boolean wasPaused;

    private int counter;
	
	public Game()
	{
	    
		super(States.GAME);
        hud = new HUD(pac);
        pac = new PacMan(106,70);
               
        realMap = new Map("res/Maze");
        
        red = new Blinky(105, 166);

        Tile[][] tiles = realMap.getTiles();
        
        for (int y=0; y<28; y++)
        {
            for (int x=0;x<31; x++)
            {
                if (tiles[x][y].getType()==TileID.BLANK)
                    
                    if ((x==7&&y==1) 
                      || (x==27&&y==1)
                      || (x==7&&y==26)
                      || (x==27&&y==26))
                            pellets.add(new BigPellet(tiles[x][y].getX(), tiles[x][y].getY()));
                    else if (!((x>10&&x<22&&!(y==6||y==21))
                            || (x==27&&!(y==6||y==12||y==15||y==21))))
                                pellets.add(new Pellet(tiles[x][y].getX()+3, tiles[x][y].getY()+3, 2, 2));
                        
            }
        }
        
        numLives=2;
        fruitNum=0;
        fruitTimer=100;
	}
	
	@Override
	public void getInput() {
		if(!paused)pac.getInput();
		realMap.getInput();
		
		if(Keyboard.isKeyDown(Keyboard.KEY_P) && !wasPaused){
		    TextHandler.clear();
	        TextHandler.write("Paused", 88, 140);
		    paused = !paused;
		    pac.stop();
		}
		
		if (wasPaused && !paused) {
		    try {
                TextHandler.erase("Paused");
            } catch (NonexistentStringException e) {
                e.printStackTrace();
            }
		}
		wasPaused = Keyboard.isKeyDown(Keyboard.KEY_P);
	}

	@Override
	public void update() {
	    if(!paused && counter>240){
	        
	        if (hasFruit) fruit.update();

	        for (Pellet p: pellets)
	        {
	            
	            if (Physics.checkPlayer2(pac, p) && !p.isEaten()){
	                p.eat();
	                pac.setEating(true);
	                pac.prevScore = pac.score;
	                if (p.isBig()) {
	                    pac.score+=50;
	                    
	                }
	                else pac.score+=10;
	                
	                try {
                        TextHandler.overwrite(String.valueOf(pac.prevScore), String.valueOf(pac.score));
                        
                            
                    } catch (NonexistentStringException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
	                
	                
	            }
	           
	            if (HUD.hiScore<pac.score) {
                    HUD.prevHiScore=HUD.hiScore;
                    HUD.hiScore=pac.score;
                    try {
                        TextHandler.overwrite(String.valueOf(HUD.prevHiScore), String.valueOf(HUD.hiScore));
                    } catch (NonexistentStringException e)
                    {}
                }
	            
	        }
	        
	        if (!hasFruit) fruitTimer--;
	        
	        
	        if (fruitTimer<=0 && !hasFruit) spawnFruit();
	        
	        if (hasFruit && Physics.checkPlayer2(pac, fruit) &!fruit.isEaten()) 
	            {
	                fruit.eat();
	                pac.prevScore=pac.score;
	                pac.score+=100;
	                hasFruit=false;
	                fruitTimer=100;
	                
	                fruitNum++;
	                if (fruitNum>7) fruitNum=0;
	                
	                try {
                        TextHandler.overwrite(String.valueOf(pac.prevScore), String.valueOf(pac.score));
                            
                    } catch (NonexistentStringException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
	                
	            }
	        
	        pac.play();
	        pac.update();
	        pac.setEating(false);
//	        red.update();
	        
	        //if (noMorePellets) level++;
	    }		
	    
        TextHandler.clear();
        if(paused)
            TextHandler.write("Paused", 88, 140);
        
        if(counter <= 240){
            TextHandler.write("READY", 88, 120);
            counter++;
        }
        
        TextHandler.write("1 UP", 24, 278);
        TextHandler.write("HIGH SCORE", 72, 278);
        TextHandler.write(String.valueOf(pac.score), 24, 268);
        TextHandler.write(String.valueOf(HUD.hiScore), 72, 268);

		
	}

	@Override
	public void render() {
		
//		red.render();
        realMap.render();
        for (Pellet p: pellets) p.render();
        
        for (int i=0; i<numLives; i++)
        {
            HUD.drawLife(13+i*16, 15);
        }
        
//        test.render();
        
        if (hasFruit) fruit.render();
        pac.render();
		
	}
	
	public PacMan getPac()
	{
		return pac;
	}
	
	public void spawnFruit()
	{
	    fruit = new Fruit(Fruit.getFruit(fruitNum), 106, 118);
	    hasFruit=true;
	    
	}
	
	public static void removeFruit()
	{
	    fruitTimer = 100;
	    hasFruit = false;
	}
    
	public static Map getTileMap(){
        return realMap;
    }
	
}
