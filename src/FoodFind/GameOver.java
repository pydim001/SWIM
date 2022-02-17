package src.FoodFind;
 
import java.awt.Color;
import java.awt.Graphics;

import java.awt.Font;

public class GameOver {

    public static int playX = 500;
    public static int playY = 313;
    public static int playW = 200;
    public static int playH = 50;

    public static void render(Handler handler, Graphics g){
        handler.removeAll();

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setFont(new Font("arial", 1, 50));
        g.setColor(Color.BLACK);

        g.drawString("Food Collected: " + String.valueOf(Fish.foodCollect), 395, 100);
        g.drawString("Trash Removed: " + String.valueOf(Net.trashCollect), 390, 200);

        g.setFont(new Font("arial", 1, 30));

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Play Again", 527, 350);

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY + 75, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Menu", 560, 425);

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY + 150, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Quit", 570, 500);
    }
}
