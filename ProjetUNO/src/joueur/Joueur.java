package joueur;

import cartes.Carte;
import exceptions.CartesValideException;
import exceptions.JoueurException;
import exceptions.UnoException;
import partie.Partie;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private boolean uno=false;
    private ArrayList<Carte> laMain = new ArrayList<>();

    /*
            DE BASES
     */

    public Joueur(String nom){
        setNom(nom);
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
            System.out.println("UNOOOO !!!!");
        }
        else{
            throw new UnoException("Le joueur "+ this +"possède plus d'une cartes",this);
        }
    }

    public void piocher() throws Exception{
        Partie partie = Partie.getInstance();
        if(partie.getJoueurAJoue())
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
        if(partie.getJoueurAJoue())
            throw new JoueurException("Erreur ce joueur a deja joue", this);
        System.out.println(""+ this+" joue le" + carte);
        carte.effet();
        partie.ajouterDansTas(carte);
        laMain.remove(carte);
        partie.setJoueurAJoue(true);
    }

    public void finirTour() throws Exception{
        Partie partie = Partie.getInstance();
        if(this != partie.getJoueurCourant())
            throw new JoueurException("Ce n'est pas ton tour", this);
        if(!partie.getJoueurAJoue())
            throw new JoueurException(""+ this +" tu n'as pas encore joue", this);
        if(doitDireUno() && !uno)
            throw new UnoException("Le joueur n'a pas dit UNO", this);
        System.out.println(this+ " a fini");
        partie.Suivant();
        partie.setJoueurAJoue(false);
    }

    public void punir(Exception e){
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
    }

    /*
           TO STRING
     */

    @Override
    public String toString() {
        return ""+nom;
    }
}