import processing.core.*;

public class App extends PApplet {
    int rectx = 325;
    int recty = 585;
    int rectspeed = 60;
    int veloX, veloY = 0;
    float ballX = 400;
    float ballY = 525;
    float ballSize = 35;
    float ballVeloX = 6;
    float ballVeloY = 6;


    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        background(100, 100, 200);

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(100, 100, 200);
        rect(rectx, recty, 150, 25);
        move(veloX, veloY);
        ballX += ballVeloX;
        ballY += ballVeloY;

        if (ballX < ballSize / 2 || ballX > width - ballSize / 2) {
            ballVeloX *= -1;
        }
        if (ballY < ballSize / 2 || ballY > height - ballSize / 2) {
            ballVeloY *= -1;
        }

        if (ballX + ballSize / 2 > rectx && ballX - ballSize / 2 < rectx + 150 &&
                ballY + ballSize / 2 > recty && ballY - ballSize / 2 < recty + 25) {
            ballVeloY *= -1;
            ballY = recty - ballSize / 2;
        }
        ellipse(ballX, ballY, ballSize, ballSize);
        

    }

    public void move(int vX, int vY) {
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

    public void checkBlockCollision(float bx, float by, float bw, float bh) { // Used ChatGPT for this method to detect
                                                                              // collision
        if (ballX + ballSize / 2 > bx && ballX - ballSize / 2 < bx + bw &&
                ballY + ballSize / 2 > by && ballY - ballSize / 2 < by + bh) {
            ballVeloY *= -1;
            ballY = by + bh + ballSize / 2;
        }
    }

}
