package src.FoodFind;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Settings {
    public static int backX = 500;
    public static int backY = 540;
    public static int backW = 200;
    public static int backH = 50;

    public static void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setColor(Color.ORANGE);
        g.fillRect(backX, backY, backW, backH);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", 1, 30));
        g.drawString("Back", 565, 575);
    }

}
