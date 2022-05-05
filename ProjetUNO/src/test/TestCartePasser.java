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
                System.out.println(e);
            }

            /*
                    TEST 2 : CARTE SIMPLE ILLEGALE
             */

            System.out.println("\n---------------------------------\nTEST 2 : CARTE SIMPLE ILLEGALE\n\n");

            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());

            /*
            Vérifier que Alice est bien le joueur courant
            Alice pose le « Passe ton tout rouge »
            Alice finit son tour
            Vérifier que Charles est le joueur courant Vérifier que Charles possède bien 3 cartes
            Charles pose le « 1 Bleu »
            Charles finit son tour
            Vérifier dans l’exception appropriée que Charles a toujours 3 cartes
             */

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();

                System.out.println("");
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println(""+ partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();
            }catch (Exception e){
                System.out.println(e);
                System.out.println(""+ partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
            }


        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
