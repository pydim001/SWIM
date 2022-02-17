package src.FoodFind;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Level {
    public static int xp;
    public static int level;
    public static int totalxp = currentLevel(level) + xp;

    public static int levX = 5;
    public static int levY = 12;
    public static int ydis = 15;

    public static int levelFunc(int lev){
        return (int) Math.pow(10, lev + 1);
    }

    public static int currentLevel(int lev){
        return (int) Math.pow(10, lev);
    }
    
    public static void render(Graphics g){
        g.setFont(new Font("arial", 1, 13));
        incLevel();
        if(Game.gameState == STATE.Game){
            g.drawString("Level " + String.valueOf(level), levX, levY + ydis);
            g.setColor(Color.BLACK);
            g.drawRect(levX, levY + ydis + 8, 100, 10);
            g.setColor(Color.GRAY);
            g.fillRect(levX, levY + ydis + 8, 100, 10);
            g.setColor(Color.GREEN);
            g.fillRect(levX, levY + ydis + 8, xp*100/levelFunc(level), 10);
        }else{
            g.drawString("Level " + String.valueOf(level), levX, levY);
            g.setColor(Color.BLACK);
            g.drawRect(levX, levY + 8, 100, 10);
            g.setColor(Color.GRAY);
            g.fillRect(levX, levY + 8, 100, 10);
            g.setColor(Color.GREEN);
            g.fillRect(levX, levY + 8, xp*100/levelFunc(level), 10);
        }
    }

    public static void incLevel(){
        if(xp >= levelFunc(level)){
            xp %= levelFunc(level);
            level++;
        }
    }
}
