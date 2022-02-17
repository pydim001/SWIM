package src.FoodFind;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class TestScreen {

    public static void render(Graphics g){
        g.setColor(Color.ORANGE);
        int[] x = {300, 400, 600};
        int[] y = {300, 500, 600};
        g.fillPolygon(x, y, 3);
    }
    public static void main(String[] args) {
        System.out.println(Customize.palCol.length);
        ArrayList<Integer> sd = new ArrayList<>();
        sd.add(1);
        System.out.println(sd.get(0));
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(i);
                System.out.println(j);
            }
        }
    }
}
