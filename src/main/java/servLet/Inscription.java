package servLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserDao;
import model.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user1 = new User(request.getParameter("nomSaisie"), request.getParameter("prenomSaisie"));

		UserDao ud = new UserDao();
		if(!ud.ajouterUser(user1, request.getParameter("emailSaisie"), request.getParameter("pwdSaisie"))) {
			request.setAttribute("erreurMail", "Attention! Cette email existe deja");
			response.sendRedirect("inscription");
			
		}else {
	    HttpSession session = request.getSession();

	    session.setAttribute("user", user1);
		
	    response.sendRedirect("index");
		}
	}

}
