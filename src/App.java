import processing.core.*;

public class App extends PApplet {//this is final version
    int rectx = 325; // Rect variables are for paddle (Position, speed, velocity)
    int recty = 585;
    float rectspeed = 80;
    float veloX;
    float ballX = 400; // Ball variables are for ball (position, diameter, velocity)
    float ballY = 525;
    float ballSize = 35;
    float ballVeloX = 6;
    float ballVeloY = 6;
    boolean gameOver = false; // GameOver and score are for game functions
    int score = 0;
    float blockX = 100; // Block variables are for the moving rectangle you are trying to hit
    float blockY = 100;
    float blockWidth = 100;
    float blockHeight = 25;
    float blockVeloX = 3;

    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void setup() {
        background(100, 100, 200); //sets background color and text size
        textSize(40);

    }

    public void settings() {
        size(800, 600); // sets window size
    }

    public void draw() {
        background(100, 100, 200); // Redraws background each frame to get rid of old shapes

        rect(rectx, recty, 150, 25); // draws paddle
        move(veloX); // moves paddle

        blockX += blockVeloX; // updates block positions and makes it bounce of the walls
        if (blockX <= 0 || blockX + blockWidth >= width) {
            blockVeloX *= -1;} // reverses direction

            fill(255, 0, 0);
            rect(blockX, blockY, blockWidth, blockHeight);

        

        if (!gameOver) { // makes it so block only moves if game isn't over
            ballX += ballVeloX; 
            ballY += ballVeloY;

            ballVeloX *= 1.0005; // speeds up ball over time
            ballVeloY *= 1.0005;
        }

        Checkcollisions(); // calls on collisions method

        ellipse(ballX, ballY, ballSize, ballSize); // draws ball and score
        fill(255);
        text("Score: " + score, 50, 100);
        if (ballY > height - ballSize / 2 && !gameOver) {
            gameOver = true;
            resetGame();
        }
    }

    public void resetGame() { // reset game variables
        ballX = 400;
        ballY = 525;
        ballVeloX = 6;
        ballVeloY = 6;
        rectx = 325;
        rectspeed = 80;
        score = 0;
        gameOver = false;
    }

    public void move(float vX) { // moves paddle by given velocity
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

    public void keyReleased() { // stops paddle when key is released so it doesn't move forever
        if (keyCode == RIGHT) {
            veloX = 0;
        }
        if (keyCode == LEFT) {
            veloX = 0;
        }
    }

    public boolean Hitblock(float bx, float by, float bwidth,float bheight){ // checks if ball touches moving block and returns boolean as true if it does

        float radius = ballSize / 2;
        return(ballX + radius > bx && ballX - radius < bx + bwidth && ballY + radius > by && ballY - radius < by + bheight); //returns true when any part of ball overlaps with block
    }
    //used ChatGPT for this method 
    public void Checkcollisions() { 
        float radius = ballSize / 2;

        if (ballX - radius <= 0 || ballX + radius >= width) { //ball hits right and left walls
            ballVeloX *= -1;
        }
        if (ballY - radius <= 0) { //ball hits ceiling
            ballVeloY *= -1;
        }

        if (ballX + radius > rectx && ballX - radius < rectx + 150 && ballY + radius > recty && ballY - radius < recty + 25) { // ball hits paddle
            ballVeloY *= -1;
            ballY = recty - radius;
            score += 1;
            rectspeed = 80 + score * 5;}

         if (Hitblock(blockX, blockY, blockWidth, blockHeight)) { //ball hits block (calls Hitblock method)
            ballVeloY *= -1;
            ballY = blockY + blockHeight + radius; // bounce off bottom of block
            score += 1; //increases score
        }

    
    }
}
    
