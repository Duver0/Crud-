/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


/**
 *
 * @author Hewlett Packard
 */
public class Venta {

    private int ID_VENTA;
    private int CODIGO_VENTA;
    private int VALOR;
    private String FECHA;
    private int ID_CLIENTE;
    private int ID_PRENDA;
    private int ID_EMPLEADO;

    public Venta(int ID_VENTA, int CODIGO_VENTA, int VALOR, String FECHA,
            int ID_CLIENTE, int ID_PRENDA, int ID_EMPLEADO) {
        this.ID_VENTA = ID_VENTA;
        this.CODIGO_VENTA = CODIGO_VENTA;
        this.VALOR = VALOR;
        this.FECHA = FECHA;
        this.ID_CLIENTE = ID_CLIENTE;
        this.ID_PRENDA = ID_PRENDA;
        this.ID_EMPLEADO = ID_EMPLEADO;

    }

    public Venta() {
    }

    public int getID_VENTA() {
        return ID_VENTA;
    }

    public void setID_VENTA(int ID_VENTA) {
        this.ID_VENTA = ID_VENTA;
    }

    public int getCODIGO_VENTA() {
        return CODIGO_VENTA;
    }

    public void setCODIGO_VENTA(int CODIGO_VENTA) {
        this.CODIGO_VENTA = CODIGO_VENTA;
    }

    public int getVALOR() {
        return VALOR;
    }

    public void setVALOR(int VALOR) {
        this.VALOR = VALOR;
    }
    
    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }
    
    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }
    
    public int getID_PRENDA() {
        return ID_PRENDA;
    }

    public void setID_PRENDA(int ID_PRENDA) {
        this.ID_PRENDA = ID_PRENDA;
    }
    
    public int getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(int ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

}
