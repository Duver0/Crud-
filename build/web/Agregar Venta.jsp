<%-- 
    Document   : Agregar Producto
    Created on : 19/04/2021, 03:49:46 PM
    Author     : Hewlett Packard
--%>
<%@page import="Entidades.Venta"%>
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
        <title>Agregar</title>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body style="background-color:#F9F6FA;">
        <div class="container">
            <div class="row align-items-center abs-center">
                <div class="col-md-4">
                </div>
                <div class="col-md-8">
                    <div class="col-md-5 bg-info text-dark">
                        <h1>Agregar Venta</h1>
                        <form method="post" id="frmRegistrese" action="Controlador_Venta">
                            <div class="form-group">
                                <label for="VALOR">VALOR</label><span id="VALOR">*</span>
                                <input name="txtVALOR" type="number" class="form-control" id="VALOR" placeholder="VALOR..." required>
                            </div>
                            <div class="form-group">
                                <label for="FECHA">FECHA</label><span id="FECHA">*</span>
                                <input name="txtFECHA" type="date" class="form-control" id="FECHA" required>
                            </div>
                            <div class="form-group">
                                <label for="ID_CLIENTE">CLIENTE</label>
                                <select name="txtID_CLIENTE" type="number" class="form-control">
                                    <option value="Vacio">Seleccione cliente...</option> 
                                    <option value="1" name="txtID_CLIENTE">1</option> 
                                    <option value="2" name="txtID_CLIENTE">2</option> 
                                    <option value="3" name="txtID_CLIENTE">3</option> 
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="ID_PRENDA">PRENDA</label>
                                <select name="txtID_PRENDA" type="number" class="form-control">
                                    <option value="Vacio" >Seleccione cliente...</option> 
                                    <option value="1" name="txtID_PRENDA">1</option> 
                                    <option value="2" name="txtID_PRENDA">2</option> 
                                    <option value="3" name="txtID_PRENDA">3</option> 
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="ID_EMPLEADO">EMPLEADO</label>
                                <select name="txtID_EMPLEADO" type="number" class="form-control">
                                    <option value="Vacio" required>Seleccione empleado...</option> 
                                    <option value="1" name="txtID_EMPLEADO">1</option> 
                                    <option value="2" name="txtID_EMPLEADO">2</option> 
                                    <option value="3" name="txtID_EMPLEADO">3</option> 
                                </select>
                            </div>
                            <input class="btn btn-primary" type="submit" name="accion" value="Agregar">    
                            <br>
                            <br>
                            <center>
                                <button class="btn btn-warning" type="reset" value="LimpiarCampos">Limpiar Campos</button>
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
