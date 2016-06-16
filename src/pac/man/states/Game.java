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
import pac.man.entities.Fruits;
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
	public static int numLives;
	public static int level;
	
    public static Map realMap;
    
    public static Fruit fruit;
    public static int fruitNum;
    
    public static int fruitTimer;
    public static boolean hasFruit;
    
    public Tile test;
    public static HUD hud;
	
    public ArrayList<Pellet> pellets = new ArrayList<Pellet>();

    private boolean paused = false;
   

    private boolean wasPaused;

    private int counter;
	
	public Game()
	{
	    
		super(States.GAME);
        hud = new HUD(pac);
        pac = new PacMan(106,68);
        
        test=new Tile(8*9, 8*9, TileID.CORNER_DR);
        
        realMap = new Map("res/Maze");

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
                TextHandler.write("1 UP", 24, 278, 8);
                TextHandler.write("HIGH SCORE", 72, 278, 8);
                TextHandler.write(String.valueOf(pac.score), 24, 268, 8);
                TextHandler.write(String.valueOf(HUD.hiScore), 72, 268);
            } catch (NonexistentStringException e) {
                
            }
		}
		wasPaused = Keyboard.isKeyDown(Keyboard.KEY_P);
	}

	@Override
	public void update() {
	    if(!paused && counter>240){
	        pac.play();
	        pac.update();
	        
	        if (hasFruit) fruit.update();

	        for (Pellet p: pellets)
	        {
	            
	            if (Physics.checkPlayer(pac, p) && !p.isEaten()){
	                p.eat();
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
	        
	        if (hasFruit && Physics.checkPlayer(pac, fruit) &!fruit.isEaten()) 
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
	        
	        if (pac.getX()<-13) pac.setX(pac.getX()+224);
	        if (pac.getX()>224) pac.setX(pac.getX()-224);
	        
	        //if (noMorePellets) level++;
	    }		
	    
        TextHandler.clear();
        if(paused)
            TextHandler.write("Paused", 88, 140);
        
        if(counter <= 240){
            TextHandler.write("READY", 88, 120);
            counter++;
        }

		
	}

	@Override
	public void render() {
		
		pac.render();
		
        realMap.render();
        for (Pellet p: pellets) p.render();
        
        for (int i=0; i<numLives; i++)
        {
            HUD.drawLife(13+i*16, 15);
        }
        
//        test.render();
        
        if (hasFruit) fruit.render();
	
		
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
