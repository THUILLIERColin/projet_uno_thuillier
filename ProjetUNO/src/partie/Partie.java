package partie;

import java.util.ArrayList;

import cartes.Cartes;
import joueur.Joueur;

public class Partie {

    public final static boolean AIGUILLE_MONTRE = true;
    public final static boolean SENS_INVERSE = false;

    private int NbJoueurs;
    private boolean sens=AIGUILLE_MONTRE;
    private ArrayList<Joueur> lesJoueurs = new ArrayList<>();
    private ArrayList<Cartes> leTas = new ArrayList<>();
    private ArrayList<Cartes> laPioche = new ArrayList<>();

    public Partie() {}

    /*
    ***********   Initialisation dans ajouter  ************

    public void setNbJoueurs(int NbJoueurs) {
        if(NbJoueurs < 0 || NbJoueurs >4)
            throw new IllegalArgumentException("NbJoueurs trop élevée");
        this.NbJoueurs = NbJoueurs;
    }
    */

    public void setSens(boolean sens) {
        this.sens = sens;
    }

    public boolean getSens() {
        return sens;
    }

    public int getNbJoueurs() {
        return NbJoueurs;
    }

    public ArrayList<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public int getTaille(){
        return lesJoueurs.size();
    }

    public Joueur getJoueur(int i){
        return lesJoueurs.get(i);
    }

    public void ajouterJoueurs(Joueur joueur){
        if(lesJoueurs.size()< 0 || lesJoueurs.size()>4)
            throw new IllegalArgumentException("NbJoueurs trop élevée");
        if(lesJoueurs.contains(joueur))
            throw new IllegalArgumentException("La liste contient deja le joueur");
        lesJoueurs.add(joueur);
        NbJoueurs = lesJoueurs.size();
    }

    public void removeJoueur(Joueur joueur){
        if(!lesJoueurs.contains(joueur))
            throw new IllegalArgumentException("Joueur non trouvé");
        lesJoueurs.remove(joueur);
        NbJoueurs = lesJoueurs.size();
    }

    public Cartes prendre(){
        Cartes cartesPioche= laPioche.get(0);
        laPioche.remove(cartesPioche);
        return cartesPioche;
    }

    public void

    public void poser(){
        
    }
}
