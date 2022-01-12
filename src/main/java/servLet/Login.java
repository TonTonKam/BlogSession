package servLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    //get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	//post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailLog");
		String pwd = request.getParameter("pwdLog");
	
		HttpSession session = request.getSession();
		UserDao ud = new UserDao();
		//j'integre dans la session l'utilisateur de ma fonction
		if(ud.checkLogin(email, pwd) != null) {
		
			session.setAttribute("user", ud.checkLogin(email, pwd));
			response.sendRedirect("index");
		}else {
			
			request.setAttribute("erreur", "erreur de login ou de mot de passe");
			doGet(request, response);
		}
	}

}
