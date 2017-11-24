/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreres2;

import java.util.ArrayList;
import processing.core.*;

/**
 *
 * @author empis
 */
public class Carreres2 extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carreres2 pt = new Carreres2 ();
        PApplet.runSketch(new String[]{"Carreres2"}, pt);
    }
    /*ATRIBUTS GLOBALS*/
    poste pdreta;//=new poste();
    poste pesquerra;//=new poste();
    coche coche;
    PImage cel;
    ArrayList<poste> posteDreta;
    ArrayList<poste> posteEsquerra;
    
    public void settings(){
        size(800,600);
        posteDreta=new ArrayList();
        posteEsquerra=new ArrayList();
        coche=new coche();//Aqui creo un coche
        coche.crearCoche();//Aqui creo un coche
        cel=loadImage("C:\\Users\\empis\\Documents\\programa\\carreres2\\cel.png");
    }
    public void draw(){
        background(0000);
        image(cel,0,0);
        crearCarretera();
        moveAll();
        clearAll();
        
        
        displayAll();

    }
    public void crearCarretera(){
        pdreta=new poste();
        pesquerra=new poste();
        
        
        pdreta.crearPosteDreta();
        pesquerra.crearPosteEsquerra();
        posteDreta.add(pdreta);
        posteEsquerra.add(pesquerra);
    }
    public void moveAll(){
        for(poste pdreta : posteDreta){
            pdreta.moureYPosteDreta();
        }
        for(poste pesquerra : posteEsquerra){
            pesquerra.moureYPosteEsquerra();
        }
    }
    public void displayAll(){
        for(poste pdreta : posteDreta){
            pdreta.display();
        }
        for(poste pesquerra : posteEsquerra){
            pesquerra.display();
        }
        coche.display();
    }
    public void clearAll(){
        for(int i =0;i < posteDreta.size(); i++){
            if (posteDreta.get(i).y>=600) {
                posteDreta.remove(i);
            }
        }
        for(int i =0;i < posteEsquerra.size(); i++){
            if (posteEsquerra.get(i).y>=600) {
                posteEsquerra.remove(i);
            }
        }
    }
    public void keyPressed(){
        if (key==CODED) {
            if (keyCode==LEFT&&coche.x>0) {
                for(poste pdreta : posteDreta){
                    pdreta.moureDreta();
                }
                for(poste pesquerra : posteEsquerra){
                    pesquerra.moureDreta();
                }
                coche.moureEsquerra();//Moc coche
            }if (keyCode==RIGHT&&coche.x<740) {
                for(poste pdreta : posteDreta){
                    pdreta.moureEsquerra();
                }
                for(poste pesquerra : posteEsquerra){
                    pesquerra.moureEsquerra();
                }
                coche.moureDreta();//Moc coche
            }
        }
    }
    /*CLASSE POSTE*/
    public class poste{
        int x;
        int y;
        public poste(){
        }
        void crearPosteDreta(){
            x=450;
            y=150;
        }
        void crearPosteEsquerra(){
            x=340;
            y=150;
        }        
        void moureYPosteDreta (){
            y=y+7;
            x=x+5;
        }
        void moureYPosteEsquerra (){
            y=y+7;
            x=x-5;
        }
        void moureDreta(){
           x=x+5;
           System.out.println(x);
        }
        void moureEsquerra(){
            x=x-5;
        }
        void display(){
            rect(x,y,10,3);
        }
    }
    public class coche{
        int x;
        int y;
        public coche(){
            
        }
        public coche(int x){
            this.x=x;
        }
        void crearCoche(){
            y=550;
            x=370;
        }
        void moureDreta(){
           x=x+3;
           System.out.println(coche.x);
        }
        void moureEsquerra(){
            x=x-3;
        }
        void display(){
            rect(x,y,60,10);
        }
    }
}

