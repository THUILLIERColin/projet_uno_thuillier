package test;

import cartes.Carte;
import cartes.CarteSimple;
import exceptions.*;
import expert.*;
import fichiers.*;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarteSimpleIllegale {
    @Test
    private static void Test1(){
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


        try {
            Carte Jaune6= alice.getCarte(1);
            alice.jouer(Jaune6);
        } catch (CartesValideException e) {
            assertEquals(3, alice.getTailleDeLaMain());
            assertTrue(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 6)));
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            exit(1);
        }
    }

    @Test
    private static void Test2(){
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

        try {
            Carte Vert2 = alice.getCarte(0);
            alice.jouer(Vert2);
            alice.finirTour();

            Carte Bleu2 = bob.getCarte(0);
            bob.jouer(Bleu2);
            bob.finirTour();

            // Bob et Alice ont joué

            Carte Bleu6= charles.getCarte(0);
            charles.jouer(Bleu6);

            assertEquals(2,charles.getTailleDeLaMain());

            Carte Bleu7 = charles.getCarte(0);
            charles.jouer(Bleu7);

        } catch (JoueurException e) {
            assertEquals(2, charles.getTailleDeLaMain());
            assertTrue(charles.getLaMain().contains(new CarteSimple(Carte.Color.BLEU, 7)));
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            exit(1);
        }
    }

    private static void Test3(){
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

        try {
            alice.finirTour();
        } catch (JoueurException e) {
            assertEquals(3,partie.getJoueurCourant().getTailleDeLaMain());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            exit(1);
        }
    }

    private static void Test4(){
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

        try {
            Carte Vert2 = alice.getCarte(0);
            alice.jouer(Vert2);
            alice.piocher();
        } catch (JoueurException e) {
            assertEquals(2,partie.getJoueurCourant().getTailleDeLaMain());
            assertTrue(partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.JAUNE, 6)));
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
            Partie.getInstance().reinitialiserPartie();
            Test4();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
