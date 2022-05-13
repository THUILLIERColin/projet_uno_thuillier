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

        Parser premierParser = new ParserCarteSimple(new ParserPlus2(null));

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(null))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        System.out.println("\n---------------------------------\nTEST 1 : COUP LEGAL +2\n");
        int NbTest=0,NbTestPassee=0;

        //test alice joueur courant
        if (partie.getJoueurCourant()==alice) {
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
            if (partie.getJoueurCourant()==bob) {
                NbTestPassee++;
            } else {
                System.out.println("Bob n'est pas le joueur courant");
            }
            NbTest++;

            //verification bob possède 3 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 3) NbTestPassee++;
            else
                System.out.println("Bob ne possède pas 3 cartes");
            NbTest++;

            //bob prend le +2
            partie.getJoueurCourant().encaisser();

            //verification bob 5 carte
            if (bob.TailleDeLaMain() == 5) NbTestPassee++;
            else
                System.out.println("Bob ne possède pas 5 cartes");
            NbTest++;

            //verification Charle joueur courant
            if (partie.getJoueurCourant()==charles) {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(2));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            if (charles.TailleDeLaMain() == 2) NbTestPassee++;
            else
                System.out.println("Charles possède"+ charles.TailleDeLaMain()+" cartes");
            NbTest++;

        }catch (Exception e){
            System.out.println(("/ATTENTION "+e.getMessage()));
        }

        System.out.println("Test Passé "+NbTestPassee+"/"+NbTest);
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

        System.out.println("\n---------------------------------\nTEST 2 :  CUMUL +2\n");
        int NbTest=0,NbTestPassee=0;

        //test alice joueur courant
        if (partie.getJoueurCourant()==alice) {
            NbTestPassee++;
        } else {
            System.out.println("Alice n'est pas le joueur courant");
        }
        NbTest++;
        try{
            //Aliche pioche 1 carte
            partie.getJoueurCourant().piocher();NbTestPassee++;NbTest++;
            partie.getJoueurCourant().finirTour();

            //verification bob joueur courant
            if (partie.getJoueurCourant()==bob) {
                NbTestPassee++;
            } else {
                System.out.println("Bob n'est pas le joueur courant");
            }
            NbTest++;

            //Bob pioche 1 carte
            partie.getJoueurCourant().piocher();NbTestPassee++;NbTest++;
            partie.getJoueurCourant().finirTour();

            //verification Charle joueur courant
            if (partie.getJoueurCourant()==charles) {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

            //charle joue le +2 vert
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            //test alice joueur courant
            if (partie.getJoueurCourant()==alice) {
                NbTestPassee++;
            } else {
                System.out.println("Alice n'est pas le joueur courant");
            }
            NbTest++;

            //Alice joue le +2 vert
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            NbTest++;
            NbTestPassee++;
            partie.getJoueurCourant().finirTour();

            //verification bob joueur courant
            if (partie.getJoueurCourant()==bob) {
                NbTestPassee++;
            } else {
                System.out.println("Bob n'est pas le joueur courant");
            }
            NbTest++;

            //verification bob 4 carte
            if (partie.getJoueurCourant().TailleDeLaMain() == 4) NbTestPassee++;
            else
                System.out.println("Bob ne possède pas 4 cartes");
            NbTest++;

            //bob encaisse
            partie.getJoueurCourant().encaisser();

            //verification bob 8 carte
            if (bob.TailleDeLaMain() == 8) NbTestPassee++;
            else
                System.out.println("Bob ne possède pas 8 cartes, il en possède "+bob.TailleDeLaMain());
            NbTest++;

            //verification Charle joueur courant
            if (partie.getJoueurCourant()==charles) {
                NbTestPassee++;
            } else {
                System.out.println("Charles n'est pas le joueur courant");
            }
            NbTest++;

        }catch (Exception e){
            System.out.println(("/ATTENTION "+e.getMessage()));
        }

        System.out.println("Test Passé "+NbTestPassee+"/"+NbTest);

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
