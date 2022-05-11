package test;

import cartes.Carte;
import cartes.CarteSimple;
import expert.*;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

public class TestCarteSimpleIllegale {

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

        int NbTestPasse = 0, NbTest = 0;

        System.out.println("\n---------------------------------\nTEST 1 : MAUVAISE CARTE\n");

        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
        } catch (Exception e) {
            // System.out.println("\nATTENTION " + e.getMessage()+"\n");
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPasse++;
            NbTest++;
            if (partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 6))) NbTestPasse++;
            NbTest++;
        }

        System.out.println("Test passé : " + NbTestPasse + "/" + NbTest);

    }

    private static void Test2() {
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

        int NbTestPasse = 0, NbTest = 0;

        System.out.println("\n---------------------------------\nTEST 2 : JOUE 2X\n");

        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            partie.getJoueurCourant().finirTour();
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            partie.getJoueurCourant().finirTour();
            // Bob et Alice ont joué

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            if (partie.getJoueurCourant().TailleDeLaMain() == 2) NbTestPasse++;
            else System.out.println("Charles ne possede pas 2 cartes");
            NbTest++;

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
        } catch (Exception e) {
            // System.out.println("\nATTENTION " + e.getMessage()+"\n");
            if (partie.getJoueurCourant().TailleDeLaMain() == 2) NbTestPasse++;
            else System.out.println("Charles ne possede pas 2 cartes");
            NbTest++;
            if (partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.BLEU, 7))) NbTestPasse++;
            else System.out.println("Charles ne possede pas le 7 BLEU");
            NbTest++;
        }

        System.out.println("Test passé : " + NbTestPasse + "/" + NbTest);
    }

    private static void Test3() {
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

        int NbTestPasse = 0, NbTest = 0;

        System.out.println("\n---------------------------------\nTEST 3 : FINIR LE TOUR \n");

        try {
            partie.getJoueurCourant().finirTour();
        } catch (Exception e) {
            // System.out.println("\nATTENTION " + e.getMessage()+"\n");
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPasse++;
            NbTest++;
        }

        System.out.println("Test passé : " + NbTestPasse + "/" + NbTest);
    }

    private static void Test4() {
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

        int NbTestPasse = 0, NbTest = 0;

        System.out.println("\n---------------------------------\nTEST 4 : PIOCHE\n");

        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            partie.getJoueurCourant().piocher();
        } catch (Exception e) {
            // System.out.println("\nATTENTION " + e.getMessage()+"\n");
            if (partie.getJoueurCourant().TailleDeLaMain() == 2) NbTestPasse++;
            NbTest++;
            if (partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.JAUNE, 6))) NbTestPasse++;
            NbTest++;
        }

        System.out.println("Test passé : " + NbTestPasse + "/" + NbTest);
    }


    public static void main(String[] args) {
        try {

            Test1();
            Partie.getInstance().reinitialiserPartie();
            Test2();
            Partie.getInstance().reinitialiserPartie();
            Test3();
            Partie.getInstance().reinitialiserPartie();
            Test4();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
