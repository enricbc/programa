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

public class TriangleEquilater extends FiguresRegulars{
    
    public TriangleEquilater(String nom, String tipus, int base, int eixX, int eixY) {
        super(nom, tipus, base, eixX, eixY);
        this.setArea(calcularArea());
        this.setPerimetre(calcularPerimetre());
    }
   
    @Override
    public double calcularArea() {
        return this.getAltura()*this.getBase()/2;
    }

    @Override
    public int calcularPerimetre() {
        return this.getBase()*3;
    }
}
