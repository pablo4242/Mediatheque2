package mediatheque.metier;

import java.time.LocalDate;
import java.time.Period;

public class Personne
{
    //Propriétes
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    private Carte carte;

    @Override
    public String toString() {
        //Le comportement de toString dans Object ne convient pas pour les personnes.
        //On souhaite récupérer le nom et le prénom
        return getPrenom()+" "+getNom();
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    //Méthodes
    public Personne(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
        //Toute les personnes doivent disposer d'une carte
        setCarte(new Carte(this));
    }

    public Personne(String nom, String prenom, String dateNaissance) {
        this(nom,prenom);
        setDateNaissance(LocalDate.parse(dateNaissance));
    }

    public boolean marcher()
    {
        System.out.println(getPrenom() + " " + getNom() + " marche.");
        return(true);
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    public void setNom(String propositionNom) {

        // on veut au moins 3 carac
        if (propositionNom.length() >= 3) {
            nom = propositionNom;
        }
        else {
            System.out.println("La proposition "+ propositionNom + " est invalide");
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String propositionPrenom) {
        prenom = propositionPrenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public static int getNbAnnees(LocalDate date1, LocalDate date2)
    {
        Period periode = Period.between(date1, date2);
        return periode.getYears();
    }
    public int getAge()
    {
        return getNbAnnees(getDateNaissance(), LocalDate.now());
    }


}
