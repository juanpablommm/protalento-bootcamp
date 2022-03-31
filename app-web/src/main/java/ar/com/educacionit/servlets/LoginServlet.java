package ar.com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.LoginViewEnum;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        capturo los parametros enviados por el html/jsp
        String userName = req.getParameter(LoginViewEnum.USERNAME.getName());
        String passwor = req.getParameter(LoginViewEnum.USERNAME.getName());

        // LOGING SERVICE
        LoginService loginService = new LoginServiceImpl();

        Users user = null;
        ViewEnums target = ViewEnums.LOGIN_SUCCESS;
        try {
            user = loginService.getUserByUserNameAndPassword(userName, passwor);
            if (user == null) {
                // login.jsp con algun mensaje de error
                target = ViewEnums.LOGIN;
//                guardar user in request
//                req.setAttribute("user", user);
                
//                Guardo el usario
//                en la seccion para tenerlo disponible
//                en todos lados que se necesite
            } 
            req.getSession().setAttribute("usuario", user);
        } catch (ServiceException e) {
            e.printStackTrace();
            target = ViewEnums.ERROR_GENERAL;
        }
        getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
    }
}
