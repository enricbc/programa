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
public class TriangleRectangle extends FiguresAbstract{
    private int base;
    private int altura;
    
    public TriangleRectangle(String nom1, String tipus1, int base1, int altura1, int eixX1, int eixY1) {
        super(nom1, tipus1, eixX1, eixY1);
        this.base = base1;
        this.altura = altura1;
        this.setArea(calcularArea());
        this.setPerimetre(calcularPerimetre());
    }

    @Override
    public double calcularArea() {
        double area=(base*altura)/2;
        return area;
    }

    @Override
    public int calcularPerimetre() {
        double perimetre=(Math.pow(base, 2)+Math.pow(altura, 2));
        perimetre=Math.sqrt(perimetre);
        return (int)perimetre;
    }
}
