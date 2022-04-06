package com.educacionit.service.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.domain.Carrousel;
import com.educacionit.exception.ServicesException;
import com.educacionit.service.ICarrouselService;
import com.educacionit.service.Impl.CarrouselServiceImlp;
import com.educacionit.service.enums.MensajesEnums;
import com.educacionit.service.enums.ViewsEnums;

@SuppressWarnings("serial")
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String imagen = req.getParameter("urlImagen");
        Long activo = Long.parseLong(req.getParameter("activo"));
        String descripcion = req.getParameter("descripcion");
        Carrousel carrousel = new Carrousel(nombre, descripcion, imagen, activo);
        
        ICarrouselService service = new CarrouselServiceImlp();
        ViewsEnums view = ViewsEnums.ESTADO;
        String mensaje = null;
        try {
            service.insert(carrousel);
            mensaje = MensajesEnums.EXITO.getMensaje();
        } catch (ServicesException e) {
            mensaje = MensajesEnums.ERROR.getMensaje() + ":" + e;
        }finally {
            req.setAttribute(MensajesEnums.class.getSimpleName(), mensaje);
            getServletContext().getRequestDispatcher(view.getView()).forward(req, resp);
        }
    }
}
