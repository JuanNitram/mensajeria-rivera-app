package dataTypes;

import java.util.Date;

public class DtEntrega {
    private String nombreEmpleado;
    private String nombreCliente;
    private int idEmpleado;
    private int idCliente;
    private int cantidad;
    private String fechaVenc;
    private String fechaRecogida;

    public DtEntrega(String nombreEmpleado, String nombreCliente,int idEmpleado,int idCliente, int cantidad, String fechaVenc, String fechaRecogida) {
        this.nombreEmpleado = nombreEmpleado;
        this.nombreCliente = nombreCliente;
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.fechaVenc = fechaVenc;
        this.fechaRecogida = fechaRecogida;
    }
    
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFechaVenc() {
        return fechaVenc;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }
    
    public int getIdCliente(){
        return this.idCliente;
    }
    
    public int getIdEmpleado(){
        return this.idEmpleado;
    }
    
}
