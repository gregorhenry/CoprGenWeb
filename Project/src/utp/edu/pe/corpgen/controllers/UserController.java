package utp.edu.pe.corpgen.controllers;


import utp.edu.pe.corpgen.models.User;
import utp.edu.pe.corpgen.services.CoServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserController", urlPatterns = "/login")
public class UserController extends  javax.servlet.http.HttpServlet {

    CoServices service;
    String url;

    public UserController(){
        super();
        service = new CoServices();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (method.equals("POST")){
            if (action.equals("create")){

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String lastname = request.getParameter("lastname");
                String password = request.getParameter("password");
                List<User> users = service.findAllUsers();
                User user = service.createUser(email,name,lastname,password);
                url = "buenLogin.jsp";

            }
            else if (action.equals("login")){
                String email = request.getParameter("mail");
                String passwd = request.getParameter("pass");
                boolean user = service.AuthenticationUser(email,passwd);
                if (user){
                    url = "buenLogin.jsp";
                }else {
                    url = "profile.jsp";
                }


            }


        }

        request.getRequestDispatcher(url).forward(request,response);


    }
}
