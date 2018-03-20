package dataTypes;

public class DtDetalleSueldo {
    private int idEmpleado;
    private int idCliente;
    private int cantidad;
    private float montoUnitario;

    public DtDetalleSueldo(int idEmpleado, int idCliente, int cantidad, float montoUnitario) {
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.montoUnitario = montoUnitario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getMontoUnitario() {
        return montoUnitario;
    }
    
}
