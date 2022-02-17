package src.FoodFind;

import javax.swing.event.MouseInputListener;

import java.awt.event.MouseEvent;
import java.util.List;

public class MouseInput implements MouseInputListener{

    private Handler handler;
    private Game game;

    public MouseInput(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
    }

    public static boolean MouseOver(int posx ,int posy, int x1, int y1, int x2, int y2){
        return posx < x2 && posx > x1 && posy < y2 && posy > y1;
    }

    public static boolean MouseAround(int posx, int posy, int radius, int x, int y){
        return FishFood.distance(posx, x, posy, y) < radius;
    }

    public void mouseMoved(MouseEvent e) {
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Net){
                tempObject.setMouseX(e.getX());
                tempObject.setMouseY(e.getY());
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if(MouseOver(mx, my, Menu.playX, Menu.playY, Menu.playX + Menu.playW, Menu.playY + Menu.playH) && Game.gameState == STATE.Menu) {
            Fish.foodCollect = 0;
            Net.trashCollect = 0;
            Game.gameState = STATE.Game;
            Spawner spawner = new Spawner(handler, game.numFood, game.numTrash);
            handler.addObject(new Fish(100, 100, ID.Fish, handler, spawner));
            handler.addObject(new Trash(300, 300, ID.Trash, handler));
            handler.addObject(new Net(50, 50, ID.Net, handler, spawner));
            handler.addObject(new Food(200, 200, ID.Food, handler));
            //System.out.println("Started new Game");
        }else if(MouseOver(mx, my, GameOver.playX, GameOver.playY, GameOver.playX + GameOver.playW, GameOver.playY + GameOver.playH) && Game.gameState == STATE.GameOver){
            Fish.foodCollect = 0;
            Net.trashCollect = 0;
            Game.gameState = STATE.Game;
            Spawner spawner = new Spawner(handler, game.numFood, game.numTrash);
            handler.addObject(new Fish(100, 100, ID.Fish, handler, spawner));
            handler.addObject(new Trash(300, 300, ID.Trash, handler));
            handler.addObject(new Net(50, 50, ID.Net, handler, spawner));
            handler.addObject(new Food(200, 200, ID.Food, handler));
            //System.out.println("Played new Game");
        }
        else if(MouseOver(mx, my, Menu.playX, Menu.playY + 300, Menu.playX + Menu.playW, Menu.playY + Menu.playH + 300) && Game.gameState == STATE.Menu){
            Game.gameState = STATE.Shop;
        }
        else if(MouseOver(mx, my, Shop.backX, Shop.backY, Shop.backX + Shop.backW, Shop.backY + Shop.backH) && Game.gameState == STATE.Shop) Game.gameState = STATE.Menu;
        else if(MouseOver(mx, my, Menu.set[0], Menu.set[1], Menu.set[2], Menu.set[3]) && Game.gameState == STATE.Menu) Game.gameState = STATE.Settings;
        else if(MouseOver(mx, my, Settings.backX, Settings.backY, Settings.backX + Settings.backW, Settings.backY + Settings.backH) && Game.gameState == STATE.Settings) Game.gameState = STATE.Menu;
        else if(MouseOver(mx, my, Info.backX, Info.backY, Info.backX + Info.backW, Info.backY + Info.backH) && Game.gameState == STATE.Info) Game.gameState = STATE.Menu;
        else if(MouseOver(mx, my, Menu.playX, Menu.playY + 150, Menu.playX + Menu.playW, Menu.playY + Menu.playH + 150) && Game.gameState == STATE.Menu) Game.gameState = STATE.Layout;
        else if(MouseOver(mx, my, GameOver.playX, GameOver.playY + 75, GameOver.playX + GameOver.playW, GameOver.playY + GameOver.playH + 75) && Game.gameState == STATE.GameOver) Game.gameState = STATE.Menu;
        else if(MouseOver(mx, my, Menu.playX, Menu.playY + 225, Menu.playX + Menu.playW, Menu.playY + Menu.playH + 225) && Game.gameState == STATE.Menu) Game.gameState = STATE.Stats;
        else if(MouseOver(mx, my, Stats.backX, Stats.backY, Stats.backX + Stats.backW, Stats.backY + Stats.backH) && Game.gameState == STATE.Stats) Game.gameState = STATE.Menu;
        else if(MouseOver(mx, my, Menu.playX, Menu.playY + 75, Menu.playX + Menu.playW, Menu.playY + 75 + Menu.playH) && Game.gameState == STATE.Menu){
            FileHandler.ReadColor();
            Customize.colors = FileHandler.colors;
            Game.gameState = STATE.Customize;
        }
        else if(MouseOver(mx, my, Customize.backX, Customize.backY, Customize.backX + Customize.backW, Customize.backY + Customize.backH) && Game.gameState == STATE.Customize){
            Game.gameState = STATE.Menu;
            FileHandler.WriteColor();
        }
        for(List<Integer> pos: Customize.posCol.keySet()){
            if(MouseOver(mx, my, pos.get(0), pos.get(1), pos.get(0) + pos.get(2), pos.get(1) + pos.get(3)) && Game.gameState == STATE.Customize){
                Customize.selectColor = true;
                Customize.outlineColor = pos;
                if(Customize.selectPart) {
                    List<Integer> position = Customize.fishInd.get(Customize.outlinePart);
                    Customize.colors[5*position.get(0) + position.get(1)] = Customize.posCol.get(Customize.outlineColor);
                }
            }
        }
        for(List<Integer> pos: Customize.fishCol.keySet()){
            if(MouseOver(mx, my, pos.get(0), pos.get(1), pos.get(0) + pos.get(2), pos.get(1) + pos.get(3)) && Game.gameState == STATE.Customize){
                Customize.selectPart = true;
                Customize.outlinePart = pos;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }

    public void mouseDragged(MouseEvent e) {
        
    }

    

}
