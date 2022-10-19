package mediatheque.test;

import java.time.LocalTime;
import java.time.Year;

public class TestSyntaxe {

    public static void saluer()
    {
        System.out.println("Bonjour Monsieur");
        System.out.println("Il est actuellement " + LocalTime.now());
    }

    public static double calculerPerimetreCercle (double rayon)
    {
        return 2 * Math.PI * rayon;
    }

    public static void saluer(boolean SEXE, String nom)
    {
        if (SEXE)
            System.out.println("Bonjour Monsieur "+ nom);
        else
            System.out.println("Bonjour Madame "+ nom);
    }

    /**
    * Cette méthode affiche bonjour avec nom puis genre en para
    * @param nom
    * c'est le nom de famille
    * @param genre
    * 1 ou 2
    * */
    public static void saluer(String nom, int genre)
    {
        switch (genre)
        {
            case 1:
                System.out.println("Bonjour Monsieur " + nom);
                break;
            case 2:
                System.out.println("Bonjour Madame "+ nom);
        }
    }

    public static void main(String[] args) {

        //Déclaration et valorisation d'une variable
        int compteur;

        compteur = 20;

        System.out.println("Le compteur vaut : " + compteur);

        //Déclaration et valorisation d'une constante
        final boolean SUCCES = true;

        //Réalisation d'un test
        if (compteur >= 100 && SUCCES == true)
        {
            System.out.println("Le compteur a une valeur importante.");
        }
        else
        {
            System.out.println("Le compteur est faible.");
        }

        for (int i=1 ; i<=10; i++) {
            if (i == 5) continue;
            System.out.println(i + " x 7 = " + i*7);
        }

        // Afficher les 4 premières années bissextiles après 1857
        Year annee = Year.of(1857);
        int nbAnneesBissextilesTrouvees = 0;

        //2
        while (nbAnneesBissextilesTrouvees < 4)
        {
            if (annee.isLeap())
            {
                System.out.println(annee);
                nbAnneesBissextilesTrouvees++;
            }
            annee = annee.plusYears(1);
        }

        //3
        double valeur = 1234567;
        do {
            System.out.println(valeur);
            valeur = valeur / Math.PI;
        }
        while (valeur >= 3);

        //
        int moisCourant = 10;
        switch (moisCourant)
        {
            case 1:
                System.out.println("31 jours");
                break;
            case 4:
                System.out.println("30 jours");
                break;
            case 10:
                System.out.println("31 jours");
                break;
            default:
                System.out.println("Nombre de jours inconnu.");
        }
        //Tableaux
        String joursDeLaSemaine[] = {"Lundi","Mardi","Mercredi"};
        System.out.println(joursDeLaSemaine[1]);

        String[] codesPostaux = new String[40000];
        for (int i = 0 ; i<40000 ; i++)
        {
            codesPostaux[i] = String.valueOf(i+10000);
        }
        System.out.println(codesPostaux[1]);

        //Tableaux double entrée (matrice)
        String[][] annuaire = new String[21][4];
        annuaire[1][3] = "2001-01-02";
        annuaire[20][0] = "N21";

        System.out.println(annuaire[1][2]);

        //Affichage de tous les jours de la semaine
        for ( String unJour : joursDeLaSemaine)
        {
            System.out.println(unJour);
        }

        //Invocation de la méthode "saluer"
        saluer();

        double perimetre = calculerPerimetreCercle(12);
        System.out.println(perimetre);

        // exercice
        saluer(true, "Durand");
        saluer(false, "Dupond");
        saluer("Dumont", 1);
        saluer("Dumont", 2);

    }
}
