package cartes;

public abstract class Cartes {
    public enum Color {BLEU, ROUGE, JAUNE, VERT, NOIR};
    private Color couleur;

    public Cartes(Color c){
        setCouleur(c);
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public abstract void effet();
}
