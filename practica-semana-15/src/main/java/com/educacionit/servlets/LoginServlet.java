package com.educacionit.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.dao.PersonaDao;
import com.educacionit.dao.PersonaDaoImpl;
import com.educacionit.domain.Persona;
import com.educacionit.exceptions.GenericExceptions;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        Long documento = Long.parseLong(req.getParameter("documento"));
        Long edad = Long.parseLong(req.getParameter("edad"));
        String ocupacion = req.getParameter("ocupacion");
        Date fechaNacimiento = Date.valueOf(req.getParameter("fechaNacimiento"));
        
        PersonaDao personaDao = new PersonaDaoImpl();
        try {
            
            Persona persona = new Persona(nombre, apellido, ocupacion, documento, edad, fechaNacimiento);
            System.out.println(persona);
//            personaDao.insert(persona);
            
            List<Persona> listaPersonas = personaDao.selectFrom();
            req.setAttribute("Listado", listaPersonas);
            getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
        
        } catch (GenericExceptions e) {
            e.printStackTrace();
        }
        
        
       
    }
}
