package connexion;

import javax.ejb.Remote;

import domaine.Conge;

import java.util.List;

@Remote
public interface UtilisateurServiceRemote {
    void ajouterUtilisateur(Utilisateur utilisateur);
    Utilisateur authentifierUtilisateur(String login, String password);
    void demanderConge(Conge conge);
    List<Conge> listerCongesParUtilisateur(Long utilisateurId);
}
