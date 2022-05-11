package test;

import cartes.Carte;
import cartes.CartePasser;
import cartes.CarteSimple;
import expert.ExpertCartePasserCartePasser;
import expert.ExpertCartePasserCarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCartePasser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

import java.rmi.NotBoundException;

public class TestCartePasser {
    private static void Test1() {
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePasser.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserCartePasser(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePasserCartePasser(new ExpertCartePasserCarteSimple(null))));
        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");


        partie.initialisationPartie(3);

            /*
                    TEST 1 : PASSER
            */
        int NbTestPassee = 0, NbTest = 0;
        System.out.println("\n---------------------------------\nTEST 1 : Passer\n");

        System.out.println("" + partie.getJoueurCourant());

        //test alice joueur courant
        if (partie.getJoueurCourant().getNom() == "Alice") {
            NbTestPassee++;
        } else {
            System.out.println("Alice n'est pas le joueur courant");
        }
        NbTest++;

        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            //verification charles joueur courant
            if (partie.getJoueurCourant().getNom() == "Charles") {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

            //verification carte du tas = passe tour rouge
            if (partie.getPremiereCarteTas().equals(new CartePasser(Carte.Color.ROUGE))) NbTestPassee++;
            else
                System.out.println("La premiere carte du tas n'est pas le PASSE TOUT ROUGE");
            NbTest++;

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            //verification bob joueur courant
            if (partie.getJoueurCourant().getNom() == "Bob") {
                NbTestPassee++;
            } else {
                System.out.println("Bob n'est pas le joueur courant");
            }
            NbTest++;

            //verification carte du tas = passe tour vert
            if (partie.getPremiereCarteTas().equals(new CartePasser(Carte.Color.VERT))) NbTestPassee++;
            else
                System.out.println("La premiere carte du tas n'est pas le PASSE TOUT ROUGE");
            NbTest++;

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            NbTestPassee++;
            NbTest++;
            partie.getJoueurCourant().finirTour();

            //verification charles joueur courant
            if (partie.getJoueurCourant().getNom() == "Charles") {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

            //verification carte du tas = 6 vert
            if (partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 6))) NbTestPassee++;
            else
                System.out.println("La premiere carte du tas n'est pas le PASSE TOUT ROUGE");
            NbTest++;

            System.out.println("Test passé : " + NbTestPassee + "/" + NbTest);

        } catch (Exception e) {
            System.out.println("\nATTENTION " + e.getMessage() + "\n");
        }
    }

    private static void Test2() {
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePasser.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserCartePasser(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePasserCartePasser(new ExpertCartePasserCarteSimple(null))));
        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        System.out.println("\n---------------------------------\nTEST 2 : CARTE SIMPLE ILLEGALE CARTE PASSER\n\n");
        int NbTestPassee = 0, NbTest = 0;

        //verification alice joueur courant
        if (partie.getJoueurCourant().getNom() == "Alice") {
            NbTestPassee++;
        } else {
            System.out.println("Alice n'est pas le joueur courant");
        }
        NbTest++;

        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            NbTestPassee++;
            NbTest++;
            partie.getJoueurCourant().finirTour();

            //verification charles joueur courant
            if (partie.getJoueurCourant().getNom() == "Charles") {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

            //verification Charle possède 3 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPassee++;
            else
                System.out.println("Charle ne possède pas 3 cartes");
            NbTest++;

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

        } catch (Exception e) {
            System.out.println("\nATTENTION " + e.getMessage() + "\n");
            //verification Charle a 3 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPassee++;
            else
                System.out.println("Charle ne possède pas 3 cartes");
            NbTest++;
            System.out.println("Test passé : " + NbTestPassee + "/" + NbTest);

        }
    }

    private void Test3() {
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePasser.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserCartePasser(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePasserCartePasser(new ExpertCartePasserCarteSimple(null))));
        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);
        /*
                    TEST 2 : CARTE PASSE TOUR ILLEGALE
             */

        System.out.println("\n---------------------------------\nTEST 2 : CARTE PASSE TOUR ILLEGALE SUR CARTE SIMPLE\n\n");
        int NbTest = 0, NbTestPassee = 0;

        //verification alice joueur courant
        if (partie.getJoueurCourant().getNom() == "Alice") {
            NbTestPassee++;
        } else {
            System.out.println("Alice n'est pas le joueur courant");
        }
        NbTest++;

        try {
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(2));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            //verification charles joueur courant
            if (partie.getJoueurCourant().getNom() == "Charles") {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

            //verification Charle possède 3 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPassee++;
            else
                System.out.println("Charle ne possède pas 3 cartes");
            NbTest++;

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();
        } catch (Exception e) {
            System.out.println("\nATTENTION " + e.getMessage() + "\n");
            //verification Charle possède 3 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPassee++;
            else
                System.out.println("Charle ne possède pas 3 cartes");
            NbTest++;

            System.out.println("Test passé : " + NbTestPassee + "/" + NbTest);
        }
    }

    public static void main(String[] args) {
        try {
            Test1();
            Partie.getInstance().reinitialiserPartie();
            Test2();
            Partie.getInstance().reinitialiserPartie();
            //Test3();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}