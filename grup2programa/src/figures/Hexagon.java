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
public class Hexagon extends FiguresRegulars{

    public Hexagon(String nom1, String tipus1, int base1, int eixX1, int eixY1) {
        super(nom1, tipus1, base1, eixX1, eixY1);
        this.setPerimetre(calcularPerimetre());
        this.setArea(calcularArea());
    }

    @Override
    public double calcularArea() {
        return this.getAltura()*this.getPerimetre()/2;
    }

    @Override
    public int getBase() {
        return super.getBase();
    }

    @Override
    public int calcularPerimetre() {
        return this.getBase()*6;
    }     
    
    @Override
    public String toString(){
        String s = "Nom: "+this.getNom()+"\n----------------------\n\n";
        s = s + "Tipus: "+this.getTipus()+"\n----------------------\n\n";
        s = s + "Base: "+this.getBase()+"\n----------------------\n\n";
        s = s + "Apotema: "+this.getAltura()+"\n----------------------\n\n";
        s = s + "Punt cèntric: "+this.geteixX()+","+this.geteixY()+"\n----------------------\n\n";
        s = s + "Àrea: "+this.getArea()+"\n----------------------\n\n";
        s = s + "Perímetre: "+this.getPerimetre()+"\n----------------------\n";
        return s;
    }
}
