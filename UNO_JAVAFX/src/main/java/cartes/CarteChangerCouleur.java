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
            SETTER / GETTER
     */

    public void setCouleurDemander(Color couleur){
        couleurDemander=couleur;
    }

    /**
     * @return couleur souhaiter par le joueur
     */
    public Color getCouleurDemander() {
        return couleurDemander;
    }

    @Override
    public void effet() {}

    /*
            EQUALS + TO STRING
     */

    @Override
    public String toString() {
        return "carte_Change_Couleur.png";
    }
}
