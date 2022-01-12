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
 * Servlet implementation class Article
 */
@WebServlet("/article")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao ad = new ArticleDao();
    private int idArt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

	//get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		idArt = Integer.parseInt(request.getParameter("idArticle"));
		request.setAttribute("idArt", ad.findById(idArt));
		
		if(session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			
			if(ad.compareIdUserWithIdArticle(user.getIdUser(), idArt) == true) {
				request.setAttribute("compare", "true");
			}
			
		}
		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

	//post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titreEdit");
		String contenu = request.getParameter("contenuEdit");
		
		System.out.println(titre + ", contenu : "+ contenu +" L54 article");
		if(titre != "" && titre != null && contenu != "" && contenu != null) {
			ad.updateArticle(titre, contenu, request.getParameter("resumeEdit"),
				request.getParameter("imageEdit"), idArt);
			
			response.sendRedirect("index");
		}else {
			request.setAttribute("erreurContenu", "Il n'y pas de contenu dans le titre ET/OU le contenu");
			response.sendRedirect("article");
		}
		
	}

}
