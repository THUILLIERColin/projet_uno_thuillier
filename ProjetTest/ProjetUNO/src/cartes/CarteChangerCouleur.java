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

    public Color JeVeuxCouleur(){
        return super.getCouleur();
    }

    /*
            EQUALS + TO STRING
     */

    @Override
    public String toString() {
        return "ChangerCouleur{" +
                "couleurChanger=" + couleurChanger +
                '}';
    }

    @Override
    public void effet() throws Exception {
        
    }
}
