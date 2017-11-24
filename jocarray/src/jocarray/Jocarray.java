/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jocarray;
import processing.core.*;
import java.util.ArrayList;
/**
 * 
 *
 * @author empis
 */
public class Jocarray extends PApplet{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jocarray p =new Jocarray();
        PApplet.runSketch(new String[]{"quadrat"}, p);

    }
    int value =0;
    int cx=450;
    int cy=0;
    int x=0;
    int y=0;
    PImage fondo1;
    PImage coche;
    PImage paisaje;
    PImage fincarretera;
    boolean j=false;
    liniae le=new liniae();
    liniad ld =new liniad();
    //gira a la dreta 2
    //gira a l'esquerra 0
    //anar pel mitj 1
    int onanar=0;
    int gamestate=0;
    ArrayList<liniae> linee;
    ArrayList<liniad> lined;
    public void settings(){
        size(800,600);
        fondo1=loadImage("C:\\Users\\empis\\Documents\\programa\\jocarray\\captura1.png");
        coche=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\car_back.png");
        paisaje=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\paisaje2.jpg");
        fincarretera=loadImage("C:\\Users\\empis\\Documents\\programa\\mquadrat\\fincarretera.jpg");
        linee=new ArrayList();
        lined=new ArrayList();
        
    }
    public void draw(){
         //MOVIMENT FONDO       
        /*cy = constrain(cy, 0, cy- fondo.height );    
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
       */
        if (gamestate==0&&y==0) {
            background(fondo1);

            
        }if (gamestate==1&&y!=0) {
            joc();
        }            if (y!=0) {
               gamestate=1; 
            }
        
    }
    void joc(){


        /*if (onanar==0) {
            linee.add(le);
            lined.add(ld);
        }*/
        /*Rectangle esquerra*/
        //rect(le.x,le.y,10,60);
        //dibuixarliniae(le);

            /*le=new liniae();
            linee.add(le);
            lined.add(ld);
            if (linee.add(le)) {
                dibuixarliniae(le);
            //rect(linee.get(0).x,linee.get(0).y,10,60);
            }
            if (lined.add(ld)) {
                dibuixarliniad(ld);
            //rect(lined.get(0).x,lined.get(0).y,10,60);
            }*/

        
        
        /*Rectangle dreta*/
        //rect(ld.x,ld.y,10,60);
        //lined.add(ld);
        //dibuixarliniad(ld);
        lined.get(0).y=lined.get(0).y+10;
        linee.get(0).y=linee.get(0).y+10;
        if (lined.get(0).x<800&&linee.get(0).x<800) {
            lined.get(0).x=lined.get(0).x+5;
            linee.get(0).x=linee.get(0).x-5;
            System.out.println(linee.get(0).x+"   "+lined.get(0).x);
        }
        j=false;
    }
    @Override
    public void keyPressed(){
        if (key==CODED) {

            if (keyCode==LEFT&&x>(-55)) {
                x=x-5;
            }if (keyCode==RIGHT&&x<655) {
                x=x+5;
            }if (keyCode==UP/*&&y>(-45)*/) {
                //y=y-5;
                liniae le=new liniae();
                linee.add(le);
                dibuixarliniae(le);
                liniad ld=new liniad();
                lined.add(ld);
                dibuixarliniad(ld);
            }if (keyCode==DOWN&&y<430) {
                y=y+5;
            }
            
        }
            
        
    }
void dibuixarliniae(liniae le){
    rect(le.x,le.y,10,60);
    le.y=le.y+10;
    le.x=le.x-5;
}     
void dibuixarliniad(liniad ld){
    rect(ld.x,ld.y,10,60);
    
}
Object girarEsquerra(liniae le, liniad ld){
    for (int i = 0; i<20; i++) {
        liniad ls= new liniad((ld.x-(7)),ld.y,10,60);
        lined.add(ls);
    }
}
void displayall(){

}
class liniad{
    int x=450;
    int y=0;
    int w;
    int h;
    public liniad(){
        
    }
    public liniad(int x, int y,int w, int h){
        
    }
    void dibuixar(){
        rect(x,y,10,60);
    }
}
class liniae{
    int x=350;
    int y=0;
    /*public liniae(){
        rect(x,y,10,60);
    }*/
    void dibuixar(){
        rect(x,y,10,60);
    }
}
class coche{
    int x;
    int y;
    PImage coche;
}

} 