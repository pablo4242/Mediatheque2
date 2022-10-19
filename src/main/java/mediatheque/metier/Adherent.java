package mediatheque.metier;

import java.time.LocalDate;

public class Adherent extends Personne {

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    private LocalDate dateAdhesion;

    public Adherent(String nom, String prenom, String dateNaissance) {
        //Appel du constructeur parent.
        //On lui passe les informations reçues : il sait comment les traiter
        super(nom, prenom, dateNaissance);

    }

    public Location louer(Ressource res)
    {
        System.out.println("Location de "+ res +" par " + this);
        return null;
    }
}
