package expert;

import cartes.CarteSimple;
import cartes.Cartes;

public class ExpertCarteSimple extends Expert{

    public ExpertCarteSimple(Expert suivant){
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
        CarteSimple tas = (CarteSimple) super.getPartie().getPremiereCarte();
        if(carte.getCouleur() == super.getPartie().getPremiereCarte().getCouleur())
            if(o.getNumero() == tas.getNumero())
                return true;
                // C'est un class Carte et il n'existe pas de getNumero() dedans, il faudrait convertir en CarteSimple
                // Ou bien recevoir directement une carte simple
        return false;
    }

    /*
            ICI IL FAUT VERIFIER SI LA CLASS EST LA MEME
            Mais également si elle est de type CarteSimple
     */

    @Override
    public boolean analyse(Cartes cartes) {
        if(cartes instanceof CarteSimple && super.getPartie().getPremiereCarte() instanceof CarteSimple)
            return true;
        return false;
    }

}
