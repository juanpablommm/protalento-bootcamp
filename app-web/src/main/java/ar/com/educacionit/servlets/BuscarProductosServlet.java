package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String limit = req.getParameter("limit");
//        String offset = req.getParameter("offset");
        
        ArticulosServices service = new ArticulosServicesImpl();
        try {
            List<Articulos> list = service.findAll();
            req.setAttribute("LISTADO", list);
            getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
            List<Articulos> list = new ArrayList<Articulos>();
            getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
        }
    }
}
