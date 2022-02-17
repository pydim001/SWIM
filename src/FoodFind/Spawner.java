package src.FoodFind;

import java.util.Random;

public class Spawner {

    private Random r = new Random();

    public Spawner(Handler handler, int numFood, int numTrash){

        for(int i = 0; i < numFood; i++){
            int xint = r.nextInt(Game.WIDTH - Food.width);
            int yint = r.nextInt(Game.HEIGHT - Food.height);
            handler.addObject(new Food(xint, yint, ID.Food, handler));
        }

        for(int i = 0; i < numTrash; i++){
            int xint = r.nextInt(Game.WIDTH - Trash.width);
            int yint = r.nextInt(Game.HEIGHT - Trash.height);
            handler.addObject(new Trash(xint, yint, ID.Trash, handler));
        }
        /** 
        handler.addObject(new Fish(100, 100, ID.Fish, handler, this));
        handler.addObject(new Trash(300, 300, ID.Trash, handler));
        handler.addObject(new Net(50, 50, ID.Net, handler, this));
        handler.addObject(new Food(200, 200, ID.Food, handler));
        */
    }

    public void foodSpawn(Handler handler){
        if(Fish.foodCollect % 10 == 0){
            int xint = r.nextInt(Game.WIDTH);
            int yint = r.nextInt(Game.HEIGHT);
            handler.addObject(new Food(xint, yint, ID.Food, handler));
        }
    }

    public void trashSpawn(Handler handler){
        if(Net.trashCollect % 10 == 0){
            int xint = r.nextInt(Game.WIDTH);
            int yint = r.nextInt(Game.HEIGHT);
            handler.addObject(new Trash(xint, yint, ID.Trash, handler));
        }
    }
}
