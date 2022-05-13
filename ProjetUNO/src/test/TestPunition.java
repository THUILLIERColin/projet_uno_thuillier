package test;

import cartes.Carte;
import cartes.CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.*;
import joueur.Joueur;
import partie.Partie;

public class TestPunition {
    private static void Test1() {
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

        int NbTest = 0, NbTestPasse = 0;

        /*
                    TEST 1 : ALICE
            */

        System.out.println("\nTEST 1 : ALICE\n");
        if(partie.getJoueurCourant()==alice)NbTestPasse++;
        else
            System.out.println("Le joueur courant n'est pas Alice");
        NbTest++;
        try {
            alice.jouer(partie.getJoueurCourant().getCarte(1));
        } catch (Exception e) {
            // System.out.println("\nATTENTION " + e.getMessage() + "\n");
            try {
                partie.getJoueurCourant().punir(e);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if(partie.getJoueurCourant()==bob)NbTestPasse++;
            else{
                System.out.println("Le joueur courant est " + partie.getJoueurCourant());}
            NbTest++;
            if(alice.getTailleDeLaMain()==5)NbTestPasse++;
            else{
                System.out.println("Alice possede " + alice.getTailleDeLaMain() + " cartes");}
            NbTest++;
            if(alice.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE,6)))NbTestPasse++;
            else
                System.out.println("Alice ne possede pas la carte 6 JAUNE");
            NbTest++;
            if(alice.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE,4)))NbTestPasse++;
            else
                System.out.println("Alice ne possede pas la carte 4 ROUGE");
            NbTest++;
            if(partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.VERT,2)))NbTestPasse++;
            else
                System.out.println("La prochaine carte de la pioche est " + partie.getPremiereCartePioche());
            NbTest++;
        }
        System.out.println("\tTest passé : "+NbTestPasse+"/"+NbTest);
    }

    private static void Test2() {
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimple.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(new ParserCartePasser(new ParserPlus2(new ParserChangerCouleur(null))));


        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(3);

        /*
                    TEST 2 : BOB
        */

        int NbTest = 0, NbTestPasse = 0;

        System.out.println("\nTEST 2 : BOB\n");

        if(partie.getJoueurCourant()==alice)NbTestPasse++;
        else
            System.out.println("Le joueur courant est " + partie.getJoueurCourant());
        NbTest++;

        try {
            bob.piocher();
        } catch (Exception e) {
            //System.out.println("\nATTENTION " + e.getMessage() + "\n");
            try {
                bob.punir(e);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if(partie.getJoueurCourant()==alice)NbTestPasse++;
            else
                System.out.println("Le joueur courant est " + partie.getJoueurCourant());
            NbTest++;

            if (bob.getTailleDeLaMain()==5)NbTestPasse++;
            else
                System.out.println("Bob possede "+ bob.getTailleDeLaMain());
            NbTest++;
            if(bob.getLaMain().contains(new CarteSimple(Carte.Color.JAUNE,6)))NbTestPasse++;
            else
                System.out.println("Bob ne possede pas la carte 6 JAUNE");
            NbTest++;
            if(bob.getLaMain().contains(new CarteSimple(Carte.Color.ROUGE,4)))NbTestPasse++;
            else
                System.out.println("Bob ne possede pas la carte 4 ROUGE");
            NbTest++;

            if(partie.getPremiereCartePioche().equals(new CarteSimple(Carte.Color.VERT,2)))NbTestPasse++;
            else
                System.out.println("La prochaine carte de la pioche est " + partie.getPremiereCartePioche());
            NbTest++;
        }
        System.out.println("\tTest passé : "+NbTestPasse+"/"+NbTest);
    }

    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            Test1();
            partie.reinitialiserPartie();
            Test2();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
