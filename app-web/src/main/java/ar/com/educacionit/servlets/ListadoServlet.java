package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

@WebServlet("/ListadoServlet")
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

//        creo mi objeto service para Articulos
            ArticulosServices articulosServices = new ArticulosServicesImpl();
            try {
//                obtengo la collections de consultar a la db todos los articulos
                Collection<Articulos> collectionArticulos = articulosServices.findAll();
                
//                guardamos la collections en un lugar llamado request para poder reenviarlo
//                a otra pagina en el front pero de ahy se termina, no podemos volver a reeviar
//                esa informacion
//                con el metodo setAtribute logramos esto, psar nuestro objeto, este recibe dos
//                parametros el primero es el string con el nombre que le demos, para poder consultarlo
//                en donde lo enviemos y el segundo es el objeto, algo parecido a un mapa, con clave y valor
                req.setAttribute("LISTADO", collectionArticulos);
                
                //ahora enviamos a la otra pagina y le psa lacollections que enviamos
                getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
    }

}
