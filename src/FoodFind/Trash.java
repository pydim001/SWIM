package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Trash extends GameObject{

    protected static int width = 20;
    protected static int height = 20;
    private Handler handler;

    public Trash(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
    
    public void tick() {
        
    }

    public void render(Graphics g, Game game) {
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(x, y, width, height, 5, 5);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
}
