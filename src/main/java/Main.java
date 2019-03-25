import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lizeth
 */

/**
 * Utilizaremos las librerias FileOutputStrem y ObjectOutputStrem.
 * Creamos una clase persona y un mapa para crear los reportes de la clase padre.
 * Crearemos un fichero txt para guardar la información del mapa persona.
 */
public class Main {
    
    public static void main(String[] args){
        
        HashMap<Integer, Persona> reportes;
        // Objeto Persona. Datos a guardar en el documento txt.
        FileOutputStream txt = null;
        
        //borrarDatos();

        try {
            // Se crea el mapa de cada persona, con su nombre y apellido, la empresa, estado y valor.
            reportes = new HashMap<>();
            Persona pJuanG = new Persona(1, "Juan Gomez");
            reportes.put(1, pJuanG);
            reportes.put(2, new Persona(2, "Jose Veloz"));
            reportes.put(3, new Persona(3, "Diana Gonzalez"));
            
            //Reportes
            //Empresa
            Persona empJuan = new Persona(4, "Yambal");
            Persona empJose = new Persona(5, "Corona");
            Persona empDiana = new Persona(6, "Postobon");
            reportes.get(1).getReportes().put(4, empJuan);
            reportes.get(2).getReportes().put(5, empJose);
            reportes.get(3).getReportes().put(6, empDiana);
            
            //Estado
            Persona estadoJuan = new Persona(7, "Activo");
            Persona estadoJose = new Persona(8, "Activo");
            Persona estadoDiana = new Persona(9, "Activo");
            reportes.get(1).getReportes().get(4).getReportes().put(7, estadoJuan);
            reportes.get(2).getReportes().get(5).getReportes().put(8, estadoJose);
            reportes.get(3).getReportes().get(6).getReportes().put(9, estadoDiana);
            
            //Valor
            Persona valorJuan = new Persona(10, "500000");
            Persona valorJose = new Persona(11, "1234000");
            Persona valorDiana = new Persona(12, "6540000");
            reportes.get(1).getReportes().get(4).getReportes().get(7).getReportes().put(10, valorJuan);
            reportes.get(2).getReportes().get(5).getReportes().get(8).getReportes().put(11, valorJose);
            reportes.get(3).getReportes().get(6).getReportes().get(9).getReportes().put(12, valorDiana);
            
            txt = new FileOutputStream("Registros.txt");
            //ObjectOutputStream datos = new ObjectOutputStream(txt);
            PrintStream datos = new PrintStream(txt);
            
            for (Integer keyPersona : reportes.keySet()){
               Persona pPersona = reportes.get(keyPersona);
               //datos.writeObject(pPersona.getNombre());
               datos.println(pPersona.getNombre());
               for (Integer keyReporte : pPersona.getReportes().keySet()){
                    Persona pReporte = pPersona.getReportes().get(keyReporte);
                    //datos.writeObject("          "+pReporte.getNombre());
                    datos.println("          "+pReporte.getNombre());
                    for (Integer keyEstado : pReporte.getReportes().keySet()){
                        Persona pEstado = pReporte.getReportes().get(keyEstado);
                        //datos.writeObject("                   "+pEstado.getNombre());
                        datos.println("                   "+pEstado.getNombre());
                        for (Integer keyValor : pEstado.getReportes().keySet()){
                        Persona pValor = pEstado.getReportes().get(keyValor);
                        //datos.writeObject("                            "+pValor.getNombre());
                        datos.println("                            "+pValor.getNombre());
                    }
                    }
                }
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                txt.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    /** Borrar datos del documento txt.
    public static void borrarDatos(){
        
        File txt = new File("Registros.txt");
        try {
            if(txt.exists()){
                txt.delete();
                System.out.println("Fichero Borrado");
            }
        } catch (Exception ex){
        }
    }
    **/
}
 