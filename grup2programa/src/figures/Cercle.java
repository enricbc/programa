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
public class Cercle extends FiguresAbstract {
    private int radi;
    
    public Cercle(String nom1, String tipus1, int radi1, int eixX1, int eixY1) {
        super(nom1, tipus1, eixX1, eixY1);
        radi = radi1;
        this.setArea(calcularArea());
        this.setPerimetre(calcularPerimetre());
    }

    public int getRadi(){
        return radi;
    }
    @Override
    public double calcularArea() {
        double area=Math.PI*(Math.pow(radi, 2));
        return area;
    }

    @Override
    public int calcularPerimetre() {
        double perimetre = 2*Math.PI*radi;
        int a=(int)perimetre;
        return a;
    }    
    
    @Override
    public String toString(){
        String s = "Nom: "+this.getNom()+"\n----------------------\n\n";
        s = s + "Tipus: "+this.getTipus()+"\n----------------------\n\n";
        s = s + "Radi: "+this.getRadi()+"\n----------------------\n\n";
        s = s + "Punt cèntric: "+this.geteixX()+","+this.geteixY()+"\n----------------------\n\n";
        s = s + "Àrea: "+this.getArea()+"\n----------------------\n\n";
        s = s + "Perímetre: "+this.getPerimetre()+"\n----------------------\n";
        return s;
    }
}
