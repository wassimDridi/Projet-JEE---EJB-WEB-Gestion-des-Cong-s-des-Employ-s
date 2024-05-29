package connexion;

import java.io.IOException;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UtilisateurServiceRemote utilisateurService;

    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            utilisateurService = (UtilisateurServiceRemote) context.lookup("ejb:/ejb__projee/UtilisateurServiceBeanlocal!services.UtilisateurServiceRemote");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Utilisateur utilisateur = utilisateurService.authentifierUtilisateur(login, password);
        if (utilisateur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", utilisateur);
            if ("ADMIN".equals(utilisateur.getType())) {
                response.sendRedirect("admin.jsp");
            } else {
                response.sendRedirect("employe.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}