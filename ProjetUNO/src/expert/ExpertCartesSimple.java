package expert;

import cartes.CarteSimple;
import cartes.Cartes;

public class ExpertCartesSimple extends Expert{

    public ExpertCartesSimple(Expert suivant){
        super(suivant);
    }

    /*                                    /
            A VERIFIER AVEC EXPERT.JAVA \/
     */

    /*
            ICI IL FAUT COMPARER LA COULEUR ET L'ENTIER
     */

    @Override
    public boolean expertise(Cartes carte) throws Exception {
        CarteSimple o = (CarteSimple) carte;
        if(carte.getCouleur() == super.getPartie().getPremiereCarte().getCouleur())
            /* if(carte.getNumero() == super.getPartie().getPremiereCarte().getNumero()) */
                // C'est un class Carte et il n'existe pas de getNumero() dedans, il faudrait convertir en CarteSimple
                // Ou bien recevoir directement une carte simple
                return true;
        return false;
    }

    /*
            ICI IL FAUT VERIFIER SI LA CLASS EST LA MEME
            Mais egalement si elle est de type CarteSimple
     */

    @Override
    public boolean analyse(Cartes cartes) {
        if(cartes.getClass() == super.getPartie().getPremiereCarte().getClass())
            // Il faut verifier que ce soit bien un class de CarteSimple car ici
            // si les deux cartes sont de meme class c'est vrai or, elles ne seront pas forcément CarteSimple
            return true;
        return false;
    }

}
