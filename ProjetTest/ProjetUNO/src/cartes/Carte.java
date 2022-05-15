package cartes;

import java.util.Objects;

public abstract class Carte {
    public enum Color {BLEU, ROUGE, JAUNE, VERT, NOIR};
    private Color couleur;

    public Carte(Color c){
        setCouleur(c);
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public abstract void effet() throws Exception;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return couleur == carte.couleur;
    }

}
