package test;

import cartes.Carte;
import cartes.CarteReverse;
import cartes.CarteSimple;
import exceptions.*;
import expert.*;
import joueur.Joueur;
import partie.Partie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestReverse {

    private static ArrayList<Carte> lesCartesDeBase = new ArrayList<>();

    private static void removeLesCartesDeBase(){
        lesCartesDeBase.clear();
    }

    private static void Test1() throws UnoException, VictoireException, JoueurException, ExpertManquantException, CartesValideException {
        Partie partie = Partie.getInstance();
        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(new ExpertCarteReveseCarteSimple(null)))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");
        Joueur yann = new Joueur("Yann");

        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,1));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,3));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,6));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.VERT,4));
        lesCartesDeBase.add(new CarteReverse(Carte.Color.ROUGE));
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

        Carte Rouge1 = alice.getCarte(0);

        alice.jouer(Rouge1);
        alice.disUNO();
        alice.finirTour();

        assertTrue(bob==partie.getJoueurCourant());

        Carte ReverseRouge = bob.getCarte(1);
        bob.jouer(ReverseRouge);
        bob.disUNO();
        bob.finirTour();

        assertTrue(alice==partie.getJoueurCourant());
    }

    private static void Test2() throws UnoException, VictoireException, JoueurException, ExpertManquantException, CartesValideException {
        Partie partie = Partie.getInstance();
        partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePlus2CarteSimple(new ExpertCartePlus2CartePlus2(new ExpertCarteReveseCarteSimple(new ExpertCarteReverseCarteReverse(null))))));

        Joueur alice = new Joueur("Alice");
        Joueur bob = new Joueur("Bob");
        Joueur charles = new Joueur("Charles");
        Joueur yann = new Joueur("Yann");

        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,1));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,3));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,9));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.VERT,4));
        lesCartesDeBase.add(new CarteReverse(Carte.Color.ROUGE));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,4));

        lesCartesDeBase.add(new CarteReverse(Carte.Color.ROUGE));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.VERT,4));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,4));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.ROUGE,6));

        lesCartesDeBase.add(new CarteSimple(Carte.Color.BLEU,5));
        lesCartesDeBase.add(new CarteSimple(Carte.Color.VERT,6));

        for (Carte c : lesCartesDeBase){
            partie.ajouterListeCartesInitiales(c);
        }

        removeLesCartesDeBase();
        partie.distribuerCartes(3);

        assertTrue(alice==partie.getJoueurCourant());

        Carte Rouge1 = alice.getCarte(0);
        alice.jouer(Rouge1);
        alice.finirTour();

        assertTrue(bob==partie.getJoueurCourant());

        Carte ReverseRouge = bob.getCarte(1);
        bob.jouer(ReverseRouge);
        bob.finirTour();

        assertTrue(alice==partie.getJoueurCourant());

        Carte ReverseRougebis = alice.getCarte(1);
        alice.jouer(ReverseRougebis);
        alice.disUNO();
        alice.finirTour();

        assertTrue(bob==partie.getJoueurCourant());
    }
    public static void main(String[] args) {
        Partie partie = Partie.getInstance();

        try {
            Test1();
            partie.reinitialiserPartie();
            Test2();
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
