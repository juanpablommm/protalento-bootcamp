package ar.com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

    protected void addAtribute(HttpServletRequest req, ViewsKeysEnum key, Object value) {
        req.setAttribute(key.getName(), value);
    }

    public void redirect(ViewJSPEnums target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(target.getView()).forward(req, resp);        
    }
}
