package test;

import cartes.Carte;
import cartes.CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

public class TestCarteSimple {

    private static void Test1(Joueur alice, Joueur bob){
        /*
                    TEST 1 : ALICE
         */
        Partie partie = Partie.getInstance();

        int NbTestPasse=0,NbTest=0;

        System.out.println("\n---------------------------------\nTEST 1 : ALICE\n");

        if(partie.getJoueurCourant()==alice) NbTestPasse++; NbTest++;
        if(partie.getJoueurCourant().TailleDeLaMain()==3)NbTestPasse++; NbTest++;

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));NbTestPasse++; NbTest++;

            if(partie.getJoueurCourant().TailleDeLaMain()==2)NbTestPasse++; NbTest++;

            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 6)))NbTestPasse++; NbTest++;
            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.ROUGE, 1)))NbTestPasse++; NbTest++;

            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 2)))NbTestPasse++; NbTest++;
            if(partie.getTailleTas()==2)NbTestPasse++; NbTest++;
            partie.getJoueurCourant().finirTour();

            if(partie.getJoueurCourant()==bob) NbTestPasse++; NbTest++;
        }catch (Exception e){
            System.out.println("\nATTENTION " + e.getMessage()+"\n");
        }

        System.out.println("Test passé : "+NbTestPasse+"/"+NbTest);

    }

    private static void Test2(Joueur charles){
        /*
                    TEST 2 : BOB
         */

        Partie partie = Partie.getInstance();

        int NbTestPasse=0,NbTest=0;

        System.out.println("\n---------------------------------\nTEST 2 : BOB\n");

        if(partie.getJoueurCourant().TailleDeLaMain()==3)NbTestPasse++; NbTest++;

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));

            if(partie.getJoueurCourant().TailleDeLaMain()==2)NbTestPasse++; NbTest++;

            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 4)))NbTestPasse++; NbTest++;
            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.ROUGE, 9)))NbTestPasse++; NbTest++;

            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.BLEU, 2)))NbTestPasse++; NbTest++;

            if(partie.getTailleTas()==3)NbTestPasse++; NbTest++;
            partie.getJoueurCourant().finirTour();
            if(partie.getJoueurCourant().equals(charles))NbTestPasse++; NbTest++;
        }catch (Exception e){
            System.out.println("\nATTENTION " + e.getMessage()+"\n");
        }
        System.out.println("Test passé : "+NbTestPasse+"/"+NbTest);
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
            Test2(charles);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

