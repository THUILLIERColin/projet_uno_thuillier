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

            Joueur joueurCourant = partie.getJoueurCourant();[]
            try{
                joueurCourant.jouer(joueurCourant.getCarte(0));
            }catch (Exception e){
                System.out.println(e);
            }

            System.out.println("Alice possède : "+ joueurCourant.TailleDeLaMain()+" cartes");
            System.out.println("Alice a la main : " + joueurCourant.getLaMain());
            System.out.println("La premiere carte est :" + partie.getPremiereCarte());
            System.out.println("Le nombre de cartes du tas est "+ partie.getTailleTas());
            System.out.println("Alice a fini");
            System.out.println("C'est le tour de "+ partie.getJoueurCourant());

            // System.out.println(premierParser.toString());




            // System.out.println("Wouais...coool...j'arrive à ouvrir /Users/thuillercolin/Documents/WorkspaceJAVA/Monopoly/Parametre/Terrains.csv");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }


    }
}

