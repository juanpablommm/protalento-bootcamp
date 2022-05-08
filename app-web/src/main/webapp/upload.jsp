<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="ISO-8859-1">
        <jsp:include page="styles.jsp"/>
        <title>Cargar Archivo</title>
    </head>
    <body>

       <!-- importo mi jps externa que contine el nav -->
       <jsp:include page="navbar.jsp"></jsp:include>

       <main>
          <!-- section para alertas para mostrar errores -->
          <jsp:include page="alertas.jsp"></jsp:include>

          <!-- section principal -->
          <section class="container-fluid">
           <div class="row d-flex justify-content-center">
            <h1>Cargar Archivo</h1>
            <div class="col">
                <!-- cargar archivo -->
                <form action="<%=request.getContextPath()%>/controllers/UploadFileServlet" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                      <label for="formFile" class="form-label">Cargar archivo de Productos (CSV | XLSX)</label>
                      <input class="form-control"  name="<%=ViewsKeysEnum.UPLOAD_FILE.getName()%>" type="file" id="formFile">                      
                  </div>
                  <button class="btn btn-outline-success me-2" type="submit">Cargar Archivo</button>   
              </form>               
          </div>
      </div>
  </section>
</main>

  <!-- importo mi jsp que contien la parte javascrip de bootrat -->
  <jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>