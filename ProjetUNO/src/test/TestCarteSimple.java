package test;

import cartes.Carte;
import cartes.CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarteSimple {

    @Test
    private static void Test1(Joueur alice, Joueur bob){
        /*
                    TEST 1 : ALICE
         */
        Partie partie = Partie.getInstance();

        assertTrue(partie.getJoueurCourant()==alice);
        assertEquals(3,alice.getTailleDeLaMain());

        try {

            Carte Vert2 = alice.getCarte(0);
            alice.jouer(Vert2);

            assertEquals(2, alice.getTailleDeLaMain());
            assertTrue(alice.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 6)));
            assertTrue(alice.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE, 1)));
            assertTrue(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 2)));

            assertEquals(2, partie.getTailleTas());

            partie.getJoueurCourant().finirTour();

            assertTrue(partie.getJoueurCourant() == bob);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            exit(1);
        }

    }

    private static void Test2(Joueur bob,Joueur charles){
        /*
                    TEST 2 : BOB
         */

        Partie partie = Partie.getInstance();

        assertEquals(3, bob.getTailleDeLaMain());

        try {
            Carte Bleu2 = bob.getCarte(0);
            bob.jouer(Bleu2);

            assertEquals(2, bob.getTailleDeLaMain());
            assertTrue(bob.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 4)));
            assertTrue(bob.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE, 9)));


            assertTrue(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.BLEU, 2)));
            assertEquals(3, partie.getTailleTas());
            bob.finirTour();

            assertTrue(partie.getJoueurCourant() == charles);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args) {
        try {
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

            Test1(alice,bob);
            Test2(bob,charles);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

