package cartes;

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
}
