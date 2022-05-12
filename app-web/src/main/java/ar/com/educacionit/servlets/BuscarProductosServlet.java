package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String limit = req.getParameter("limit");
//        String offset = req.getParameter("offset");
        
        String KeyWord = req.getParameter(ViewsKeysEnum.KEYWORD.getParam());
        
        ArticulosServices service = new ArticulosServicesImpl();
        try {
//            List<Articulos> list = service.findAll();
//            /*utilizamos iterator para recorrer y sacar lo que no 
//            nos comvenga de la lista*/
//            for (Iterator<Articulos> iterator = list.iterator(); iterator.hasNext();) {
//                if(!iterator.next().getTitulo().contains(KeyWord)) {
//                    iterator.remove();
//                }
//            }
            List<Articulos> list = service.findAllBy(KeyWord);
            
            req.setAttribute(ViewsKeysEnum.LISTADO.getParam(), list);
            getServletContext().getRequestDispatcher(ViewJSPEnums.LISTADO_GENERAL.getParam()).forward(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
            List<Articulos> list = new ArrayList<Articulos>();
            getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
        }
    }
}
