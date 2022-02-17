package src.FoodFind;

import java.util.LinkedList;

import java.awt.Graphics;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
            
        }
    }

    public void render(Graphics g, Game game){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g, game);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void removeAll(){
        for(int i = 0; i < object.size(); i++){
            removeObject(object.get(i));
        }
    }
}
