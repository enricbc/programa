/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegirfitxer;

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
        ArrayList<String[]> array=new ArrayList<String[]>();
        Scanner sc=new Scanner (System.in);
        public void introduirPuntuacio(){
            String nom=sc.nextLine();
            String num=sc.nextLine();
            String [] x = new String [2];
            x[0]=nom;
            x[1]=num;
            array.add(x);
        }
        public void llegirPuntuacio(){
            try {
               arxiu=new File("src/llegirfitxer/arxiu.txt"); 
               /* Obrim el fitxer iniciem el buffer reader*/
               fr = new FileReader(arxiu);
               br = new BufferedReader(fr);
               //Llegim el fitxer
               String linia;
               int i=0;
               while((linia=br.readLine())!=null){
                   array.add(linia.split(";"));                 
                   System.out.println("Nom: "+array.get(array.size()-1)[0]+" Puntuació: "+array.get(array.size()-1)[1]);
                   i++;
               }
               br.close();
            }catch (Exception b){
                System.out.println(b);
            }
        }
        void ordenarArray(){
            Collections.sort(array,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[1].compareTo(otherStrings[1]);
            }
            });
            int i =0;
            for (String[] sa : array) {
                System.out.println(Arrays.toString(sa));
            }
        }
        void compararPuntuacio(String nom,int x){
            for (int i = 0; i < linies.length; i++) {
                int b=Integer.parseInt(linies[i][1]);
                System.out.println(b);
                if (x>b) {
                    linies[i][1]=Integer.toString(x);
                    linies[i][0]=nom;
                }
            }
        }
        void maxPuntuació(){
            try {
                
            }catch (Exception b){
                
            }
        }
        public void escriurePuntuacio(){
            try {
                fw=new FileWriter("C:\\Users\\empis\\Documents\\programa\\llegirFitxer\\src\\llegirfitxer\\ranking.txt"); 
                pw= new PrintWriter(fw);
                pw.println("\t\tPUNTUACIÓNS\t\t");
                for (int i = 0; i < array.size(); i++) {
                    System.out.println(String.valueOf(array.get(i)[0]));
                    pw.println("\tNom: "+String.valueOf(array.get(i)[0])+"\tPuntuacio: "+String.valueOf(array.get(i)[1]));
                }
                //pw.println(nom+";"+puntuacio);
                pw.close();
            }catch (Exception c){
                
            }
        }
        public void guardarPuntuacio(){
            
        }
}
class punts{
    String [] noms = new String [100];
    int [] punts = new int [100];
}