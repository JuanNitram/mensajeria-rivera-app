package controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.MysqlConnect;
import dataTypes.DtCliente;
import dataTypes.DtDetalleSueldo;
import dataTypes.DtEmpleado;
import dataTypes.DtEntrega;
import dataTypes.DtPagoClienteEntrega;
import dataTypes.DtSueldo;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlOperations implements IOperations {

    private static final CtrlOperations instance = new CtrlOperations();

    public static CtrlOperations getInstance() {
        return instance;
    }

    public List<DtEmpleado> getEmpleados() throws SQLException {
        ArrayList<DtEmpleado> res = new ArrayList<DtEmpleado>();
        String query = "select * from empleados";
        ResultSet result = null;
        result = MysqlConnect.getDbCon().query(query);

        while (result.next()) {
            String nombre = result.getString("NOMBRE");
            String telefono = result.getString("TELEFONO");
            String direccion = result.getString("DIRECCION");
            String ci = result.getString("CI");
            String id = result.getString("ID");
            DtEmpleado dtC = new DtEmpleado(Integer.parseInt(id), nombre, telefono, direccion, ci);
            res.add(dtC);
        }
        return res;
    }

    public List<DtCliente> getClientes() throws SQLException {
        ArrayList<DtCliente> res = new ArrayList<DtCliente>();
        String query = "select * from clientes";
        ResultSet result = null;

        result = MysqlConnect.getDbCon().query(query);
        while (result.next()) {
            String nombre = result.getString("NOMBRE");
            String telefono = result.getString("TELEFONO");
            String direccion = result.getString("DIRECCION");
            String id = result.getString("ID");
            DtCliente dtC = new DtCliente(Integer.parseInt(id), nombre, telefono, direccion);
            res.add(dtC);
        }
        return res;
    }

    public void altaEmpleado(DtEmpleado dtE) throws SQLException {
        String nombre = dtE.getNombre();
        String telefono = dtE.getTelefono();
        String direccion = dtE.getDireccion();
        String ci = dtE.getCi();
        String query = " insert into empleados (NOMBRE, CI, DIRECCION, TELEFONO)" + " values ('" + nombre.trim().toUpperCase() + "','" + telefono.trim().toUpperCase() + "','" + direccion.trim().toUpperCase() + "','" + ci.trim().toUpperCase() + "')";
        MysqlConnect.getDbCon().execute(query);
    }

    public void altaCliente(DtCliente dtC) throws SQLException {
        String nombre = dtC.getNombre();
        String telefono = dtC.getTelefono();
        String direccion = dtC.getDireccion();
        String query = "insert into clientes (NOMBRE,TELEFONO,DIRECCION)" + "values('" + nombre.trim().toUpperCase() + "','" + telefono.trim().toUpperCase() + "','" + direccion.trim().toUpperCase() + "')";
        MysqlConnect.getDbCon().execute(query);
    }

    public DtEmpleado getInfoEmpleado(int id) throws SQLException {
        DtEmpleado res = null;
        String query = "select * from empleados where id ='" + id + "'";
        ResultSet rs = MysqlConnect.getDbCon().query(query);
        if (rs.next()) {
            res = new DtEmpleado(Integer.parseInt(rs.getString("ID").trim()), rs.getString("NOMBRE"), rs.getString("TELEFONO"), rs.getString("DIRECCION"), rs.getString("CI"));
        }
        return res;
    }

    public List<DtPagoClienteEntrega> getPagoCliente(String empleadoID) throws SQLException {
        ArrayList<DtPagoClienteEntrega> res = new ArrayList<DtPagoClienteEntrega>();
        String query = "select  e.id idEmpleado,e.nombre nombre, c.id idCliente, c.nombre cliente,monto_unidad from pago_cliente result "
                + "inner join empleados e on result.ID_EMPLEADO = e.ID "
                + "inner join clientes c on result.ID_CLIENTE = c.ID "
                + "where e.id ='" + empleadoID + "'";
        ResultSet rs = MysqlConnect.getDbCon().query(query);
        while (rs.next()) {
            String nombreEmpleado = rs.getString("nombre");
            String nombreCliente = rs.getString("cliente");
            float monto = Float.parseFloat(rs.getString("monto_unidad"));
            int idCliente = Integer.parseInt(rs.getString("idCliente"));
            int idEmpleado = Integer.parseInt(rs.getString("idEmpleado"));
            res.add(new DtPagoClienteEntrega(idEmpleado, idCliente, nombreEmpleado, nombreCliente, monto));
        }
        return res;
    }

    public void altaPagoClienteEntrega(DtPagoClienteEntrega dtP) throws SQLException {
        int idEmpleado = dtP.getIdEmpleado();
        int idCliente = dtP.getIdCliente();
        float monto = dtP.getMonto();
        String query = "insert into pago_cliente (ID_EMPLEADO,ID_CLIENTE,MONTO_UNIDAD) values('" + idEmpleado + "','" + idCliente + "','" + monto + "')";
        MysqlConnect.getDbCon().execute(query);
    }

    public List<DtEntrega> getEntregas() throws SQLException {
        ArrayList<DtEntrega> res = new ArrayList<DtEntrega>();
        String query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                + " from entregas result"
                + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                + " inner join clientes c on result.ID_CLIENTE = c.ID"
                + " order by fecha_levante DESC";
        ResultSet rs = MysqlConnect.getDbCon().query(query);
        while (rs.next()) {
            String nomEmpleado = rs.getString("nomEmpleado");
            String nomCliente = rs.getString("nomCliente");
            String cantidad = rs.getString("cantidad");
            String fechaLevante = rs.getString("fecha_levante");
            String fechaVencimiento = rs.getString("fecha_vencimiento");
            String partsLevante[] = fechaLevante.split("-");
            String partsVencimiento[] = fechaLevante.split("-");
            res.add(new DtEntrega(nomEmpleado, nomCliente, 0, 0, Integer.parseInt(cantidad), fechaVencimiento, fechaLevante));
        }
        return res;
    }

    public void altaEntrega(DtEntrega dtE) throws SQLException {
        int idEmpleado = dtE.getIdEmpleado();
        int idCliente = dtE.getIdCliente();
        int cantidad = dtE.getCantidad();
        String fechaVencimiento = dtE.getFechaVenc();
        String fechaRecogida = dtE.getFechaRecogida();
        String query = "insert into entregas (ID_EMPLEADO,ID_CLIENTE,CANTIDAD,FECHA_LEVANTE,FECHA_VENCIMIENTO)" + "values('" + idEmpleado + "','" + idCliente + "','" + cantidad + "','" + fechaRecogida + "','" + fechaVencimiento + "')";
        MysqlConnect.getDbCon().execute(query);
    }

    public List<DtEntrega> filtrarEntregas(boolean iSelectedEmpleado, boolean iSelectedCliente, boolean iSelectedRango, int idEmpleado, int idCliente, String fechaIni, String fechaFin) throws SQLException {
        ArrayList<DtEntrega> res = new ArrayList<DtEntrega>();

        String query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                + " from entregas result"
                + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                + " inner join clientes c on result.ID_CLIENTE = c.ID"
                + " order by fecha_levante DESC";

        if (iSelectedEmpleado && !iSelectedCliente && !iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where result.ID_EMPLEADO = '" + idEmpleado + "'"
                    + " order by fecha_levante DESC";
        } else if (!iSelectedEmpleado && iSelectedCliente && !iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where result.ID_CLIENTE = '" + idCliente + "'"
                    + " order by fecha_levante DESC";
        } else if (!iSelectedEmpleado && !iSelectedCliente && iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where fecha_levante between '" + fechaIni + "' and '" + fechaFin + "'"
                    + " order by fecha_levante DESC";
        } else if (iSelectedEmpleado && iSelectedCliente && !iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where result.ID_EMPLEADO = '" + idEmpleado + "' and result.ID_CLIENTE = '" + idCliente + "'"
                    + " order by fecha_levante DESC";
        } else if (iSelectedEmpleado && !iSelectedCliente && iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente, cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where (result.ID_EMPLEADO = '" + idEmpleado + "') and (fecha_levante between '" + fechaIni + "' and '" + fechaFin + "')"
                    + " order by fecha_levante DESC";
        } else if (iSelectedEmpleado && iSelectedCliente && iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where ( result.id_empleado = '" + idEmpleado + "' and result.ID_CLIENTE = '" + idCliente + "' ) and fecha_levante between '" + fechaIni + "' and '" + fechaFin + "'"
                    + " order by fecha_levante DESC";
        } else if (!iSelectedEmpleado && iSelectedCliente && iSelectedRango) {
            query = "select e.nombre nomEmpleado,c.nombre nomCliente,cantidad,fecha_levante,fecha_vencimiento"
                    + " from entregas result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join clientes c on result.ID_CLIENTE = c.ID"
                    + " where ( result.ID_CLIENTE = '" + idCliente + "' ) and fecha_levante between '" + fechaIni + "' and '" + fechaFin + "'"
                    + " order by fecha_levante DESC";
        }

        ResultSet rs = MysqlConnect.getDbCon().query(query);

        while (rs.next()) {
            String nomEmpleado = rs.getString("nomEmpleado");
            String nomCliente = rs.getString("nomCliente");
            String cantidad = rs.getString("cantidad");
            String fechaLevante = rs.getString("fecha_levante");
            String fechaVencimiento = rs.getString("fecha_vencimiento");
            String partsLevante[] = fechaLevante.split("-");
            String partsVencimiento[] = fechaLevante.split("-");
            res.add(new DtEntrega(nomEmpleado, nomCliente, 0, 0, Integer.parseInt(cantidad), fechaVencimiento, fechaLevante));
        }

        return res;
    }

    public List<DtSueldo> getSueldos() throws SQLException {
        ArrayList<DtSueldo> res = new ArrayList<DtSueldo>();
        String query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO";
        ResultSet result = null;
        result = MysqlConnect.getDbCon().query(query);
        while (result.next()) {
            String monto = result.getString("MONTO").trim();
            String fechaCierre = result.getString("FECHA_CIERRE").trim();
            String fechaApertura = result.getString("FECHA_APERTURA").trim();
            String nomEmpleado = result.getString("nom_empleado");
            String idEmpleado = result.getString("ID_EMPLEADO").trim();
            String id = result.getString("ID").trim();
            DtSueldo dtS = new DtSueldo(Integer.parseInt(id), Integer.parseInt(idEmpleado), nomEmpleado, Float.parseFloat(monto), fechaCierre, fechaApertura);
            res.add(dtS);
        }
        return res;
    }

    private void limpiarSueldos(String fechaApertura, String fechaCierre) throws SQLException {
        String sueldosQuery = "select * from sueldos where fecha_apertura = '" + fechaApertura + "' and fecha_cierre = '" + fechaCierre + "'";
        ResultSet rsSueldos = MysqlConnect.getDbCon().query(sueldosQuery);
        while (rsSueldos.next()) {
            int idSueldo = Integer.parseInt(rsSueldos.getString("id"));
            String eliminarQuery = "delete from detalle_sueldo where id_sueldo = " + idSueldo;
            String eliminarSueldosQuery = "delete from sueldos where id = " + idSueldo;
            MysqlConnect.getDbCon().execute(eliminarQuery);
            MysqlConnect.getDbCon().execute(eliminarSueldosQuery);
        }

    }

    public void calcularSueldos(String fechaApertura, String fechaCierre) throws SQLException {
        limpiarSueldos(fechaApertura, fechaCierre);
        String queryEmpleados = "select * from empleados";
        ResultSet rsEmpleados = MysqlConnect.getDbCon().query(queryEmpleados);
        String queryClientes = "select * from clientes";
        while (rsEmpleados.next()) {
            int idEmpleado = Integer.parseInt(rsEmpleados.getString("ID").trim());
            ResultSet rsClientes = MysqlConnect.getDbCon().query(queryClientes);
            float totalSueldo = 0;
            int sumaCantidad = 0;
            List<DtDetalleSueldo> detalles = new ArrayList<DtDetalleSueldo>();
            while (rsClientes.next()) {

                int idCliente = Integer.parseInt(rsClientes.getString("ID"));
                String queryEntregasCliente = "select * from entregas where ID_CLIENTE = '" + idCliente + "' and ID_EMPLEADO = '" + idEmpleado + "' and FECHA_LEVANTE between '" + fechaApertura + "' and '" + fechaCierre + "'";
                ResultSet rsEntregasCliente = MysqlConnect.getDbCon().query(queryEntregasCliente);
                sumaCantidad = 0;

                while (rsEntregasCliente.next()) {
                    sumaCantidad = sumaCantidad + Integer.parseInt(rsEntregasCliente.getString("CANTIDAD"));
                }

                String queryPagoCliente = "select * from pago_cliente where ID_CLIENTE = '" + idCliente + "' and ID_EMPLEADO = '" + idEmpleado + "'";
                ResultSet rsPagoCliente = MysqlConnect.getDbCon().query(queryPagoCliente);
                if (rsPagoCliente.next()) {
                    float precioClienteEmpleado = Float.parseFloat(rsPagoCliente.getString("MONTO_UNIDAD"));
                    float totalEntrega = precioClienteEmpleado * sumaCantidad;
                    totalSueldo = totalSueldo + totalEntrega;
                    DtDetalleSueldo nuevo = new DtDetalleSueldo(idEmpleado, idCliente, sumaCantidad, precioClienteEmpleado);
                    detalles.add(nuevo);
                }
            }

            String insertQuery = "insert into sueldos (ID_EMPLEADO, MONTO, FECHA_APERTURA,FECHA_CIERRE) values ('" + idEmpleado + "','" + totalSueldo + "','" + fechaApertura + "','" + fechaCierre + "')";
            MysqlConnect.getDbCon().execute(insertQuery);
            String querySueldo = "select id from sueldos where ID_EMPLEADO = '" + idEmpleado + "' and FECHA_APERTURA = '" + fechaApertura + "' and FECHA_CIERRE = '" + fechaCierre + "'";
            ResultSet rsSueldo = MysqlConnect.getDbCon().query(querySueldo);
            String idSueldo = "";
            if (rsSueldo.next()) {
                idSueldo = rsSueldo.getString("ID").trim();
            }

            for (int i = 0; i < detalles.size(); i++) {
                String insertDetalle = "insert into detalle_sueldo (ID_EMPLEADO,ID_CLIENTE,ID_SUELDO,CANTIDAD,MONTO_UNITARIO) values ('" + detalles.get(i).getIdEmpleado() + "','"
                        + detalles.get(i).getIdCliente() + "','" + idSueldo + "','" + detalles.get(i).getCantidad() + "','" + detalles.get(i).getMontoUnitario() + "')";
                MysqlConnect.getDbCon().execute(insertDetalle);
            }
        }
    }

    public List<DtSueldo> getSueldosEmpleado(int idEmpleado) throws SQLException {
        ArrayList<DtSueldo> res = new ArrayList<DtSueldo>();
        String query = "select e.nombre nomEmpleado,monto,fecha_apertura, fecha_cierre from sueldos result"
                + " inner join empleados e on result.id_empleado = e.ID"
                + " where ID_EMPLEADO = '" + idEmpleado + "'";
        ResultSet result = MysqlConnect.getDbCon().query(query);
        while (result.next()) {
            String monto = result.getString("MONTO").trim();
            String fechaCierre = result.getString("FECHA_CIERRE").trim();
            String fechaApertura = result.getString("FECHA_APERTURA").trim();
            String nomEmpleado = result.getString("nomEmpleado").trim();
            DtSueldo dtS = new DtSueldo(0, 0, nomEmpleado, Float.parseFloat(monto), fechaCierre, fechaApertura);
            res.add(dtS);
        }
        return res;
    }

    public List<DtSueldo> filtrarSueldos(boolean isSelectedEmpleado, boolean isSelectedRangoFecha, boolean isSelectedRangoSueldos, int idEmpleado, String fechaIni, String fechaFin, float sueldoIni, float sueldoFin) throws SQLException {
        ArrayList<DtSueldo> res = new ArrayList<DtSueldo>();

        String query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO";
        if (isSelectedEmpleado && !isSelectedRangoFecha && !isSelectedRangoSueldos) {
            query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO"
                    + " where result.ID_EMPLEADO = '" + idEmpleado + "'";
        } else if (isSelectedEmpleado && !isSelectedRangoFecha && isSelectedRangoSueldos) {
            query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO"
                    + " where result.ID_EMPLEADO = '" + idEmpleado + "'"
                    + " and ( s.fecha_apertura = '" + fechaIni + "' and s.fecha_cierre = '" + fechaFin + "')";
        } else if (isSelectedEmpleado && isSelectedRangoFecha && !isSelectedRangoSueldos) {
            query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO"
                    + " where result.ID_EMPLEADO = '" + idEmpleado + "'"
                    + " and ( s.fecha_apertura = '" + fechaIni + "' and s.fecha_cierre = '" + fechaFin + "')";
                System.out.println(query);
        } else if (isSelectedEmpleado && isSelectedRangoFecha && isSelectedRangoSueldos) {
            query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO"
                    + " where result.ID_EMPLEADO = '" + idEmpleado + "'"
                    + " and ( s.fecha_apertura = '" + fechaIni + "' and s.fecha_cierre = '" + fechaFin + "')"
                    + " and (s.monto between " + sueldoIni + " and " + sueldoFin + ")";
        } else if (!isSelectedEmpleado && isSelectedRangoFecha && isSelectedRangoSueldos) {
            query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO"
                    + " where ( s.fecha_apertura = '" + fechaIni + "' and s.fecha_cierre = '" + fechaFin + "')"
                    + " and (s.monto between " + sueldoIni + " and " + sueldoFin + ")";
        } else if (!isSelectedEmpleado && isSelectedRangoFecha && !isSelectedRangoSueldos) {
            query = "select distinct s.id,e.nombre nom_empleado, s.id_empleado, s.monto, s.fecha_apertura, s.fecha_cierre from sueldos result"
                    + " inner join empleados e on result.ID_EMPLEADO = e.ID"
                    + " inner join sueldos s on result.ID_EMPLEADO = s.ID_EMPLEADO"
                    + " where ( s.fecha_apertura = '" + fechaIni + "' and s.fecha_cierre = '" + fechaFin + "')";
        }

        //System.out.println(query);
        ResultSet result = MysqlConnect.getDbCon().query(query);

        while (result.next()) {
            String monto = result.getString("MONTO").trim();
            String fechaCierre = result.getString("FECHA_CIERRE").trim();
            String fechaApertura = result.getString("FECHA_APERTURA").trim();
            String nomEmpleado = result.getString("nom_empleado");
            String idEmp = result.getString("ID_EMPLEADO").trim();
            String id = result.getString("ID").trim();
            DtSueldo dtS = new DtSueldo(Integer.parseInt(id), Integer.parseInt(idEmp), nomEmpleado, Float.parseFloat(monto), fechaCierre, fechaApertura);
            res.add(dtS);
        }

        return res;
    }

    public void generarFactura(int idEmpleado, int idSueldo, String monto, String nomEmpleado, String fechaApertura, String fechaCierre) throws SQLException {
        String query = "select c.nombre nom_cliente, cantidad, monto_unitario from detalle_sueldo result inner join clientes c on result.ID_CLIENTE = c.ID"
                + " where ID_EMPLEADO = '" + idEmpleado + "' and ID_SUELDO = '" + idSueldo + "'";
        ResultSet rsDetalleSueldo = MysqlConnect.getDbCon().query(query);
        PdfReport pdf = new PdfReport();
        String nomDocumento = idEmpleado + "_" + idSueldo + "_" + nomEmpleado + "_" + fechaApertura + "_" + fechaCierre + ".pdf";
        String datos = "EMPLEADO: " + nomEmpleado + "\nFECHA APERTURA: " + fechaApertura + "\nFECHA CIERRE: " + fechaCierre;
        try {
            pdf.createPdf(nomDocumento, datos, monto, rsDetalleSueldo);
        } catch (DocumentException ex) {
            Logger.getLogger(CtrlOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CtrlOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarPagoCliente(int idCliente, int idEmpleado, float nuevoMonto) throws SQLException {
        String query = "update pago_cliente set monto_unidad = " + nuevoMonto + " where id_empleado = " + idEmpleado + " and id_cliente = " + idCliente;
        System.out.println(query);
        MysqlConnect.getDbCon().execute(query);
    }
}
