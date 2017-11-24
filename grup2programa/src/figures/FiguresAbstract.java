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
public abstract class FiguresAbstract implements Figures {
    private String nom;
    private String tipus;
    private int perimetre;
    private double area;
    private int eixX;
    private int eixY;
    
    public FiguresAbstract (String nom1, String tipus1, int eixX1, int eixY1){
        this.nom = nom1;
        this.tipus = tipus1;
        this.eixX = eixX1;
        this.eixY = eixY1;
    }
    
    public boolean esSolapen(FiguresAbstract a){
        boolean colisionen;
        double distX = a.geteixX()-this.eixX;
        double distY = a.geteixY()-this.eixY;
        double distTotal = Math.sqrt(distY+distX);
        if(distTotal < 1 || Double.isNaN(distTotal)){
            colisionen = true;
        }else{
            colisionen = false;
        }
        return colisionen;
    }


    public String getNom(){
        return this.nom;
    }
    public String getTipus(){
        return this.tipus;
    }
    public int geteixX(){
        return this.eixX;
    }
    public int geteixY(){
        return this.eixY;
    }    
    public double getArea(){
        return this.area;
    }
    public int getPerimetre(){
        return this.perimetre;
    }
    
    public void setPerimetre(int i){
        perimetre = i;
    }
    
    public void setArea(double i){
        area = i;
    }
}
