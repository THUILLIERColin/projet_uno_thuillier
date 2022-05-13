package test;

import cartes.Carte;
import cartes.CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.*;
import joueur.Joueur;
import partie.Partie;

public class TestPunition {
    private static void Test1() {
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimple.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);


        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        int NbTest = 0, NbTestPasse = 0;

        /*
                    TEST 1 : ALICE
            */

        System.out.println("\n---------------------------------\nTEST 1 : ALICE\n");
        if(partie.getJoueurCourant()==alice)NbTestPasse++;
        else
            System.out.println("Le joueur courant n'est pas Alice");
        NbTest++;
        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
        } catch (Exception e) {
            // System.out.println("\nATTENTION " + e.getMessage() + "\n");
            try {
                partie.getJoueurCourant().punir(e);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if(partie.getJoueurCourant()==bob)NbTestPasse++;
            else
                System.out.println("Le joueur courant est " + partie.getJoueurCourant());
            NbTestPasse++;
            if(alice.TailleDeLaMain()==5)NbTestPasse++;
            else
                System.out.println("Alice possede " + alice.TailleDeLaMain() + " cartes");
            NbTest++;
            if(alice.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE,6)))NbTestPasse++;
            else
                System.out.println("Alice ne possede pas la carte 6 JAUNE");
            NbTest++;
            if(alice.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE,4)))NbTestPasse++;
            else
                System.out.println("Alice ne possede pas la carte 4 ROUGE");
            NbTest++;
            if(partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.VERT,2)))NbTestPasse++;
            else
                System.out.println("La prochaine carte de la pioche est " + partie.getPremiereCartePioche());
            NbTest++;
        }
        System.out.println("Test passé : "+NbTestPasse+"/"+NbTest);
    }

    private static void Test2() {
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimple.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserCartePasser(new ParserPlus2(new ParserChangerCouleur(null))));


        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        /*
                    TEST 2 : BOB
        */

        int NbTest = 0, NbTestPasse = 0;

        System.out.println("\n---------------------------------\nTEST 2 : BOB\n");

        if(partie.getJoueurCourant()==alice)NbTestPasse++;
        else
            System.out.println("Le joueur courant est " + partie.getJoueurCourant());
        NbTest++;

        try {
            partie.getJoueur(1).piocher();
            System.out.println("Bob possède : " + partie.getJoueurCourant().TailleDeLaMain() + " cartes");
        } catch (Exception e) {
            System.out.println("\nATTENTION " + e.getMessage() + "\n");
            try {
                partie.getJoueur(1).punir(e);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Le joueur courant est " + partie.getJoueurCourant());
            System.out.println("Bob a la main : " + partie.getJoueur(1).getLaMain());
            System.out.println("La prochaine carte de la pioche est " + partie.getPremiereCartePioche());
        }

    }

    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            Test1();
            partie.reinitialiserPartie();
            Test2();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
