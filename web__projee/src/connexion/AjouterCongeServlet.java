package connexion;

import domaine.Conge;
import connexion.Utilisateur;
import domaine.CongeServiceBeanLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ajouterConge")
public class AjouterCongeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private CongeServiceBeanLocal congeService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Ne crée pas de nouvelle session si elle n'existe pas
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur != null) {
            // Utilisateur connecté trouvé, récupérer son ID
            Long utilisateurId = utilisateur.getId();

            // Récupérer les autres paramètres du formulaire
            String description = request.getParameter("description");
            String dateDebutStr = request.getParameter("dateDebut");
            String dateFinStr = request.getParameter("dateFin");
            String dateRuptureStr = request.getParameter("dateRupture");
            String etat = "SOLLICITE";

            // Convertir les chaînes de date en objets Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = null;
            Date dateFin = null;
            Date dateRupture = null;
            try {
                dateDebut = dateFormat.parse(dateDebutStr);
                dateFin = dateFormat.parse(dateFinStr);
                dateRupture = dateFormat.parse(dateRuptureStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Créer un nouvel objet Conge avec les données saisies
            Conge newConge = new Conge();
            newConge.setDescription(description);
            newConge.setDateDebut(dateDebut);
            newConge.setDateFin(dateFin);
            newConge.setDateRupture(dateRupture);
            newConge.setEtat(etat);
            newConge.setUtilisateur(utilisateur);

            // Appeler la méthode de la session bean pour ajouter le congé dans la base de données
            congeService.ajouterConge(newConge);

            // Rediriger l'utilisateur vers une page de confirmation ou une autre page appropriée
            response.sendRedirect(request.getContextPath() + "/employe.jsp");
        } else {
            // Utilisateur non connecté, gérer l'erreur ou rediriger vers la page de connexion
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
