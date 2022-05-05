package test;

import expert.ExpertCarteSimpleCarteSimple;
import fichiers.Fichier;
import fichiers.Parser;
import fichiers.ParserCarteSimple;
import partie.Partie;

public class TestPunition {
    public static void main(String[] args) {
        try {
            Partie partie = Partie.getInstance();

            String nomDuFichier = "/JeuTestCarteSimple.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();

            Parser premierParser = new ParserCarteSimple(null);

			/* Ou bien

			Parser premierParser =null;
			premierParser =new ParserCaseDepart(premierParser);
			premierParser = new ParserGare(premierParser);

			 */

            Fichier.lire(nomDuFichier, premierParser);

            partie.setExpert(new ExpertCarteSimpleCarteSimple(null));

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
            }catch (Exception e){
                System.out.println(e);
                partie.getJoueurCourant().punir(e);
                /*
                Vérifier que Bob est le joueur courant
                Vérifier que Alice possède 5 cartes dont le « 6 jaune » et le « 4 rouge » (les 2 cartes de la pioche)
                Vérifier que la prochaine carte de la pioche est le « 2 vert »
                 */
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println(""+partie.getJoueur(0)+" possede "+ partie.getJoueur(0).TailleDeLaMain()+" cartes");
                System.out.println("Alice a la main : " + partie.getJoueur(0).getLaMain());
                System.out.println("La prochaine carte de la pioche est " +partie.getPremiereCartePioche());
            }




            /*
                    TEST 2 : BOB
             */

            System.out.println("\n---------------------------------\nTEST 2 : BOB\n");

            System.out.println("Le joueur courant est "+ partie.getJoueurCourant());

            try{
                partie.getJoueur(1).piocher();
                System.out.println("Bob possède : "+ partie.getJoueurCourant().TailleDeLaMain()+" cartes");
            }catch (Exception e){
                System.out.println(e);
                partie.getJoueur(1).punir(e);
                System.out.println("Le joueur courant est "+ partie.getJoueurCourant());
                System.out.println("Bob a la main : " + partie.getJoueur(1).getLaMain());
                System.out.println("La prochaine carte de la pioche est " +partie.getPremiereCartePioche());
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
