package ar.com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listado")
//creamos una anotacion para poder que esta clase
// escuche una peticion con ese nombre
public class ListadoServlet extends HttpServlet {

    /**
     * los servlet no tienen el metodo main, porque no son de tipo consola, sino web
     * 
     */
    
    //doPost o doGet son ahora nuestro main, de ellos vamos a recibir una peticion
//    por parte del front
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("llegue al servlet /listado que atiende POST");
        
        //utilizamos el parametro response para responder a un request realizado desde el front
        response.getWriter().print("hola front-end soy el back-end y atendi tu solitud por POS");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("hola front-end, soy el back-kend y atendi tu peticion por GET");
    }

}
