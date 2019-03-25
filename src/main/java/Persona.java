
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.FileOutputStream;
import java.util.HashMap;
/**
 *
 * @author lizeth
 */
public class Persona implements Serializable {
    private int codigo;
    private String nombre;
    private HashMap<Integer,Persona> reportes;
    // Constructor
    public Persona(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        reportes = new HashMap<>();
    }
    
    // Metodos Getters
    public String getNombre() {
        return nombre;
    }
    
    public HashMap<Integer, Persona> getReportes() {
        return reportes;
    }
}
