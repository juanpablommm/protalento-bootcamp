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
@WebFilter(filterName = "SeccionFilter", urlPatterns = "/controllers/*")
public class SeccionFilter implements Filter {

    // nos servira para aplicar un filtro en las peticiones
//    y de esta manera poder aplicar una resticion depentiendo de
//    ese filtro asi no se podra acceder a las jsp de la web sin
//    haberse logueado primero
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 1. debo obtener mi usuario de la seccion

        // 2. tomar url (/controller/algunSevlet)
        // empleo un casteo dado que los reques no son los mismos de los servlet
//        que vwnimos trabajando
        HttpServletRequest request2 = (HttpServletRequest) request;
//        String url = request2.getRequestURI();// http://localhost:8080/app-web/

//        String contextPath = request2.getContextPath();

        // 3. si tenemos rutas que estan escluidas,, si no son parte del
        // filtro las deja pasar directamente
//        defino una lista pra a quellas url que queremos revisar
//        List<String> validatePatch = Arrays.asList(contextPath + "/controllers");

//        boolean mostValidate = false; 
//        for (String pat : validatePatch) {
//            if (url.contains(pat)) {
//                mostValidate = true;
//            }
//        }

        // stream
//        boolean mostValidate = validatePatch.stream().filter(x -> url.contains(x)).count() > 0;

        HttpSession session = request2.getSession(false);// cuando pido la secciontengo
//        que indicarla un parametro false para que me traiga la seccion y no 
//        cree una nueva
//        if (mostValidate) {
            if (session == null) {
                request2.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), "Debe loguearse");
                request2.getRequestDispatcher("/login.jsp").forward(request2, response);
            } else {

                Users user = (Users) request2.getSession().getAttribute(ViewsKeysEnum.USER.getName());

                // la seccion pude estar sucioa por lo que tengo que validar si veine un
//                usuario o no
                if (user != null) {
                    // dejo que acceda al /controller/AlgunServlets solitado
                    chain.doFilter(request2, response);
                } else {
                    // si el usuario al final de todo viene nulo pues loredirecino
//                    a una jsp, que seria el login, para que nuevamente vuelva a reegistrase
                    request2.setAttribute(ViewsKeysEnum.ERROR_GENERAL.getName(), "Debe loguearse");
                    request2.getRequestDispatcher("/login.jsp").forward(request2, response);
                }
            }
//        } else {
//            // es como una cade de filtros en donde una vez
//            // enviado a uno, este puede enviarlo al siguiente filtro de existir
//            // y asu vez este a otro y asi...
//            chain.doFilter(request2, response);
//        }
 //        // 4 -logica
    }
}
