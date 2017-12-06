/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreres8;

import java.util.ArrayList;
import processing.core.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author empis
 */
public class Carreres8 extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carreres8 pt = new Carreres8 ();
        PApplet.runSketch(new String[]{"Carreres8"}, pt);
    }
    /*ATRIBUTS GLOBALS*/
    /*objectes*/
    poste pdreta;//=new poste();
    poste pesquerra;//=new poste();
    poste linia;
    coche coche;
    charco charco;
    /*imatges*/
    PImage cel;
    PImage carrega;
    PImage coche1;
    PImage cochee;
    PImage coched;
    PImage charco1;
    PImage marcador;
    ArrayList<poste> posteDreta;
    ArrayList<poste> posteEsquerra;
    ArrayList<poste> liniam;
    ArrayList<charco> charcos;
    int gamemode=0;
    
    public void settings(){
        size(800,750);
        posteDreta=new ArrayList();
        posteEsquerra=new ArrayList();
        charcos=new ArrayList();
        liniam=new ArrayList();    
        marcador=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\marcador.png");
        charco1=loadImage("C:\\Users\\empis\\Desktop\\Joc m03\\charco\\charco.png");
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
        if (coche.puntuacio>1000) {
            charco.aumentarAceleracio();
        }           
            crearCarretera();
            moveAll();
            clearAll();
            displayAll();
            image(marcador,0,600);
            puntuacio();
        }if (gamemode==2) {
            background(255);
            textSize(200);
            text("PAUSE",0,375);
        }if (gamemode==3) {
            
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
        charco=new charco();
        if(charcos.isEmpty()){
        charcos.add(charco);
        }
        if (charcos.get(charcos.size()-1).y-charco.y>=1000) {
            charcos.add(charco);
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
        for(charco charco : charcos){
            charco.moureCharco();
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
        for(charco charco : charcos){
            charco.display();
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
        for(int i =0;i < charcos.size(); i++){
            if (charcos.get(i).y>coche.y+8) {
                charcos.remove(i);
            }
        }
    }
    public void puntuacio(){
        for(int i =0;i < charcos.size(); i++){
            if (charcos.get(i).y>coche.y) {
                coche.puntuacio=coche.puntuacio+100;
                textSize(20);
                
                
            }
            text(coche.puntuacio,375,675);
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
                for(charco charco : charcos){
                    charco.moureDreta();
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
                for(charco charco : charcos){
                    charco.moureEsquerra();
                }
                coche.moureDreta();//Moc coche
                coche.buid=coched;
                //coche.displayd();
            }if (keyCode==UP) {
                if (gamemode==3) {
                gamemode=0;
            }else{
                gamemode++;
                }
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
                gamemode =2;
            }
        }
        for(poste pesquerra : posteEsquerra){
            if(pesquerra.x>(coche.x)&&pesquerra.y>coche.y){
                x=true;
                gamemode=2;
            }
        }
        for(charco charco : charcos){
            if(coche.x>=charco.x&&coche.x<=charco.x+charco.width||coche.x+80>=charco.x&&coche.x+80<=charco.x){
                if (charco.y+charco.height>=coche.y) {
                    x=true;
                   gamemode=2;
                }
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
        }
        void moureEsquerra(){
            x=x-5;
        }
        void display(){
            rect(x,y,10,3);
        }
        void displayl(){
            //stroke(321);
            rect(x,y,6,20);
        }
    }
    public class coche{
        int x;
        int y;
        int puntuacio;
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
        int y=150;
        int height;
        int width;
        int aceleracio=4;
        public charco(){
            x = (int)(Math.random()*(320-430+1)+430);
        }
        void crearCharco(){
            y=150;
            height=6;
            width=10;
        }
        void moureCharco(){
            if (x<360) {
                y=y+aceleracio;
                x=x-3;
                height=height+2;
                width=width+2;
            }if (x>390) {
                y=y+aceleracio;
                x=x+3;
                height=height+2;
                width=width+2;
            }if (x<=390&&x>=360) {
                y=y+aceleracio;
                height=height+2;
                width=width+2;
            }
        }
        void moureDreta(){
            x=x+5;
        }
        void moureEsquerra(){
            x=x-5;
        }
        void aumentarAceleracio(){
            aceleracio=aceleracio+4;
        }
        void display(){
            image (charco1,x,y,width,height);
        }           
    }
    public class biblioteca{
        File arxiu=null;
        FileReader fr=null;
        BufferedReader br=null;
        String[][] puntuacions = new String [2][1];
        
        void llegirPuntuacio(){
            try {
               arxiu=new File(""); 
               /* Obrim el fitxer iniciem el buffer reader*/
               fr = new FileReader(arxiu);
               br = new BufferedReader(fr);
               //Llegim el fitxer
               String linia;
               while((linia=br.readLine())!=null){
                   int j=0;
                    for (int i =0; i<2; i++) {
                        String [] puntuacio=linia.split(".");
                       puntuacions[j]=linia.split(".");
                    }
                    j++;
               }
            }catch (Exception b){
                
            }
        }
        void compararPuntuacio(int x){
            
        }
        void maxPuntuació(){
            try {
                
            }catch (Exception b){
                
            }
        }
    }
}
