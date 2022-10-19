package mediatheque.test;

import mediatheque.metier.Ressource;

public class TestRessource {
    public static void main(String[] args) {
        Ressource livre = new Ressource("Asterix");
        System.out.println("La ressource " + livre.getTitre() + " a été créée");
    }
}
