package connexion;

import javax.ejb.Local;

import domaine.Conge;

import java.util.List;

@Local
public interface UtilisateurServicelocal {
    void ajouterUtilisateur(Utilisateur utilisateur);
    Utilisateur authentifierUtilisateur(String login, String password);
    void demanderConge(Conge conge);
    List<Conge> listerCongesParUtilisateur(Long utilisateurId);
}
