/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mquadrat;
import processing.core.*;
/**
 * 
 *
 * @author empis
 */
public class Mquadrat extends PApplet{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mquadrat p =new Mquadrat();
        PApplet.runSketch(new String[]{"quadrat"}, p);

    }
    int value =0;
    int cx=0;
    int cy=0;
    int x=295;
    int y=430;
    PImage fondo;
    PImage coche;
    PImage paisaje;
    PImage fincarretera;
    boolean j=false;
    public void settings(){
        size(800,600);
        fondo=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\fondo.jpg");
        coche=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\car_back.png");
        paisaje=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\paisaje2.jpg");
        fincarretera=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\fincarretera.jpg");
    }
    public void draw(){
         //MOVIMENT FONDO       
        image(paisaje,(-55),0);
        cy = constrain(cy, 0, cy- fondo.height );    
        image(fondo, 0, cy);
        image(paisaje,0,0);
        image(fincarretera,0,350);
        if (cy>100&&j==false) {
            cy=0;
            frameCount=0;
            image(fondo, 0, cy);
            System.out.println("Burro");
            j=true;
        }
        if (j==true) {
            j=false;
        }
        cy = (10*frameCount);
        stroke(0,0,0);

        System.out.println(cy);
        //background(fondo);
        fill(150,200,255);
        image(coche,x,y,200,300);
        System.out.println(x);
       

    }
    
    @Override
    public void keyPressed(){
        if (key==CODED) {

            if (keyCode==LEFT&&x>(-55)) {
                x=x-5;
            }if (keyCode==RIGHT&&x<655) {
                x=x+5;
            }/*if (keyCode==UP&&y>(-45)) {
                y=y-5;
            }if (keyCode==DOWN&&y<430) {
                y=y+5;
            }*/
            
        }
            
        
    }
     
}
