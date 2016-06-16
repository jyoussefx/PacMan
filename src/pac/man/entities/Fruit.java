package pac.man.entities;

import java.awt.Rectangle;

import pac.man.engine.Draw;
import pac.man.entities.Entity;
import pac.man.entities.Fruits;
import pac.man.states.Game;

public class Fruit extends Entity{

    private int counter;
    protected boolean isEaten;
    
    public Rectangle area;
    
    Fruits type;
    public Fruit(Fruits type, float x, float y)
    {
        super(x, y, Fruit.getSx(type), Fruit.getSy(type));
        this.type = type;
                
        counter = (int)Math.random()*60+540;
    }
    @Override
    public void update() {
        if (counter>0) counter--;
        else if (!isEaten){
            isEaten=true;
            Game.removeFruit();
        }
                
    }
    @Override
    public void render() {
        if (!isEaten) Draw.rect(x, y, Fruit.getSx(type), Fruit.getSy(type), Fruit.getTexX(type), Fruit.getTexY(type), Fruit.getTexX(type) + (Fruit.getSx(type)), Fruit.getTexY(type) + (Fruit.getSy(type)), 1);
        
    }
    
    public static int getTexX(Fruits fruit)
    {
        switch (fruit)
        {
        case CHERRY: return 0;
        case STRAWBERRY: return 12;
        case ORANGE: return 24;
        case APPLE: return 36;
        case MELON: return 48;
        case GALAXIAN_BOSS: return 60;
        case BELL: return 72;
        case KEY: return 84;
        default: return 0;
        
        }
    }
    
    public static int getTexY(Fruits fruit)
    {
        return 96;
    }
    
    public static int getSx(Fruits fruit)
    {
        if (fruit==Fruits.GALAXIAN_BOSS) return 10;
        if (fruit==Fruits.MELON) return 10;
        if (fruit==Fruits.KEY) return 8;
        return 12;
    }
    
    public static int getSy(Fruits fruit)
    {
        if (fruit==Fruits.MELON) return 12;
        if (fruit==Fruits.KEY) return 14;
        if (fruit==Fruits.GALAXIAN_BOSS) return 9;
        return 12;
    }
    
    public static Fruits getFruit(int i)
    {
        switch (i)
        {
        case 0: return Fruits.CHERRY;
        case 1: return Fruits.STRAWBERRY;
        case 2: return Fruits.ORANGE;
        case 3: return Fruits.APPLE;
        case 4: return Fruits.MELON;
        case 5: return Fruits.GALAXIAN_BOSS;
        case 6: return Fruits.BELL;
        case 7: return Fruits.KEY;
        default: return null;
        }
    }
    
    public void eat()
    {
        if (!isEaten) isEaten = true;
    }
    
    public boolean isEaten()
    {
        return isEaten;
    }
}
