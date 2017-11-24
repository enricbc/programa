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
public class Quadrat extends FiguresRegulars{

    public Quadrat(String nom1, String tipus1, int base1, int eixX1, int eixY1) {
        super(nom1, tipus1, base1, eixX1, eixY1);
    }
    
    @Override
    public int calculaAltura(int basetmp){
        return basetmp;
    }

    @Override
    public double calcularArea() {
        return this.getBase()*this.getBase();
    }

    @Override
    public int calcularPerimetre() {
        return this.getBase()*4;
    }
}
