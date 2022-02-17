package src.FoodFind;

import java.awt.Graphics;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class Stats {

    public static int backX = 500;
    public static int backY = 540;
    public static int backW = 200;
    public static int backH = 50;

    public static void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        FileHandler.ReadFile();

        g.setFont(new Font("arial", 1, 20));
        g.setColor(Color.BLACK);
        g.drawString("Total Trash Collected: " + FileHandler.data[0], 50, 50);
        g.drawString("Total Food Collected: " + FileHandler.data[1], 50, 100);
        g.drawString("Total Deaths: " + FileHandler.data[2], 50, 150);
        g.drawString("Most Trash Collected: " + FileHandler.data[3], 400, 50);
        g.drawString("Most Food Collected: " + FileHandler.data[4], 400, 100);

        g.setColor(Color.ORANGE);
        g.fillRect(backX, backY, backW, backH);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", 1, 30));
        g.drawString("Back", 565, 575);
    }
}
