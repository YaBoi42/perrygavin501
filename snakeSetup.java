import java.io.*;

public class snakeSetup
{
    public static void main(String[] args) throws IOException {
        File file1 = new File("Snake High");
        File file2 = new File("Snake Points");
        File file3 = new File("Snake Colors");
        if (file1.createNewFile() && file2.createNewFile() && file3.createNewFile())
        {
            System.out.println("File 'Snake High' created..." + "\n" + "File 'Snake Points' created..." + "\n" + "File 'Snake Colors' created..." + "\n" + "All Files Created!" + "\n");
            FileWriter writer1 = new FileWriter(file1);
            writer1.write("0");
            writer1.close();

            FileWriter writer2 = new FileWriter(file2);
            writer2.write("0");
            writer2.close();

            FileWriter writer3 = new FileWriter(file3);
            writer3.write("100000");
            writer3.close();
            System.out.println("File 'Snake High' data saved..." + "\n" + "File 'Snake Points' data saved..." + "\n" + "File 'Snake Colors' data saved..." + "\n" + "All Data Saved to Files!" + "\n");
            System.out.println("Snake is setup and ready to use! Just RIGHT click the 'Start' box and LEFT click 'void main(String[] args)'." + "\n" + "Then once you are in the main menu you can click 'Play', or the red button which will take you to the shop." + "\n" + "If further instructions are need double click the box that looks like a piece of paper.");
        } else {
            System.out.println("Error Creating Files! File(s) could already exist.");
        }
    }
}