package src.FoodFind;

import java.awt.Graphics;
import java.awt.Color;

public class Tower{

    public static int x = 700;
    public static int y = 100 ; 

    public static void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, 200, 200, 20, 20);
    }
    
}
