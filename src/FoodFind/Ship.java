package src.FoodFind;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ship extends GameObject{

    public Ship(int x, int y, ID id) {
        super(x, y, id);
    }
    
    public void tick() {
        
    }
    
    public void render(Graphics g, Game game) {
       LoadImage loader = new LoadImage();
       g.drawImage(loader.loadImage("Boat.png"), x, y, game);
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
