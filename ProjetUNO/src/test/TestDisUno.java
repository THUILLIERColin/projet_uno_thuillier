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

        String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(2);

        int NbTestPasse=0,NbTest=0;

        System.out.println("\nTEST 1 : ALICE UNO BON MOMENT\n");

        if(partie.getJoueurCourant()==alice) NbTestPasse++;
        else
            System.out.println("Le joueur courant n'est pas Alice");
        NbTest++;
        if(partie.getJoueurCourant().getTailleDeLaMain()==2)NbTestPasse++;
        else
            System.out.println("");
        NbTest++;
        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));//alice joue le 2 Vert
            partie.getJoueurCourant().disUNO();//alice dit uno
            if(partie.getJoueurCourant().getUno())NbTestPasse++;
            else
                System.out.println("");
            NbTest++;//verification de uno
            partie.getJoueurCourant().finirTour(); //Alice fini le tour

            if(alice.getTailleDeLaMain()==1)NbTestPasse++;
            else System.out.println("Alice ne possede pas une carte");
            NbTest++;//verification que alice a que 1 carte
            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 2)))NbTestPasse++;
            else System.out.println("La premiere carte du tas n'est pas le 2 VERT"); ; NbTest++;//verification 1er carte tas = 2vert
            if(partie.getJoueurCourant()==bob) NbTestPasse++;
            else System.out.println("le joueur courant n'est pas bob"); NbTest++;
        }catch(Exception e){
            System.out.println("\nATTENTION " + e.getMessage()+"\n");
        }

        System.out.println("\tTest passé : "+NbTestPasse+"/"+NbTest);
    }

    private static void Test2 (){
        /*
                    TEST 2 : ALICE OUBLIE UNO
         */
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(2);

        int NbTestPasse=0,NbTest=0;

        System.out.println("\nTEST 2 : OUBLIE UNO\n");

        try{
            partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            partie.getJoueurCourant().finirTour();
        }catch (Exception e){
            try{
                alice.punir(e);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            if(alice.getTailleDeLaMain()==4)NbTestPasse++;
            else
                System.out.println("Alice ne possede pas carte");
            NbTest++;
            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 8)))NbTestPasse++;
            else
                System.out.println("La carte 8 VERT n'est pas la premiere carte du tas");
            NbTest++;
            if(partie.getJoueurCourant()==bob) NbTestPasse++;
            else
                System.out.println("Le joueur courant n'est pas Bob");
            NbTest++;
        }

        System.out.println("\tTest passé : "+NbTestPasse+"/"+NbTest);
    }
    private static void Test3(){
        Partie partie = Partie.getInstance();

        String nomDuFichier = "/JeuTestCarteSimplePourUno.csv";
        nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

        Parser premierParser = new ParserCarteSimple(null);

        Fichier.lire(nomDuFichier, premierParser);

        partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");

        partie.initialisationPartie(2);

        int NbTestPassee=0,NbTest=0;

        System.out.println("\nTEST 3 : MAUVAIS UNO\n");

        //verification Alice joueur courant
        if (partie.getJoueurCourant().getNom() == "Alice")NbTestPassee++;
        else
            System.out.println("Alice n'est pas le joueur courant");
        NbTest++;

        try{
            partie.getJoueur(1).getUno();
        }catch (Exception e){
            try{
                bob.punir(e);NbTestPassee++; NbTest++;
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            if(bob.getTailleDeLaMain()==4)NbTestPassee++;
            else
                System.out.println("Bob ne possede pas 4 cartes");
            NbTest++;
            if(partie.getPremiereCarteTas().equals(new CarteSimple(Carte.Color.VERT, 8)))NbTestPassee++;
            else
                System.out.println("La premiere carte du tas n'est pas le 8 VERT");
            NbTest++;
            if(partie.getJoueurCourant().getNom()=="Alice") NbTestPassee++;
            else
                System.out.println("Le joueur courant n'est pas Alice");
            NbTest++;
        }

        System.out.println("\tTest passé : "+NbTestPassee+"/"+NbTest);

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

