/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedadesalumne;

import com.db4o.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author empis
 */
public class Metodes {
    public static ObjectContainer baseDeDades= Db4o.openFile("C:\\Users\\empis\\base1.yap");
    Alumne a = new Alumne();
    public void tancarConexio (){
        try{
            baseDeDades.close();
        }catch(Exception e){
            System.out.print("error al tancar la conexio");
        }
    }
    public static boolean login (String user, String pass){
        if (user.equals("Enric")&&pass.equals("123456")) {
            return true;
        }else {
            return false;
        }
    }
    public DefaultTableModel consultarAlumnes(){
        
        DefaultTableModel row = new DefaultTableModel();//Model per a la taula dels alumnes
        ArrayList alumnescap = new ArrayList();//ArrayList per a guardar les columnes
        alumnescap.add("DNI");
        alumnescap.add("Nom");
        alumnescap.add("Cognom1");
        alumnescap.add("Cognom2");
        alumnescap.add("Adreça");
        alumnescap.add("Codi postal");
        alumnescap.add("Poblacio");
        for(int i=0; i<alumnescap.size();i++){
                row.addColumn(alumnescap.get(i));
        }
        int e = row.getRowCount()-1;//Agafa el numero de linies menos la primera

        //Esborra totes les linies menos la primera
        for (int i = e; i >= 0; i--) {           
                row.removeRow(row.getRowCount()-1);
        } 
        Alumne a = new Alumne();
        
        ObjectSet result = baseDeDades.get(a);
        String[] dades= new String[baseDeDades.get(a).size()];//array per a guardar les columnes
        
        try{
            
            while(result.hasNext()){
                        System.out.println("While");

                for (int i=0;i<dades.length;i++){
                    System.out.println("For "+i+" dades.length "+dades.length);
                    dades[i]=result.next().toString();
                    String [] prova=dades[i].split(";");
                    row.addRow(prova);
                }            
            }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Error al realizar la conexión "+ex);
        }
        return row;
    }
    public void afegirAlumne(Alumne a){
        System.out.println(a);
        baseDeDades.set(a);
    }
}
