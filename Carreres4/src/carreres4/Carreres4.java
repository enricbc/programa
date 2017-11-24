/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreres4;

import java.util.ArrayList;
import processing.core.*;

/**
 *
 * @author empis
 */
public class Carreres4 extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carreres4 pt = new Carreres4 ();
        PApplet.runSketch(new String[]{"Carreres2"}, pt);
    }
    /*ATRIBUTS GLOBALS*/
    /*objectes*/
    poste pdreta;//=new poste();
    poste pesquerra;//=new poste();
    coche coche;
    /*imatges*/
    PImage cel;
    PImage carrega;
    PImage coche1;
    PImage cochee;
    PImage coched;
    ArrayList<poste> posteDreta;
    ArrayList<poste> posteEsquerra;
    int gamemode=0;
    public void settings(){
        size(800,600);
        posteDreta=new ArrayList();
        posteEsquerra=new ArrayList();
        coche=new coche();//Aqui creo un coche
        coche.crearCoche();//Aqui creo un coche
        coche1=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\Coches\\coche2.png");
        cochee=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\Coches\\cochee.png");
        coched=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\Coches\\coched.png");
        cel=loadImage("C:\\Users\\empis\\Documents\\programa\\carreres2\\cel.png");
        carrega=loadImage("C:\\Users\\empis\\Documents\\programa\\jocarray\\captura1.png");
    }
    public void draw(){
        if (gamemode==0) {
            pantallaCarrega();
        }if (gamemode==1&&comprovarColisio()==false){
            background(0000);
            image(cel,0,0);
            crearCarretera();
            moveAll();
            clearAll();
            displayAll();
        }
    }
    public void pantallaCarrega(){
        image(carrega,0,0);
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
        if (keyCode==RIGHT) {
            coche.displayd();
        }if (keyCode==LEFT) {
            coche.displaye();
        }if(keyCode!=LEFT&&keyCode!=RIGHT){
        coche.display();//Dibuixem el coche
        }
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
                //coche.displaye();
            }if (keyCode==RIGHT&&coche.x<740) {
                for(poste pdreta : posteDreta){
                    pdreta.moureEsquerra();
                }
                for(poste pesquerra : posteEsquerra){
                    pesquerra.moureEsquerra();
                }
                coche.moureDreta();//Moc coche
                //coche.displayd();
            }if (keyCode==UP) {
                gamemode=1;
            }
        }
    }
    public boolean comprovarColisio(){
        boolean x=false;
        for(poste pdreta : posteDreta){
            if(pdreta.x<(coche.x+58)&&pdreta.y>coche.y){
                x=true;
                break;
            }
        }
        for(poste pesquerra : posteEsquerra){
            if(pesquerra.x>(coche.x)&&pesquerra.y>coche.y){
                x=true;
                break;
            }
        }
        return x;
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
        void crearLinia(){
            
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
           //System.out.println(coche.x);
        }
        void moureEsquerra(){
            x=x-3;
        }
        void display(){
            image(coche1,x,y,80,40);
        }
        void displaye(){
            image(cochee,x,y,80,40);
        }
        void displayd(){
            image(coched,x,y,80,40);
        }
    }
}
