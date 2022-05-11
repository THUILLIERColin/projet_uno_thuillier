package test;

import expert.ExpertCarteSimpleCarteSimple;
import fichiers.*;
import joueur.Joueur;
import partie.Partie;

public class TestPunition {
    public static void Test1(){
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


        /*
                    TEST 1 : ALICE
            */

        System.out.println("\n---------------------------------\nTEST 1 : ALICE\n");
        System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
        System.out.println(""+partie.getJoueurCourant()+" possede "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");


        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(1));
            System.out.println(""+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
        }catch (Exception e) {
            System.out.println("\nATTENTION " + e.getMessage() + "\n");
            try{
                partie.getJoueurCourant().punir(e);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Le joueur courant est " + partie.getJoueurCourant());
            System.out.println("" + partie.getJoueur(0) + " possede " + partie.getJoueur(0).TailleDeLaMain() + " cartes");
            System.out.println("Alice a la main : " + partie.getJoueur(0).getLaMain());
            System.out.println("La prochaine carte de la pioche est " + partie.getPremiereCartePioche());
        }
    }

    public static void Test2(){
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

        System.out.println("\n---------------------------------\nTEST 2 : BOB\n");

        System.out.println("Le joueur courant est "+ partie.getJoueurCourant());

        try{
            partie.getJoueur(1).piocher();
            System.out.println("Bob possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
        }catch (Exception e){
            System.out.println("\nATTENTION " + e.getMessage()+"\n");
            try {
                partie.getJoueur(1).punir(e);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
            System.out.println("Bob a la main : " + partie.getJoueur(1).getLaMain());
            System.out.println("La prochaine carte de la pioche est " +partie.getPremiereCartePioche());
        }

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
