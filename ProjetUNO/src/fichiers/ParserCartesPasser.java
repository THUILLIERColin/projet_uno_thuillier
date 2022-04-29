package fichiers;

import cartes.CartesPasser;
import cartes.Cartes;
import cartes.Cartes.Color;

public class ParserCartesPasser extends Parser {
    public ParserCartesPasser(Parser suivant) {
        super(suivant);
    }

    @Override
    public Cartes parser(String ligne) throws Exception {
        Color couleur = ParserCarteSimple.ExtractColor(ligne);
        return new CartesPasser(couleur); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CartePasser");
    }
}
