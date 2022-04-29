package cartes;

public class ChangerCouleur extends Carte {

    private Color couleurChanger;

    /*
            CONSTRUCTEUR
     */
    public ChangerCouleur() {
        super(Color.NOIR);
    }

    /*
            SETTER
     */

    public void setCouleurChanger(Color couleur){
        couleurChanger =couleur;
    }

    public Color JeVeuxCouleur(Color couleur){
        setCouleurChanger(couleur);
        return couleur;
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
