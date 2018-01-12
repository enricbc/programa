/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegirfixers1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author empis
 */
public class biblioteca {
        File arxiu= null; 
        FileReader fr=null;
        FileWriter fw=null;
        PrintWriter pw=null;
        BufferedReader br=null;
        String [] [] linies= new String [4][2];
        punts punts;
        ArrayList<punts> array=new ArrayList<punts>();
        Scanner sc=new Scanner (System.in);
        public void introduirPuntuacio(){
            String nom=sc.nextLine();
            String num=sc.nextLine();
            String [] x = new String [2];
            x[0]=nom;
            x[1]=num;
            array.add(new punts (x[0],Integer.parseInt(x[1])));
        }
        public void llegirPuntuacio(){
            try {
               arxiu=new File("src/llegirfixers1/arxiu.txt"); 
               /* Obrim el fitxer iniciem el buffer reader*/
               fr = new FileReader(arxiu);
               br = new BufferedReader(fr);
               //Llegim el fitxer
               String linia;
               int i=0;
               while((linia=br.readLine())!=null){
                   String x []=linia.split(";");
                   array.add(new punts (x[0],Integer.parseInt(x[1])));                 
                   System.out.println("Nom: "+array.get(i).nom+" Puntuació: "+array.get(i).punt);
                   i++;
               }
               br.close();
            }catch (Exception b){
                System.out.println(b);
            }
        }
        void ordenarArray(){            
            Collections.sort(array,new Comparator<punts>() {
            public int compare(punts p1, punts p2) {
                return p1.getPunt()-p2.getPunt();
            }
            });
            int i =0;
            for (punts sa : array) {
                System.out.println("Nom: "+array.get(i).nom+" Puntuació: "+array.get(i).punt);
                i++;
            }
        }
        void maxPuntuació(){
            try {
                
            }catch (Exception b){
                
            }
        }
        public void escriurePuntuacio(){
            try {
                arxiu=new File("src/llegirfixers1/ranking.txt"); 
                fw=new FileWriter(arxiu); 
                pw= new PrintWriter(fw);
                pw.println("\t\tPUNTUACIÓNS\t\t");
                for (int i = 0; i < array.size(); i++) {
                    System.out.println(array.get(i).nom);
                    pw.println("\tNom: "+array.get(i).nom+"\tPuntuacio: "+array.get(i).punt);
                }
                //pw.println(nom+";"+puntuacio);
                pw.close();
            }catch (Exception c){
                
            }
        }
        public void guardarPuntuacio(){
            
        }
}
class punts {
    String nom;
    int punt;
    public punts (String nom, int punts){
        this.nom=nom;
        this.punt=punts;
    }
    int getPunt (){
        return this.punt;
    }
}
