/**
 * Draw.java		May 11, 2016, 11:26:38 AM
 */
package pac.man.engine;

import static org.lwjgl.opengl.GL11.*;


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
    
    private static Texture[] tex = new Texture[1];
    
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
        glPushMatrix();
        {            
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
    
    public static void rect(float x, float y, float sx, float sy, int texx, int texy, int texsx, int texsy, int rot, int texID) {
        glPushMatrix();
        {            
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
    
    
    
    
    public static void rect(float x, float y, int sx, int sy){
    	glPushMatrix();{
    		 glTranslatef((int) x, (int) y, 0);
    		 glColor3f(0.0f,0.0f,1.0f);
    		 glBegin(GL_QUADS);
             { 
            	 
                 glVertex2f(0, 0);
                
                 glVertex2f(0, (int) sy);
                
                 glVertex2f((int) sx, (int) sy);
                
                 glVertex2f((int) sx, 0);
             }
             glEnd();
    	}
    }
}

