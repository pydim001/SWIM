package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boat extends GameObject{

    public Boat(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        
    }

    public void render(Graphics g, Game game) {
       LoadImage loader = new LoadImage();
       g.drawImage(loader.loadImage("Boat.png"), x, y, game);
    }

    public void collision(){
        
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
