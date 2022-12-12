package presentation;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import DAO.CommandeDAO;
import metier.ICommande;

import javax.servlet.annotation.*;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private ICommande cmdService = new CommandeDAO();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("cmds",cmdService.findAll());
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/acceuil.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
