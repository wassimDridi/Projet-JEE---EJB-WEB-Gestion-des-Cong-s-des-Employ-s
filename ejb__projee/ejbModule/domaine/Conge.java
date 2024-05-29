package domaine;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import connexion.Utilisateur;

@Entity
public class Conge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Temporal(TemporalType.DATE)
    private Date dateRupture;

    @Column(length = 20)
    private String etat;

    @ManyToOne
    private Utilisateur utilisateur;


    // Getters

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Date getDateRupture() {
        return dateRupture;
    }

    public String getEtat() {
        return etat;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setDateRupture(Date dateRupture) {
        this.dateRupture = dateRupture;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // toString() method

    @Override
    public String toString() {
        return "Conge{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", dateRupture=" + dateRupture +
                ", etat='" + etat + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
    public Conge() {
        super();
    }

    public Conge(String description, Date dateDebut, Date dateFin, String etat, Utilisateur utilisateur) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.utilisateur = utilisateur;
    }
}
