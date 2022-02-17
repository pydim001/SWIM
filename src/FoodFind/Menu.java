package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Font;

public class Menu {

    public static int playX = 500;
    public static int playY = 240;
    public static int playW = 200;
    public static int playH = 50;

    public static int[] set = {1090, 530, Game.WIDTH, Game.HEIGHT};

    public static void render(Graphics g, Game game){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setFont(new Font("arial", 1, 100));
        g.setColor(Color.BLACK);
        g.drawString("SWIM", 465, 150);

        g.setFont(new Font("arial", 1, 30));

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Play", 567, 275);

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY + 75, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Customize", 525, 350);

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY + 150, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Layout", 550, 425);

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY + 225, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Stats", 560, 500);

        g.setColor(Color.ORANGE);
        g.fillRect(playX, playY + 300, playW, playH);
        g.setColor(Color.BLACK);
        g.drawString("Shop", 560, 575);
        
        LoadImage loader = new LoadImage();
        g.drawImage(loader.loadImage("gear.png"), set[0], set[1], 100, 100, game);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", 1, 16));
        g.drawString("SETTINGS", 1100, 635);
    }
}
