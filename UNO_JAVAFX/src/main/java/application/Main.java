package application;

import cartes.Carte;
import cartes.CarteChangerCouleur;
import exceptions.*;
import expert.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import joueur.Joueur;
import partie.Partie;

public class Main extends Application {

    private static final int H_CANVAS = 130;
    private static final int L_CANVAS = 400;
    private static final int L_CARTE = 80;
    private static final int ECART = 30;

    private BorderPane root;
    private Stage fenetreEnCours;
    private boolean afficherCarte;

    private Partie partie;
    private Canvas canSabot;
    private Joueur joueurNord;
    private Joueur joueurOuest;
    private Joueur joueurSud;
    private Joueur joueurEst;

    private Carte.Color couleurChoisiAvecBouton = null;
    private String couleurChoisiAffichage;

    @Override
    public void start(Stage primaryStage) {
        try {
            root = new BorderPane();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            fenetreEnCours = primaryStage;

            partie = Partie.getInstance();
            partie.setExpert(new ExpertCarteSimpleCarteSimple(new ExpertCartePasserCartePasser(new ExpertCartePasserCarteSimple(new ExpertCartePlus2CartePasser(new ExpertCartePlus2CartePlus2(new ExpertCartePlus2CarteSimple(new ExpertCarteReverseCartePasser(new ExpertCarteReveseCarteSimple(new ExpertCarteReverseCartePasser(new ExpertCarteReverseCarteReverse(new ExpertCarteReverseCartePasser(new ExpertCarteChangerCouleur(new ExpertCartePlus2CarteReverse(null))))))))))))));

            GestionCartes.creerListeCarteInitial(new CreationCartes());
            GestionCartes.melangerCarte(Partie.getInstance().getListeCartesInitiales());

            joueurNord = new Joueur("Yann");
            joueurOuest = new Joueur("Camille");
            joueurSud = new Joueur("Isabelle");
            joueurEst = new Joueur("Charlotte");

            GestionCartes.distribuerAuxJoueurs(7);

            root.setTop(initJoueur(joueurNord));
            root.setRight(initJoueur(joueurOuest));
            root.setBottom(initJoueur(joueurSud));
            root.setLeft(initJoueur(joueurEst));
            root.setCenter(initSabot());

            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private VBox initJoueur(Joueur joueur) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        Label nomNord;

        /*
                Visualisation de toutes les cartes
         */

        //if(joueur == Partie.getInstance().getJoueurCourant()){
        // nomNord= initLabelNom(joueur.getNom()+ " c'est ton tour");
        // afficherCarte = true;
        // }
        //else nomNord=initLabelNom(joueur.getNom());

        /*
                Visualisation des cartes du joueur en cours
         */
        nomNord= initLabelNom(joueur.getNom());
        afficherCarte = (joueur == Partie.getInstance().getJoueurCourant());
        /* -------------------------------------------------------------------- */

        Canvas canMainNord = initMain(joueur);
        HBox unoNord = initBoutonUno(canMainNord, joueur);
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
                System.err.println(e.getMessage());
                try {
                    joueur.punir();
                } catch (JoueurException ex) {
                    System.err.println(ex.getMessage());
                } catch (UnoException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            actualiserAffichagePartie();
        });

        Button	boutonPioche = new Button("Pioche");
        boutonPioche.setOnAction(select -> {
            System.out.print("Le joueur pioche : ");
            int taille = joueur.getTailleDeLaMain();
            try {
                joueur.piocher();
                System.out.println(joueur.getTailleDeLaMain()-taille+" carte(s)");
            } catch (JoueurException e) {
                e.printStackTrace();
                try {
                    joueur.punir();
                } catch (JoueurException ex) {
                    ex.printStackTrace();
                } catch (UnoException ex) {
                    ex.printStackTrace();
                }
            } catch (UnoException e) {
                try {
                    joueur.punirUnoException();
                } catch (JoueurException ex) {
                    ex.printStackTrace();
                } catch (UnoException ex) {
                    ex.printStackTrace();
                }
            } catch (VictoireException e) {
                e.printStackTrace();
            }
            actualiserAffichagePartie();
        });

        Button	boutonEncaisser = new Button("Encaisser");
        boutonEncaisser.setOnAction(select -> {
            System.out.print("Le joueur encaisse les plus 2 et prends donc : ");
            int taille = joueur.getTailleDeLaMain();
            try {
                joueur.encaisser();
                System.out.println(joueur.getTailleDeLaMain()-taille);
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
            actualiserAffichagePartie();
        });

        Button boutonFinirTour = new Button("Finir tour");
        boutonFinirTour.setOnAction(select -> {
            System.out.println(joueur.getNom() + " finit son tour");
            try {
                joueur.finirTour();
            } catch (UnoException e) {
                try {
                    joueur.punirUnoException();
                    System.err.println(e.getMessage());
                } catch (JoueurException ex) {
                    System.err.println(ex.getMessage());
                } catch (UnoException ex) {
                    System.err.println(ex.getMessage());
                }
            } catch (JoueurException e) {
                try {
                    e.getMauvaisJoueur().punir();
                    System.err.println(e.getMessage());
                } catch (JoueurException ex) {
                    System.err.println(ex.getMessage());
                } catch (UnoException ex) {
                    System.err.println(ex.getMessage());
                }
            } catch (VictoireException e) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle("Boite de Victoire");
                dialog.setHeaderText("Un joueur a gagné la partie");
                dialog.setContentText("Félicitation " + e.getJoueurVainqueur()+ " vous avez gagné cette partie !");
                dialog.showAndWait();
                fenetreEnCours.close();
            }
            actualiserAffichagePartie();
            if(partie.getPremiereCarteTas() instanceof CarteChangerCouleur){
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle("Le choix de couleur");
                dialog.setHeaderText(joueur+" a joué la carte joker");
                dialog.setContentText("La couleur demandée est la couleur " + couleurChoisiAffichage);
                couleurChoisiAvecBouton=null;
                dialog.showAndWait();
            }
        });

        hBox.getChildren().addAll(boutonUno,boutonPioche, boutonEncaisser, boutonFinirTour);

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
             * prévu pour chaque joueur. Faites comme vous voulez !
             */
        });

        return canSabot;
    }

    private void dessinerSabot() {
        Image sabot = new Image("Sabot.png");
        Image dos = new Image("carte_dos.png");
        canSabot.setWidth(sabot.getWidth());
        canSabot.setHeight(sabot.getHeight());

        /* normalement, il faut retourner la première carte de la pioche pour amorcer
         * la manche. J'initialise cela en dur mais vous devrez changer cela en fonction
         * de vos classes
         */



        Image imageCarte = new Image(""+ Partie.getInstance().getPremiereCarteTas());

        canSabot.getGraphicsContext2D().drawImage(sabot,0,0);
        canSabot.getGraphicsContext2D().drawImage(imageCarte,25,20);
        canSabot.getGraphicsContext2D().drawImage(dos,124,20);
    }


    private Canvas initMain(Joueur joueur) {
        Canvas canMain = new Canvas(L_CANVAS,H_CANVAS);

        dessinerMain(joueur, canMain);

        canMain.setOnMouseClicked(clic -> {
            int x = (int) clic.getX();
            int nbCartes = joueur.getTailleDeLaMain();
            int lMain = L_CARTE+((nbCartes-1)*ECART);
            int pad = (L_CANVAS-lMain) / 2;

            if(joueur == Partie.getInstance().getJoueurCourant()){
                if (x>=pad && x<=pad+lMain) {
                    int num = (int) ((x-pad) / ECART);
                    num = Math.min(nbCartes-1, num);
                    try {
                        Carte carteChoisi = joueur.getCarte(num);
                        System.out.println(joueur.getNom() + " a joué la carte "+ carteChoisi);

                        // Pour carte changer couleur
                        if(carteChoisi instanceof CarteChangerCouleur)
                        {
                            GridPane changeColorBox = new GridPane();
                            changeColorBox.setPrefSize(300,300);
                            changeColorBox.setVgap(10);
                            changeColorBox.setHgap(8);

                            Button boutonBleu = new Button("Bleu");
                            boutonBleu.setStyle("-fx-background-color : blue; -fx-text-fill: white");
                            boutonBleu.setPrefSize(110,110);
                            GridPane.setConstraints(boutonBleu, 0 , 0);
                            boutonBleu.setOnAction(select -> {
                                couleurChoisiAvecBouton= Carte.Color.BLEU;
                            });

                            Button boutonRouge = new Button("Rouge");
                            boutonRouge.setStyle("-fx-background-color : red");
                            boutonRouge.setPrefSize(110,110);
                            GridPane.setConstraints(boutonRouge, 0 , 1);
                            boutonRouge.setOnAction(select -> {
                                couleurChoisiAvecBouton= Carte.Color.ROUGE;
                            });

                            Button boutonJaune = new Button("Jaune");
                            boutonJaune.setStyle("-fx-background-color : yellow");
                            boutonJaune.setPrefSize(110,110);
                            GridPane.setConstraints(boutonJaune, 1, 0);
                            boutonJaune.setOnAction(select -> {
                                couleurChoisiAvecBouton= Carte.Color.JAUNE;
                            });

                            Button boutonVert = new Button("Vert");
                            boutonVert.setStyle("-fx-background-color : green");
                            boutonVert.setPrefSize(110,110);
                            GridPane.setConstraints(boutonVert, 1 , 1);
                            boutonVert.setOnAction(select -> {
                                couleurChoisiAvecBouton= Carte.Color.VERT;
                            });

                            changeColorBox.getChildren().addAll(boutonBleu,boutonRouge,boutonJaune,boutonVert);

                            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
                            dialog.setTitle("Choisis la couleur que tu veux jouer");
                            dialog.getDialogPane().setContent(changeColorBox);

                            ButtonType buttonApply = new ButtonType("Appliquer", ButtonBar.ButtonData.APPLY);
                            dialog.getDialogPane().getButtonTypes().addAll(buttonApply);

                            dialog.showAndWait();

                            CarteChangerCouleur c = (CarteChangerCouleur) carteChoisi;
                            c.setCouleurDemander(couleurChoisiAvecBouton);
                            switch (couleurChoisiAvecBouton){
                                case ROUGE : couleurChoisiAffichage="rouge";break;
                                case VERT: couleurChoisiAffichage="verte";break;
                                case JAUNE: couleurChoisiAffichage="jaune";break;
                                case BLEU: couleurChoisiAffichage="bleu";break;
                                default: System.err.println("Erreur couleur non répertorié");break;
                            }
                            dialog.close();
                        }
                        joueur.jouer(joueur.getCarte(num));
                    } catch (JoueurException e) {
                        System.err.println(e.getMessage());
                        try {
                            joueur.punir();
                        } catch (JoueurException ex) {
                            System.err.println(ex.getMessage());
                        } catch (UnoException ex) {
                            System.err.println(ex.getMessage());
                        }
                    } catch (ExpertManquantException e) {
                        System.err.println(e.getMessage());
                    } catch (CartesValideException e) {
                        System.err.println(e.getMessage());
                        try {
                            joueur.punirCarteValideException();
                        } catch (JoueurException ex) {
                            System.err.println(ex.getMessage());
                        } catch (UnoException ex) {
                            System.err.println(ex.getMessage());
                        }
                    } catch (UnoException e) {
                        e.printStackTrace();
                    } catch (VictoireException e) {
                        e.printStackTrace();
                    }
                    actualiserAffichagePartie();
                }
            }
        });

        return canMain;
    }


    private void dessinerMain(Joueur joueur, Canvas canvas) {
        Image dos = new Image("carte_dos.png");
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int nbCartes = joueur.getTailleDeLaMain();
        int lMain = L_CARTE+((nbCartes-1)*ECART);
        int pad = (L_CANVAS-lMain) / 2;

        for (int i=0; i<nbCartes; i++) {
            if(afficherCarte) {
                Image carte = new Image("" + joueur.getCarte(i));
                canvas.getGraphicsContext2D().drawImage(carte, pad + i * ECART, 0);
            }
            else {
                canvas.getGraphicsContext2D().drawImage(dos, pad + i * ECART, 0);
            }

        }
    }

    public void actualiserAffichagePartie() {
        root.setTop(initJoueur(joueurNord));
        root.setRight(initJoueur(joueurOuest));
        root.setBottom(initJoueur(joueurSud));
        root.setLeft(initJoueur(joueurEst));
        root.setCenter(initSabot());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
