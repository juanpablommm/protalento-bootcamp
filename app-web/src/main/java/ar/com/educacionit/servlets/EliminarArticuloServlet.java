package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/controllers/EliminarArticuloServlet")
public class EliminarArticuloServlet extends BaseServlet{
     @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
         String id = req.getParameter(ViewsKeysEnum.ID_ELIMINAR.getParam());
         Collection<Articulos> articulos = (Collection<Articulos>) req.getSession().getAttribute(ViewsKeysEnum.LISTADO.getParam());
         if((id != null && !id.equals("")) && (articulos != null && !articulos.isEmpty())) {
             req.getSession().removeAttribute(ViewsKeysEnum.LISTADO.getParam());
             ArticulosServices services = new ArticulosServicesImpl();
             try {
                 Long idLong = Long.parseLong(id);
                 services.delete(idLong);
                 articulos = articulos.stream().filter(x -> !x.getId().equals(idLong)).collect(Collectors.toList());
                 super.addAtribute(req, ViewsKeysEnum.EXITO, "Exito!! Se ha eliminado el articulo");
             } catch (ServiceException e) {
                 super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, e.getMessage());
             }finally {
                Double valorTotal = articulos.stream().map(x -> x.getPrecio()).reduce(0d, (x,y) -> x+y);
                req.getSession().setAttribute(ViewsKeysEnum.LISTADO.getParam(), articulos);
                req.getSession().setAttribute(ViewsKeysEnum.VALOR_TOTAL.getParam(), valorTotal);
            }
         }else {
             super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "No existe un id para el registro a eliminar...");
        }
         super.redirect(ViewJSPEnums.LISTADO_GENERAL, req, resp);
    }
}
