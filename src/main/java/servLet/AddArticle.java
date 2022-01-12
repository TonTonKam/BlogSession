package servLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ArticleDao;
import model.User;

/**
 * Servlet implementation class AddArticle
 */
@WebServlet("/creation-article")
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao ad = new ArticleDao();
	HttpSession session;

    public AddArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	//get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.getAttribute("user");
		request.getRequestDispatcher("addArticle.jsp").forward(request, response);
	}

	//post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		User utilisateur = (User) session.getAttribute("user");
		
		/*
		 * String titre, String auteur, String contenu, String resume, String image
		 */
		String titre = request.getParameter("titreSaisi");
		String contenu = request.getParameter("contenuSaisi");
		if(titre != null && contenu != null) {
			ad.creerArticle(titre, utilisateur.getIdUser(), contenu, request.getParameter("resumeSaisi"),
				request.getParameter("lienImage"));
			
			response.sendRedirect("index");
		}else {
			request.setAttribute("erreurSais", "Vous devez saisir 'un titre' et un 'contenu'");
			response.sendRedirect("creation-article");
		}
		
	}

}
