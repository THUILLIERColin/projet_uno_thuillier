package cartes;

import java.util.Objects;

/**
 * Classe abstraite qui permet de définir les cartes
 */
public abstract class Carte {
    public enum Color {BLEU, ROUGE, JAUNE, VERT, NOIR};
    private Color couleur;

    /**
     * Constructeur d'une carte a partir d'une couleur
     * @param c Couleur de la carte
     */
    public Carte(Color c){
        setCouleur(c);
    }

    /**
     *  Seteur de couleur
     * @param couleur couelur de la carte
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /** retourne la couleur d'une carte
     * @return couleur de la carte
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * effet de la carte
     * @throws Exception
     */
    public abstract void effet() throws Exception;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return couleur == carte.couleur;
    }

}
