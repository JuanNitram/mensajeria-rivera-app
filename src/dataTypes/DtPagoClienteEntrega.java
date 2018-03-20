package dataTypes;

public class DtPagoClienteEntrega {
    private String nombreEmpleado;
    private String nombreCliente;
    private int idEmpleado;
    private int idCliente;
    private float monto;
    
    public DtPagoClienteEntrega(int idEmpleado,int idCliente,String nomEmp, String nomCli, float monto){
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        nombreEmpleado = nomEmp;
        nombreCliente = nomCli;
        this.monto = monto;
    }
    
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public float getMonto() {
        return monto;
    }
    
    public int getIdEmpleado(){
        return idEmpleado;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
}
