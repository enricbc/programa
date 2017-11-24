/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import java.util.Scanner;

/**
 *
 * @author palatsii06
 */
public class inout {
    static Scanner sc;
    static String[] menu_princ;
    static String[] introduir_fig;
    static String[] dibuixar_figs;
    
    public inout(){
        sc = new Scanner(System.in);
        
        menu_princ = new String [7];
        menu_princ[0] = "==============================";
        menu_princ[1] = "            FIGURES           ";
        menu_princ[2] = "==============================";
        menu_princ[3] = "1. INTRODUIR FIGURA";
        menu_princ[4] = "2. CONSULTAR FIGURA";
        menu_princ[5] = "3. COMPROVAR SI 2 FIGURES ES SOLAPEN";
        menu_princ[6] = "4. SORTIR";
        
        introduir_fig = new String[8];
        introduir_fig[0] = "QUINA FIGURA VOLS INTRODUIR?";
        introduir_fig[1] = "1. CERCLE";
        introduir_fig[2] = "2. TRIANGLE EQUILÀTER";
        introduir_fig[3] = "3. QUADRAT";
        introduir_fig[4] = "4. HEXÀGON";
        introduir_fig[5] = "5. RECTANGLE";
        introduir_fig[6] = "6. TRIANGLE RECTANGLE";
        introduir_fig[7] = "7. FIGURA LLIURE";
        
        dibuixar_figs = new String[4];
        dibuixar_figs[0] = "QUÈ VOLS FER AMB LES FIGURES?";
        dibuixar_figs[1] = "1. VEURE-LES AL CANVAS";
        dibuixar_figs[2] = "2. ES SOLAPEN AL CANVAS?";
        dibuixar_figs[3] = "3. SORTIR";
    }
    
    static void imprimirMissatge(String s){
        System.out.println(s);
    }
    
    static void demanarOpcio(){
        System.out.print("Opció: ");
    }
    
    static char llegirOpcio(){
        return sc.next().charAt(0);
    }
    
    static String llegirString(){
        return sc.next();
    }
    
    static void esperarEnter(){
        imprimirMissatge("Prem ENTER per continuar...");
        sc.nextLine();
        sc.nextLine();
        imprimirMissatge("\033[H\033[2J");
        System.out.flush();
    }
    
    static Double llegirDouble(){
        return sc.nextDouble();
    }
    
    static void imprimirMenu(String[] menu){
        for(int i = 0; i < menu.length; i++){
            imprimirMissatge(menu[i]);
        }
        demanarOpcio();
    }

    static int llegirInt() {
        int n = 0;
        String s;
        boolean isNumeric = false;
        while(!isNumeric){
            s = llegirString();
            try{
                n = Integer.valueOf(s);
                isNumeric = true;
            }catch(Exception e){
                inout.imprimirMissatge("Introdueix un nombre vàlid!!!");
            }
        }
        return n;
    }
    
    static String llegirLinea(){
        sc.nextLine();
        return sc.nextLine();
    }
    

}
