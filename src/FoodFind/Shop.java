package src.FoodFind;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class Shop {
    public static int backX = 500;
    public static int backY = 540;
    public static int backW = 200;
    public static int backH = 50;

    public static int startX = 125;
    public static int startY = 50;
    public static int space = 50;
    public static int itemW = 200;
    public static int itemH = 200; 

    public static HashMap<List<Integer>, BUY> posId= new HashMap<List<Integer>, BUY>();
    
    public static void render(Graphics g, Game game){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        BoatBuy.render(g, game);
        FertilizerBuy.render(g, game);
        SaunaBuy.render(g, game);
        ShipBuy.render(g, game);
        ShrinkerBuy.render(g, game);
        TowerBuy.render(g, game);
        ShieldBuy.render(g, game);

        g.setColor(Color.ORANGE);
        g.fillRect(backX, backY, backW, backH);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", 1, 30));
        g.drawString("Back", 565, 575);
    }
}
