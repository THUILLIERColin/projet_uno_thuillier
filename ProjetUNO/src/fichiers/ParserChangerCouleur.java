package fichiers;

import cartes.ChangerCouleur;
import cartes.Carte;
import cartes.Carte.Color;

public class ParserChangerCouleur extends Parser {
    public ParserChangerCouleur(Parser suivant) {
        super(suivant);
    }

    @Override
    public Carte parser(String ligne) throws Exception {
        return new ChangerCouleur(); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CarteCouleur");
    }
}
