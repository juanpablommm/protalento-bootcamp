package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
@WebServlet("/controllers/CargarProductoServlet")
public class CargarProductoServlet extends BaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*1. tengo que recuperar la lista de articullos que se levante desde 
        el file y ha sido guardada en la seccion (que esta en el request)*/
        Collection<Articulos> articulos = (Collection<Articulos>) req.getSession().getAttribute(ViewsKeysEnum.UPLOAD_PREVIEW_KEY.getName()); 
        
        /*2. validaciones */
        if(articulos == null || articulos.isEmpty()) {
            req.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), " No ahy datos para procesar");
            super.redirect(ViewJSPEnums.UPLOAD_PREVIEW, req, resp);
        }
        
        ArticulosServices service = new ArticulosServicesImpl();
        List<Articulos> oks = new ArrayList<Articulos>();
        List<Articulos> fails = new ArrayList<Articulos>();
        
            /*persistir los datos en la db por medio del services recooriendo
             * cada elemento de la collection para persistir cada uno*/
            for(Articulos arti: articulos) {
                try {
                    service.save(arti);
                    oks.add(arti);
                } catch (ServiceException e) {
                    fails.add(arti);
                }
            }
            
            /*elimino la lista de articulos que habia sido cargada a la seccion
             * ya que no se necesita mas*/
            req.getSession().removeAttribute(ViewsKeysEnum.UPLOAD_PREVIEW_KEY.getName());
            
            
            //seterar las listas al reques
            super.addAtribute(req, ViewsKeysEnum.ARTICULOS_OK, oks);
            super.addAtribute(req.getSession(), ViewsKeysEnum.ARTICULOS_FAILS, fails);/*guardo los artituclos fails en 
            la seccion para posteriorment poder enviarlos a un servlet que se encargara de generar un archivo de ellos*/
            //redirec a la jsp
            super.redirect(ViewJSPEnums.RESULT_PREVIEW, req, resp);
            
    }
}
