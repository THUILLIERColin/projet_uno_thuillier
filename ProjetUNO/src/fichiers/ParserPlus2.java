package fichiers;

import cartes.Plus2;
import cartes.Cartes;
import cartes.Cartes.Color;

public class ParserPlus2 extends Parser {
    public ParserPlus2(Parser suivant) {
        super(suivant);
    }

    @Override
    public Cartes parser(String ligne) throws Exception {
        Cartes.Color couleur = null;
        switch (ligne.split(";")[1]) { //récupère la couleur de la carte
            case "Vert":
                couleur = Color.VERT;
                break;
            case "Rouge":
                couleur = Color.ROUGE;
                break;
            case "Jaune":
                couleur = Color.JAUNE;
                break;
            case "Bleu":
                couleur = Color.BLEU;
                break;
        }
        return new Plus2(couleur); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CartePlus2");
    }
}
