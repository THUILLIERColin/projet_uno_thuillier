package fichiers;

import cartes.CarteSimple;
import cartes.Cartes;
import cartes.Cartes.Color;

public class ParserCarteSimple extends Parser {
    public ParserCarteSimple(Parser suivant) {
        super(suivant);
    }

    @Override
    public void parser(String ligne) throws Exception {
        Cartes.Color couleur = null;
        switch (ligne.split(";")[1]){ //récupère la couleur de la carte
            case "Vert" : couleur = Color.VERT;
            case "Rouge" : couleur = Color.ROUGE;
            case "Jaune" : couleur = Color.JAUNE;
            case "Bleu" : couleur = Color.BLEU;
        }

        String val = ligne.split(";")[2]; //récupère le numéro de la carte
        int num = Integer.parseInt(val); //transforme un String en Int
        new CarteSimple(couleur,num); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CarteSimple");
    }
}
