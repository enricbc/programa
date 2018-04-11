/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedadesalumne;

/**
 *
 * @author empis
 */
public class Alumne {
    private String dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String carrer_numero_pis_porta;
    private String codi_postal;
    private String poblacio;
    
    public Alumne(){
        
    }
    
    public Alumne (String dni, String nom, String cognom1, String cognom2, String carrer_numero_pis_porta, String codi_postal, String poblacio){
        this.dni=dni;
        this.nom=nom;
        this.cognom1=cognom1;
        this.cognom2=cognom2;
        this.carrer_numero_pis_porta=carrer_numero_pis_porta;
        this.codi_postal=codi_postal;
        this.poblacio=poblacio;
    }
    public Alumne (String dni, int a){
        if (a==0) {
            this.dni=dni;
        }else{
            this.poblacio=dni;
        }
        
    }
    
    public String toString(){
        return dni+";"+nom+";"+cognom1+";"+cognom2+";"+carrer_numero_pis_porta+";"+codi_postal+";"+poblacio;
    }
    
    public String getPoblacio (){
        return this.poblacio;
    }
}
