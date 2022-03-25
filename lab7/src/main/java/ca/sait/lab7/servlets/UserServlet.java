/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.lab7.servlets;

import ca.sait.lab7.models.Role;
import ca.sait.lab7.models.User;
import ca.sait.lab7.services.RoleService;
import ca.sait.lab7.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pierce
 */
public class UserServlet extends HttpServlet {

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
        UserService service = new UserService();

        String action = request.getParameter("action");

        if(action!=null && action.equals("delete")){  
            try{
                String email = request.getParameter("email");   
                service.delete(email);
            }
            catch(Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else if(action!=null && action.equals("edit")){
            try{
                String email = request.getParameter("email");
                String first_name = request.getParameter("first_name");
                String last_name = request.getParameter("last_name");

                request.setAttribute("email", email);
                request.setAttribute("first_name", first_name);
                request.setAttribute("last_name", last_name);


                this.getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
                return;
            }
            catch(Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else if(action!=null && action.equals("create")){
            try{
                this.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
                return;
            }
            catch(Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
       
    try{

        List<User> users = service.getAll();
        request.setAttribute("users", users);
    }

    catch(Exception e){Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);}
        
    this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
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

        UserService service = new UserService();
        RoleService roleService = new RoleService();
        String action = request.getParameter("action");

        String email = request.getParameter("email");
        int active = Integer.valueOf(request.getParameter("active"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String password = request.getParameter("password");
        int role_id = Integer.valueOf(request.getParameter("role_id"));   

        Role role;

        boolean active_bool = active==1;

        if(action!=null && action.equals("edit")){  
            try{
                role = roleService.get(role_id);
                service.update(email, active_bool, first_name, last_name, password, role);
            }
            catch(Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        else if(action!=null && action.equals("create")){  
            try{
                role = roleService.get(role_id);
                service.insert(email, active_bool, first_name, last_name, password, role);     
            }
            catch(Exception e){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
 
        try{

            List<User> users = service.getAll();
            request.setAttribute("users", users);
        }

        catch(Exception e){Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);}

        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
