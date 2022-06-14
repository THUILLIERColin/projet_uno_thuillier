package application;

import cartes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CreationCartes{
    private ArrayList<Carte> cartes = new ArrayList<>();

    private Carte bleu0 = new CarteSimple(Carte.Color.BLEU, 0);
    private Carte bleu1 = new CarteSimple(Carte.Color.BLEU, 1);
    private Carte bleu2 = new CarteSimple(Carte.Color.BLEU, 2);
    private Carte bleu3 = new CarteSimple(Carte.Color.BLEU, 3);
    private Carte bleu4 = new CarteSimple(Carte.Color.BLEU, 4);
    private Carte bleu5 = new CarteSimple(Carte.Color.BLEU, 5);
    private Carte bleu6 = new CarteSimple(Carte.Color.BLEU, 6);
    private Carte bleu7 = new CarteSimple(Carte.Color.BLEU, 7);
    private Carte bleu8 = new CarteSimple(Carte.Color.BLEU, 8);
    private Carte bleu9 = new CarteSimple(Carte.Color.BLEU, 9);
    private Carte bleuPasse = new CartePasser(Carte.Color.BLEU);
    private Carte bleuPlus2 = new CartePlus2(Carte.Color.BLEU);
    private Carte bleuReverse = new CarteReverse(Carte.Color.BLEU);

    private Carte jaune0 = new CarteSimple(Carte.Color.JAUNE, 0);
    private Carte jaune1 = new CarteSimple(Carte.Color.JAUNE, 1);
    private Carte jaune2 = new CarteSimple(Carte.Color.JAUNE, 2);
    private Carte jaune3 = new CarteSimple(Carte.Color.JAUNE, 3);
    private Carte jaune4 = new CarteSimple(Carte.Color.JAUNE, 4);
    private Carte jaune5 = new CarteSimple(Carte.Color.JAUNE, 5);
    private Carte jaune6 = new CarteSimple(Carte.Color.JAUNE, 6);
    private Carte jaune7 = new CarteSimple(Carte.Color.JAUNE, 7);
    private Carte jaune8 = new CarteSimple(Carte.Color.JAUNE, 8);
    private Carte jaune9 = new CarteSimple(Carte.Color.JAUNE, 9);
    private Carte jaunePasse = new CartePasser(Carte.Color.JAUNE);
    private Carte jaunePlus2 = new CartePlus2(Carte.Color.JAUNE);
    private Carte jauneReverse = new CarteReverse(Carte.Color.JAUNE);

    private Carte rouge0 = new CarteSimple(Carte.Color.ROUGE, 0);
    private Carte rouge1 = new CarteSimple(Carte.Color.ROUGE, 1);
    private Carte rouge2 = new CarteSimple(Carte.Color.ROUGE, 2);
    private Carte rouge3 = new CarteSimple(Carte.Color.ROUGE, 3);
    private Carte rouge4 = new CarteSimple(Carte.Color.ROUGE, 4);
    private Carte rouge5 = new CarteSimple(Carte.Color.ROUGE, 5);
    private Carte rouge6 = new CarteSimple(Carte.Color.ROUGE, 6);
    private Carte rouge7 = new CarteSimple(Carte.Color.ROUGE, 7);
    private Carte rouge8 = new CarteSimple(Carte.Color.ROUGE, 8);
    private Carte rouge9 = new CarteSimple(Carte.Color.ROUGE, 9);
    private Carte rougePasse = new CartePasser(Carte.Color.ROUGE);
    private Carte rougePlus2 = new CartePlus2(Carte.Color.ROUGE);
    private Carte rougeReverse = new CarteReverse(Carte.Color.ROUGE);

    private Carte vert0 = new CarteSimple(Carte.Color.VERT, 0);
    private Carte vert1 = new CarteSimple(Carte.Color.VERT, 1);
    private Carte vert2 = new CarteSimple(Carte.Color.VERT, 2);
    private Carte vert3 = new CarteSimple(Carte.Color.VERT, 3);
    private Carte vert4 = new CarteSimple(Carte.Color.VERT, 4);
    private Carte vert5 = new CarteSimple(Carte.Color.VERT, 5);
    private Carte vert6 = new CarteSimple(Carte.Color.VERT, 6);
    private Carte vert7 = new CarteSimple(Carte.Color.VERT, 7);
    private Carte vert8 = new CarteSimple(Carte.Color.VERT, 8);
    private Carte vert9 = new CarteSimple(Carte.Color.VERT, 9);
    private Carte vertPasse = new CartePasser(Carte.Color.VERT);
    private Carte vertPlus2 = new CartePlus2(Carte.Color.VERT);
    private Carte vertReverse = new CarteReverse(Carte.Color.VERT);

    private Carte changerCouleur = new CarteChangerCouleur();

    public CreationCartes() {
        cartes.add(changerCouleur);
        cartes.add(changerCouleur);
        cartes.add(changerCouleur);
        cartes.add(changerCouleur);

        cartes.add(bleu0);
        cartes.add(bleu1);
        cartes.add(bleu2);
        cartes.add(bleu3);
        cartes.add(bleu4);
        cartes.add(bleu5);
        cartes.add(bleu6);
        cartes.add(bleu7);
        cartes.add(bleu8);
        cartes.add(bleu9);
        cartes.add(bleuPasse);
        cartes.add(bleuPlus2);
        cartes.add(bleuReverse);

        cartes.add(jaune0);
        cartes.add(jaune1);
        cartes.add(jaune2);
        cartes.add(jaune3);
        cartes.add(jaune4);
        cartes.add(jaune5);
        cartes.add(jaune6);
        cartes.add(jaune7);
        cartes.add(jaune8);
        cartes.add(jaune9);
        cartes.add(jaunePasse);
        cartes.add(jaunePlus2);
        cartes.add(jauneReverse);

        cartes.add(rouge0);
        cartes.add(rouge1);
        cartes.add(rouge2);
        cartes.add(rouge3);
        cartes.add(rouge4);
        cartes.add(rouge5);
        cartes.add(rouge6);
        cartes.add(rouge7);
        cartes.add(rouge8);
        cartes.add(rouge9);
        cartes.add(rougePasse);
        cartes.add(rougePlus2);
        cartes.add(rougeReverse);

        cartes.add(vert0);
        cartes.add(vert1);
        cartes.add(vert2);
        cartes.add(vert3);
        cartes.add(vert4);
        cartes.add(vert5);
        cartes.add(vert6);
        cartes.add(vert7);
        cartes.add(vert8);
        cartes.add(vert9);
        cartes.add(vertPasse);
        cartes.add(vertPlus2);
        cartes.add(vertReverse);
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
}

