package ar.com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ServiceException;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.ViewsKeysEnum;
import ar.com.educacionit.web.enums.ViewJSPEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    //
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        capturo los parametros enviados por el html/jsp
        //String userName = req.getParameter(ViewsKeysEnum.USERNAME.getName());
        //String passwor = req.getParameter(ViewsKeysEnum.PASSWORD.getName());
        
        
        //recupero el objeto JSON que viene del input con hidden
        String objectJSON = req.getParameter("data");
        LoginDTO dto = mapper.readValue(objectJSON, LoginDTO.class);/*este metodo resive 
        un parametro que seria el object JSON y un segundo que seria
        al tipo que uqeremo convertir*/
        
        ViewJSPEnums target = ViewJSPEnums.LOGIN_SUCCESS;

        //validamos usuario y passwor
        if(isValid(dto.getUsername(), dto.getPassword())) {
            
            // LOGING SERVICE
            LoginService loginService = new LoginServiceImpl();
            Users user = null;
            try {
                user = loginService.getUserByUserNameAndPassword(dto.getUsername(), dto.getPassword());
                if (user == null) {
                    target = ViewJSPEnums.LOGIN;
                }else {
                    req.getSession().setAttribute(ViewsKeysEnum.USER.getName(), user);
                } 
            } catch (ServiceException e) {
                //crear una tabal de manejo de errores por clave 
                req.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), e.getMessage());
                target = ViewJSPEnums.LOGIN;
            }
        }else {
          //guardar en el requst el mensajde error
            req.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), ViewsKeysEnum.USUARIO_PASSWORD_INVALID.getName());
            target = ViewJSPEnums.LOGIN;
        }        
        getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
    }

    private boolean isValid(String userName, String passwor) {
        return (userName != null  && !userName.isBlank()) && (passwor != null && !passwor.isBlank());
    }
}
