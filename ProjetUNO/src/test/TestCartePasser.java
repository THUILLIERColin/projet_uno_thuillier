package test;

import expert.ExpertCartePasserCartePasser;
import expert.ExpertCartePasserCarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCartePasser;
import fichiers.ParserCarteSimple;
import partie.Partie;

public class TestCartePasser {
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCartePasser.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

            Parser premierParser = new ParserCarteSimple(new ParserCartePasser(null));

            Fichier.lire(nomDuFichier, premierParser);

            partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePasserCartePasser( new ExpertCartePasserCarteSimple(null))));

            partie.initialisationPartie(3);

            /*
                    TEST 1 : PASSER


            System.out.println("\n---------------------------------\nTEST 1 : Passer\n");

            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());

                System.out.println("");
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
                partie.getJoueurCourant().finirTour();
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());

                System.out.println("");
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
                partie.getJoueurCourant().finirTour();
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());

            }catch (Exception e){
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
            }

            /*
                    TEST 2 : CARTE SIMPLE ILLEGALE


            System.out.println("\n---------------------------------\nTEST 2 : CARTE SIMPLE ILLEGALE\n\n");

            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();

                System.out.println("");
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println(""+ partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();
            }catch (Exception e){
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
                System.out.println(""+ partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
            }

            /*
                    TEST 2 : CARTE PASSE TOUR ILLEGALE
             */

            System.out.println("\n---------------------------------\nTEST 2 : CARTE PASSE TOUR ILLEGALE\n\n");

            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
                partie.getJoueurCourant().finirTour();

                System.out.println("");
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(2));
                partie.getJoueurCourant().finirTour();

                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println(""+ partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
                partie.getJoueurCourant().finirTour();
            }catch (Exception e){
                System.out.println("\nATTENTION " + e.getMessage()+"\n");
                System.out.println(""+ partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
