package mediatheque.metier;

public class Etudiant extends Adherent{
    private Universite campus;

    public Universite getCampus() {
        return campus;
    }

    public void setCampus(Universite campus) {
        this.campus = campus;
    }

    public Etudiant(String nom, String prenom, String dateNaissance, Universite camp) {
        super(nom, prenom, dateNaissance);

        setCampus(camp);
    }

    @Override
    public String toString() {
        //return getNom() + getPrenom() + getAge() + getCampus();
        return super.toString() + " (" + getAge() + " ans " + getCampus();
    }

    @Override
    public Location louer(Ressource res) {
        System.out.println("Location gratuite de " + res + " par " + this);
        return(null);
    }
}
