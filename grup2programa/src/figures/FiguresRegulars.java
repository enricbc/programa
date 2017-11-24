/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figures;

/**
 *
 * @author palatsii06
 */
public abstract class FiguresRegulars extends FiguresAbstract {

    private int base;
    private int altura;
    
    public FiguresRegulars(String nom1, String tipus1,int base1, int eixX1, int eixY1) {
        super(nom1, tipus1, eixX1, eixY1);
        this.base = base1;
        this.altura = calculaAltura(base);
    }

    public int getAltura(){
        return this.altura;
    }
    
    public int getBase(){
        return this.base;
    }
    
    public int calculaAltura(int basetmp){
        double d = (double) basetmp;
        d = d * 1.7320508075 / 2;
        Double returned = d;
        basetmp = returned.intValue();
       return basetmp; 
    }
    
    @Override
    public String toString(){
        String s = "Nom: "+this.getNom()+"\n----------------------\n\n";
        s = s + "Tipus: "+this.getTipus()+"\n----------------------\n\n";
        s = s + "Base: "+this.getBase()+"\n----------------------\n\n";
        s = s + "Altura: "+this.getAltura()+"\n----------------------\n\n";
        s = s + "Punt cèntric: "+this.geteixX()+","+this.geteixY()+"\n----------------------\n\n";
        s = s + "Àrea: "+this.getArea()+"\n----------------------\n\n";
        s = s + "Perímetre: "+this.getPerimetre()+"\n----------------------\n";
        return s;
    }
}
