package test;

import cartes.Carte;
import cartes.CarteSimple;
import exceptions.CartesValideException;
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

        if(partie.getJoueurCourant()==alice) NbTestPasse++;
        else
            System.out.println("Alice n'est pas le joueur courant");
        NbTest++;
        if(partie.getJoueurCourant().TailleDeLaMain()==3)NbTestPasse++;
        else
            System.out.println("Alice ne possède pas 3 cartes");
        NbTest++;

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));NbTestPasse++;            NbTest++;

            if(partie.getJoueurCourant().TailleDeLaMain()==2)NbTestPasse++;
            else
                System.out.println("Alice ne possede pas 2 cartes");
            NbTest++;

            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 6)))NbTestPasse++;
            else
                System.out.println("La carte 6 JAUNE n'est pas dans la main d'alice");
            NbTest++;
            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.ROUGE, 1)))NbTestPasse++;
            else
                System.out.println("La carte 1 ROUGE n'est pas dans la main d'alice");
            NbTest++;

            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 2)))NbTestPasse++;
            else
                System.out.println("La premiere carte du tas n'est pas le 2 VERT");
            NbTest++;
            if(partie.getTailleTas()==2)NbTestPasse++;
            else
                System.out.println("Le tas ne possede pas 2 carte");
            NbTest++;
            partie.getJoueurCourant().finirTour();

            if(partie.getJoueurCourant()==bob) NbTestPasse++;
            else
                System.out.println("Le joueur courant n'est pas bob");
            NbTest++;
            NbTest++;
        }catch (Exception e){
            if(e instanceof CartesValideException)NbTestPasse++;
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

        if(partie.getJoueurCourant().TailleDeLaMain()==3)NbTestPasse++;
        else
            System.out.println("Bob ne possede pas 3 cartes");
        NbTest++;

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));

            if(partie.getJoueurCourant().TailleDeLaMain()==2)NbTestPasse++;
            else
                System.out.println("Bob ne possede pas 2 cartes");NbTest++;

            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.JAUNE, 4)))NbTestPasse++;
            else
                System.out.println("La carte 4 JAUNE n'est pas dans la main de Bob");
            NbTest++;
            if(partie.getJoueurCourant().getLaMain().contains(new CarteSimple(Carte.Color.ROUGE, 9)))NbTestPasse++;
            else
                System.out.println("La carte 9 ROUGE n'est pas dans la main de Bob");
            NbTest++;

            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.BLEU, 2)))NbTestPasse++;
            else
                System.out.println("La carte 2 BLEU n'est pas la premiere carte du tas");
            NbTest++;

            if(partie.getTailleTas()==3)NbTestPasse++;
            else
                System.out.println("Le tas n'est pas de taille 3");
            NbTest++;

            partie.getJoueurCourant().finirTour();

            if(partie.getJoueurCourant().equals(charles))NbTestPasse++;
            else
                System.out.println("Charles n'est pas le joueur courant");
            NbTest++;

        }catch (Exception e){
            if(e instanceof CartesValideException)NbTestPasse++;
        }
        NbTest++;
        System.out.println("Test passé : "+NbTestPasse+"/"+NbTest);
    }
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
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

