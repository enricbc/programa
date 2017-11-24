/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figures;

import figures.FiguresAbstract;

/**
 *
 * @author palatsii06
 */
public class FiguraLliure extends FiguresAbstract {
    private int area;
    private int perimetre;
    public FiguraLliure(String nom1, String tipus1, int eixX1, int eixY1, int area1, int perimetre1) {
        super(nom1, tipus1, eixX1, eixY1);
        area = area1;
        perimetre = perimetre1;
        this.setPerimetre(calcularPerimetre());
        this.setArea(calcularArea());
    }

    @Override
    public double calcularArea() {
        return this.area;
    }

    @Override
    public int calcularPerimetre() {
        return this.perimetre;
    }

     @Override
    public String toString(){
        String s = "Nom: "+this.getNom()+"\n----------------------\n\n";
        s = s + "Tipus: "+this.getTipus()+"\n----------------------\n\n";
        s = s + "Punt cèntric: "+this.geteixX()+","+this.geteixY()+"\n----------------------\n\n";
        s = s + "Àrea: "+this.getArea()+"\n----------------------\n\n";
        s = s + "Perímetre: "+this.getPerimetre()+"\n----------------------\n";
        return s;
    }
    
}
