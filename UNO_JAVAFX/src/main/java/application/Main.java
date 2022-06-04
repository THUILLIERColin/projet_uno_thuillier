package application;

import cartes.Carte;
import exceptions.CartesValideException;
import exceptions.ExpertManquantException;
import exceptions.JoueurException;
import exceptions.UnoException;
import expert.*;
import fichiers.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import joueur.Joueur;
import partie.Partie;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    private static final int H_CANVAS = 130;
    private static final int L_CANVAS = 400;
    private static final int L_CARTE = 80;
    private static final int ECART = 30;
    private Canvas canSabot;

    private Carte carteChoisi;

    private ArrayList<Carte> listeCartes = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            Partie partie = Partie.getInstance();

            // Acces au fichier contenant les cartes
            File file = new File("");
            String nomDuFichier = file.getAbsolutePath();
            nomDuFichier+="/src/main/resources/JeuTest.csv";


            Parser premierParser = new ParserCarteSimple(new ParserCartePasser(new ParserPlus2(new ParserChangerCouleur(null) )));

            Fichier.lire(nomDuFichier, premierParser);

            partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePasserCartePasser(new ExpertCartePasserCarteSimple(new ExpertCartePlus2CartePasser(new ExpertCartePlus2CartePlus2(new ExpertCartePlus2CarteSimple(null)))))));

            Joueur joueurN = new Joueur("Yann");
            Joueur joueurO = new Joueur("Camille");
            Joueur joueurS = new Joueur("Isabelle");
            Joueur joueurE = new Joueur("Charlotte");

            partie.distribuerCartes(7);

            VBox joueurNord = initJoueur(joueurN);
            root.setTop(joueurNord);

            VBox joueurOuest = initJoueur(joueurO);
            root.setRight(joueurOuest);

            VBox joueurSud = initJoueur(joueurS);
            root.setBottom(joueurSud);

            VBox joueurEst = initJoueur(joueurE);
            root.setLeft(joueurEst);

            root.setCenter(initSabot());

            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private VBox initJoueur(Joueur joueur) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Label nomNord = initLabelNom(joueur.getNom());
        /*
                rajouter
         */
        //  **************************  //
        Canvas canMainNord = initMain(joueur.getLaMain()/* paramètres ?*/);
        HBox unoNord = initBoutonUno(canMainNord, joueur/* et d'autres paramètres ? */);
        vBox.getChildren().addAll(nomNord,canMainNord,unoNord);
        return vBox;
    }


    private HBox initBoutonUno(Canvas canMain, Joueur joueur /* et d'autres paramètres ? */) {
        /* Cette partie est sans doute incomplète. Il y a sans doute d'autres actions à
         * prévoir que piocher et dire uno !
         */


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        Button boutonUno = new Button("Uno !");

        boutonUno.setOnAction(select -> {
            System.out.println("Le joueur dit Uno !");
            try {
                joueur.disUNO();
            } catch (JoueurException e) {
                e.printStackTrace();
                try {
                    joueur.punir();
                } catch (JoueurException ex) {
                    ex.printStackTrace();
                } catch (UnoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button	boutonPioche = new Button("Pioche");

        boutonPioche.setOnAction(select -> {
            System.out.println("Le joueur pioche");
            try {
                joueur.piocher();
            } catch (JoueurException e) {
                e.printStackTrace();
                try {
                    joueur.punir();
                } catch (JoueurException ex) {
                    ex.printStackTrace();
                } catch (UnoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button	boutonJouer = new Button("Jouer");

        boutonJouer.setOnAction(select -> {
            System.out.println("Le joueur joue");

            try {
                System.out.println("Le joueur a joué le "+ carteChoisi);
                joueur.jouer(carteChoisi);
            } catch (JoueurException | ExpertManquantException e) {
                e.printStackTrace();
                try {
                    joueur.punir();
                } catch (JoueurException ex) {
                    ex.printStackTrace();
                } catch (UnoException ex) {
                    ex.printStackTrace();
                }
            } catch (CartesValideException cartesValideException){
                try {
                    joueur.punirCarteValideException();
                } catch (JoueurException e) {
                    e.printStackTrace();
                } catch (UnoException e) {
                    e.printStackTrace();
                }
            }
        });

        hBox.getChildren().addAll(boutonUno,boutonPioche, boutonJouer);

        return hBox;
    }


    private Label initLabelNom(String nom) {
        Label bidon = new Label("");
        bidon.setFont(new Font("Arial", 30));

        Label lNom = new Label(nom);
        lNom.setFont(new Font("Arial", 30));

        return lNom;
    }


    private Canvas initSabot() {

        canSabot = new Canvas();

        dessinerSabot();

        canSabot.setOnMouseClicked(clic -> {
            System.out.println("Pioche!");
            /* j'ai prévu l'évènement mais personnellement je ne l'utilise pas. J'utilise le bouton
             * prévu pour chaque joueur. Faites coimme vous voulez !
             */
        });

        return canSabot;
    }

    private void dessinerSabot() {
        // getClass().getResourceAsStream()
        Image sabot = new Image("Sabot.png");
        // getClass().getResourceAsStream("/carte_dos.png")
        Image dos = new Image("carte_dos.png");
        canSabot.setWidth(sabot.getWidth());
        canSabot.setHeight(sabot.getHeight());

        /* normalement, il faut retourner la première carte de la pioche pour amorcer
         * la manche. J'initialise cela en dur mais vous devrez changer cela en fonction
         * de vos classes
         */

        Image imageCarte = new Image(""+ Partie.getInstance().getPremiereCartePioche());

        canSabot.getGraphicsContext2D().drawImage(sabot,0,0);
        canSabot.getGraphicsContext2D().drawImage(imageCarte,25,20);
        canSabot.getGraphicsContext2D().drawImage(dos,124,20);
    }


    private Canvas initMain(ArrayList<Carte> liste) {
        Canvas canMain = new Canvas(L_CANVAS,H_CANVAS);

        dessinerMain(liste, canMain);


        canMain.setOnMouseClicked(clic -> {
            int x = (int) clic.getX();
            int nbCartes = liste.size();
            int lMain = L_CARTE+((nbCartes-1)*ECART);
            int pad = (L_CANVAS-lMain) / 2;

            if (x>=pad && x<=pad+lMain) {
                int num = (int) ((x-pad) / ECART);
                num = Math.min(nbCartes-1, num);
                System.out.println("Le joueur a sélectionné la carte "+num);
                /* sûrement à compléter */

                carteChoisi = Partie.getInstance().getJoueurCourant().getCarte(num);
            }
        });

        return canMain;
    }


    private void dessinerMain(ArrayList<Carte> liste, Canvas canvas) {
        /* liste est une liste de chaines de car. Mais vous devriez sans doute utiliser
         * vos propres classes, pas des String !
         */


        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int nbCartes = liste.size();
        int lMain = L_CARTE+((nbCartes-1)*ECART);
        int pad = (L_CANVAS-lMain) / 2;

        for (int i=0; i<nbCartes; i++) {
            Image carte = new Image(""+liste.get(i)); /* à adapter */
            canvas.getGraphicsContext2D().drawImage(carte,pad+i*ECART,0);

        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}
