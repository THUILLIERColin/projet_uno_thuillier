package cartes;

public class CarteChangerCouleur extends Carte {

    private Color couleurChanger;

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
        couleurChanger =couleur;
    }

    /**
     * @return couleur souhaiter par le joueur
     */
    public Color JeVeuxCouleur(){
        return super.getCouleur();
    }

    /*
            EQUALS + TO STRING
     */

    @Override
    public String toString() {
        return "carte_Change_Couleur.png";
    }

    @Override
    public void effet() {
        
    }
}
