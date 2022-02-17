package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;

public class Coins {
    public static int coins = 0;

    public static void render(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString("Coins: " + String.valueOf(coins), 1100, 12);
    }
}
