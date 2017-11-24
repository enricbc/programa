/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fondomov;
import processing.core.*;
/**
 *
 * @author empis
 */
public class Fondomov extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fondomov p =new Fondomov();
        PApplet.runSketch(new String[]{"fondo"}, p);
    }
    PImage img;
int x,y;
public void settings()
  {
    size(800,600);  
    img = loadImage("fondo-cesped-02.jpg"); // image is 1600 x 600
  }
public void draw()
{
  //  background(0); 
      // not needed as image is bigger than size 
     // and thus overwrites all areas
  x = constrain(x, 0, img.width - width);    
     // ensures that "scrolling" stops at right end of image
  // y = constrain(y, 0, img.height - height); 
     // Not needed here, as scolling only in x
  image(img, -x, 0);  
     // overwrites the whole screen with the "shifted" image
  x = frameCount;     
     // advances the image with each new frame
     // do whatever is wanted from here on 
     // like after a call of background();
  stroke(0,0,0);
  ellipse(mouseX,mouseY,15,15);
}
}
