package com.educacionit.service.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import com.educacionit.service.enums.MensajesEnums;
import com.educacionit.service.enums.ViewsEnums;

@SuppressWarnings("serial")
@WebServlet("/CarrouselServlet")
public class CarrouselServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICarrouselService service = new CarrouselServiceImlp();
        ViewsEnums view = null;
        try {
            List<Carrousel> list = service.selectFindAll();
            req.setAttribute("LISTADO", list);
            view = ViewsEnums.LISTADO;
            getServletContext().getRequestDispatcher(view.getView()).forward(req, resp);
        } catch (ServicesException e) {
            e.printStackTrace();
        }
    }
}
