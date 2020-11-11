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

@WebServlet(name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    private final UsersDAO userDAO = new UsersDAOImplementation();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.selectUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("Authorized user", user);
            response.sendRedirect("../Main.jsp");
        }
        else {
            String errorMessage = "User not found";
            HttpSession session = request.getSession();
            session.setAttribute("Login error", errorMessage);
            response.sendRedirect("Authorization.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
