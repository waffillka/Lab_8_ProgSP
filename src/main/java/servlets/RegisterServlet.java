package servlets;

import DAO.implementation.UsersDAOImplementation;
import DAO.interfaces.UsersDAO;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private final UsersDAO usersDAO = new UsersDAOImplementation();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String surname  = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contactPhone = request.getParameter("contactPhone");
        User user = new User(firstName, surname, username, password, contactPhone);
        if (usersDAO.insertUser(user)) {
            response.sendRedirect("Views/Authorization.jsp");
        }
        else {
            String errorMessage = "User Available";
            HttpSession session = request.getSession();
            session.setAttribute("Registration error", errorMessage);
            response.sendRedirect("Views/Registration.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
