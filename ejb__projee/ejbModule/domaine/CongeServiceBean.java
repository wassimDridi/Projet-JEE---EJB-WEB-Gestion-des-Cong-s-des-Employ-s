package domaine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CongeServiceBean implements CongeServiceBeanLocal, CongeServiceBeanRemote {
    
    @PersistenceContext(unitName = "ejb__projee")
    private EntityManager entityManager;

    @Override
    public void ajouterConge(Conge conge) {
        entityManager.persist(conge);
    }

    @Override
    public List<Conge> listerCongesParUtilisateur(Long utilisateurId) {
        return entityManager.createQuery("SELECT c FROM Conge c WHERE c.utilisateur.id = :userId", Conge.class)
                .setParameter("userId", utilisateurId)
                .getResultList();
    }
}
