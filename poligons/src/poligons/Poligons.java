/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligons;
import processing.core.*;
/**
 *
 * @author empis
 */
public class Poligons extends PApplet{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Poligons p =new Poligons();
        PApplet.runSketch(new String[]{"Poligons"}, p);
    }
    int radius=10;
    int direccio=1;
    double x=10;
    double speed=0.5; 
    public void settings (){
        size (600,600);
        ellipseMode(RADIUS);
    }
    public void draw(){
        background(0);
        x=x+speed*direccio;
        if((x>width-radius) || (x<radius)) {
            direccio=-direccio;} 
        if (direccio==1) {
            rect(200,200,200,200);
        }
        
        
    }
    public void keyPressed (){
         if(key == CODED)
        {
            if (keyCode == LEFT)
            {
            if (direccio>0)    direccio=-direccio;
            }
            if(keyCode == RIGHT)
            {
            if (direccio<0)     direccio=-direccio;
            }
        }
    }
}
