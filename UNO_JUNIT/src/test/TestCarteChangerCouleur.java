package test;

import cartes.Carte;
import cartes.CarteChangerCouleur;
import cartes.CarteReverse;
import cartes.CarteSimple;
import exceptions.*;
import expert.*;
import joueur.Joueur;
import partie.Partie;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCarteChangerCouleur {

    private static void afficherMain(Joueur j){
        System.out.println(j.getNom()+ " a la main "+ j.getLaMain());
    }

    private static ArrayList<Carte> lesCartesDeBase = new ArrayList<>();

    private static void removeLesCartesDeBase(){
        lesCartesDeBase.clear();
    }

    private static void Test1() throws UnoException, VictoireException, JoueurException, ExpertManquantException, CartesValideException {
        Partie partie = Partie.getInstance();
        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(new ExpertCarteReveseCarteSimple(new ExpertCarteChangerCouleur(null))))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");
        Joueur yann = new Joueur("Yann");

        lesCartesDeBase.add(new CarteChangerCouleur());
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,3));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,6));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.VERT,4));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,3));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,4));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,6));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.VERT,6));

        for (Carte c : lesCartesDeBase){
            partie.ajouterListeCartesInitiales(c);
        }

        removeLesCartesDeBase();
        partie.distribuerCartes(2);

        assertTrue(alice==partie.getJoueurCourant());

        CarteChangerCouleur ChangerCouleur = (CarteChangerCouleur) alice.getCarte(0);
        ChangerCouleur.setCouleurDemander(Carte.Color.BLEU);

        alice.jouer(ChangerCouleur);
        alice.disUNO();
        alice.finirTour();

        assertTrue(bob==partie.getJoueurCourant());

        Carte Bleu3 = bob.getCarte(1);
        bob.jouer(Bleu3);
        bob.disUNO();
        bob.finirTour();

        assertTrue(charles==partie.getJoueurCourant());
    }

    public static void main(String[] args) {
        Partie partie = Partie.getInstance();

        try {
            Test1();
        } catch (UnoException e) {
            e.printStackTrace();
        } catch (VictoireException e) {
            e.printStackTrace();
        } catch (JoueurException e) {
            e.printStackTrace();
        } catch (ExpertManquantException e) {
            e.printStackTrace();
        } catch (CartesValideException e) {
            e.printStackTrace();
        }
    }
}
