package dataTypes;

public class DtSueldo {
    private int idEmpleado;
    private int idSueldo;
    private float monto;
    private String fechaCierre;
    private String fechaApertura;
    private String nomEmpleado;

    public DtSueldo(int idSueldo,int idEmpleado,String nomEmpleado, float monto, String fechaCierre, String fechaApertura) {
        this.idEmpleado = idEmpleado;
        this.monto = monto;
        this.fechaCierre = fechaCierre;
        this.fechaApertura = fechaApertura;
        this.nomEmpleado = nomEmpleado;
        this.idSueldo = idSueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
    
    public int getIdSueldo(){
        return idSueldo;
    }

    public float getMonto() {
        return monto;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }
    
    public String getNombreEmpleado(){
        return nomEmpleado;
    }
}
