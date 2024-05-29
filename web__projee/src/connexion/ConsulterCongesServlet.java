package connexion;

import domaine.Conge;
import connexion.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/consulterConges")
public class ConsulterCongesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @PersistenceUnit(unitName = "projee")
    private EntityManagerFactory emf;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Ne crée pas de nouvelle session si elle n'existe pas
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur != null) {
            Long utilisateurId = utilisateur.getId();
            String etat = request.getParameter("etat");

            EntityManager em = emf.createEntityManager();

            try {
                String queryString = "SELECT c FROM Conge c WHERE c.utilisateur.id = :userId";
                if (etat != null && !etat.isEmpty()) {
                    queryString += " AND c.etat = :etat";
                }

                Query query = em.createQuery(queryString, Conge.class);
                query.setParameter("userId", utilisateurId);
                if (etat != null && !etat.isEmpty()) {
                    query.setParameter("etat", etat);
                }

                List<Conge> conges = query.getResultList();

                request.setAttribute("conges", conges);

                request.getRequestDispatcher("consultationConges.jsp").forward(request, response);
            } finally {
                em.close();
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
