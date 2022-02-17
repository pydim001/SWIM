package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Net extends GameObject{

    //private BufferedImage image;

    private int width = 25;
    private int height = 25;
    private Handler handler;
    private Spawner spawner;
    public static int trashCollect = 0;

    public Net(int x, int y, ID id, Handler handler, Spawner spawner) {
        super(x, y, id);
        this.handler = handler;
        this.spawner = spawner;
    }
    
    public void tick() {
        x = mouseX - width/2;
        y = mouseY - height/2;

        if(Fish.fishLife) collision();
    }
    
    public void render(Graphics g, Game game) {
        LoadImage loader = new LoadImage();
        g.drawImage(loader.loadImage("net.png"), x - 35, y - 50, 100, 100, game);

        if(Game.hacks){
            g.setColor(Color.RED);
            g.drawRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
        }

        g.setColor(Color.BLACK);
        g.drawString("Trash Collected: " + String.valueOf(trashCollect), 400, 12);
    }

    public void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            Random randx = new Random();
            Random randy = new Random();
            int xint = randx.nextInt(Game.WIDTH - width);
            int yint = randy.nextInt(Game.HEIGHT - height);

            if(tempObject.getID() == ID.Trash){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                    handler.addObject(new Trash(xint, yint, ID.Trash, handler));
                    Level.xp++;
                    trashCollect++;
                    spawner.trashSpawn(handler);
                }
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x - 5, y - 15, width + 10, height + 15);
    }
    
}
