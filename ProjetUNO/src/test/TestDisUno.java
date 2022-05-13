package test;

import cartes.Carte;
import cartes.CarteSimple;
import exceptions.JoueurException;
import exceptions.UnoException;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;

public class TestDisUno {
    @Test
    private static void Test1(){
        /*
                    TEST 1 : ALICE DIT UNO QUAND IL FAUT
         */
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(2);

        assertTrue(partie.getJoueurCourant()==alice);

        assertEquals(2,alice.getTailleDeLaMain());
        try{
            Carte Vert2 = alice.getCarte(0);
            alice.jouer(Vert2);//alice joue le 2 Vert
            alice.disUNO();//alice dit uno
            assertTrue(partie.getJoueurCourant().getUno());//verification de uno
            alice.finirTour(); //Alice fini le tour
            assertEquals(1, alice.getTailleDeLaMain());//verification que alice a que 1 carte

            assertTrue(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 2)));//verification 1er carte tas = 2vert
            assertTrue(partie.getJoueurCourant()==bob);

        }catch (Exception e){
            System.out.println(e.getMessage());
            exit(1);
        }
    }

    private static void Test2 () throws Exception{
        /*
                    TEST 2 : ALICE OUBLIE UNO
         */
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(2);

        try{
            Carte Vert2 = alice.getCarte(0);
            alice.jouer(Vert2);
            alice.finirTour();
        }catch (UnoException e){
            alice.punirUnoException();

            assertEquals(4,alice.getTailleDeLaMain());

            assertTrue(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 8)));
            assertTrue(partie.getJoueurCourant()==bob);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            exit(1);
        }
    }
    @Test
    private static void Test3(){
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(2);

        //verification Alice joueur courant
        assertTrue(partie.getJoueurCourant()==alice);

        try{
            bob.disUNO();
        }catch (JoueurException e){
            try{
                bob.punir();
            }catch (Exception exception){
                System.out.println(exception.getMessage());
                exit(1);
            }

            assertEquals(4,bob.getTailleDeLaMain());
            assertTrue(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 8)));

            assertTrue(partie.getJoueurCourant()==alice);
        }catch (Exception exception){
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
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}

