package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.MarcasServiceImpl;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/controllers/NuevoProductoServlet")
public class NuevoProductoServlet extends BaseServlet{
    
    private MarcasService marcasService = new MarcasServiceImpl();;
    private CategoriaService categoriaService = new CategoriaServiceImpl();
    private ArticulosServices articulosServices =  new ArticulosServicesImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Marcas> marcas = new ArrayList<>();
        List<Categorias> categorias = new ArrayList<>();
        try {
            marcas = marcasService.findAll();
            categorias = categoriaService.findAll(); 
        } catch (ServiceException e) {
            e.printStackTrace(System.err);
        }finally {
            req.getSession().setAttribute(ViewsKeysEnum.MARCAS.getParam(), marcas);
            req.getSession().setAttribute(ViewsKeysEnum.CATEGORIAS.getParam(), categorias);
            super.redirect(ViewJSPEnums.NUEVO_PRODUCTO, req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo").trim(),   
        codigo = req.getParameter("codigo").trim(),
        precio = req.getParameter("precio").trim(),
        stock = req.getParameter("stock").trim(),
        marcasId = req.getParameter("marcasId").trim(),
        categoriasId = req.getParameter("categoriasId").trim();
        
        Articulos articulo = new Articulos(titulo, new Date(), codigo, Double.parseDouble(precio),
                Long.parseLong(stock), Long.parseLong(marcasId), Long.parseLong(categoriasId));
        try {
            articulosServices.save(articulo);
            super.addAtribute(req, ViewsKeysEnum.EXITO, "Exito!! se ha completado el registro...");
            super.redirect(ViewJSPEnums.LISTADO_GENERAL, req, resp);
        } catch (ServiceException e) {
            super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "Errror!! no es posible el resgistro verifique los datos: " + e.getMessage());
            super.redirect(ViewJSPEnums.NUEVO_PRODUCTO, req, resp);
        }
    }
}
