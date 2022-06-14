package expert;

import cartes.Carte;
import cartes.CarteChangerCouleur;
import partie.Partie;

public class ExpertCarteChangerCouleur extends Expert{

    public ExpertCarteChangerCouleur(Expert suivant) {
        super(suivant);
    }

    @Override
    public boolean expertise(Carte carte) {
        Partie partie = Partie.getInstance();
        if(carte instanceof CarteChangerCouleur){
            CarteChangerCouleur c = (CarteChangerCouleur) carte;
            if(c.getCouleurDemander()==null) throw new IllegalArgumentException("La couleur demande est null");
            return true;
        }
        CarteChangerCouleur c = (CarteChangerCouleur) partie.getPremiereCarteTas();
        return (c.getCouleurDemander()==carte.getCouleur());
    }

    @Override
    public boolean saitExpertiser(Carte carte) {
        Partie partie = Partie.getInstance();
        return (carte instanceof CarteChangerCouleur || partie.getPremiereCarteTas() instanceof CarteChangerCouleur);
    }
}
