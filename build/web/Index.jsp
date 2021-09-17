<%@page import="ModeloDAO.VentaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Entidades.Venta"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    </head>
    <body style="background-color:#F9F6FA;">
        <script type="text/javascript">
            function confirmDelete() {
                var respuesta = confirm("Desea Eliminar esta venta?");
                if (respuesta == true) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <br>
        <h1 class="text-center">INFORMACIÓN VENTA<span class="glyphicon"></span></h1>
        <br>
        <div id="main">
            <center>
                <div class="container ">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>CODIGO</th>
                                <th>VALOR</th>
                                <th>FECHA</th>
                                <th>CLIENTE</th>
                                <th>PRENDA</th>
                                <th>EMPLEADO</th>
                            </tr>
                        </thead>
                        <%
                            VentaDAO dao = new VentaDAO();
                            List<Venta> list = dao.listar();
                            Iterator<Venta> iter = list.iterator();
                            Venta ven = null;
                            while (iter.hasNext()) {
                                ven = iter.next();

                        %>
                        <tbody>
                            <tr class="table-dark">
                                <td><%= ven.getID_VENTA()%></td>
                                <td><%= ven.getCODIGO_VENTA()%></td>
                                <td><%= ven.getVALOR()%></td>
                                <td><%= ven.getFECHA()%></td>
                                <td><%= ven.getID_CLIENTE()%></td>
                                <td><%= ven.getID_PRENDA()%></td>
                                <td><%= ven.getID_EMPLEADO()%></td>
                                <td>
                                    <a href="Controlador_Venta?accion=edit&id=<%= ven.getID_VENTA()%>" class="btn btn-info stretched-link"> <i class="far fa-edit"></i></a>
                                    <a href="Controlador_Venta?accion=eliminar&id=<%= ven.getID_VENTA()%>" class="btn btn-danger stretched-link" onclick="return confirmDelete()"> <i class="far fa-trash-alt"></i></a>
                                </td>
                            </tr>
                        </tbody>                    
                        <%}%> 

                    </table>
                    <form class="text-left">
                        <a href="Agregar Venta.jsp" class="btn btn-success stretched-link">Agregar</a>  
                        <a href="Index.jsp" class="btn btn-primary stretched-link">Refrescar <i class="fas fa-sync-alt"> </i> </a>
                    </form>
                </div>

            </center>  
        </div>
    </body>
</html>

