/**
 * Map.java		May 24, 2016, 11:11:58 AM
 */
package pac.man.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import org.lwjgl.input.Keyboard;

import pac.man.engine.Playable;
import pac.man.engine.Renderable;
import pac.man.entities.Entity;


/**
 * Represents an array of tiles
 *
 * @author Aaron Roy
 * @version 
 */
public class Map implements Playable{
    Tile[][] tiles;
    private boolean wasGrid;


    /**
     * Creates a map from an integer array
     * 
     * @param t The input int[][] array
     */
    public Map(int[][] t){
        tiles = new Tile[t.length][t[0].length];

        for (int i = 0, k = t.length-1; i < t.length; i++, k--) {
            for (int j = 0; j < t[0].length; j++) {
                tiles[i][j] = new Tile(j, i, TileID.getTile(t[k][j]));
            }
        }
    }

    
    
    public Map(String key){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File(key)));
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());

            tiles = new Tile[rows][cols];


            for (int i = rows-1; i >= 0; i--) {
                String[] str = reader.readLine().split(" ");
                int index = 0;
                for (int j = 0; j < cols; j++, index++) {
                    if(str[index].equals("")){
                        index++;
                    }
                    tiles[i][j] =new Tile(j, 36-rows+i, 
                            TileID.getTile(Integer.parseInt(str[index])));
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Goes through every tile in the map and renders it
     */
    public void render(){
        for (Tile[] t : tiles) {
            for (Tile tile : t) {
                tile.render();
            }
        }
    }


    /* (non-Javadoc)
     * @see pac.man.engine.Renderable#update()
     */
    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
    
    public Tile[][] getTiles()
    {
        return tiles;
    }
    
    public int getX(Entity entity){
        
        return (int) entity.getOx()/8;
    }

    public int getY(Entity entity){
        
        return (int) entity.getOy()/8;
    }
    
    /**
     * Returns the type of the tile at the specified array location
     * 
     * @param col column index
     * @param row row index
     * @return type of the specified tile
     */
    public TileID getTileID(int row, int col){
        return tiles[row][col].getType();
    }



    /* (non-Javadoc)
     * @see pac.man.engine.Playable#getInput()
     */
    @Override
    public void getInput() {
        if(Keyboard.isKeyDown(Keyboard.KEY_G) && !wasGrid){
            Tile.changeGrid();
        }
        
        wasGrid = Keyboard.isKeyDown(Keyboard.KEY_G);
    }



    /**
     * @return
     */
    public int getWidth() {
        // TODO Auto-generated method stub
        return tiles[0].length;
    }
}
