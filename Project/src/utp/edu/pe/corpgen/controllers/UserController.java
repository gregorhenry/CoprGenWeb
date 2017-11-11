package utp.edu.pe.corpgen.controllers;


import utp.edu.pe.corpgen.models.User;
import utp.edu.pe.corpgen.services.CoServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserController", urlPatterns = "/login")
public class UserController extends  javax.servlet.http.HttpServlet {

    public static String URL_LOGIN ="/buenLogin.jsp";
    public static String URL_PROFILE ="/profile.jsp";

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

                User user=new User();
                user.setName(request.getParameter("name"));
                user.setEmail(request.getParameter("email"));
                user.setLastName(request.getParameter("lastName"));
                user.setPassword(request.getParameter("password"));
                List<User> users = service.findAllUsers();

                String msg=service.createUser(user)? "Usuario creado con exito":"Ocurrio un error";

                log(msg);
                //User user = service.createUser(email,name,lastName,password);
                url = URL_LOGIN;

            }
            else if (action.equals("login")){

                User user=new User();
                user.setEmail(request.getParameter("mail"));
                user.setPassword(request.getParameter("pass"));
     //           String email = request.getParameter("mail");
     //           String passwd = request.getParameter("pass");
                String msg = service.AuthenticationUser(user) ? "Correcto" :"Error";
                log(msg);
                url=URL_PROFILE;


            }


        }

        request.getRequestDispatcher(url).forward(request,response);


    }
}
