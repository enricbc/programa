/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreres;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author empis
 */
public class Carreres extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carreres pt = new Carreres ();
        PApplet.runSketch(new String[]{"Carreres"}, pt);
    }
    /*ATRIBUTS GLOBALS*/
    poste pdreta;//=new poste();
    poste pesquerra;//=new poste();
    ArrayList<poste> posteDreta;
    ArrayList<poste> posteEsquerra;
    public void settings(){
        size(800,600);
        posteDreta=new ArrayList();
        posteEsquerra=new ArrayList();
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
    }
    public void keyPressed(){
        if (key==CODED) {
            if (keyCode==LEFT) {
                
            }if (keyCode==RIGHT) {
                
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
        void display(){
            rect(x,y,10,60);
        }
    }
    public class coche{
        int x;
        int y;
        void crearCoche(){
            y=430;
        }
        void display(){
            rect(x,y,60,10);
        }
    }
}
