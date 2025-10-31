import processing.core.*;

public class App extends PApplet {
    int rectx = 325;
    int recty = 585;
    float rectspeed = 8;
    int veloX = 0;
    float ballX = 400;
    float ballY = 525;
    float ballSize = 35;
    float ballVeloX = 6;
    float ballVeloY = 6;
    boolean gameOver = false;
    int score = 0;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        background(100, 100, 200);
        textAlign(LEFT, TOP);
    }

    public void draw() {
        background(100, 100, 200);

        // Draw paddle
        rect(rectx, recty, 150, 25);

        // Move paddle
        move(veloX, 0);

        // Move ball
        ballX += ballVeloX;
        ballY += ballVeloY;

        // Draw ball
        ellipse(ballX, ballY, ballSize, ballSize);

        // Show score
        fill(255);
        textSize(40);
        text("Score: " + score, 50, 40);

        // Bounce off left and right walls
        if (ballX < ballSize / 2 || ballX > width - ballSize / 2) {
            ballVeloX *= -1;
        }

        // Bounce off top only (not bottom)
        if (ballY < ballSize / 2) {
            ballVeloY *= -1;
        }

        // Paddle collision ChatGPT
        if (ballX + ballSize / 2 > rectx &&
            ballX - ballSize / 2 < rectx + 150 &&
            ballY + ballSize / 2 > recty &&
            ballY - ballSize / 2 < recty + 25) {

            ballVeloY *= -1;
            ballY = recty - ballSize / 2;
            score++;

            // Speed up ball and paddle slightly
            ballVeloX *= 1.05;
            ballVeloY *= 1.05;
            rectspeed *= 1.05;
        }

    }

    public void move(int vX, int vY) {
        rectx += vX;
        // keep paddle within bounds
        if (rectx < 0) rectx = 0;
        if (rectx + 150 > width) rectx = width - 150;
    }

    public void keyPressed() {
        if (keyCode == RIGHT) {
            veloX = (int) rectspeed;
        }
        if (keyCode == LEFT) {
            veloX = (int) -rectspeed;
        }
    }

    public void keyReleased() {
        if (keyCode == RIGHT || keyCode == LEFT) {
            veloX = 0;
        }
    }
}
