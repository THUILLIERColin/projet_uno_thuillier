package fichiers;

import cartes.CarteSimple;
import cartes.Carte;
import cartes.Carte.Color;

public class ParserCarteSimple extends Parser {
    public ParserCarteSimple(Parser suivant) {
        super(suivant);
    }

    @Override
    public Carte parser(String ligne) throws Exception {
        Color couleur = extractColor(ligne);

        String val = ligne.split(";")[2]; //récupère le numéro de la carte
        int num = Integer.parseInt(val); //transforme un String en Int
        return new CarteSimple(couleur, num); //Création de la carte
    }



    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CarteSimple");
    }
}
