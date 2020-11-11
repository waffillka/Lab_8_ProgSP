package servlets;

import DAO.implementation.WatchDAOImplementation;
import DAO.interfaces.WatchDAO;
import Models.Watch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WatchServlet")
public class WatchServlet extends HttpServlet {
    private final WatchDAO watchDAO;

    public WatchServlet() {
        watchDAO = new WatchDAOImplementation();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("addWatch") != null) {
            insertWatch(request, response);
        }
        else if (request.getParameter("deleteWatch") != null) {
            deleteWatch(request, response);
        }
        else if (request.getParameter("editManufacturer") != null) {
            //updateManufacturer(request, response);
        }
        else if (request.getParameter("deleteSouvenirs") != null) {
            deleteWatch(request, response);
        }
    }

    private void insertWatch(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nameWatch = request.getParameter("nameWatch");
        String typeWatch  = request.getParameter("typeWatch");
        double price = Double.parseDouble(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        String manufacturer = request.getParameter("manufacturer");
        String country = request.getParameter("country");
        Watch watch = new Watch(nameWatch, typeWatch, price, count, manufacturer,country);
            watchDAO.insert(watch);
        response.sendRedirect("WatchListALL.jsp");
    }

    private void deleteWatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        watchDAO.deleteWatch(id);
        response.sendRedirect("WatchListALL.jsp");
    }
}
