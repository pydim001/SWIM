package src.FoodFind;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Color;

public class FileHandler {
    public static File current = new File("");
    public static File dataFile = new File(current.getAbsolutePath()+ "/res/Stats.txt");
    public static File colorFile = new File(current.getAbsolutePath()+ "/res/Customize.txt");
    public static File coinFile = new File(current.getAbsolutePath()+ "/res/Coins.txt");
    public static File levelFile = new File(current.getAbsolutePath()+ "/res/Levels.txt");

    public static String[] data;
    public static Color[] colors = new Color[Customize.colors.length];
    public static int coins;
    public static int[] xp;
    public static HashMap<String, Color> strCol = new HashMap<>();
    public static HashMap<Color, String> colStr = new HashMap<>();

    private static void FillHashMap(){
        Color[] cols = Customize.palCol;
        String[] strs = {"black", "blue", "cyan", 
        "dgray", "gray", "lgray", "green", "verid", 
        "mag", "ora", "moss", "pink", "red", "white", 
        "yel", "purp"};
        if(cols.length == strs.length){
            for(int i = 0; i < cols.length; i++){
                strCol.put(strs[i], cols[i]);
                colStr.put(cols[i], strs[i]);
            }
        }else System.out.println("Not enough colors");
    }
    
    private static void READ() throws IOException{
        Scanner scanner = new Scanner(dataFile);
        data = scanner.nextLine().split(",");
        scanner.close();
    }

    private static void WRITE() throws IOException{
        FileWriter writer = new FileWriter(dataFile);
        data[0] = String.valueOf(Integer.parseInt(data[0]) + Net.trashCollect);
        data[1] = String.valueOf(Integer.parseInt(data[1]) + Fish.foodCollect);
        data[2] = String.valueOf(Integer.parseInt(data[2]) + 1); 
        if(Integer.parseInt(data[3]) < Net.trashCollect) data[3] = String.valueOf(Net.trashCollect);
        if(Integer.parseInt(data[4]) < Fish.foodCollect) {
            data[4] = String.valueOf(Fish.foodCollect);
            Coins.coins += Fish.foodCollect;
        }
        writer.write(String.join(",", data));
        writer.close();
    }

    private static void READCOLOR() throws IOException{
        Scanner scanner = new Scanner(colorFile);
        if(strCol.size() != Customize.palCol.length) FillHashMap();
        String[] sCols = scanner.nextLine().split(",");
        for(int i = 0; i < sCols.length; i++){
            colors[i] = strCol.get(sCols[i]);
        }
        scanner.close();
    }

    private static void WRITECOLOR() throws IOException{
        FileWriter writer = new FileWriter(colorFile);
        if(strCol.size() != Customize.palCol.length) FillHashMap();
        String[] lst = new String[Customize.colors.length];
        for(int i = 0; i < Customize.colors.length; i++){
            lst[i] = colStr.get(Customize.colors[i]);
        }
        writer.write(String.join(",", lst));
        writer.close();
    }    

    public static void READCOINS() throws IOException{
        Scanner scanner = new Scanner(coinFile);
        Coins.coins = Integer.parseInt(scanner.nextLine());
        scanner.close();
    }

    public static void WRITECOINS() throws IOException{
        FileWriter writer = new FileWriter(coinFile);
        writer.write(String.valueOf(Coins.coins));
        writer.close();
    }

    public static void READLEVEL() throws IOException{
        Scanner scanner = new Scanner(levelFile);
        String values = scanner.nextLine();
        Level.xp = Integer.parseInt(values.split(" ")[1]); 
        Level.level = Integer.parseInt(values.split(" ")[0]); 
        scanner.close();
    }

    public static void WRITELEVEL() throws IOException{
        FileWriter writer = new FileWriter(levelFile);
        writer.write(String.valueOf(Level.level) + " " + String.valueOf(Level.xp));
        writer.close();
    }
    
    public static void ReadFile(){
        try{
            READ();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void WriteFile(){
        try{
            WRITE();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void ReadColor(){
        try{
            READCOLOR();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void WriteColor(){
        try{
            WRITECOLOR();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void ReadCoins(){
        try{
            READCOINS();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void WriteCoins(){
        try{
            WRITECOINS();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void ReadLevel(){
        try{
            READLEVEL();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void WriteLevel(){
        try{
            WRITELEVEL();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void update(){
        ReadFile();
        WriteFile();
    }
}
