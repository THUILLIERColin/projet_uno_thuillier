package expert;

import cartes.Carte;
import exceptions.ExpertManquantException;
import partie.Partie;

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
     * Parse une ligne. Renvoie une Exception si quelque chose a mal tourné...
     * @param carte
     * @throws Exception
     */
    public abstract boolean expertise(Carte carte);

    /**
     * Renvoie true si le parser en question reconnait le type de ligne, c'est-à-dire
     * qu'il sait la "décortiquer", et créer le ou les objets qu'il faut. Il n'y a pas
     * d'exception. En cas de problème, on renvoie false !
     * @param carte
     * @return true si la ligne est reconnue
     */
    public abstract boolean saitExpertiser(Carte carte);

}
