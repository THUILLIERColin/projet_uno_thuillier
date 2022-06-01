package fichiers;

import cartes.CartePasser;
import cartes.Carte;
import cartes.Carte.Color;

public class ParserCartePasser extends Parser {
    public ParserCartePasser(Parser suivant) {
        super(suivant);
    }

    @Override
    public Carte parser(String ligne) throws Exception {
        Color couleur = extractColor(ligne);
        return new CartePasser(couleur); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CartePasser");
    }
}
