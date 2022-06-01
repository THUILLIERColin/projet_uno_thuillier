package fichiers;

import cartes.CarteChangerCouleur;
import cartes.Carte;

public class ParserChangerCouleur extends Parser {
    public ParserChangerCouleur(Parser suivant) {
        super(suivant);
    }

    @Override
    public Carte parser(String ligne) throws Exception {
        return new CarteChangerCouleur(); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CarteCouleur");
    }
}
