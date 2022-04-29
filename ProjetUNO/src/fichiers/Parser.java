package fichiers;

import cartes.Cartes;
import exceptions.ParserManquantException;

import java.util.ArrayList;

public abstract class Parser {

    // Un parser est en fait un maillon dans une liste chainée...
    // Cette liste chainée représente une instruction "switch"
    // Chaque maillon représente un "case" du switch
    private Parser suivant = null;

    private ArrayList<Cartes> initialisationJeu = new ArrayList<>();

    public ArrayList<Cartes> getInitialisationJeu() {
        return initialisationJeu;
    }

    public Cartes getCartes(int i){
        return initialisationJeu.get(i);
    }

    public void ajouter(Cartes cartes){
        initialisationJeu.add(cartes);
    }

    public Parser(Parser suivant) {
        this.suivant = suivant;
    }

    /*
     * La fonction traiter() parcours la liste à la recherche d'un maillon qui sait comment parser
     * la ligne. Dans ce cas la ligne est parsée et la recherche s'arrête
     * @param ligne la ligne à parser
     * @exception lance une exception si quelque chose a mal tourné
     */
    public void traiter(String ligne) throws Exception {
        if (saitParser(ligne))
            // Si le parser sait parser la ligne, il la parse
            ajouter(parser(ligne));
        else if (aUnSuivant())
            // S'il ne sait pas mais qu'il a un suivant dans la liste chaine, il lui repasse la ligne et qu'il se débrouille !
            getSuivant().traiter(ligne);
        else
            // Sinon, on est arrivé au bout sans trouver un parser
            // et on lance une exception ! Que le prog appelant se débrouille avec cette ligne !
            throw new ParserManquantException();

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
    public abstract Cartes parser(String ligne) throws Exception;

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
                ", initialisationJeu=" + initialisationJeu +
                '}';
    }
}
