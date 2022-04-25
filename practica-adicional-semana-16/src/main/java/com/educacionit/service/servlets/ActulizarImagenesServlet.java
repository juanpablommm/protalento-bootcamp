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
@WebServlet("/ActulizarImagenesServlet")
public class ActulizarImagenesServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  descripcion = req.getParameter("descripcion");
        String url = req.getParameter("url");
        String nombre = req.getParameter("nombre");
        Long activo = Long.parseLong(req.getParameter("activo"));
        Long id = Long.parseLong(req.getParameter("id_carrousel"));
        
        Carrousel carrousel = new Carrousel(nombre, descripcion, url, activo);
        ICarrouselService service = new CarrouselServiceImlp();
        
        ViewsEnums view = ViewsEnums.ESTADO;
        String mensaje = "";
        try {
            service.update(id, carrousel);
            mensaje = MensajesEnums.EXITO.getMensaje();
        } catch (ServicesException e) {
            mensaje = MensajesEnums.ERROR.getMensaje() + ":" + e;
        }finally {
            req.setAttribute(MensajesEnums.class.getSimpleName(), mensaje);
            getServletContext().getRequestDispatcher(view.getView()).forward(req, resp);
        }
    }
}
