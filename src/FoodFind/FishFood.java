package src.FoodFind;

import java.util.ArrayList;
import java.util.Collections;

public class FishFood {

    private Fish fishObject; 
    private Handler handler;

    public FishFood(Handler handler, Fish fish){
        this.fishObject = fish;
        this.handler = handler;

    }

    public static double distance(int x1, int x2, int y1, int y2){
        double xdis = Math.pow((double) x1 - (double) x2, 2);
        double ydis = Math.pow((double) y1 - (double) y2, 2);
        double distance = Math.pow(xdis + ydis, 0.5);
        return distance;
    }

    public void startMotion(){
        
        ArrayList<Double> distances = new ArrayList<>();
        ArrayList<GameObject> foodObjects = new ArrayList<>();
        GameObject tempObject;
        double dis = 1.0;

        for(int i = 0; i < handler.object.size(); i++){
            tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Food){
                dis = distance(fishObject.x, tempObject.x, fishObject.y, tempObject.y);
                distances.add(dis);
                foodObjects.add(tempObject);
            }
        }

        GameObject closestFood = foodObjects.get(distances.indexOf(Collections.min(distances)));
        
        fishObject.setVelX((3 * (closestFood.x - fishObject.x)/dis > 0) ? (int) Math.ceil(3 * (closestFood.x - fishObject.x)/dis) : (int) Math.floor(3 * (closestFood.x - fishObject.x)/dis));
        fishObject.setVelY((3 * (closestFood.y - fishObject.y)/dis > 0) ? (int) Math.ceil(3 * (closestFood.y - fishObject.y)/dis) : (int) Math.floor(3 * (closestFood.y - fishObject.y)/dis));
    }

    public void stopMotion(){
        fishObject.setVelX(0);
        fishObject.setVelY(0);
    }
}
