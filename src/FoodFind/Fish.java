package src.FoodFind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Fish extends GameObject{

    private int width = 20;
    private int height = 20;
    private int collisionWidth;
    private int collisionHeight;

    private Handler handler;
    private FishFood fishai;
    private Spawner spawner;
    
    public static boolean fishLife;
    public static int foodCollect;

    public Fish(int x, int y, ID id, Handler handler, Spawner spawner){
        super(x, y, id);
        this.handler = handler;
        this.spawner = spawner;
        fishai = new FishFood(handler, this);
        fishLife = true;
        
    }

    
    public void tick() {
        x += velX;
        y += velY;

        if(fishLife) fishai.startMotion();
        
        collision();
    }

    
    public void render(Graphics g, Game game) {
        FileHandler.ReadColor();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                g.setColor(FileHandler.colors[5*i+j]);
                g.fillRect(x + (width/5)*i, y + (height/5)*j, width/5, height/5);
            }
        }
        //g.setColor(Color.orange);
        //g.fillRect(x, y, width, height);
        collisionWidth = (width/5)*5;
        collisionHeight = (height/5)*5;
        g.setColor(Color.BLACK);
        g.drawString("Food Collected: " + String.valueOf(foodCollect), 200, 12);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, collisionWidth, collisionHeight);
    }

    public void collision(){
        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);
            Random randx = new Random();
            Random randy = new Random();
            int xint = randx.nextInt(Game.WIDTH - width);
            int yint = randy.nextInt(Game.HEIGHT - height);

            if(tempObject.getID() == ID.Food){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                    handler.addObject(new Food(xint, yint, ID.Food, handler));
                    Coins.coins++;
                    foodCollect++;
                    width++;
                    height++;
                    spawner.foodSpawn(handler);
                }
            }else if(tempObject.getID() == ID.Trash || tempObject.getID() == ID.Net){
                if(getBounds().intersects(tempObject.getBounds())){
                    fishLife = false;
                    Game.gameState = STATE.GameOver;
                    fishai.stopMotion();
                    FileHandler.update();
                }
            }

        }
    }
    
}
