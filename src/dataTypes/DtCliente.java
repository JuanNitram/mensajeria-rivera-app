/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTypes;

/**
 *
 * @author Juan Martin
 */
public class DtCliente {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    
    public DtCliente(int id,String nom, String tel, String dir){
        this.id = id;
        nombre = nom;
        telefono = tel;
        direccion = dir;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public int getId(){
        return id;
    }
    
}
