import processing.core.*;

public class App extends PApplet{
     int rectx = 325;
        int recty = 585;
        int rectspeed = 60;
        int veloX, veloY = 0;
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
    rect(0, 0, 100, 100);
    rect(175, 0, 100, 100);
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
}
