package presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.CommandeDAO;
import metier.ICommande;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SupCmdServlet", value = "/supprimer")
public class SupCmdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICommande cmdService = new CommandeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        cmdService.delete(_id);
        response.sendRedirect(getServletContext().getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
