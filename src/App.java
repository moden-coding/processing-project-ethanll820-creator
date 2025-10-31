import processing.core.*;

public class App extends PApplet {
    int rectx = 325;
    int recty = 585;
    float rectspeed = 80;
    float veloX;
    float ballX = 400;
    float ballY = 525;
    float ballSize = 35;
    float ballVeloX = 6;
    float ballVeloY = 6;
    boolean gameOver = false;
    int score = 0;
    float blockX = 100;
    float blockY = 100;
    float blockWidth = 100;
    float blockHeight = 25;
    float blockVeloX = 3;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        background(100, 100, 200);
        textSize(40);

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(100, 100, 200);

        rect(rectx, recty, 150, 25);
        move(veloX);

        blockX += blockVeloX;
        if (blockX <= 0 || blockX + blockWidth >= width) {
            blockVeloX *= -1;}
            fill(255, 0, 0);
            rect(blockX, blockY, blockWidth, blockHeight);

        

        if (!gameOver) {
            ballX += ballVeloX;
            ballY += ballVeloY;

            ballVeloX *= 1.0005;
            ballVeloY *= 1.0005;
        }

        Checkcollisions();
        ellipse(ballX, ballY, ballSize, ballSize);
        fill(255);
        text("Score: " + score, 50, 100);
        if (ballY > height - ballSize / 2 && !gameOver) {
            gameOver = true;
            resetGame();
        }
    }

    public void resetGame() {
        ballX = 400;
        ballY = 525;
        ballVeloX = 6;
        ballVeloY = 6;
        rectx = 325;
        rectspeed = 80;
        score = 0;
        gameOver = false;
    }

    public void move(float vX) {
        rectx += vX;
    }

    public void keyPressed() {
        if (keyCode == RIGHT) {
            veloX = rectspeed / 10;
        }
        if (keyCode == LEFT) {
            veloX = -rectspeed / 10;
        }
    }

    public void keyReleased() {
        if (keyCode == RIGHT) {
            veloX = 0;
        }
        if (keyCode == LEFT) {
            veloX = 0;
        }
    }

    public void Checkcollisions() { //used ChatGPT for this method
        float radius = ballSize / 2;

        if (ballX - radius <= 0 || ballX + radius >= width) {
            ballVeloX *= -1;
        }
        if (ballY - radius <= 0) {
            ballVeloY *= -1;
        }

        if (ballX + radius > rectx && ballX - radius < rectx + 150 &&
                ballY + radius > recty && ballY - radius < recty + 25) {
            ballVeloY *= -1;
            ballY = recty - radius;
            score += 1;
            rectspeed = 80 + score * 5;}

        if (ballX + radius > blockX && ballX - radius < blockX + blockWidth &&
        ballY + radius > blockY && ballY - radius < blockY + blockHeight) {
        ballVeloY *= -1;
        ballY = blockY + blockHeight + radius;
        score += 1;
        }
    
    }
}
    
