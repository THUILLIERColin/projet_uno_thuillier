package expert;

import exceptions.ExpertManquantException;

public abstract class Expert {

    private Expert suivant = null;

    public Expert(Expert suivant) {
        this.suivant = suivant;
    }

    /**
     * La fonction traiter() parcours la liste à la recherche d'un maillon qui sait comment parser
     * la ligne. Dans ce cas la ligne est parsée et la recherche s'arrête
     * @param ligne la ligne à parser
     * @exception lance une exception si quelque chose a mal tourné
     */
    public void traiter(String ligne) throws Exception {
        if (expertise(ligne))
            expert(ligne);
        else if (aUnSuivant())
            getSuivant().traiter(ligne);
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
     * @param ligne
     * @throws Exception
     */
    public abstract void expert(String ligne) throws Exception;

    /**
     * Renvoie true si le parser en question reconnait le type de ligne, c'est-à-dire
     * qu'il sait la "décortiquer", et créer le ou les objets qu'il faut. Il n'y a pas
     * d'exception. En cas de problème, on renvoie false !
     * @param ligne
     * @return true si la ligne est reconnue
     */
    public abstract boolean expertise(String ligne);

}
