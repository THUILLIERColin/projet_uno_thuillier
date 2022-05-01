package test;

import expert.ExpertCarteSimpleSurCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import partie.Partie;

public class TestCarteSimple {
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
                    TEST 1 : ALICE
             */
            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
            System.out.println(""+partie.getJoueurCourant()+" possede "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");


            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                System.out.println(""+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                System.out.println("Alice a la main : " + partie.getJoueurCourant().getLaMain());
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());
                System.out.println("Le nombre de cartes du tas est "+ partie.getTailleTas());
                partie.getJoueurCourant().finirTour();
                System.out.println("C'est le tour de "+ partie.getJoueurCourant());

            }catch (Exception e){
                System.out.println(e);
            }




            /*
                    TEST 2 : BOB
             */

            System.out.println("\n---------------------------------\nTEST 2 : BOB\n");
            System.out.println("\n"+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                System.out.println("Bob possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                System.out.println("Bob a la main : " + partie.getJoueurCourant().getLaMain());
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());
                System.out.println("Le nombre de cartes du tas est "+ partie.getTailleTas());
                partie.getJoueurCourant().finirTour();
                System.out.println("C'est le tour de "+ partie.getJoueurCourant());
            }catch (Exception e){
                System.out.println(e);
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

