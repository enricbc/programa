/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreres5;

import java.util.ArrayList;
import processing.core.*;

/**
 *
 * @author empis
 */
public class Carreres5 extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carreres5 pt = new Carreres5 ();
        PApplet.runSketch(new String[]{"Carreres2"}, pt);
    }
    /*ATRIBUTS GLOBALS*/
    /*objectes*/
    poste pdreta;//=new poste();
    poste pesquerra;//=new poste();
    poste linia;
    coche coche;
    /*imatges*/
    PImage cel;
    PImage carrega;
    PImage coche1;
    PImage cochee;
    PImage coched;
    ArrayList<poste> posteDreta;
    ArrayList<poste> posteEsquerra;
    ArrayList<poste> liniam;
    int gamemode=0;
    public void settings(){
        size(800,600);
        posteDreta=new ArrayList();
        posteEsquerra=new ArrayList();
        liniam=new ArrayList();        
        coche1=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\Coches\\coche2.png");
        cochee=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\Coches\\cochee.png");
        coched=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\Coches\\coched.png");
        cel=loadImage("C:\\Users\\empis\\Documents\\programa\\carreres2\\cel.png");
        carrega=loadImage("C:\\Users\\empis\\Documents\\programa\\jocarray\\captura1.png");
        coche=new coche();//Aqui inicialitzo
        coche.crearCoche();//Aqui creo un coche
    }
    public void draw(){
        if (gamemode==0) {
            pantallaCarrega();
        }if (gamemode==1&&comprovarColisio()==false){
            background(127);
            
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
        linia=new poste();
        linia.crearLinia();
        pdreta.crearPosteDreta();
        pesquerra.crearPosteEsquerra();
        posteDreta.add(pdreta);
        posteEsquerra.add(pesquerra);
        if(liniam.isEmpty()){
        liniam.add(linia);
        }
        if (liniam.get(liniam.size()-1).y-linia.y>=100) {
            liniam.add(linia);
        }
    }
    public void moveAll(){
        for(poste pdreta : posteDreta){
            pdreta.moureYPosteDreta();
        }
        for(poste pesquerra : posteEsquerra){
            pesquerra.moureYPosteEsquerra();
        }
        for(poste linia : liniam){
            linia.moureLinia();
        }
    }
    public void displayAll(){
        for(poste pdreta : posteDreta){
            pdreta.display();
        }
        for(poste pesquerra : posteEsquerra){
            pesquerra.display();
        }
        for(poste linia : liniam){
            linia.displayl();
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
        for(int i =0;i < liniam.size(); i++){
            if (liniam.get(i).y>=600) {
                liniam.remove(i);
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
                for(poste linia : liniam){
                    linia.moureDreta();
                }
                coche.moureEsquerra();//Moc coche
                coche.buid=cochee;
                //coche.displaye();
            }if (keyCode==RIGHT&&coche.x<740) {
                for(poste pdreta : posteDreta){
                    pdreta.moureEsquerra();
                }
                for(poste pesquerra : posteEsquerra){
                    pesquerra.moureEsquerra();
                }
                for(poste linia : liniam){
                    linia.moureEsquerra();
                }
                coche.moureDreta();//Moc coche
                coche.buid=coched;
                //coche.displayd();
            }if (keyCode==UP) {
                gamemode=1;
            }
        }
    }
    public void keyReleased(){
        if (key==CODED) {
            if (keyCode==RIGHT||keyCode==LEFT) {
                coche.buid=coche1;
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
            x=395;
            y=150;
        }
        void moureLinia(){
            y=y+10;
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
        void displayl(){
            rect(x,y,6,20);
        }
    }
    public class coche{
        int x;
        int y;
        PImage buid;
        public coche(){
            buid=coche1;
        }
        void crearCoche(){
            y=550;
            x=370;
        }
        void moureDreta(){
           x=x+3;
        }
        void moureEsquerra(){
            x=x-3;
        }
        void display(){          
            image(buid,x,y,80,40);
        }
    }
    public class charco{
        int x;
        int y;
        public charco(){
            
        }
        void crearCharco(){
            y=150;
            x = (int)(Math.random()*450+340);
        }
    }
}

