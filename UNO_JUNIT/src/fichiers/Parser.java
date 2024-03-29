package fichiers;

import cartes.Carte;
import exceptions.ParserManquantException;
import partie.Partie;

/**
 * Permet de creer les différentes cartes a l'aide des différents parser
 */
public abstract class Parser {

    private Parser suivant = null;

    public Parser(Parser suivant) {
        this.suivant = suivant;
    }

    private Partie partie = Partie.getInstance();

    /**
     * La fonction traiter() parcours la liste à la recherche d'un maillon qui sait comment parser
     * la ligne. Dans ce cas la ligne est parsée et la recherche s'arrête
     * @param ligne la ligne à parser
     * @exception lance une exception si quelque chose a mal tourné
     */
    public void traiter(String ligne) throws Exception {
        if (saitParser(ligne))
            // Si le parser sait parser la ligne, il la parse
            partie.ajouterListeCartesInitiales(parser(ligne));
        else if (aUnSuivant())
            // S'il ne sait pas mais qu'il a un suivant dans la liste chaine, il lui repasse la ligne et qu'il se débrouille !
            getSuivant().traiter(ligne);
        else
            // Sinon, on est arrivé au bout sans trouver un parser
            // et on lance une exception ! Que le prog appelant se débrouille avec cette ligne !
            throw new ParserManquantException();

    }

    public static Carte.Color extractColor(String ligne) {
        Carte.Color couleur = null;

        switch (ligne.split(";")[1]) { //récupère la couleur de la carte
            case "Vert":
                couleur = Carte.Color.VERT;
                break;
            case "Rouge":
                couleur = Carte.Color.ROUGE;
                break;
            case "Jaune":
                couleur = Carte.Color.JAUNE;
                break;
            case "Bleu":
                couleur = Carte.Color.BLEU;
                break;
        }
        return couleur;
    }

    private Parser getSuivant() {
        return suivant;
    }

    private boolean aUnSuivant() {
        return suivant != null;
    }

    /**
     * Parse une ligne. Renvoie une Exception si quelque chose a mal tourné...
     * @param ligne
     * @throws Exception
     */
    public abstract Carte parser(String ligne) throws Exception;

    /**
     * Renvoie true si le parser en question reconnait le type de ligne, c'est-à-dire
     * qu'il sait la "décortiquer", et créer le ou les objets qu'il faut. Il n'y a pas
     * d'exception. En cas de problème, on renvoie false !
     * @param ligne
     * @return true si la ligne est reconnue
     */
    public abstract boolean saitParser(String ligne);

    @Override
    public String toString() {
        return "Parser{" +
                ", initialisationJeu=" + partie.getListeCartesInitiales() +
                '}';
    }
}
