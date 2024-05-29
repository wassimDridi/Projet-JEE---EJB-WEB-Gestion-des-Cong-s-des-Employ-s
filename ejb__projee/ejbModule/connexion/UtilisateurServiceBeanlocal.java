package connexion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domaine.Conge;

@Stateless
public class UtilisateurServiceBeanlocal implements UtilisateurServicelocal, UtilisateurServiceRemote {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);
    }

    @Override
    public Utilisateur authentifierUtilisateur(String login, String password) {
        try {
            return entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :password", Utilisateur.class)
                                .setParameter("login", login)
                                .setParameter("password", password)
                                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void demanderConge(Conge conge) {
        entityManager.persist(conge);
    }

    @Override
    public List<Conge> listerCongesParUtilisateur(Long utilisateurId) {
        return entityManager.createQuery("SELECT c FROM Conge c WHERE c.utilisateur.id = :utilisateurId", Conge.class)
                            .setParameter("utilisateurId", utilisateurId)
                            .getResultList();
    }
}
