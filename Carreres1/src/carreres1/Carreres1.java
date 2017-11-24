/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreres1;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author empis
 */
public class Carreres1 extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carreres1 pt = new Carreres1 ();
        PApplet.runSketch(new String[]{"Carreres1"}, pt);
    }
    /*ATRIBUTS GLOBALS*/
    poste pdreta;//=new poste();
    poste pesquerra;//=new poste();
    coche coche;
    ArrayList<poste> posteDreta;
    ArrayList<poste> posteEsquerra;
    public void settings(){
        size(800,600);
        posteDreta=new ArrayList();
        posteEsquerra=new ArrayList();
        coche=new coche();//Aqui creo un coche
        coche.crearCoche();//Aqui creo un coche
    }
    public void draw(){
        background(00000);
        crearCarretera();
        moveAll();
        
        
        
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
    public void keyPressed(){
        if (key==CODED) {
            if (keyCode==LEFT&&coche.x>0) {
                coche.moureEsquerra();
            }if (keyCode==RIGHT&&coche.x<740) {
                coche.moureDreta();
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
            y=0;
        }
        void crearPosteEsquerra(){
            x=340;
            y=0;
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
            rect(x,y,10,60);
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
           x=x+5;
           System.out.println(coche.x);
        }
        void moureEsquerra(){
            x=x-5;
        }
        void display(){
            rect(x,y,60,10);
        }
    }
}

