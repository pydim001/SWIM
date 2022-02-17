package src.FoodFind;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Customize {
    public static int backX = 500;
    public static int backY = 540;
    public static int backW = 200;
    public static int backH = 50;

    public static Color a = Color.ORANGE;
    public static Color b = Color.ORANGE;
    public static Color c = Color.ORANGE;
    public static Color d = Color.ORANGE;
    public static Color e = Color.ORANGE;

    public static int startX = 50;
    public static int mid = 287;
    public static int scale = 300;

    public static int palX = 800;
    public static int palY = 137;
    public static int palW = 75;
    public static int palH = 75;

    public static Color[] palCol = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
        Color.GRAY, Color.LIGHT_GRAY, Color.GREEN, new Color(6, 61, 44), Color.MAGENTA, 
        Color.ORANGE, new Color(124, 171, 14), Color.PINK, Color.RED, Color.WHITE, 
        Color.YELLOW, new Color(128, 0, 128)};
    public static HashMap<Color, List<Integer>> colPos = new HashMap<Color, List<Integer>>();
    public static HashMap<List<Integer>, Color> posCol = new HashMap<List<Integer>, Color>();

    public static HashMap<Color, List<Integer>> colFish = new HashMap<Color, List<Integer>>();
    public static HashMap<List<Integer>, Color> fishCol = new HashMap<List<Integer>, Color>();
    public static HashMap<List<Integer>, List<Integer>> fishInd = new HashMap<List<Integer>, List<Integer>>();


    public static List<Integer> outlineColor; 
    public static boolean selectColor = false;

    public static List<Integer> outlinePart; 
    public static boolean selectPart = false;

    public static Color[] colors = {a, b, c, d, e, 
        a, b, c, d, e, 
        a, b, c, d, e, 
        a, b, c, d, e, 
        a, b, c, d, e};

    public static void palette(Graphics g){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                g.setColor(palCol[4*i + j]);
                g.fillRect(palX + (j*palW), palY + (i*palH), palW, palH);
                colPos.put(palCol[4*i + j], Arrays.asList(palX + j*palW, palY + i*palH, palW, palH));
                posCol.put(Arrays.asList(palX + j*palW, palY + i*palH, palW, palH), palCol[4*i + j]);
            }
        }
    }

    public static void render(Graphics g, Graphics2D g2d){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                g.setColor(colors[5*i + j]);
                g.fillRect(startX + (scale/5*j), mid - scale/2 + (scale/5*i), scale/5, scale/5);
                fishCol.put(Arrays.asList(startX + (scale/5*j), mid - scale/2 + (scale/5*i), scale/5, scale/5), colors[i]);
                colFish.put(colors[i], Arrays.asList(startX + (scale/5*j), mid - scale/2 + (scale/5*i), scale/5, scale/5));
                fishInd.put(Arrays.asList(startX + (scale/5*j), mid - scale/2 + (scale/5*i), scale/5, scale/5), Arrays.asList(i, j));   
            }
        }
        
        palette(g);       
        if(selectColor){
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke((float) 5));
            g2d.drawRect(outlineColor.get(0), outlineColor.get(1), outlineColor.get(2), outlineColor.get(3));
        }
        if(selectPart){
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke((float) 5));
            g2d.drawRect(outlinePart.get(0), outlinePart.get(1), outlinePart.get(2), outlinePart.get(3));
        }

        g.setColor(Color.ORANGE);
        g.fillRect(backX, backY, backW, backH);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", 1, 30));
        g.drawString("Back", 565, 575);
    }
}
