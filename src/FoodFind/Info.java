package src.FoodFind;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Info {

    public static int backX = 500;
    public static int backY = 540;
    public static int backW = 200;
    public static int backH = 50;

    public static void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setFont(new Font("arial", 1, 15));
        g.setColor(Color.BLACK);

        g.drawString("Remove the trash with your net so that the fish can collect the food", 50, 50);
        g.drawString("If you catch the fish with the net, the game ends", 50, 100);
        g.drawString("If the fish eats a piece of trash, the game ends", 50, 150);
        g.drawString("Try to collect as much trash so that the fish does not eat it and so it only eats the food", 50, 200);

        g.setColor(Color.ORANGE);
        g.fillRect(50, 250, 20, 20);

        g.setColor(Color.BLACK);
        g.fillRoundRect(50, 300, 20, 20, 5, 5);

        g.setColor(Color.YELLOW);
        g.fillOval(50, 350, 20, 20);

        g.setColor(Color.WHITE);
        g.fillRect(50, 400, 25, 25);

        g.setColor(Color.BLACK);
        g.drawString("- Fish", 75, 265);
        g.drawString("- Trash", 75, 315);
        g.drawString("- Food", 75, 365);
        g.drawString("- Net", 80, 420);

        g.setColor(Color.ORANGE);
        g.fillRect(backX, backY, backW, backH);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", 1, 30));
        g.drawString("Back", 565, 575);
        
    }
}
