package test;

import expert.*;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import partie.Partie;

public class TestCarteSimpleIllegale {
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCarteSimple.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

            Parser premierParser = new ParserCarteSimple(null);

            Fichier.lire(nomDuFichier, premierParser);

            partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

            partie.initialisationPartie(3);

            /*
                    TEST 1 : MAUVAISE CARTE
             */

            System.out.println("TEST 1 : MAUVAISE CARTE\n");

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            }catch (Exception e){
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
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
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
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
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
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
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
                System.out.println(""+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                System.out.println("La premiere carte de la pioche est le : " + partie.getPremiereCartePioche());
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
