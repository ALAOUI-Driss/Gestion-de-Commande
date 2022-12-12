package presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.CommandeDAO;
import entities.Commande;
import metier.ICommande;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AjouterCmdExcServlet", value = "/AjouterCmdExcServlet")
public class AjouterCmdExcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICommande cmdService = new CommandeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String article = request.getParameter("article");
        String qte = request.getParameter("qte");
        String prix_unit = request.getParameter("prix_unit");
        String client = request.getParameter("client");
        String prix_total = request.getParameter("prix_total");
        Commande o = new Commande();
        o.setArticle(article);
        o.setQte(qte);
        o.setPrix_unit(prix_unit);
        o.setClient(client);
        o.setPrix_total(prix_total);
        cmdService.save(o);
        response.sendRedirect(getServletContext().getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
