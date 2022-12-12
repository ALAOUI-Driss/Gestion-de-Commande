package presentation;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import DAO.CommandeDAO;
import entities.Commande;
import metier.ICommande;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import javax.servlet.annotation.*;

@WebServlet(name = "ImprimWServlet", value = "/imprimerWord.docx")
public class ImprimWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICommande cmdService = new CommandeDAO();

	public void init() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("cmds", cmdService.findAll());
		response.setContentType("application/docx");
		OutputStream out = response.getOutputStream();

		report(out);
		out.close();
	}

	public void destroy() {
	}

	public void report(OutputStream out) {
		try {
			JasperReportBuilder report = DynamicReports.report();
			report.addColumn(Columns.column("Id", "id", DataTypes.stringType()));
			report.addColumn(Columns.column("Article", "article", DataTypes.stringType()));
			report.addColumn(Columns.column("qte", "qte", DataTypes.stringType()));
			report.addColumn(Columns.column("Prix total", "prix_total", DataTypes.stringType()));
			report.addColumn(Columns.column("Prix unit", "prix_unit", DataTypes.stringType()));
			report.addColumn(Columns.column("Client", "client", DataTypes.stringType()));
			report.addTitle(Components.text("Listes des commandes"));
			report.addPageFooter(Components.pageXofY());

			report.setDataSource(createDataSource());
			
			report.toDocx(out);

		} catch (DRException e) {

			e.printStackTrace();

		}

	}
	public JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("id", "article", "qte","prix_total","prix_unit","client");
		for (Commande o : cmdService.findAll()){
			dataSource.add(o.get_id(), o.getArticle(),o.getQte(), o.getPrix_total(),o.getPrix_unit(),o.getClient());
		}
		

		return dataSource;


	}


}
