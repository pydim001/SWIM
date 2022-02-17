package src.FoodFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONHandler {

    public static JSONParser parser = new JSONParser();
    public static JSONObject json;
    
    public static void ReadBuy(){
        try{
            json = (JSONObject) parser.parse(new FileReader(FileHandler.current.getAbsolutePath() + "/res/Buys.json"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void WriteBuy(BUY key, int num, String locked){
        json.put(String.valueOf(key), Arrays.asList(num, locked));
        try{
            FileWriter writer = new FileWriter(new File(FileHandler.current.getAbsolutePath() + "/res/Buys.json"));
            writer.write(json.toString());
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void ReadLayout(){

    }

    public static void WriteLayout(){
        
    }
}
