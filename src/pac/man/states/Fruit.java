package pac.man.states;

import java.awt.Rectangle;

import pac.man.engine.Draw;
import pac.man.entities.Entity;
import pac.man.entities.Fruits;

public class Fruit extends Entity{

    private int counter;
    protected boolean isEaten;
    
    public Rectangle area;
    
    Fruits type;
    public Fruit(Fruits type, float x, float y)
    {
        this.type = type;
        this.x = x;
        this.y = y;
        
        this.area = new Rectangle((int) x, (int) y, Fruit.getSx(type), Fruit.getSy(type));
        
        counter = 100;
    }
    @Override
    public void update() {
        if (counter>0) counter--;
        else if (!isEaten){
            isEaten=true;
            Game.removeFruit();
        }
        
        System.out.println(counter);
        
    }
    @Override
    public void render() {
        if (!isEaten) Draw.rect(x, y, Fruit.getSx(type), Fruit.getSy(type), Fruit.getTexX(type), Fruit.getTexY(type), Fruit.getTexX(type) + (Fruit.getSx(type)*3), Fruit.getTexY(type) + (Fruit.getSy(type)*3), 1);
        
    }
    
    public static int getTexX(Fruits fruit)
    {
        switch (fruit)
        {
        case CHERRY: return 0;
        case STRAWBERRY: return 45;
        case ORANGE: return 88;
        case APPLE: return 131;
        case MELON: return 179;
        case GALAXIAN_BOSS: return 222;
        case BELL: return 261;
        case KEY: return 306;
        default: return 0;
        
        }
    }
    
    public static int getTexY(Fruits fruit)
    {
        if (fruit==Fruits.MELON) return 101;
        if (fruit==Fruits.KEY) return 102;
        if (fruit==Fruits.GALAXIAN_BOSS) return 110;
        return 102;
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
        if (fruit==Fruits.MELON) return 13;
        if (fruit==Fruits.KEY) return 15;
        if (fruit==Fruits.GALAXIAN_BOSS) return 10;
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
        System.out.println(isEaten);
    }
    
    public boolean isEaten()
    {
        return isEaten;
    }
}
