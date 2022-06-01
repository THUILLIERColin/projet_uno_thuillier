package fichiers;

import cartes.CartePlus2;
import cartes.Carte;
import cartes.Carte.Color;

public class ParserPlus2 extends Parser {
    public ParserPlus2(Parser suivant) {
        super(suivant);
    }

    @Override
    public Carte parser(String ligne) throws Exception {
        Color couleur = extractColor(ligne);
        return new CartePlus2(couleur); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CartePlus2");
    }
}
