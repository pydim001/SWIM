package src.FoodFind;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage {
    
    private BufferedImage image;

    public BufferedImage loadImage(String file){
        try{
            image = ImageIO.read(new FileInputStream("res/" + file));
        }catch(IOException e){
            
        }
        return image;
    }

}
