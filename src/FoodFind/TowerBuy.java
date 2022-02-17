package src.FoodFind;

import java.awt.Graphics;
import java.util.Arrays;

import org.json.simple.JSONArray;

import java.awt.Color;
import java.awt.Font;

public class TowerBuy {

    public static int x = Shop.startX + 2*(Shop.itemW + Shop.space);
    public static int y = Shop.startY; 
    public static BUY id = BUY.Tower; 

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
            g.drawString("Level 4", x + 65, y + 185);

            LoadImage loader = new LoadImage();
            g.drawImage(loader.loadImage("Lock.png"), x + 35, y, 150, 150, game);
        }
    }
}
