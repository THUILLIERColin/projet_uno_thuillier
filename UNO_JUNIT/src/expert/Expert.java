package expert;

import cartes.Carte;
import exceptions.ExpertManquantException;
import partie.Partie;

/**
 * Permet de faire appel au différent expert qui sont les coups valide lors d'une partie
 */
public abstract class Expert {

    private Expert suivant = null;

    public Expert(Expert suivant) {
        this.suivant = suivant;
    }

    /**
     * La fonction traiter() parcours la liste à la recherche d'un maillon qui sait comment parser
     * la ligne. Dans ce cas la ligne est parsée et la recherche s'arrête
     * @param carte la ligne à parser
     */
    public boolean traiter(Carte carte) throws ExpertManquantException {
        if (saitExpertiser(carte))
            return expertise(carte);
        else if (aUnSuivant())
            return getSuivant().traiter(carte);
        else
            throw new ExpertManquantException();
    }

    private Expert getSuivant() {
        return suivant;
    }

    private boolean aUnSuivant() {
        return suivant != null;
    }

    /**
     * Revoie true si les conditions pour poser la carte sont remplies (même couleur, etc)
     * @param carte
     * @return true si les cartes sont compatibles
     */
    public abstract boolean expertise(Carte carte);

    /**
     * Renvoie true si la class des cartes est la même, sinon il renvoie false
     * @param carte
     * @return true si la class des cartes est la même
     */
    public abstract boolean saitExpertiser(Carte carte);

}
