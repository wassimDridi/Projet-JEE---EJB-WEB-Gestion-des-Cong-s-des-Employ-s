package connexion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String code;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateEmbauchement;

    @Column(length = 50)
    private String login;

    @Column(length = 10)
    private String password;

    @Column(length = 10, columnDefinition = "VARCHAR(11) DEFAULT 'EMPLOYE'")
    private String type;

    private static final long serialVersionUID = 1L;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String code, String nom, String prenom, Date dateEmbauchement, String login, String password, String type) {
        super();
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauchement = dateEmbauchement;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    // Getters and setters...
    // Getters

  

    public Long getId() {
		return id;
	}

    public String getCode() {
        return code;
    }

   
	public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateEmbauchement() {
        return dateEmbauchement;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateEmbauchement(Date dateEmbauchement) {
        this.dateEmbauchement = dateEmbauchement;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", dateEmbauchement=" + dateEmbauchement + ", login=" + login + ", password=" + password + ", type=" + type + "]";
    }
    

}
