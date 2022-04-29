package fichiers;

import cartes.ChangerCouleur;
import cartes.Cartes;
import cartes.Cartes.Color;

public class ParserChangerCouleur extends Parser {
    public ParserChangerCouleur(Parser suivant) {
        super(suivant);
    }

    @Override
    public Cartes parser(String ligne) throws Exception {
        return new ChangerCouleur(); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CarteCouleur");
    }
}
