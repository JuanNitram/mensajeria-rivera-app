package controllers;

import dataTypes.DtCliente;
import dataTypes.DtEmpleado;
import dataTypes.DtEntrega;
import dataTypes.DtPagoClienteEntrega;
import dataTypes.DtSueldo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IOperations {
    
    List<DtEmpleado> getEmpleados() throws SQLException;
    
    List<DtCliente> getClientes() throws SQLException;
    
    void altaEmpleado(DtEmpleado dtE) throws SQLException;
    
    void altaCliente(DtCliente dtC) throws SQLException;
    
    DtEmpleado getInfoEmpleado(int id) throws SQLException;
    
    List<DtPagoClienteEntrega> getPagoCliente(String empleadoID) throws SQLException;
    
    void altaPagoClienteEntrega(DtPagoClienteEntrega dtP) throws SQLException;
    
    List<DtEntrega> getEntregas() throws SQLException;
    
    void altaEntrega(DtEntrega dtE) throws SQLException;
    
    List<DtEntrega> filtrarEntregas(boolean iSelectedEmpleado, boolean iSelectedCliente, boolean iSelectedRango, int idEmpleado, int idCliente, String fechaIni, String fechaFin) throws SQLException;
    
    List<DtSueldo> getSueldos() throws SQLException;
    
    void calcularSueldos(String fechaApertura, String fechaCierre) throws SQLException;
    
    List<DtSueldo> getSueldosEmpleado(int idEmpleado) throws SQLException;
    
    List<DtSueldo> filtrarSueldos(boolean isSelectedEmpleado, boolean isSelectedRangoFecha, boolean isSelectedRangoSueldos,int idEmpleado,String fechaIni,String fechaFin,float sueldoIni, float sueldoFin) throws SQLException;
    
    void generarFactura(int idEmpleado, int idSueldo,String monto,String nomEmpleado,String fechaApertura, String fechaCierre) throws SQLException;

    void actualizarPagoCliente(int idCliente, int idEmpleado, float nuevoMonto) throws SQLException;
}
