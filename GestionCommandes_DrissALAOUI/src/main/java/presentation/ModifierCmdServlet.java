package presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.CommandeDAO;
import metier.ICommande;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifierCmdServlet", value = "/modifier")
public class ModifierCmdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICommande cmdService = new CommandeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        request.setAttribute("cmd",cmdService.findById(_id));
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/modifier.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
