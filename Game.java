import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.*;

public class Game extends JFrame {
    static JFrame frame;
    Game() {
        add(new Board());
        setResizable(false);
        pack();
        setTitle("Snake");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Snake_Icon.png"));
        setIconImage(image);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void playSnake() {
        // Creates a new thread so our GUI can process itself
        EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame = new Game();
                    frame.setVisible(true);
                }
            });
    }

    public static void visible(boolean bool) {
        frame.setVisible(bool);
    }
}