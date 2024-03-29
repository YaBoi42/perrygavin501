public class Food {
    private Snake snake = new Snake();
    private int foodX; // Stores X pos of our food
    private int foodY; // Stores Y pos of our food
    private final int RANDOMPOSITION = 28;

    public void createFood() {
        int location = (int) (Math.random() * RANDOMPOSITION);
        foodX = ((location * Board.getDotSize()));
        location = (int) (Math.random() * RANDOMPOSITION);
        foodY = ((location * Board.getDotSize()));

        if ((foodX == snake.getSnakeX(0)) && (foodY == snake.getSnakeY(0))) {
            createFood();
        }
    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}