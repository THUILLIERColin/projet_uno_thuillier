package joueur;

import cartes.Carte;
import cartes.CartePlus2;
import exceptions.CartesValideException;
import exceptions.JoueurException;
import exceptions.UnoException;
import partie.Partie;

import java.util.ArrayList;
import java.util.Objects;

public class Joueur {
    private String nom;
    private boolean uno=false;
    private ArrayList<Carte> laMain = new ArrayList<>();

    /*
            DE BASES
     */

    public Joueur(String nom){
        setNom(nom);
        Partie.getInstance().ajouterJoueurs(this);
    }

    public void setNom(String nom) {
        if(nom.equals(null)|| nom.trim().equals(""))
            throw new IllegalArgumentException("Probleme de nom");
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setUno(boolean uno) {
        this.uno = uno;
    }

    public boolean getUno() {
        return uno;
    }


    /*
            POUR LaMain
     */

    public ArrayList<Carte> getLaMain() {
        return laMain;
    }

    public Carte getCarte(int i){
        return laMain.get(i);
    }

    public void InitialisationCartes(Carte cartes){
        if(laMain.size() < 0 || laMain.size() >7)
            throw new IllegalArgumentException("Nombres de cartes non valide");
        laMain.add(cartes);
    }

    public int TailleDeLaMain(){
        return laMain.size();
    }
    public boolean doitDireUno(){
        return laMain.size()==1;
    }

    /*
            FONCTION POUR JOUER
     */

    public void disUNO() throws JoueurException, UnoException{
        if(this != Partie.getInstance().getJoueurCourant())
            throw new JoueurException("Erreur le joueur n'est pas celui qui doit jouer", this);
        if(doitDireUno()) {
            this.uno=true;
        }
        else{
            throw new UnoException("Le joueur "+ this +"possède plus d'une cartes",this);
        }
    }

    // FONCTION ENCAISSER 2

    public void piocher() throws Exception{
        Partie partie = Partie.getInstance();
        if(partie.getSiJoueurAJoue())
            throw new JoueurException("Erreur : tu as deja joue", this);
        if(this != partie.getJoueurCourant())
            throw new JoueurException("Erreur le joueur n'est pas celui qui doit jouer", this);
        laMain.add(partie.prendrePioche());
        partie.setJoueurAJoue(true);
    }

    public void jouer(Carte carte) throws Exception {
        Partie partie = Partie.getInstance();
        if(this != partie.getJoueurCourant())
            throw new JoueurException("Erreur le joueur n'est pas celui qui doit jouer", this);
        if(partie.getSiJoueurAJoue())
            throw new JoueurException("Erreur ce joueur a deja joue ", this);
        partie.ajouterDansTas(carte);
        laMain.remove(carte);
        partie.setJoueurAJoue(true);
        partie.getPremiereCarteTas().effet();
    }

    public void finirTour() throws Exception{
        Partie partie = Partie.getInstance();
        if(this != partie.getJoueurCourant())
            throw new JoueurException("Ce n'est pas ton tour ", this);
        if(!partie.getSiJoueurAJoue())
            throw new JoueurException(""+ this +" tu n'as pas encore joue ", this);
        if(doitDireUno() && !uno)
            throw new UnoException("Le joueur n'a pas dit UNO ", this);
        partie.Suivant();
        partie.setJoueurAJoue(false);
    }

    public void punir(Exception e) throws Exception {
        Partie partie = Partie.getInstance();
        laMain.add(partie.prendrePioche());
        laMain.add(partie.prendrePioche());
        if(e instanceof CartesValideException)
            partie.Suivant();
        if(e instanceof UnoException){
            laMain.add(partie.getPremiereCarteTas());
            partie.removeCarteTas(partie.getPremiereCarteTas());
            partie.Suivant();
        }
        if(e instanceof JoueurException){
            if(partie.getPremiereCarteTas() instanceof CartePlus2);
                encaisser();
        }
    }

    public void encaisser() throws Exception {
        Partie partie = Partie.getInstance();

        if(partie.getPremiereCarteTas() instanceof CartePlus2) {
            CartePlus2 plus2 = (CartePlus2) partie.getPremiereCarteTas();

            for (int i = 0; i < partie.getCumulPlus2()*2; i++) {
                piocher();
                partie.setJoueurAJoue(false);
            }
        }
        partie.setJoueurAJoue(true);
        finirTour();
    }

    /*
           TO STRING
     */

    @Override
    public String toString() {
        return ""+nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return uno == joueur.uno && Objects.equals(nom, joueur.nom) && Objects.equals(laMain, joueur.laMain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, uno, laMain);
    }
}