/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import figures.*;


/**
 *
 * @author palatsii06
 */
public class biblioteca {
    int figures_cim;
    FiguresAbstract[] llista_figs;
    final int FIGURES_MAX = 5;
    
    public biblioteca(){
        figures_cim = 0;
        llista_figs = new FiguresAbstract[FIGURES_MAX];
    }

    void createFig(char llegirOpcio) {
        int base;
        int altura;
        int radi;
        
        inout.imprimirMissatge("Nom: ");
        String nom = inout.llegirLinea();
        inout.imprimirMissatge("eixX: ");
        int eixX = inout.llegirInt();
        inout.imprimirMissatge("eixY: ");
        int eixY = inout.llegirInt();
        
        switch(llegirOpcio){
            case '1':
                inout.imprimirMissatge("Radi: ");
                radi = inout.llegirInt();
                llista_figs[figures_cim] = new Cercle(nom,"Cercle",radi,eixX,eixY);
                figures_cim++;
                break;
            case '2':
                inout.imprimirMissatge("Base: ");
                base = inout.llegirInt();
                llista_figs[figures_cim] = new TriangleEquilater(nom,"Triangle Equilàter",base,eixX,eixY);
                figures_cim++;
                break;
            case '3':
                inout.imprimirMissatge("Costat: ");
                base = inout.llegirInt();
                llista_figs[figures_cim] = new Quadrat(nom,"Quadrat",base,eixX,eixY);
                figures_cim++;
                break;
            case '4':
                inout.imprimirMissatge("Base: ");
                base = inout.llegirInt();
                llista_figs[figures_cim] = new Hexagon(nom,"Hexàgon",base,eixX,eixY);
                figures_cim++;
                break;
            case '5':
                inout.imprimirMissatge("Base: ");
                base = inout.llegirInt();
                inout.imprimirMissatge("Altura: ");
                altura = inout.llegirInt();
                llista_figs[figures_cim] = new Rectangle(nom,"Rectangle",base,altura,eixX,eixY);
                figures_cim++;
                break;
            case '6':
                inout.imprimirMissatge("Base: ");
                base = inout.llegirInt();
                inout.imprimirMissatge("Altura: ");
                altura = inout.llegirInt();
                llista_figs[figures_cim] = new TriangleRectangle(nom,"Triangle Rectangle",base,altura,eixX,eixY);
                figures_cim++;
                break;
            case '7':
                inout.imprimirMissatge("Area: ");
                altura = inout.llegirInt();
                inout.imprimirMissatge("Perimetre: ");
                base = inout.llegirInt();
                llista_figs[figures_cim]= new FiguraLliure(nom,"Figura Lliure",eixX,eixY,altura,base);
                figures_cim++;
                break;
            default:
                inout.imprimirMissatge("Opció incorrecta!!!");
                break;
        }
    }
    
    void llistarFigs(){
        inout.imprimirMissatge("ID\tNom\t\tTipus");
        for(int i = 0; i < figures_cim;i++){
            inout.imprimirMissatge((i+1) + "\t" + llista_figs[i].getNom() + "\t\t" + llista_figs[i].getTipus());
        }
    }
     
    void mostraFigura(char llegirOpcio) {
        if(Character.isDigit(llegirOpcio)){
            int id = Character.getNumericValue(llegirOpcio);
            id--;
            if(id < figures_cim){
               inout.imprimirMissatge(llista_figs[id].toString());
            }else{
                inout.imprimirMissatge("No hi ha figura amb aquest ID!!");
            }
        }else{
            inout.imprimirMissatge("Opció incorrecta!!");
        }
        inout.esperarEnter();
    }

    void esSolapen(int pos1, int pos2) {
        if(llista_figs[pos1-1].esSolapen(llista_figs[pos2-1]) == true){
            inout.imprimirMissatge("Les dos figures es solapen!");
            inout.esperarEnter();
        }else{
            inout.imprimirMissatge("Les dos figures no es solapen!");
            inout.esperarEnter();
        }
    }
}
