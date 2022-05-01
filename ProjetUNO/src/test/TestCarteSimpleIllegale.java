package test;

import exceptions.CartesValideException;
import exceptions.JoueurException;
import exceptions.UnoException;
import expert.*;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

public class TestCarteSimpleIllegale {
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCarteSimple.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();
            // Maintenant, à vous de jouer !

            Parser premierParser = new ParserCarteSimple(null);

			/* Ou bien

			Parser premierParser =null;
			premierParser =new ParserCaseDepart(premierParser);
			premierParser = new ParserGare(premierParser);

			 */



            // A vous de créer des parser puis de les chainer les uns aux autres avant d'envoyer
            // le premier à la méthode lire

            Fichier.lire(nomDuFichier, premierParser);

            /*
                    TEST AFFICHAGE CARTE : OK
             */

            partie.setExpert(new ExpertCarteSimpleSurCarteSimple(null));

            partie.initialisationPartie(3);

            /*
                    TEST 1 : MAUVAISE CARTE
             */

            System.out.println("TEST 1 : MAUVAISE CARTE\n");

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            }catch (Exception e){
                System.out.println(e);
                System.out.println(""+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                System.out.println("La carte : " + partie.getJoueurCourant().getCarte(1) + " en fait partie");
            }

            /*
                    TEST 2 : JOUE 2X


            System.out.println("\n---------------------------------\nTEST 2 : JOUE 2X\n");

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();
                // Bob et Alice ont joué

                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                System.out.println(""+partie.getJoueurCourant()+" possede "+ partie.getJoueurCourant().TailleDeLaMain() +" cartes");

                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            }catch (Exception e){
                System.out.println(e);
                System.out.println(""+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                System.out.println("La carte : " + partie.getJoueurCourant().getCarte(0) + " en fait partie");
            }

            /*
                    TEST 3 : FINIR LE TOUR
             */

            System.out.println("\n---------------------------------\nTEST 3 : FINIR LE TOUR \n");

            try{
                partie.getJoueurCourant().finirTour();
            }catch (Exception e){
                System.out.println(e);
                System.out.println(" "+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
            }

            /*
                    TEST 4 : PIOCHE
             */

            System.out.println("\n---------------------------------\nTEST 4 : PIOCHE\n");

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().piocher();
            }catch (Exception e){
                System.out.println(e);
                System.out.println(""+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                System.out.println("La premiere carte de la pioche est le : " + partie.getPremiereCartePioche());
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
