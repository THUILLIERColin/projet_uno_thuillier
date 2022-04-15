package expert;

import cartes.Cartes;
import exceptions.ExpertManquantException;
import partie.Partie;

public abstract class Expert {

    private Expert suivant = null;

    private Partie partie = Partie.getInstance();

    public Expert(Expert suivant) {
        this.suivant = suivant;
    }

    /**
     * La fonction traiter() parcours la liste à la recherche d'un maillon qui sait comment parser
     * la ligne. Dans ce cas la ligne est parsée et la recherche s'arrête
     * @param cartes la ligne à parser
     */
    public boolean traiter(Cartes cartes) throws Exception {
        if (analyse(cartes))
            return expertise(cartes);
        else if (aUnSuivant())
            return getSuivant().traiter(cartes);
        else
            throw new ExpertManquantException();
    }

    private Expert getSuivant() {
        return suivant;
    }

    private boolean aUnSuivant() {
        return suivant != null;
    }

    public Partie getPartie() {
        return partie;
    }


    /**
     * Parse une ligne. Renvoie une Exception si quelque chose a mal tourné...
     * @param ligne
     * @throws Exception
     */
    public abstract boolean expertise(Cartes cartes) throws Exception;

    /**
     * Renvoie true si le parser en question reconnait le type de ligne, c'est-à-dire
     * qu'il sait la "décortiquer", et créer le ou les objets qu'il faut. Il n'y a pas
     * d'exception. En cas de problème, on renvoie false !
     * @param ligne
     * @return true si la ligne est reconnue
     */
    public abstract boolean analyse(Cartes cartes);

}
