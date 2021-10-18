
package com.curso.servlets;

import com.curso.cdi.LoginMejoradoQualifier;
import com.curso.cdi.LoginService;
import com.curso.cdi.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SaludoServlet", urlPatterns = {"/saludo","/s"})
public class SaludoServlet extends HttpServlet {
    
    
    
    //ATRIBUTOS
    @Inject  //import javax.inject.Inject;
    private LoginService servicioLogin;  // new LoginServiceImpMejorado();
    
    @Inject @LoginMejoradoQualifier
    private LoginService servicioMej;
    
    @Inject 
    private UsuarioBean usuarioBean;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. leer parametro peticion  "nombre"
        //http://localhost:8080/001_CDI_beans2-1.0/saludo?nombre=Luis
        String nombre = request.getParameter("nombre"); // null si existe
        if(nombre == null || nombre.length() == 0){
            nombre = "Amigo";
        }
        
        //2. logica de negocio
        String existe = "No Existe";
        //comprobar que existe
        if (servicioLogin.existe(nombre)){
            existe = "Existe";
        }
        
        //3. pasar el control al jsp que generará la salida
        // 3.1. guardar en una ATRIBUTO DE REQUEST el NOMBRE
        
        request.setAttribute("usuario", nombre);
        request.setAttribute("existe", existe);
       // request.setAttribute("camion", new Camion());
       
       this.usuarioBean.setNombre(nombre);
  
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("saludo.jsp");
        dispatcher.forward(request, response);
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(".... estoy en doGet");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(".... estoy en doPost");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
