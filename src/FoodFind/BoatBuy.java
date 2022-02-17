package src.FoodFind;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

import org.json.simple.JSONArray;

public class BoatBuy{

    public static int unlockLevel = 2;

    public static int x = Shop.startX;
    public static int y = Shop.startY; 
    public static BUY id = BUY.Boat;

    public static void render(Graphics g, Game game) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, Shop.itemW, Shop.itemH, 20, 20);
        Shop.posId.put(Arrays.asList(x, y, Shop.itemW, Shop.itemH), id);

        JSONHandler.ReadBuy();
        JSONArray array = (JSONArray) JSONHandler.json.get(String.valueOf(id));

        if(!Boolean.parseBoolean((String) array.get(1))){
            g.setColor(new Color(50, 50, 50, 200));
            g.fillRoundRect(x, y, Shop.itemW, Shop.itemH, 20, 20);

            g.setColor(Color.ORANGE);
            g.setFont(new Font("arial", 1, 20));
            g.drawString("Unlocks at", x + 50, y + 155);
            g.drawString("Level 2", x + 65, y + 185);

            LoadImage loader = new LoadImage();
            g.drawImage(loader.loadImage("Lock.png"), x + 35, y, 150, 150, game);
            
        }else{
            LoadImage loader = new LoadImage();
            g.setFont(new Font("arial", 1, 30));
            g.drawString(String.valueOf(id), x + 63, y + 30);
            g.drawImage(loader.loadImage("Boat.png"), x + 70, y + 50, 350, 350, game);
        }
    }
}
