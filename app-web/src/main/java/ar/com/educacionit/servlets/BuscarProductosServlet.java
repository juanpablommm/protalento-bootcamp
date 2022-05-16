package ar.com.educacionit.servlets;

import java.io.IOException;
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

@SuppressWarnings("serial")
@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String KeyWord = req.getParameter(ViewsKeysEnum.KEYWORD.getParam());
        
        ArticulosServices service = new ArticulosServicesImpl();
        try {
            List<Articulos> list = service.findAllBy(KeyWord);
            Double precioTotal = list.stream().map(x -> x.getPrecio()).reduce(0d, (x,y) -> x+y);
            
            req.getSession().setAttribute(ViewsKeysEnum.LISTADO.getParam(), list);
            req.getSession().setAttribute(ViewsKeysEnum.VALOR_TOTAL.getParam(), precioTotal);
            getServletContext().getRequestDispatcher(ViewJSPEnums.LISTADO_GENERAL.getParam()).forward(req, resp);
        } catch (ServiceException e) {
            req.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), e.getMessage());
            getServletContext().getRequestDispatcher(ViewJSPEnums.LISTADO_GENERAL.getParam()).forward(req, resp);
        }
    }
}
