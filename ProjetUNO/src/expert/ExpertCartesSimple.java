package expert;

import cartes.CarteSimple;
import cartes.Cartes;

public class ExpertCartesSimple extends Expert{

    public ExpertCartesSimple(Expert suivant){
        super(suivant);
    }

    /*
            A VERIFIER AVEC EXPERT.JAVA
     */

    /*
            FAUX CAR IL VA RETOURNER VRAI SI LA COULEUR EST LA MEME SANS FORCEMENT REGARDER LE CHIFFRE
     */

    /*
            ICI IL FAUT COMPARER LA COULEUR ET L'ENTIER
     */

    @Override
    public boolean expertise(Cartes carte) throws Exception {

        if(carte.getCouleur() == super.partie.getPremiereCarte().getCouleur())
            return true;
        return false;
    }

    /*
            ICI IL FAUT VERIFIER SI LA CLASS EST LA MEME
     */

    @Override
    public boolean analyse(Cartes cartes) {
        if(cartes.getClass() == super.partie.getPremiereCarte().getClass())
            return true;
        return false;
    }

}
