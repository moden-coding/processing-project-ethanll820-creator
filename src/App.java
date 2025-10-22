import processing.core.*;

public class App extends PApplet{
     int rectx = 325;
        int recty = 585;
        int rectspeed = 60;
        int veloX, veloY = 0;
        float ballX = 400;
        float ballY = 525;
        float ballSize = 35;
        float ballVeloX = 3;
        float ballVeloY = 3;
        float block1X = 0, block1Y = 0, blockW = 50, blockH = 100;
        float block2X = 100, block2Y = 0;
        float block3X = 275, block3Y = 0;

    public static void main(String[] args)  {
        PApplet.main("App");
        
    }

    public void setup(){
    background(100, 100, 200);
        
    }

    public void settings(){
        size(800, 600);
    }

    public void draw() {
    background(100, 100, 200);
    rect(rectx, recty, 150, 25);
    move(veloX, veloY);
    rect(0, 0, 50, 100);
    rect(100, 0, 50, 100);
    rect(275, 0, 50, 100);
    ballX += ballVeloX;
    ballY += ballVeloY;

        if (ballX < ballSize/2 || ballX > width - ballSize/2) {
            ballVeloX *= -1;
        }
        if (ballY < ballSize/2 || ballY > height - ballSize/2) {
            ballVeloY *= -1;
        }

        if (ballX + ballSize/2 > rectx && ballX - ballSize/2 < rectx + 150 && // Used chatGPT
            ballY + ballSize/2 > recty && ballY - ballSize/2 < recty + 25) {
            ballVeloY *= -1;
            ballY = recty - ballSize/2; 
        }
        ellipse(ballX, ballY, ballSize, ballSize);
        checkBlockCollision(block1X, block1Y, blockW, blockH);
        checkBlockCollision(block2X, block2Y, blockW, blockH);
        checkBlockCollision(block3X, block3Y, blockW, blockH);

}

    public void move(int vX, int vY) {
        rectx += vX;
    }
    
    public void keyPressed(){
        if (keyCode == RIGHT){
            veloX = rectspeed/10;
        } if(keyCode == LEFT){
            veloX = -rectspeed/10;
        }
    }
    public void keyReleased(){
        if (keyCode == RIGHT){
            veloX = 0;
        } if(keyCode == LEFT){
            veloX = 0;
        }
    }
    public void checkBlockCollision(float bx, float by, float bw, float bh) {
    if (ballX + ballSize/2 > bx && ballX - ballSize/2 < bx + bw &&
        ballY + ballSize/2 > by && ballY - ballSize/2 < by + bh) {
        ballVeloY *= -1; 
        ballY = by + bh + ballSize/2; 
    }
}

}

