package Interface;

import Entidades.Venta;
import java.util.List;


public interface CRUDVenta {
    public List listar();
    public Venta list(int id);
    public boolean add(Venta ve);
    public boolean edit(Venta ve);
    public boolean eliminar(int id);
    public String obtenerUltimo();
}
