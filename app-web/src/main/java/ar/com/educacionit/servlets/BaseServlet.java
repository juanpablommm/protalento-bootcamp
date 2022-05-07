package ar.com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.web.enums.IEnumerable;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

    protected void addAtribute(HttpServletRequest req, IEnumerable key, Object value) {
        req.setAttribute(key.getParam(), value);
    }
    
    protected void addAtribute(HttpSession session, IEnumerable key, Object value) {
        session.setAttribute(key.getParam(), value);
    }

    public void redirect(IEnumerable target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(target.getParam()).forward(req, resp);        
    }
}
