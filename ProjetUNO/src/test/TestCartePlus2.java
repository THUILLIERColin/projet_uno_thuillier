package test;

import cartes.Carte;
import expert.ExpertCartePlus2CartePlus2;
import expert.ExpertCartePlus2CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import fichiers.ParserPlus2;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class TestCartePlus2 {
    @Test
    private static void Test1(){
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePlus2.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserPlus2(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(null))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        //test alice joueur courant
        assertTrue(partie.getJoueurCourant()==alice);

        try{
            Carte Plus2vert = alice.getCarte(0);
            alice.jouer(Plus2vert);

            alice.finirTour();

            //verification bob joueur courant
            assertTrue(partie.getJoueurCourant()==bob);

            //verification bob possède 3 carte
            assertEquals(3,partie.getJoueurCourant().getTailleDeLaMain());

            //bob prend le +2
            bob.encaisser();

            //verification bob 5 carte
            assertEquals(5,bob.getTailleDeLaMain());

            //verification Charle joueur courant
            assertTrue(partie.getJoueurCourant()==charles);
            Carte Vert1 = charles.getCarte(2);
            charles.jouer(Vert1);
            charles.finirTour();

            assertEquals(2,charles.getTailleDeLaMain());
        }catch (Exception e){
            System.out.println(("/ATTENTION "+e.getMessage()));
            exit(1);
        }
    }

    private static void Test2(){
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePlus2.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserPlus2(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(null))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);


        //test alice joueur courant
        assertTrue(partie.getJoueurCourant()==alice);

        try{
            //Alice pioche 1 carte
            alice.piocher();
            alice.finirTour();

            //verification bob joueur courant
            assertTrue(partie.getJoueurCourant()==bob);

            //Bob pioche 1 carte
            bob.piocher();
            bob.finirTour();

            //verification Charle joueur courant
            assertTrue(partie.getJoueurCourant()==charles);

            //charle joue le +2 vert
            Carte Vert2 = charles.getCarte(1);
            charles.jouer(Vert2);
            charles.finirTour();

            //test alice joueur courant
            assertTrue(partie.getJoueurCourant()==alice);

            //Alice joue le +2 vert
            Carte Vert2bis = alice.getCarte(0);
            alice.jouer(Vert2bis);
            alice.finirTour();

            //verification bob joueur courant
            assertTrue(partie.getJoueurCourant()==bob);

            //verification bob 4 carte
            assertEquals(4,partie.getJoueurCourant().getTailleDeLaMain());

            //bob encaisse
            bob.encaisser();

            //verification bob 8 carte
            assertEquals(8,bob.getTailleDeLaMain());

            //verification Charle joueur courant
            assertTrue(partie.getJoueurCourant()==charles);

        }catch (Exception e){
            System.out.println(("/ATTENTION "+e.getMessage()));
            exit(1);
        }
    }
    public static void main(String[] args) {
        try {
            Test1();
            Partie.getInstance().reinitialiserPartie();
            Test2();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
