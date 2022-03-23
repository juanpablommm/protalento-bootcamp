package com.educacionit.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.dao.PersonaDao;
import com.educacionit.dao.PersonaDaoImpl;
import com.educacionit.domain.Persona;
import com.educacionit.exceptions.GenericExceptions;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PersonaDao personaDao = new PersonaDaoImpl();
        Persona persona = new Persona();
        try {
            if(!recuperarDatos(persona, req)) {
                req.setAttribute("Mensaje", "Error en el registro de datos,"
                        + " revise nuevamente su documento debe de tener 10 dijitos,"
                        + " no puede haber una edad menor a 1 año, y no puede haber una feha de nacimiento"
                        + " del año 2022");
                getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(req, resp);   
            }else {
                personaDao.insert(persona);
                getServletContext().getRequestDispatcher("/exito.jsp").forward(req, resp);
            }
            
        } catch (GenericExceptions e) {
            req.setAttribute("Mensaje", e.getMessage() + " consulte listado para segurar que esta persona "
                    + "no este registrata, o vuleva al menu de registro a cambiar los datos");
            getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(req, resp);
        }
    }
    
    private boolean recuperarDatos(Persona persona, HttpServletRequest req) {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        Long documento = Long.parseLong(req.getParameter("documento"));
        Long edad = Long.parseLong(req.getParameter("edad"));
        String ocupacion = req.getParameter("ocupacion");
        Date fechaNacimiento = Date.valueOf(req.getParameter("fechaNacimiento"));
        if(edad < 1 || (documento.toString().length()) < 10  || fechaNacimiento.after(Date.valueOf("2022-01-01"))) {
            return false;
        }else {
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setDocumento(documento);
            persona.setEdad(edad);
            persona.setOcupacion(ocupacion);
            persona.setFechaNacimiento(fechaNacimiento);
            return true;
        }
    }
}
