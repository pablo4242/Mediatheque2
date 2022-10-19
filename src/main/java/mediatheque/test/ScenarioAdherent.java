package mediatheque.test;

import mediatheque.metier.*;

import java.time.format.TextStyle;
import java.util.Locale;

public class ScenarioAdherent {
    public static void main(String[] args) {
        //Création d'un adhérent
        Adherent adh1 = new Adherent("durand", "pierre", "1980-04-14");
        //Lui demander le numéro de sa carte
        if (adh1.getCarte() != null) {
            System.out.println(adh1.getCarte().getIdentifiant());
        }
        //Lui demander le nom du jour de sa naissance
        System.out.println(adh1.getDateNaissance()
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.getDefault()));

        //Lui demander de louer "Harry Potter"
        adh1.louer(new Ressource("Harry Potter"));

        //Création d'un actif et d'un étudiant
        Entreprise ent1 = new Entreprise("NomEntreprise1");
        Universite campus1 = new Universite("campus1");
        Actif act1 = new Actif("pierre", "dupond", "1980-04-14",ent1);
        Etudiant etu1 = new Etudiant("toto","dumont", "2000-01-02", campus1);
        //Leur demander de louer une ressource
        etu1.louer(new Ressource("livre1"));
        act1.louer(new Ressource("disque1"));

        //Afficher l'identifiant de la carte de etu1
        System.out.println(etu1.getCarte().getIdentifiant());

        //Gestion d'un tableau d'adhérents
        Adherent[] annuaire = new Adherent[10];
        annuaire[0] = adh1;
        annuaire[1] = act1;
        annuaire[2] = etu1;

        //On demande au tableau de nous fournir l'un des éléments
        Adherent adherentRang2 = annuaire[2];

        // adherentRang2 = etu1 ? oui
        System.out.println(adherentRang2.equals(etu1));

        // on peut atteindre la règle de gestion gratuite de l'adhérent étudiant pour la méthode louer
        adherentRang2.louer(null);
        // mais on ne peut pas atteindre la méthode getCampus, à moins de le caster en Etudiant :
        //Etudiant etudiantRang2 = (Etudiant)adherentRang2;
        //System.out.println(etudiantRang2.getCampus());
        // mais pour être sûr, il faut vérifier que c'est un Etudiant
        if(adherentRang2.getClass().getSimpleName().equals("Etudiant"))
        {
            Etudiant etudiantRang2 = (Etudiant)adherentRang2;
            System.out.println(etudiantRang2.getCampus());
        }

        //Gestion d'un tableau d'objets
        Object[] elements = new Object[10];
        elements[0] = adh1;
        elements[1] = act1;
        elements[2] = etu1;
        elements[3] = etu1.getCarte();
        elements[4] = etu1.getDateNaissance();
        elements[5] = etu1.getCampus();

        if(elements[5] instanceof Personne) {
            Personne pers1 = (Personne) elements[5];
            System.out.println(pers1.getNom() + " " + pers1.getPrenom());
        }

        //On a toujours le droit de regarder un objet comme s'il était issu d'une de ses classes parentes
        Object obj1 = new Actif("nomact2", "prenomact2", "1982-01-02", ent1);
        // alors on ne voit plus que les méthodes de Object
        // puis on peut caster en Personne ou Adherent ... pour accéder aux méthodes Personnes ou Adherent
    }
}
