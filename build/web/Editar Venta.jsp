<%@page import="Entidades.Venta"%>
<%@page import="ModeloDAO.VentaDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/MyStile.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>       
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
        <script src="js/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/npm.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>URBANT</title>
    </head>
    <body style="background-color:#F9F6FA;">
        <script type="text/javascript">
            function confirmuPDATE() {
                var respuesta = confirm("Está seguro que desea Actualizar esta venta?");
                if (respuesta == true) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <div class="container">
            <div class="row align-items-center abs-center">
                <div class="col-md-4">
                </div>
                <div class="col-md-8">
                    <div class="col-md-4 bg-info text-dark">
                        <h1>Editar venta</h1>
                        <form  method="post" id="frmEditar" action="Controlador_Venta">
                            <%
                                VentaDAO dao = new VentaDAO();
                                int id = Integer.parseInt((String) request.getAttribute("idVenta"));
                                Venta ven = (Venta) dao.list(id);
                            %>
                            <label for="id" style="display: none;">ID_VENTA</label>
                            <input type="hidden"  name="txtID_VENTA" value="<%= ven.getID_VENTA()%>"/> 
                            <label for="id" style="display: none;">CODIGO_VENTA</label>
                            <input type="hidden"  name="txtCODIGO_VENTA" value="<%= ven.getCODIGO_VENTA()%>"/>
                            <div class="form-group">
                                <label for="NOMBRE_PRODUCTO">VALOR</label><span id="VALOR">*</span>
                                <input name="txtVALOR" type="number" class="form-control" value="<%= ven.getVALOR()%>" id="VALOR" required/>
                            </div>
                            <div class="form-group">
                                <label for="FECHA" style="display: none;"></label><span id="FECHA"></span>
                                <input type="hidden" name="txtFECHA" value="<%= ven.getFECHA()%>"/>
                            </div>
                            <div class="form-group">
                                <label for="ID_CLIENTE">CLIENTE</label>
                                <select name="txtID_CLIENTE" type="number" class="form-control" value="<%= ven.getID_CLIENTE()%>" id="ID_CLIENTE">
                                    <option value="1" name="txtID_CLIENTE">EDWIN</option> 
                                    <option value="2" name="txtID_CLIENTE">HULBERT</option> 
                                    <option value="3" name="txtID_CLIENTE">JOSE</option> 
                                    <option value="4" name="txtID_CLIENTE">CARMEN</option> 
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="ID_PRENDA">PRENDA</label>
                                <select name="txtID_PRENDA" type="number" class="form-control" value="<%= ven.getID_PRENDA()%>" id="ID_PRENDA">
                                    <option value="1" name="txtID_PRENDA">CAMISETA ADIDAS</option> 
                                    <option value="2" name="txtID_PRENDA">CAMISETA NIKE</option> 
                                    <option value="3" name="txtID_PRENDA">PANTALONES LEVI´S</option> 
                                    <option value="4" name="txtID_PRENDA">TENIS ADIDAS</option> 
                                </select>
                            </div>        
                            <div class="form-group">
                                <label for="ID_EMPLEADO">EMPLEADO</label>
                                <select name="txtID_EMPLEADO" type="number" class="form-control" value="<%= ven.getID_EMPLEADO()%>" id="ID_EMPLEADO">
                                    <option value="1" name="txtID_EMPLEADO">DUVIER</option> 
                                    <option value="2" name="txtID_EMPLEADO">ROSA</option> 
                                    <option value="3" name="txtID_EMPLEADO">PIETRO</option> 
                                    <option value="4" name="txtID_EMPLEADO">OSCAR</option> 
                                    <option value="5" name="txtID_EMPLEADO">SARA</option> 
                                    <option value="6" name="txtID_EMPLEADO">OSCAR</option> 
                                </select>
                            </div> 
                                    <input class="btn btn-info" type="submit" name="accion" value="Actualizar" id="Actualizar" onclick="return confirmuPDATE()"> 
                            <br>
                            <br>
                            <center>
                                <button class="btn btn-warning" type="reset" value="Limpiar Campos">Limpiar Campos</button>
                                <a href="Index.jsp" class="btn btn-danger stretched-link"><i class="fas fa-undo"></i></a>
                            </center>
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
