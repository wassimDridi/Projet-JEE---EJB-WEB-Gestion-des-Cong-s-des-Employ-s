package domaine;

import domaine.Conge;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CongeServiceBeanLocal {
    void ajouterConge(Conge conge);
    List<Conge> listerCongesParUtilisateur(Long utilisateurId);
}
