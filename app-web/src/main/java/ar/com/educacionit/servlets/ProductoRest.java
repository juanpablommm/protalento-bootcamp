package ar.com.educacionit.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.fasterxml.jackson.databind.ObjectMapper;

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
@WebServlet("/rest/ProductoRest")
public class ProductoRest extends BaseServlet {

    private ArticulosServices articulosServie = new ArticulosServicesImpl();
    private MarcasService marcasService = new MarcasServiceImpl();
    private CategoriaService categoriaService = new CategoriaServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();

    /* realizo la eliminacion del articulo por id, atravez del verbo get */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tomar el id que viene del request
        String id = req.getParameter("id");

        try {
            Articulos articulo = articulosServie.getOne(Long.parseLong(id));
            articulo.setCategoria(categoriaService.getOne(articulo.getCategoriasId()));
            articulo.setMarcas(marcasService.getOne(articulo.getMarcasId()));
            
            /*armo una lista de todas las marcas y todas las categorias
             * para representar todas las opcines de marcas y categorias
             *  que tendra el usuario en un opcion para elegir la actulizacion
             *  */
            List<Marcas> marcas = marcasService.findAll();
            List<Categorias> categorias = categoriaService.findAll();
            
            /*atravez del parse de un mapa a JSON podre representar
             * un objet de este mismo mas completo, que tenga
             * objetos dentro de el, en este caso el articulo
             * tendra un array de marcas, y un array de categorias*/
            Map<String, Object> mapaOject = new HashedMap();
            mapaOject.put("articulo", articulo);
            mapaOject.put("marca", marcas);
            mapaOject.put("categoria", categorias);
            String objectJSON = mapper.writeValueAsString(mapaOject);

            // escribo en el response el objeto
            resp.getWriter().println(objectJSON);
        } catch (ServiceException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* realizo la actulizacion de los datos por el verbo post */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idInput");
        String titulo = req.getParameter("titulo");
        String precio = req.getParameter("precio");
        String stock = req.getParameter("stock");
        String marca = req.getParameter("selectMarcas");
        String categoria = req.getParameter("selectCategorias");
        
        /** recupero la collection de la seccion para sacar el articulo */
        Collection<Articulos> collection = (Collection<Articulos>) req.getSession().getAttribute(ViewsKeysEnum.LISTADO.getParam());

        if (!id.isEmpty() && !titulo.isEmpty() && !precio.isEmpty() && !stock.isEmpty()) {
            Optional<Articulos> articulo = collection.stream().filter(x -> x.getId().toString().equals(id)).findAny();
                articulo.get().setTitulo(titulo);
                articulo.get().setPrecio(Double.parseDouble(precio));
                articulo.get().setStock(Long.parseLong(stock));
                articulo.get().setCategoriasId(Long.parseLong(categoria));
                articulo.get().setMarcasId(Long.parseLong(marca));
                try {
                    articulosServie.update(articulo.get());
                    super.addAtribute(req, ViewsKeysEnum.EXITO, "Exito!! El Articulo se ha actulizado..");
                } catch (ServiceException e) {
                    super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "Error!! " + e.getMessage());
                }finally {
                    Double valorTotal = (Double) req.getSession().getAttribute(ViewsKeysEnum.VALOR_TOTAL.getParam());
                    valorTotal = collection.stream().map(x -> x.getPrecio()).reduce(0d, (x,y) -> x+y);
                }
        }else {
            //informar que ahy datos hubieron datos vacios
            super.addAtribute(req, ViewsKeysEnum.ERROR_GENERAL, "Error!! Algunos de los datos no eran correctos o estaban vacios...");
        }
        super.redirect(ViewJSPEnums.LISTADO_GENERAL, req, resp);
    }
}
