/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Venta;
import ModeloDAO.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Controlador_Venta", urlPatterns = {"/Controlador_Venta"})
public class Controlador_Venta extends HttpServlet {

    String listar = "Index.jsp";
    String add = "Agregar Venta.jsp";
    String edit = "Editar Venta.jsp";
    Venta v = new Venta();
    VentaDAO dao = new VentaDAO();

    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Venta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Venta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acceso = "";
            String action = request.getParameter("accion");
            if (action.equalsIgnoreCase("listar")) {
                acceso = listar;
            } else if (action.equalsIgnoreCase("add")) {
                acceso = add;
            } else if (action.equalsIgnoreCase("edit")) {
                request.setAttribute("idVenta", request.getParameter("id"));
                acceso = edit;
            } else if (action.equalsIgnoreCase("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                v.setID_VENTA(id);
                dao.eliminar(id);
                acceso = listar;
            }
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acceso = "";
            String action = request.getParameter("accion");
            System.out.println("VALOR" + action);
            if (action.equalsIgnoreCase("Agregar")) {
                int ID_VENTA = 1;
                int CODIGO_VENTA = 001;
                int VALOR = Integer.parseInt(request.getParameter("txtVALOR"));
                String FECHA = request.getParameter("txtFECHA");
                int ID_CLIENTE = Integer.parseInt(request.getParameter("txtID_CLIENTE"));
                int ID_PRENDA = Integer.parseInt(request.getParameter("txtID_PRENDA"));
                int ID_EMPLEADO = Integer.parseInt(request.getParameter("txtID_EMPLEADO"));
                v.setID_VENTA(ID_VENTA);
                v.setCODIGO_VENTA(CODIGO_VENTA);
                v.setVALOR(VALOR);
                v.setFECHA(FECHA);
                v.setID_CLIENTE(ID_CLIENTE);
                v.setID_PRENDA(ID_PRENDA);
                v.setID_EMPLEADO(ID_EMPLEADO);
                dao.add(v);
                acceso = listar;

            } else if (action.equalsIgnoreCase("Actualizar")) {                
                v.setID_VENTA(Integer.parseInt(request.getParameter("txtID_VENTA")));
                v.setCODIGO_VENTA(Integer.parseInt(request.getParameter("txtCODIGO_VENTA")));
                v.setVALOR(Integer.parseInt(request.getParameter("txtVALOR")));
                v.setFECHA(request.getParameter("txtFECHA"));
                v.setID_CLIENTE(Integer.parseInt(request.getParameter("txtID_CLIENTE")));
                v.setID_PRENDA(Integer.parseInt(request.getParameter("txtID_PRENDA")));
                v.setID_EMPLEADO(Integer.parseInt(request.getParameter("txtID_EMPLEADO")));
                dao.edit(v);
                acceso = listar;
            }

            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        } catch (Exception ex) {
            String mensage = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}