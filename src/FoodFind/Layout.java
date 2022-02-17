package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;

public class Layout {

    public static int x = 50;
    public static int y = 100;
    public static int width = 1000;
    public static int height = width/16*9;

    public static void scaler(){
        
    }

    public static void render(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
}
