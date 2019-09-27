import java.awt.event.*; 
import javax.swing.*;    
import java.awt.*;

public class Start implements ActionListener
{
    JFrame f = new JFrame("Main Menu");
    JButton Sbutton, Cbutton;
    public static String selectedColor = "red";
    private final int BOARDWIDTH = 160;
    private final int BOARDHEIGHT = 200;
    Shop shopTest = new Shop();
    public Start() {
        Sbutton = new JButton("Play");
        //Sbutton = new JButton("Jugar");
        Sbutton.setBounds(20,20,100,50);
        Sbutton.addActionListener(this);
        Sbutton.setActionCommand("play");
        Sbutton.setEnabled(true);

        Cbutton = new JButton("");
        Cbutton.setBounds(20,90,100,50);
        Cbutton.addActionListener(this);
        Cbutton.setActionCommand("openShop");
        if(selectedColor.equalsIgnoreCase("red")){Cbutton.setBackground(Color.RED);}
        if(selectedColor.equalsIgnoreCase("blue")){Cbutton.setBackground(Color.BLUE);}
        if(selectedColor.equalsIgnoreCase("yellow")){Cbutton.setBackground(Color.YELLOW);}
        if(selectedColor.equalsIgnoreCase("pink")){Cbutton.setBackground(Color.PINK);}
        if(selectedColor.equalsIgnoreCase("white")){Cbutton.setBackground(Color.WHITE);}
        Cbutton.setEnabled(true);

        f.add(Sbutton);f.add(Cbutton);
        f.setSize(BOARDWIDTH, BOARDHEIGHT);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Snake_Icon.png"));
        f.setIconImage(image);
        f.setVisible(true);
    }

    public static void recieve(String col) {
        selectedColor = col;
        new Start();
    }

    public static String getColor() {
        return selectedColor;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equalsIgnoreCase("play")) {
            f.setVisible(false);
            Game game = new Game();
            game.playSnake();
        } else if(e.getActionCommand().equalsIgnoreCase("openShop")) {
            f.setVisible(false);
            shopTest.runShop_Load();
        }
    }

    public static void main(String[] args) {
        new Start();
    }

    public void runStart(String col){
        selectedColor = col;
        if(selectedColor.equalsIgnoreCase("red")){Cbutton.setBackground(Color.RED);}
        if(selectedColor.equalsIgnoreCase("blue")){Cbutton.setBackground(Color.BLUE);}
        if(selectedColor.equalsIgnoreCase("yellow")){Cbutton.setBackground(Color.YELLOW);}
        if(selectedColor.equalsIgnoreCase("pink")){Cbutton.setBackground(Color.PINK);}
        if(selectedColor.equalsIgnoreCase("white")){Cbutton.setBackground(Color.WHITE);}
        f.setVisible(true);
    }
}