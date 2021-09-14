package ModeloDAO;

import Conexion.Conexion;
import Interface.CRUDVenta;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaDAO implements CRUDVenta{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Venta ve = new Venta();

    @Override
    public List listar() {
        ArrayList<Venta> list = new ArrayList<>();
        String sql = "SELECT *FROM VENTA ORDER BY ID_VENTA";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta ven = new Venta();
                ven.setID_VENTA(rs.getInt("ID_VENTA"));
                ven.setCODIGO_VENTA(rs.getInt("CODIGO_VENTA"));
                ven.setVALOR(rs.getInt("VALOR"));
                ven.setFECHA(rs.getString("FECHA"));
                ven.setID_CLIENTE(rs.getInt("ID_CLIENTE"));
                ven.setID_PRENDA(rs.getInt("ID_PRENDA"));
                ven.setID_EMPLEADO(rs.getInt("ID_EMPLEADO"));
                list.add(ven);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Venta list(int id) {
        String sql = "SELECT * FROM VENTA WHERE ID_VENTA =" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ve.setID_VENTA(rs.getInt("ID_VENTA"));
                ve.setCODIGO_VENTA(rs.getInt("CODIGO_VENTA"));
                ve.setVALOR(rs.getInt("VALOR"));
                ve.setFECHA(rs.getString("FECHA"));
                ve.setID_CLIENTE(rs.getInt("ID_CLIENTE"));
                ve.setID_PRENDA(rs.getInt("ID_PRENDA"));
                ve.setID_EMPLEADO(rs.getInt("ID_EMPLEADO"));
            }
        } catch (Exception e) {
        }
        return ve;
    }

    @Override
    public boolean add(Venta ve) {
        Connection con = null;
        PreparedStatement ps = null;
        int ultimo = Integer.parseInt(obtenerUltimo());
        ultimo++;
        int ultimo1 = Integer.parseInt(obtenerUltimo());
        ultimo1++;
        String sql = "CALL SP_INSERTAR_VENTA (?,?,?,?,?,?,?)";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ultimo);
            ps.setInt(2, ultimo1);
            ps.setInt(3, ve.getVALOR());
            ps.setString(4, ve.getFECHA());
            ps.setInt(5, ve.getID_CLIENTE());
            ps.setInt(6, ve.getID_PRENDA());
            ps.setInt(7, ve.getID_EMPLEADO());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean edit(Venta ve) {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "UPDATE VENTA SET VALOR = ?, FECHA = ?, ID_CLIENTE = ?, ID_PRENDA = ?, ID_EMPLEADO = ? WHERE ID_VENTA = ?";
        
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getVALOR());
            ps.setString(2, ve.getFECHA());
            ps.setInt(3, ve.getID_CLIENTE());
            ps.setInt(4, ve.getID_PRENDA());          
            ps.setInt(5, ve.getID_EMPLEADO());
            ps.setInt(6, ve.getID_VENTA());
            ps.executeUpdate(); 
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "CALL SP_ELIMINAR_VENTA(" + id + ")";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public String obtenerUltimo() {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "SELECT ID_VENTA FROM VENTA ORDER BY ID_VENTA ASC";
        String mensaje = "";
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mensaje = (rs.getString("ID_VENTA"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje = ("error al obtener ultimo " + ex.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();

                }
            } catch (SQLException e) {
                mensaje = mensaje + " error al cerrar " + e.getMessage();
            }
        }
        return mensaje;
    }
}
