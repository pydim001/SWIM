package src.FoodFind;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 1200, HEIGHT = WIDTH/16*9;
    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private Spawner spawner;

    public int frames;
    public int displayFrame;

    public int numFood = 5;
    public int numTrash = 3;

    public static STATE gameState = STATE.Shop;

    public static boolean hacks = false;

    public Game(){
        handler = new Handler();
        //this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler, this));
        this.addMouseMotionListener(new MouseInput(handler, this));

        new Window(WIDTH, HEIGHT, "FOODFIND", this);
        
        if(gameState == STATE.Game){
            spawner = new Spawner(handler, numFood, numTrash);
            handler.addObject(new Fish(100, 100, ID.Fish, handler, spawner));
            handler.addObject(new Trash(300, 300, ID.Trash, handler));
            handler.addObject(new Net(50, 50, ID.Net, handler, spawner));
            handler.addObject(new Food(200, 200, ID.Food, handler));
        }
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        FileHandler.ReadCoins();
        FileHandler.ReadLevel();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                displayFrame = frames;
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        FileHandler.WriteCoins();
        FileHandler.WriteLevel();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics(); 
        Graphics2D g2d = (Graphics2D) g;
        
        
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g, this);
    
        if(gameState == STATE.Menu){
            Menu.render(g, this);
        }
        else if(gameState == STATE.Game){
            g.setColor(Color.BLACK);
            g.drawString("FPS: " + String.valueOf(displayFrame), 5, 12);
        }else if(gameState == STATE.GameOver){
            GameOver.render(handler, g);
        }else if(gameState == STATE.Info){
            Info.render(g);
        }else if(gameState == STATE.Stats){
            Stats.render(g);
        }else if(gameState == STATE.Settings){
            Settings.render(g);
        }else if(gameState == STATE.Customize){
            Customize.render(g, g2d);
        }else if(gameState == STATE.Shop){
            Shop.render(g, this);
        }else if(gameState == STATE.Layout){
            Layout.render(g);
        }else{
            TestScreen.render(g);
        }

        g.setFont(new Font("arial", 1, 15));
        Coins.render(g);
        Level.render(g);

        g.dispose();
        bs.show();
    }
    public static void main(String[] args) {
        new Game();
    }
}