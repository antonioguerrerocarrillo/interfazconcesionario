/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcrud;

//import interfazcrud.Coche;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
public class EscribirCoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        ArrayList<Coche> coches = new ArrayList<Coche>();
        File fichero = new File("C:\\tmp\\FicheCoche.dat");
        FileOutputStream fileout = new FileOutputStream (fichero);
        ObjectOutputStream dataOS = new  ObjectOutputStream(fileout);
                
        Coche seat =  new Coche();
        seat.setNombre("seat");
        seat.setModelo("arona");
        seat.setIdentificador(1200);
        
        Coche opel =  new Coche();
        opel.setNombre("opel");
        opel.setModelo("calibra");
        opel.setIdentificador(1211);
        
        Coche audi =  new Coche();
        audi.setNombre("audi");
        audi.setModelo("s1");
        audi.setIdentificador(1911);
        
        coches.add(seat); //añado objeto coche al arraylist.
        coches.add(opel);
        coches.add(audi);
        
       try{
            dataOS.writeObject(seat);//guarda en el fichero el vector
           // dataOS.flush();//lo hace si o si
            dataOS.close();//lo cierra
            System.out.println("Coches guardados correctamente en fichero");
        } catch (FileNotFoundException f) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
            
        dataOS.close();
   }

}
