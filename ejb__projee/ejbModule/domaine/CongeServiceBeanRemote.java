package domaine;

import domaine.Conge;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CongeServiceBeanRemote {
    void ajouterConge(Conge conge);
    List<Conge> listerCongesParUtilisateur(Long utilisateurId);
}
