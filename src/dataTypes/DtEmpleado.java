/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTypes;

public class DtEmpleado {
    private String nombre;
    private String telefono;
    private String ci;
    private String direccion;
    private int id;
    
    public DtEmpleado(int id, String nom, String tel, String dir, String ci){
        this.id = id;
        nombre = nom;
        telefono = tel;
        direccion = dir;
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId(){
        return id;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String getCi() {
        return ci;
    }

    public String getDireccion() {
        return direccion;
    }
    
}
