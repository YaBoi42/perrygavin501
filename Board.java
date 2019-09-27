import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.Timer;
import java.io.*;

//High score file = Snake High
//Colors owned file = Snake Colors
//Points to purchase colors = Snake Points
//Possible new Colors: Gray(1000), magenta(1000), Cyan(500). 
@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
    private final static int BOARDWIDTH = 700;
    private final static int BOARDHEIGHT = 700;
    private final static int PIXELSIZE = 25;
    private final static int TOTALPIXELS = (BOARDWIDTH * BOARDHEIGHT)
        / (PIXELSIZE * PIXELSIZE);
    private boolean inGame = true;
    private Timer timer;
    private static int speed = 45;
    private Snake snake = new Snake();
    private Food food = new Food();
    private int score;
    int high = 0;
    int points = 0;
    int temp = 1;
    Shop shop = new Shop();
    //Game game = new Game();
    public Board() {
        addKeyListener(new Keys());
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
        initializeGame();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    void draw(Graphics g) {
        if(inGame == true) {
            g.setColor(Color.green);
            g.fillRect(food.getFoodX(), food.getFoodY(), PIXELSIZE, PIXELSIZE); // food
            for (int i = 0; i < snake.getJoints(); i++) {
                if(i == 0) {
                    if(Start.getColor().equalsIgnoreCase("red")){g.setColor(Color.RED);}
                    if(Start.getColor().equalsIgnoreCase("blue")){g.setColor(Color.BLUE);}
                    if(Start.getColor().equalsIgnoreCase("yellow")){g.setColor(Color.YELLOW);}
                    if(Start.getColor().equalsIgnoreCase("pink")){g.setColor(Color.PINK);}
                    if(Start.getColor().equalsIgnoreCase("white")){g.setColor(Color.WHITE);}
                    g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),
                        PIXELSIZE, PIXELSIZE);
                } else {
                    g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),
                        PIXELSIZE, PIXELSIZE);
                }
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            endGame(g);
        }
    }

    void initializeGame() {
        snake.setJoints(3); // set our snake's initial size

        for (int i = 0; i < snake.getJoints(); i++) {
            snake.setSnakeX(BOARDWIDTH / 2);
            snake.setSnakeY(BOARDHEIGHT / 2);
        }
        food.createFood();
        score = 0;
        Score score = new Score();
        try { //
            high = score.getHigh();
            points = score.getPoints();
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }
        timer = new Timer(speed, this);
        timer.start();
    }

    void checkFoodCollisions() {
        if((proximity(snake.getSnakeX(0), food.getFoodX(), 20))
        && (proximity(snake.getSnakeY(0), food.getFoodY(), 20))) {
            snake.setJoints(snake.getJoints() + 1);
            score += snake.getJoints() - 3;
            food.createFood();
        }
    }

    void checkCollisions() {
        for (int i = snake.getJoints(); i > 0; i--) {
            if((i > 5)
            && (snake.getSnakeX(0) == snake.getSnakeX(i) && (snake
                    .getSnakeY(0) == snake.getSnakeY(i)))) {
                inGame = false; // then the game ends
            }
        }
        if(snake.getSnakeY(0) >= BOARDHEIGHT) {
            inGame = false;
        }

        if(snake.getSnakeY(0) < 0) {
            inGame = false;
        }

        if(snake.getSnakeX(0) >= BOARDWIDTH) {
            inGame = false;
        }

        if(snake.getSnakeX(0) < 0) {
            inGame = false;
        }

        if(!inGame) {
            timer.stop();
        }
    }

    void endGame(Graphics g) {
        String messageGO = "Game over";
        String messageS = "Score: " + score;
        String messageL = "Length: " + snake.getJoints();
        points += snake.getJoints();
        String messageHS = "High Score: " + high;
        String messageNHS = "New High Score!!!";
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        FontMetrics metrics = getFontMetrics(font);
        g.setColor(Color.red);
        g.setFont(font);
        try {
            Score.newPoints(points + "");
        } catch (IOException ex) {
            System.out.println("Error");
            System.exit(1);
        }
        if(score > high){
            g.drawString(messageNHS, (BOARDWIDTH - metrics.stringWidth(messageNHS)) / 2,
                (BOARDHEIGHT / 2) + 50);
            try {
                Score.newHigh(score + "");
            } catch (IOException ex) {
                System.out.println("Error");
                System.exit(1);
            }
        }

        g.drawString(messageGO, (BOARDWIDTH - metrics.stringWidth(messageGO)) / 2,
            (BOARDHEIGHT / 2) + 30);
        g.drawString(messageHS, (BOARDWIDTH - metrics.stringWidth(messageHS)) / 2,
            (BOARDHEIGHT / 2) - 10);
        g.drawString(messageS, (BOARDWIDTH - metrics.stringWidth(messageS)) / 2,
            (BOARDHEIGHT / 2) - 30);
        g.drawString(messageL, (BOARDWIDTH - metrics.stringWidth(messageL)) / 2,
            (BOARDHEIGHT / 2) + 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame == true) {
            checkFoodCollisions();
            checkCollisions();
            snake.move();
        }
        repaint();
    }

    private class Keys extends KeyAdapter  {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if((key == KeyEvent.VK_LEFT) && (!snake.isMovingRight())) {
                snake.setMovingLeft(true);
                snake.setMovingUp(false);
                snake.setMovingDown(false);
                if(temp == 1) {timer.start();temp *= -1;}
            }

            if((key == KeyEvent.VK_RIGHT) && (!snake.isMovingLeft())) {
                snake.setMovingRight(true);
                snake.setMovingUp(false);
                snake.setMovingDown(false);
                if(temp == 1) {timer.start();temp *= -1;}
            }

            if((key == KeyEvent.VK_UP) && (!snake.isMovingDown())) {
                snake.setMovingUp(true);
                snake.setMovingRight(false);
                snake.setMovingLeft(false);
                if(temp == 1) {timer.start();temp *= -1;}
            }

            if((key == KeyEvent.VK_DOWN) && (!snake.isMovingUp())) {
                snake.setMovingDown(true);
                snake.setMovingRight(false);
                snake.setMovingLeft(false);
                if(temp == 1) {timer.start();temp *= -1;}
            }

            if(key == KeyEvent.VK_DELETE) {
                System.exit(0);
            }

            if((inGame == false) && (key == KeyEvent.VK_S)) {
                Game.visible(false);
                shop.runShop_Load();
            }

            if((inGame == false) && (key == KeyEvent.VK_ENTER)) {
                inGame = true;
                snake.setMovingDown(false);
                snake.setMovingRight(false);
                snake.setMovingLeft(false);
                snake.setMovingUp(false);
                initializeGame();
            }

            if((inGame == true) && (key == KeyEvent.VK_ESCAPE)) {
                if(temp == -1) {timer.stop();temp *= -1;}
            }
        }
    }

    private boolean proximity(int a, int b, int closeness) {
        return Math.abs((long) a - b) <= closeness;
    }

    public static int getAllDots() {
        return TOTALPIXELS;
    }

    public static int getDotSize() {
        return PIXELSIZE;
    }
}