package test;

import expert.Expert;
import expert.ExpertCarteSimpleSurCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import joueur.Joueur;
import partie.Partie;

public class TestCarteSimple {
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCarteSimple.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();
            // Maintenant, à vous de jouer !

            Parser premierParser = new ParserCarteSimple(null);

			/* Ou bien

			Parser premierParser =null;
			premierParser =new ParserCaseDepart(premierParser);
			premierParser = new ParserGare(premierParser);

			 */



            // A vous de créer des parser puis de les chainer les uns aux autres avant d'envoyer
            // le premier à la méthode lire

            Fichier.lire(nomDuFichier, premierParser);

            /*
                    TEST AFFICHAGE CARTE OK
             */

            partie.setExpert(new ExpertCarteSimpleSurCarteSimple(null));

            partie.initialisationPartie(3);
            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
            System.out.println("Alice possede "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");

            Joueur joueurAyantJoue= partie.getJoueurCourant();
            // Faire une variable joueurAyantJoue dans Partie ???

            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            }catch (Exception e){
                System.out.println(e);
            }

            /*
                    juste après avoir joué le joueur suivant devient Bob donc pour voir la mains de Alice
                    on ne peut plus utiliser partie.getJoueurCourant()
             */

            System.out.println(""+joueurAyantJoue+" possède : "+ joueurAyantJoue.TailleDeLaMain()+" cartes");
            System.out.println("Alice a la main : " + joueurAyantJoue.getLaMain());
            System.out.println("La premiere carte est :" + partie.getPremiereCarte());
            System.out.println("Le nombre de cartes du tas est "+ partie.getTailleTas());
            System.out.println("Alice a fini");
            System.out.println("C'est le tour de "+ partie.getJoueurCourant());

            System.out.println("\n"+partie.getJoueurCourant()+" possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");

            joueurAyantJoue= partie.getJoueurCourant();
            try{
                partie.getJoueurCourant().jouer(partie.getJoueurCourant().getCarte(0));
            }catch (Exception e){
                System.out.println(e);
            }


            System.out.println("Bob possède : "+ joueurAyantJoue.TailleDeLaMain()+" cartes");
            System.out.println("Bob a la main : " + joueurAyantJoue.getLaMain());
            System.out.println("La premiere carte est :" + partie.getPremiereCarte());
            System.out.println("Le nombre de cartes du tas est "+ partie.getTailleTas());
            System.out.println("Bob a fini");
            System.out.println("C'est le tour de "+ partie.getJoueurCourant());

            System.out.println("la pioche : "+ partie.getLaPioche());

            // System.out.println(premierParser.toString());




            // System.out.println("Wouais...coool...j'arrive à ouvrir /Users/thuillercolin/Documents/WorkspaceJAVA/Monopoly/Parametre/Terrains.csv");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }


    }
}

