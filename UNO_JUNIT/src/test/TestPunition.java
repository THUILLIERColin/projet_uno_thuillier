package test;

import cartes.Carte;
import cartes.CarteSimple;
import exceptions.CartesValideException;
import exceptions.JoueurException;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.*;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class TestPunition {
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

        assertTrue(partie.getJoueurCourant()==alice);

        try {
            Carte Jaune6 = alice.getCarte(1);
            alice.jouer(Jaune6);
        } catch (CartesValideException e) {
            try{
            alice.punirCarteValideException();
            }catch (Exception exception){
                System.out.println(exception.getMessage());
                exit(1);
            }
            assertTrue(partie.getJoueurCourant()==bob);

            assertEquals(5,alice.getTailleDeLaMain());
            assertTrue(alice.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE,6)));

            assertTrue(alice.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE,4)));

            assertTrue(partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.VERT,2)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            exit(1);
        }
    }

    private static void Test2(){
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

        assertTrue(partie.getJoueurCourant()==alice);
        try {
            bob.piocher();
        } catch (JoueurException e) {
            try{
            bob.punir();
            }catch (Exception exception){
                System.out.println(exception.getMessage());
                exit(1);
            }

            assertTrue(partie.getJoueurCourant()==alice);
            assertEquals(5, bob.getTailleDeLaMain());


            assertTrue(bob.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE,6)));
            assertTrue(bob.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE,4)));

            assertTrue(partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.VERT,2)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            exit(1);
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
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
