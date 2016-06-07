/**
 * Draw.java        May 11, 2016, 11:26:38 AM
 */
package pac.man.engine;

import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;


import java.io.File;
import java.io.FileInputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

/**
 * Draws stuff :D
 *
 * @author Aaron Roy
 * @version 
 */
public class Draw {
    
    private static Texture[] tex = new Texture[3];
    
    
    public static void rect(float x, float y, float sx, float sy, int texx, int texy, int texID) {
        rect(x, y, sx, sy, texx, texy, texx + (int)sx, texy + (int)sy, texID);
    }

    
    /**
     * Draws a sprite on the screen from the specified image
     * 
     * @param x the X position on the screen, starting from the left
     * @param y the Y position on the screen, starting from the <i>bottom</i>
     * @param sx the width
     * @param sy the height
     * @param texx X position on the picture, starting from the left
     * @param texy Y position on the picture, starting from the <i>top<i/>
     * @param texsx end X position on the picture, starting from the left
     * @param texsy end Y position on the picture, starting from the <i>top<i/>
     * @param texID Use 0 for Pacman, 1 for ghosts
     */
    public static void rect(float x, float y, float sx, float sy, int texx, int texy, int texsx, int texsy, int texID) {
        rect(x, y, sx, sy, texx, texy, texsx, texsy, 0, texID);
    }
    
    public static void rect(float x, float y, float sx, float sy, int texx, int texy, int texsx, int texsy, int rot, int texID) {
        glPushMatrix();{  
            glEnable(GL_TEXTURE_2D);
            
            int imgX = tex[texID].getImageWidth();
            int imgY = tex[texID].getImageHeight();
            
            glTranslatef((int) x, (int) y, 0);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            tex[texID].bind();
            
            glBegin(GL_QUADS);{
                glColor3f(1,1,1);
                
                glTexCoord2f((float)texx/imgX, (float) texsy/imgY);
                    glVertex2f(0, 0);
                glTexCoord2f((float) texx/imgX, (float) texy/imgY);
                    glVertex2f(0, (int) sy);
                glTexCoord2f((float) texsx/imgX, (float) texy/imgY);
                    glVertex2f((int) sx, (int) sy);
                glTexCoord2f((float) texsx/imgX, (float) texsy/imgY);
                    glVertex2f((int) sx, 0);
            }
            glEnd();
        }
        glPopMatrix();
        
    }
    
    public static void loadTextures() {
        try {
            tex[0] = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/filler.png")));
            tex[1] = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/all_tiles.png")));
            tex[2] = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/nesfont.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public static void cRect(float x, float y, int sx, int sy, float r, float g, float b){
        glPushMatrix();{
             glDisable(GL_TEXTURE_2D);

            
             glTranslatef((int) x, (int) y, 0);
             
             glBegin(GL_QUADS);
             { 
                 
                 glColor3f(r/255,g/255,b/255);
                 glVertex2f(0, 0);
                 glVertex2f(0, (int) sy);
                 glVertex2f((int) sx, (int) sy);
                 glVertex2f((int) sx, 0);
                 
             }
             glEnd();
        }
    }
}
