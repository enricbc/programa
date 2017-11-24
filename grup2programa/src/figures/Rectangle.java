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
public class Rectangle extends FiguresAbstract{
    private int base;
    private int altura;
    public Rectangle(String nom1, String tipus1, int base1, int altura1, int eixX1, int eixY1) {
        super(nom1, tipus1, eixX1, eixY1);
        base = base1;
        altura = altura1;
        this.setPerimetre(calcularPerimetre());
        this.setArea(calcularArea());
    }

    public int getBase(){
        return this.base;
    }
    
    public int getAltura(){
        return this.altura;
    }
    
    @Override
    public double calcularArea() {
        return base*altura;
    }

    @Override
    public int calcularPerimetre() {
        return base*2+altura*2;
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
