package ar.com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //removemos el usuario de la seccion
        req.getSession().removeAttribute(ViewsKeysEnum.USER.getName());
        //nos remouebe cokkis que allan quedado de la seccion
        req.getSession().invalidate();
        
        //redireccionamos al login de nuevo
        resp.sendRedirect(getServletContext().getContextPath());
    }
}
