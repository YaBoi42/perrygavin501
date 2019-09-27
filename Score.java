import java.io.*;
import java.util.*;

public class Score
{
    public static void newHigh(String high) throws IOException {
        File file = new File("Snake High");
        if(file.exists()) {
            FileWriter writer = new FileWriter(file);
            writer.write(high);
            writer.close();
        }
    }
    
    public static void newPoints(String points) throws IOException {
        File file = new File("Snake Points");
        if(file.exists()) {
            FileWriter writer = new FileWriter(file);
            writer.write(points);
            writer.close();
        }
    }

    public int getHigh() throws FileNotFoundException, NumberFormatException {
        String data = "";
        File myObj = new File("Snake High");
        Scanner myReader = new Scanner(myObj); 
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();
        int idata = Integer.parseInt(data);
        return idata;
    }

    public int getColors() throws FileNotFoundException, NumberFormatException {
        String data = "";
        File myObj = new File("Snake High");
        Scanner myReader = new Scanner(myObj); 
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();
        int idata = Integer.parseInt(data);
        return idata;
    }
    
    public int getPoints() throws FileNotFoundException, NumberFormatException {
        String data = "";
        File file = new File("Snake Points");
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()){
            data = reader.nextLine();
        }
        reader.close();
        int idata = Integer.parseInt(data);
        return idata;
    }
}