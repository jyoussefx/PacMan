/** hud
  *
  */
package pac.man.engine;

import pac.man.entities.PacMan;

/*var hud = (function(){

      var on = false;

      return {

          update: function() {
              var valid = this.isValidState();
              if (valid != on) {
                  on = valid;
                  if (on) {
                      inGameMenu.onHudEnable();
                      vcr.onHudEnable();
                  }
                  else {
                      inGameMenu.onHudDisable();
                      vcr.onHudDisable();
                  }
              }
          },
          draw: function(ctx) {
              inGameMenu.draw(ctx);
              vcr.draw(ctx);
          },
          isValidState: function() {
              return (
                  state == playState ||
                  state == newGameState ||
                  state == readyNewState ||
                  state == readyRestartState ||
                  state == finishState ||
                  state == deadState ||
                  state == overState);
          },
      };

})();
*/

public class HUD {
    
    public static int hiScore;
    public static int prevHiScore;
    private PacMan pac;
    
    public HUD(PacMan pacman)
    {
        pac = pacman;
        TextHandler.write("1 UP", 24, 278, 8);
        TextHandler.write("0", 24, 268, 8);
        TextHandler.write("HIGH SCORE", 72, 278, 8);
        TextHandler.write("0", 72, 268);
    }
    
    public static void drawLife(float x, float y)
    {
        Draw.rect(x, y, 13, 13, 71, 21, 84, 34, 2, 1);
    }
    
    
}
