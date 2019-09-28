import java.awt.event.*; 
import javax.swing.*;    
import java.awt.*;
import java.io.*;
import java.util.Scanner;

//red(1), blue(2), yellow(3), orange(4), pink(5), white(6);
public class Shop implements ActionListener
{
    public static int SavedColors = 100000;
    public static int Points = 0;
    JFrame f = new JFrame("Shop");
    //JFrame f = new JFrame("Comprar");
    JButton b1, b2, b3, b4, b5, b6;
    JButton b11, b12, b13, b14, b15, b16;
    JButton b0;
    private final int BOARDWIDTH = 700;
    private final int BOARDHEIGHT = 240;
    public void Shop_Load()  {
        b0 = new JButton(Points + "");
        b0.setBounds(-1,0,700,50);
        b0.setEnabled(false);

        b1 = new JButton("Red");
        //b1 = new JButton("Rojo");
        b1.setBounds(20,60,100,50);
        b1.addActionListener(this);
        b1.setActionCommand("RedS");

        b2 = new JButton("Blue");
        //b2 = new JButton("Azul");
        b2.setBounds(130,60,100,50);
        b2.addActionListener(this);
        b2.setActionCommand("BlueS");
        b2.setEnabled(false);

        b3 = new JButton("Yellow");
        //b3 = new JButton("Amarillo");
        b3.setBounds(240,60,100,50);
        b3.addActionListener(this);
        b3.setActionCommand("YellowS");
        b3.setEnabled(false);

        b4 = new JButton("Orange");
        //b4 = new JButton("Naranja");
        b4.setBounds(350,60,100,50);
        b4.addActionListener(this);
        b4.setActionCommand("OrangeS");
        b4.setEnabled(false);

        b5 = new JButton("Pink");
        //b5 = new JButton("Rosa");
        b5.setBounds(460,60,100,50);
        b5.addActionListener(this);
        b5.setActionCommand("PinkS");
        b5.setEnabled(false);

        b6 = new JButton("White");
        //b6 = new JButton("Blanco");
        b6.setBounds(570,60,100,50);
        b6.addActionListener(this);
        b6.setActionCommand("WhiteS");
        b6.setEnabled(false);

        b11 = new JButton("Purchased");//Red
        b11.setBounds(20,120,100,50);
        b11.setEnabled(false);

        b12 = new JButton("1000 Points");//Blue
        b12.setBounds(130,120,100,50);
        b12.addActionListener(this);
        b12.setActionCommand("BlueP");
        if(Integer.parseInt((SavedColors + "").substring(1,2)) == 1) { b12.setEnabled(false); b12.setText("Purchased"); b2.setEnabled(true);}

        b13 = new JButton("1000 Points");//Yellow
        b13.setBounds(240,120,100,50);
        b13.addActionListener(this);
        b13.setActionCommand("YellowP");
        if(Integer.parseInt((SavedColors + "").substring(2,3)) == 1) { b13.setEnabled(false); b13.setText("Purchased"); b3.setEnabled(true);}

        b14 = new JButton("1000 Points");//Orange
        b14.setBounds(350,120,100,50);
        b14.addActionListener(this);
        b14.setActionCommand("OrangeP");
        if(Integer.parseInt((SavedColors + "").substring(3,4)) == 1) { b14.setEnabled(false); b14.setText("Purchased"); b4.setEnabled(true);}

        b15 = new JButton("1000 Points");//Pink
        b15.setBounds(460,120,100,50);
        b15.addActionListener(this);
        b15.setActionCommand("PinkP");
        if(Integer.parseInt((SavedColors + "").substring(4,5)) == 1) { b15.setEnabled(false); b15.setText("Purchased"); b5.setEnabled(true);}

        b16 = new JButton("1500 Points");//White
        b16.setBounds(570,120,100,50);
        b16.addActionListener(this);
        b16.setActionCommand("WhiteP");
        if(Integer.parseInt((SavedColors + "").substring(5,6)) == 1) { b16.setEnabled(false); b16.setText("Purchased"); b6.setEnabled(true);}

        f.add(b0);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(b6);f.add(b11);f.add(b12);f.add(b13);f.add(b14);f.add(b15);f.add(b16);
        f.setSize(BOARDWIDTH, BOARDHEIGHT);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Snake_Icon.png"));
        f.setIconImage(image);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){  
        if(e.getActionCommand().equalsIgnoreCase("reds")) {f.setVisible(false);Start startTest = new Start();startTest.runStart("red");}
        if(e.getActionCommand().equalsIgnoreCase("blues")) {f.setVisible(false);Start startTest = new Start();startTest.runStart("blue");}
        if(e.getActionCommand().equalsIgnoreCase("yellows")) {f.setVisible(false);Start startTest = new Start();startTest.runStart("yellow");}
        if(e.getActionCommand().equalsIgnoreCase("oranges")) {f.setVisible(false);Start startTest = new Start();startTest.runStart("orange");}
        if(e.getActionCommand().equalsIgnoreCase("pinks")) {f.setVisible(false);Start startTest = new Start();startTest.runStart("pink");}
        if(e.getActionCommand().equalsIgnoreCase("whites")) {f.setVisible(false);Start startTest = new Start();startTest.runStart("white");}

        if(e.getActionCommand().equalsIgnoreCase("bluep")) { if(Points >= 1000) {SavedColors +=10000; b2.setEnabled(true); b12.setEnabled(false); Points -= 1000; b0.setText(Points + "");}}
        if(e.getActionCommand().equalsIgnoreCase("yellowp")) { if(Points >= 1000) {SavedColors +=1000; b3.setEnabled(true); b13.setEnabled(false); Points -= 1000; b0.setText(Points + "");}}
        if(e.getActionCommand().equalsIgnoreCase("orangep")) { if(Points >= 1000) {SavedColors +=100; b4.setEnabled(true); b14.setEnabled(false); Points -= 1000; b0.setText(Points + "");}}
        if(e.getActionCommand().equalsIgnoreCase("pinkp")) { if(Points >= 1000) {SavedColors +=10; b5.setEnabled(true); b15.setEnabled(false); Points -= 1000; b0.setText(Points + "");}}
        if(e.getActionCommand().equalsIgnoreCase("whitep")) { if(Points >= 1500) {SavedColors +=1; b6.setEnabled(true); b16.setEnabled(false); Points -= 1500; b0.setText(Points + "");}}

        if(e.getActionCommand().substring(e.getActionCommand().length() - 1).equalsIgnoreCase("p")) {
            try{
                File file1 = new File("Snake Colors");// Saves colors when new color is purchased
                FileWriter writer1 = new FileWriter(file1);
                writer1.write((SavedColors + ""));
                writer1.close();

                File file2 = new File("Snake Points");// Saves points when color is purchased
                FileWriter writer2 = new FileWriter(file2);
                writer2.write((Points + ""));
                writer2.close();
            } catch(IOException io){
                System.out.println("IO Exception");
            }
        }
    }  

    public static void loadFiles(){
        try{
            File myObj = new File("Snake Colors");//Gets purchased colors
            Scanner reader1 = new Scanner(myObj); 
            while (reader1.hasNextLine()) {
                SavedColors = Integer.parseInt(reader1.nextLine());
            }
            reader1.close();

            File file = new File("Snake Points");//Gets points
            Scanner reader2 = new Scanner(file);
            while(reader2.hasNextLine()) {
                Points = Integer.parseInt(reader2.nextLine());
            }
            reader2.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void runShop_Load() {
        Shop.loadFiles();
        Shop shopTest = new Shop();
        shopTest.Shop_Load();
    }
}
