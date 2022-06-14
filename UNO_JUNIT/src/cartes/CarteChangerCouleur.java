package cartes;

public class CarteChangerCouleur extends Carte {

    private Color couleurDemander=null;

    /*
            CONSTRUCTEUR
     */

    public CarteChangerCouleur() {
        super(Color.NOIR);
    }

    /*
            SETTER
     */

    public void setCouleurChanger(Color couleur){
        couleurDemander=couleur;
    }

    @Override
    public void effet() {
        if(couleurDemander==null) throw new IllegalArgumentException("Couleur demandé null");
    }

    /*
            EQUALS + TO STRING
     */

    @Override
    public String toString() {
        return "carte_Change_Couleur.png";
    }
}
