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
        return new CartesPasser(couleur); //Création de la carte
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CartePasser");
    }
}
