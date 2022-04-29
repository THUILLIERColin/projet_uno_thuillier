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
        Color couleur = ExtractColor(ligne);

        String val = ligne.split(";")[2]; //récupère le numéro de la carte
        int num = Integer.parseInt(val); //transforme un String en Int
        return new CarteSimple(couleur, num); //Création de la carte
    }

    static Color ExtractColor(String ligne) {
        Color couleur = null;
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
        return couleur;
    }

    @Override
    public boolean saitParser(String ligne) {
        return ligne.contains("CarteSimple");
    }
}
