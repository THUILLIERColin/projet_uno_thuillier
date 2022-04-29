package partie;

import java.util.ArrayList;
import java.util.Objects;

import cartes.Cartes;
import exceptions.CartesValideException;
import expert.Expert;
import joueur.Joueur;

public class Partie {

    public final static boolean AIGUILLE_MONTRE = true;
    public final static boolean SENS_INVERSE = false;

    private Expert expert;

    private int NbJoueurs;
    private boolean sens=AIGUILLE_MONTRE;
    private ArrayList<Joueur> lesJoueurs = new ArrayList<Joueur>();
    private ArrayList<Cartes> leTas = new ArrayList<Cartes>();
    private ArrayList<Cartes> laPioche = new ArrayList<Cartes>();
    private static volatile Partie instance= null;

    private Joueur joueurCourant;

    private Partie() {}

    /*
    ***********   Initialisation dans ajouter  ************

    public void setNbJoueurs(int NbJoueurs) {
        if(NbJoueurs < 0 || NbJoueurs >4)
            throw new IllegalArgumentException("NbJoueurs trop élevée");
        this.NbJoueurs = NbJoueurs;
    }
    */

    public static Partie getInstance() {
        if (instance == null) {
            instance = new Partie();
        }
        return instance;
    }

    /*
            DE BASE
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

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    /*
            POUR LES JOUEURS
     */

    public ArrayList<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public int getTaille(){
        return lesJoueurs.size();
    }

    public Joueur getJoueur(int i){
        if(i<0)
            return lesJoueurs.get(lesJoueurs.size()+i);  // A verifier car peut-etre ajouter 1
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

    public int getIndiceJoueur(Joueur joueurEnJeu){
        return lesJoueurs.indexOf(joueurEnJeu);
    }

    /*
            POUR LES CARTES DE PIOCHE
     */

    public Cartes prendre(){
        Cartes cartesPioche= laPioche.get(0);
        laPioche.remove(cartesPioche);
        return cartesPioche;
    }

    /*
            POUR LES CARTES DU TAS
     */

    public ArrayList<Cartes> getLeTas() {
        return leTas;
    }

    public Cartes getPremiereCarte(){
        return leTas.get(0);
    }

    public void poser(Cartes cartes) throws Exception{
        if(!expert.traiter(cartes))
            throw new CartesValideException("Cout invalide",cartes);
        leTas.add(cartes);
    }

    /*
            FONCTION POUR JOUER
     */

    public void Suivant(){
        if(sens==SENS_INVERSE){
            joueurCourant= lesJoueurs.get(getIndiceJoueur(joueurCourant)-1);
        }
        else
        {
            joueurCourant= lesJoueurs.get(getIndiceJoueur(joueurCourant)+1);
        }
    }

    /*
            FAIRE FONCTION DISTRIBUER +
     */

    /*
           FONCTIONS GÉNÉRÉES
     */

    @Override
    public String toString() {
        return "Partie{" +
                "expert=" + expert +
                ", NbJoueurs=" + NbJoueurs +
                ", sens=" + sens +
                ", lesJoueurs=" + lesJoueurs +
                ", leTas=" + leTas +
                ", laPioche=" + laPioche +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partie partie = (Partie) o;
        return NbJoueurs == partie.NbJoueurs && sens == partie.sens && Objects.equals(expert, partie.expert) && Objects.equals(lesJoueurs, partie.lesJoueurs) && Objects.equals(leTas, partie.leTas) && Objects.equals(laPioche, partie.laPioche);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expert, NbJoueurs, sens, lesJoueurs, leTas, laPioche);
    }
}
