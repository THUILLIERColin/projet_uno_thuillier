package test;

import cartes.Carte;
import cartes.CartePasser;
import cartes.CarteSimple;
import exceptions.CartesValideException;
import expert.ExpertCartePasserCartePasser;
import expert.ExpertCartePasserCarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCartePasser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class TestCartePasser {
    @Test
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

        //test alice joueur courant
        assertTrue(partie.getJoueurCourant()==alice);

        try {
            Carte PasserRouge = alice.getCarte(0);
            alice.jouer(PasserRouge);
            alice.finirTour();

            //verification charles joueur courant
            assertTrue(partie.getJoueurCourant()==charles);

            //verification carte du tas = passe tour rouge
            assertTrue(partie.getPremiereCarteTas().equals(new CartePasser(Carte.Color.ROUGE)));

            Carte PasserVert = charles.getCarte(1);
            charles.jouer(PasserVert);
            charles.finirTour();


            //verification bob joueur courant
            assertTrue(partie.getJoueurCourant()==bob);

            //verification carte du tas = passe tour vert
            assertTrue(partie.getPremiereCarteTas().equals(new CartePasser(Carte.Color.VERT)));

            Carte Vert6 = bob.getCarte(1);
            bob.jouer(Vert6);
            bob.finirTour();

            //verification charles joueur courant
            assertTrue(partie.getJoueurCourant()==charles);

            //verification carte du tas = 6 vert
            assertTrue(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 6)));

        } catch (Exception e) {
            System.out.println("\nATTENTION " + e.getMessage() + "\n");
            exit(1);
        }
    }

    @Test
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

        //verification alice joueur courant
        assertTrue(partie.getJoueurCourant()==alice);

        try {
            Carte PasserRouge = alice.getCarte(0);
            alice.jouer(PasserRouge);
            alice.finirTour();

            //verification charles joueur courant
            assertTrue(partie.getJoueurCourant()==charles);

            //verification Charle possède 3 carte
            assertEquals(3,partie.getJoueurCourant().getTailleDeLaMain());

            Carte Bleu1 = charles.getCarte(0);
            charles.jouer(Bleu1);
            charles.finirTour();

        } catch (CartesValideException e) {
            //verification Charle a 3 carte
            assertEquals(3,partie.getJoueurCourant().getTailleDeLaMain());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            exit(1);
        }
    }

    @Test
    private static void Test3() {
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
                    TEST 3 : CARTE PASSE TOUR ILLEGALE
        */

        //verification alice joueur courant
        assertTrue(partie.getJoueurCourant()==alice);

        try {
            Carte Bleu9 = alice.getCarte(1);
            alice.jouer(Bleu9);
            alice.finirTour();

            Carte Bleu7 = bob.getCarte(2);
            bob.jouer(Bleu7);
            bob.finirTour();

            //verification charles joueur courant
            assertTrue(partie.getJoueurCourant()==charles);

            //verification Charle possède 3 carte
            assertEquals(3,partie.getJoueurCourant().getTailleDeLaMain());

            Carte PasserVert = charles.getCarte(1);
            charles.jouer(PasserVert);
            charles.finirTour();

        } catch (CartesValideException e) {
            //verification Charle possède 3 carte
            assertEquals(3,partie.getJoueurCourant().getTailleDeLaMain());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args) {
        try {
            Test1();
            Partie.getInstance().reinitialiserPartie();
            Test2();
            Partie.getInstance().reinitialiserPartie();
            Test3();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}