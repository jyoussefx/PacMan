/**
 * Draw.java		May 11, 2016, 11:26:38 AM
 */
package pac.man.engine;

import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
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
    
    protected static boolean texLoaded;
    private static Texture[] tex = new Texture[1];
    
    /**
     * 
     * @param x
     * @param y
     * @param sx
     * @param sy
     * @param texx
     * @param texy
     * @param texsx
     * @param texsy 
     * @param texID Use 0 for Pacman, 1 for ghosts
     */
    public static void rect(float x, float y, float sx, float sy, int texx, int texy, int texsx, int texsy, int texID) {
        glPushMatrix();
        {
            if(!texLoaded){
                loadTextures();
                texLoaded =true;
            }
            
            int imgX = tex[texID].getImageWidth();
            int imgY = tex[texID].getImageHeight();
            
            glTranslatef((int) x, (int) y, 0);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            tex[texID].bind();
            
            glBegin(GL_QUADS);
            { 
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

