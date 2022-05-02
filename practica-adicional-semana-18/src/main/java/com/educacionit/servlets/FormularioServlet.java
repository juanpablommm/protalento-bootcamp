package com.educacionit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter printWriter = resp.getWriter();
        String nombres = req.getParameter("nombres");
        String correo = req.getParameter("correo");
        String genero = req.getParameter("radioGenero");
        String[] tecnologias = req.getParameterValues("tecnologias");
        String carrera = req.getParameter("carrera");
        String password = req.getParameter("password");
        
        printWriter.println("nombre: " + nombres);
        printWriter.println("correo: " + correo);
        printWriter.println("genero: " + genero);
        for(String t: tecnologias) {
            printWriter.println("conocimientos en: " + t);
        }
        printWriter.println("profesional en: " + carrera);
        printWriter.println("password: " + password);
        printWriter.close();
    }
}
