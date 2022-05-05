package test;

import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import partie.Partie;

public class TestDisUno {
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCarteSimplePourTestUno.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

            Parser premierParser = new ParserCarteSimple(null);

            Fichier.lire(nomDuFichier, premierParser);

            partie.setExpert(new ExpertCarteSimpleCarteSimple(null));
            partie.initialisationPartie(2);

            /*
                    TEST 1 : DIS UNO
             */


            System.out.println("\n---------------------------------\nTEST 1 : DIS UNO\n");
            System.out.println("\n"+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");

            try {
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().disUNO();
                partie.getJoueurCourant().finirTour();
                System.out.println("\n"+partie.getJoueur(0)+" possède : "+ partie.getJoueur(0).TailleDeLaMain()+" cartes");
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());
                System.out.println("C'est le tour de "+ partie.getJoueurCourant());
            }catch (Exception e){
                System.out.println(e);
            }

            /*
                    TEST 2 : OUBLI UNO
            */


            System.out.println("\n---------------------------------\nTEST 2 : OUBLI UNO\n");
            System.out.println("\n"+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" carte");

            try {
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
                partie.getJoueurCourant().finirTour();
            }catch (Exception e){
                System.out.println(e);
                partie.getJoueurCourant().punir(e);
                System.out.println("\n"+partie.getJoueur(0)+" possède : "+ partie.getJoueur(0).TailleDeLaMain()+" cartes");
                System.out.println("La premiere carte est :" + partie.getPremiereCarteTas());
                System.out.println("C'est le tour de "+ partie.getJoueurCourant());
            }


            /*
                    TEST 3 : C'EST PAS À TOI
             */


            System.out.println("\n---------------------------------\nTEST 3 : C'EST PAS À TOI\n");
            System.out.println("\n"+partie.getJoueurCourant()+" est le joueur courant");

            try {
                partie.getJoueur(1).disUNO();
            }catch (Exception e){
                System.out.println(e);
                partie.getJoueur(1).punir(e);
                System.out.println("\n"+partie.getJoueur(1)+" possède : "+ partie.getJoueur(1).TailleDeLaMain()+" cartes");
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println("La premiere carte du tas est :" + partie.getPremiereCarteTas());

            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

