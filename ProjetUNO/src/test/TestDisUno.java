package test;

import cartes.Carte;
import cartes.CarteSimple;
import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

public class TestDisUno {
    private static void Test1(){
        /*
                    TEST 1 : ALICE DIT UNO QUAND IL FAUT
         */
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

        int NbTestPasse=0,NbTest=0;

        System.out.println("\n---------------------------------\nTEST 1 : ALICE UNO BON MOMENT\n");

        if(partie.getJoueurCourant()==alice) NbTestPasse++; NbTest++;
        if(partie.getJoueurCourant().TailleDeLaMain()==2)NbTestPasse++; NbTest++;

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));NbTestPasse++; NbTest++;//alice joue le 2 Vert
            partie.getJoueurCourant().disUNO();//alice dit uno
            if(partie.getJoueurCourant().getUno())NbTestPasse++; NbTest++;//verification de uno
            partie.getJoueurCourant().finirTour(); //Alice fini le tour

            if(partie.getJoueurCourant().TailleDeLaMain()==1)NbTestPasse++; NbTest++;//verification que alice a que 1 carte
            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 2)))NbTestPasse++; NbTest++;//verification 1er carte tas = 2vert
            if(partie.getJoueurCourant()==bob) NbTestPasse++; NbTest++;
        }catch(Exception e){
            System.out.println("\nATTENTION " + e.getMessage()+"\n");
        }

        System.out.println("Test passé : "+NbTestPasse+"/"+NbTest);
    }

    private static void Test2 (){
        /*
                    TEST 2 : ALICE OUBLIE UNO
         */
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

        int NbTestPasse=0,NbTest=0;

        System.out.println("\n---------------------------------\nTEST 2 : OUBLIE UNO\n");

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            if(partie.getJoueurCourant().TailleDeLaMain()==4)NbTestPasse++; NbTest++;
            if(partie.getJoueurCourant()==bob) NbTestPasse++; NbTest++;
            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 8)))NbTestPasse++; NbTest++;
        }catch (Exception e){
            if(!partie.getJoueurCourant().getUno() && partie.getJoueurCourant().TailleDeLaMain()==1){
                partie.getJoueurCourant().punir(e);
            }
        }

        System.out.println("Test passé : "+NbTestPasse+"/"+NbTest);
    }
    private static void Test3(){
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

        int NbTestPasse=0,NbTest=0;

        System.out.println("\n---------------------------------\nTEST 3 : MAUVAIS UNO\n");
    }
    public static void main(String[] args) {
        try {
            Test1();
            Partie.getInstance().reinitialiserPartie();
            Test2();
            Partie.getInstance().reinitialiserPartie();
            Test3();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

