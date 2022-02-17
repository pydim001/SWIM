package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Food extends GameObject{

    protected static int width = 20;
    protected static int height = 20;
    private Handler handler;

    public Food(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
    }
    
    public void tick() {
    
    }

    public void render(Graphics g, Game game) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
}
