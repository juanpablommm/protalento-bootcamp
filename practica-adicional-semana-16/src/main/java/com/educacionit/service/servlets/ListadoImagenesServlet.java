package com.educacionit.service.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.domain.Carrousel;
import com.educacionit.exception.ServicesException;
import com.educacionit.service.ICarrouselService;
import com.educacionit.service.Impl.CarrouselServiceImlp;
import com.educacionit.service.enums.ViewsEnums;

@WebServlet("/ListadoImagenesServlet")
public class ListadoImagenesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ICarrouselService carrouselService = new CarrouselServiceImlp();
        try {
            List<Carrousel> list = carrouselService.selectFindAll();
            req.setAttribute("imagenes", list);
            req.getRequestDispatcher(ViewsEnums.ACTUALIZAR_IMAGENES.getView()).forward(req, resp);
        } catch (ServicesException e) {
            e.printStackTrace();
        } 
    }
}
