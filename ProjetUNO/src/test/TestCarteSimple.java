package test;

import fichiers.Fichier;
import fichiers.Parser;

public class TestCarteSimple {
    public static void TestCarteSimple(String[] args) {
        try {
            String nomDuFichier = "/JeuTestCarteSimple.csv";
            nomDuFichier = Fichier.class.getResource(nomDuFichier).getPath();
            // Maintenant, à vous de jouer !

            Parser premierParser = new ParserCaseDepart(new ParserGare(null));

			/* Ou bien

			Parser premierParser =null;
			premierParser =new ParserCaseDepart(premierParser);
			premierParser = new ParserGare(premierParser);

			 */

            // A vous de créer des parser puis de les chainer les uns aux autres avant d'envoyer
            // le premier à la méthode lire

            Fichier.lire(nomDuFichier, premierParser);

            // System.out.println("Wouais...coool...j'arrive à ouvrir /Users/thuillercolin/Documents/WorkspaceJAVA/Monopoly/Parametre/Terrains.csv");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }


    }
    }
}
