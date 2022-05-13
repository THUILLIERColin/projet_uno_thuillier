package test;

import expert.ExpertCartePlus2CartePlus2;
import expert.ExpertCartePlus2CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import fichiers.ParserPlus2;
import joueur.Joueur;
import partie.Partie;

public class TestCartePlus2 {
    private static void Test1(){
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePlus2.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        System.out.println("\n---------------------------------\nTEST 1 : COUP LEGAL +2\n");
        int NbTest=0,NbTestPasse=0;
    }

    private static void Test2(){
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCartePlus2.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserPlus2(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(null))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        System.out.println("\n---------------------------------\nTEST 3 :  CUMUL +2\n");
        int NbTest=0,NbTestPassee=0;

        //test alice joueur courant
        if (partie.getJoueurCourant().getNom() == "Alice") {
            NbTestPassee++;
        } else {
            System.out.println("Alice n'est pas le joueur courant");
        }
        NbTest++;
        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            //verification bob joueur courant
            if (partie.getJoueurCourant().getNom() == "Bob") {
                NbTestPassee++;
            } else {
                System.out.println("Bob n'est pas le joueur courant");
            }
            NbTest++;

            //verification bob possède 3 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPasse++;
            else
                System.out.println("Alice ne possède pas 3 cartes");
            NbTest++;

            partie.getJoueurCourant().prendre();

            //verification bob 5 carte
            if (bob.TailleDeLaMain() == 3) NbTestPassee++;
            else
                System.out.println("Alice ne possède pas 3 cartes");
            NbTest++;

            //verification Charle joueur courant
            //verification charles joueur courant
            if (partie.getJoueurCourant().getNom() == "Charles") {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;
        }catch (Exception e){
            System.out.println(("/ATTENTION "+e.getMessage()));
        }
    }
    public static void main(String[] args) {
        try {
            Test1();
            Partie.getInstance().reinitialiserPartie();
            Test2();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
