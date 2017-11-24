/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author palatsii06
 */
public class main {
    public static void main(String[] args){
        main principi = new main();
        principi.start();
    }
    
    public void start(){
        inout io = new inout();
        biblioteca media = new biblioteca();
        char opcio;
        do{
            inout.imprimirMissatge("Actualment hi han "+media.figures_cim+"/"+(media.FIGURES_MAX)+" figures al sistema");
            inout.imprimirMenu(inout.menu_princ);
            switch(opcio = inout.llegirOpcio()){
                case '1':
                    if(media.figures_cim == media.FIGURES_MAX){
                        inout.imprimirMissatge("La memòria de figures esta plena\n");
                    }else{
                        inout.imprimirMenu(inout.introduir_fig);
                        media.createFig(inout.llegirOpcio());
                        inout.esperarEnter();
                    }
                    break;
                case '2':
                    if(media.figures_cim > 0){
                        media.llistarFigs();
                        inout.imprimirMissatge("ID de la figura:");
                        media.mostraFigura(inout.llegirOpcio());
                    }else{
                        inout.imprimirMissatge("No hi ha figures guardades!!!");
                    }  
                    break;
                case '3':
                    media.llistarFigs();
                    inout.imprimirMissatge("Tria 2 figures diferents: ");
                    int pos1 = inout.llegirInt();
                    int pos2 = inout.llegirInt();
                    media.esSolapen(pos1,pos2);
                    break;
                case '4':
                    inout.imprimirMissatge("Heu sortit del programa!");
                    break;
                default:
                    inout.imprimirMissatge("****Opció no disponible****");
            }
        }while(opcio != '4');
    }
}
