package ar.com.educacionit.files.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.web.enums.ViewsKeysEnum;

//al iugal que los servlet a los filter debemos darl una anotacion similar
//el parametro urlPatterns revice un array
//por ejemplo {"*/", "/v1", "/v2"} pero poa ahora le deimos
//que intercete todas las peticiones con el *
@WebFilter(filterName = "LogginFilter", urlPatterns = "/*")
public class LogginFilter implements Filter {

    // nos servira para aplicar un filtro en las peticiones
//    y de esta manera poder aplicar una resticion depentiendo de
//    ese filtro asi no se podra acceder a las jsp de la web sin
//    haberse logueado primero
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request2 = (HttpServletRequest) request;
        
        System.out.println(request2.getParameterMap());
        chain.doFilter(request2, response);
        
    }
}
