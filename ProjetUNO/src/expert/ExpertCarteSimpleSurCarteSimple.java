package expert;

import cartes.CarteSimple;
import cartes.Carte;
import exceptions.UnoException;
import partie.Partie;

public class ExpertCarteSimpleSurCarteSimple extends Expert{

    public ExpertCarteSimpleSurCarteSimple(Expert suivant){
        super(suivant);
    }

    /*                                    /
            A VERIFIER AVEC EXPERT.JAVA \/
     */

    /*
            ICI IL FAUT COMPARER LA COULEUR ET L'ENTIER
     */

    @Override
    public boolean expertise(Carte carte) throws Exception {

        /*
                    ATTENTION UNE CARTE SIMPLE PEU ETRE POSÉ SUR TOUTES LES AUTRE CARTES

            Si la carte est ChangerCouleur / Plus2 / Reverse
                Alors verifier la couleur et si on est bien le joueur qui doit jouer
                Sinon pénalité

            Si c'est une carte simple

            --> faire dans un autre
            -->
         */
        Partie partie = Partie.getInstance();

        CarteSimple carteJoueur = (CarteSimple) carte;
        CarteSimple carteTas = (CarteSimple) super.getPartie().getPremiereCarte() ;
        if(partie.getJoueurCourant().doitDireUno() && !partie.getJoueurCourant().getUno())
            throw new UnoException("Ce joueur possede une carte et n'a pas dit UNO",partie.getJoueurCourant());
        if(partie.getJoueurCourant().doitDireUno() && partie.getJoueurCourant().getUno())
            throw new UnoException("",partie.getJoueurCourant());
        if(carte.getCouleur() == super.getPartie().getPremiereCarte().getCouleur())
                return true;
        else
        {
            if(carteJoueur.getNumero() == carteTas.getNumero())
                return true;
        }
                // C'est un class Carte et il n'existe pas de getNumero() dedans, il faudrait convertir en CarteSimple
                // Ou bien recevoir directement une carte simple
        return false;
    }

    @Override
    public boolean analyse(Carte cartes) {
        if(cartes instanceof CarteSimple && super.getPartie().getPremiereCarte() instanceof CarteSimple)
            return true;
        return false;
    }

}
