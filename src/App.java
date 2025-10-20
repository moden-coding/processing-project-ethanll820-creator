import processing.core.*;

public class App extends PApplet{
     int rectx = 325;
        int recty = 585;
        int rectspeed = 10;
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
}


    
    public void keyPressed(){
        if (keyCode == RIGHT){
            rectx += rectspeed;
        } if(keyCode == LEFT){
            rectx-= rectspeed;
        }
    }
}
