package com.kotprog.game;

import com.kotprog.game.entities.EnemyHero;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * A ControllerBattle osztály.
 *
 * Egy igazi monstrum.
 * Ez az osztály felel a csata lebonyolításáért: Egységek elhelyezése, ellenfél egységeinek lehelyezése, ellenfél hősének
 * tulajdonságainak és varázslatainak megjelenítése, kezdeményezési sorrend meghatározása és megjelenítése,
 * hőssel való támadás és varázslás, egységekkel való művelet végrehajtás illetve a játék befejezése.
 *
 */

public class ControllerBattle {

    ControllerUnit controllerUnit = new ControllerUnit();
    ControllerHero controllerHero = new ControllerHero();
    ControllerDiff controllerDiff = new ControllerDiff();
    EnemyHero enemyHero = new EnemyHero();


    int farmerCount;
    int archerCount;
    int griffCount;
    int inquisitorCount;
    int angelCount;

    int farmerMaxCount;
    int archerMaxCount;
    int griffMaxCount;
    int inquisitorMaxCount;
    int angelMaxCount;


    int farmerMaxHealth;
    int archerMaxHealth;
    int griffMaxHealth;
    int inquisitorMaxHealth;
    int angelMaxHealth;

    int enemyUnit1MaxHealth;
    int enemyUnit2MaxHealth;
    int enemyUnit3MaxHealth;
    int enemyUnit4MaxHealth;
    int enemyUnit5MaxHealth;

    int farmerHealth;
    int archerHealth;
    int griffHealth;
    int inquisitorHealth;
    int angelHealth;

    int enemyUnit1Health;
    int enemyUnit2Health;
    int enemyUnit3Health;
    int enemyUnit4Health;
    int enemyUnit5Health;

    int manna;
    int newManna;

    int count = 0;
    int count1;
    int roundCount = 1;
    int unitsOnBoard = 0;
    int heroActionDone = 0;
    int unitActionDone = 0;

    Label rank1 = new Label("");
    Label rank2 = new Label("");
    Label rank3 = new Label("");
    Label rank4 = new Label("");
    Label rank5 = new Label("");
    Label rank6 = new Label("");
    Label rank7 = new Label("");
    Label rank8 = new Label("");
    Label rank9 = new Label("");
    Label rank10 = new Label("");


    AnchorPane root = new AnchorPane();

    Label lblRound = new Label("");
    Label lblInit = new Label("Kezdeményezési sorrend:");
    Label lblActual = new Label("");

    Label lblFarmer = new Label("");
    Label lblFarmerC = new Label("");
    Label lblFarmer1 = new Label("");
    Label lblFarmerC1 = new Label("");
    VBox vbFarmer = new VBox(lblFarmer);
    VBox vbFarmer1 = new VBox();
    boolean farmerExist = false;

    Label lblArcher = new Label("");
    Label lblArcherC = new Label("");
    Label lblArcher1 = new Label("");
    Label lblArcherC1 = new Label("");
    VBox vbArcher = new VBox(lblArcher);
    VBox vbArcher1 = new VBox();
    boolean archerExist = false;

    Label lblGriff = new Label("");
    Label lblGriffC = new Label("");
    Label lblGriff1 = new Label("");
    Label lblGriffC1 = new Label("");
    VBox vbGriff = new VBox(lblGriff);
    VBox vbGriff1 = new VBox();
    boolean griffExist = false;

    Label lblInquisitor = new Label("");
    Label lblInquisitorC = new Label("");
    Label lblInquisitor1 = new Label("");
    Label lblInquisitorC1 = new Label("");
    VBox vbInquisitor = new VBox(lblInquisitor);
    VBox vbInquisitor1 = new VBox();
    boolean inquisitorExist = false;

    Label lblAngel = new Label("");
    Label lblAngelC = new Label("");
    Label lblAngel1 = new Label("");
    Label lblAngelC1 = new Label("");
    VBox vbAngel = new VBox(lblAngel);
    VBox vbAngel1 = new VBox();
    boolean angelExist = false;

    Label lblEnemyVirtues = new Label("");
    Label lblAttack = new Label("");
    Label lblDefence = new Label("");
    Label lblSpellpower = new Label("");
    Label lblKnowledge = new Label("");
    Label lblMorale = new Label("");
    Label lblLuck = new Label("");

    Label lblEnemySpells = new Label("");
    Label lblSpellOne = new Label("");
    Label lblSpellTwo = new Label("");
    Label lblSpellThree = new Label("");

    Label lblEnemyUnit1 = new Label("");
    Label lblEnemyUnit2 = new Label("");
    Label lblEnemyUnit3 = new Label("");
    Label lblEnemyUnit4 = new Label("");
    Label lblEnemyUnit5 = new Label("");

    Label lblUnit1Count = new Label("");
    Label lblUnit2Count = new Label("");
    Label lblUnit3Count = new Label("");
    Label lblUnit4Count = new Label("");
    Label lblUnit5Count = new Label("");

    VBox vbUnit1 = new VBox(lblEnemyUnit1, lblUnit1Count);
    VBox vbUnit2 = new VBox(lblEnemyUnit2, lblUnit2Count);
    VBox vbUnit3 = new VBox(lblEnemyUnit3, lblUnit3Count);
    VBox vbUnit4 = new VBox(lblEnemyUnit4, lblUnit4Count);
    VBox vbUnit5 = new VBox(lblEnemyUnit5, lblUnit5Count);

    boolean enemyUnit1Exist = false;
    boolean enemyUnit2Exist = false;
    boolean enemyUnit3Exist = false;
    boolean enemyUnit4Exist = false;
    boolean enemyUnit5Exist = false;

    Label lblHero = new Label("");
    Label lblHeroManna = new Label("");


    Button btnNext = new Button("Tovább");
    int nextClickCounter;
    Button btnBegin = new Button("Csata elkezdése");
    Button btnNextUnit = new Button("Következő egység");

    Button btnHeroAttack = new Button("Támadás");
    Button btnHeroSpells = new Button("Varázslás");

    Button btnUnitAttack = new Button("Támadás");
    Button btnUnitWait = new Button("Várakozás");

    Button btnSpellOne = new Button(controllerHero.one.getName()+" ("+controllerHero.one.getManaCost()+")");
    Button btnSpellTwo = new Button(controllerHero.two.getName()+" ("+controllerHero.two.getManaCost()+")");
    Button btnSpellThree = new Button(controllerHero.three.getName()+" ("+controllerHero.three.getManaCost()+")");

    GridPane gridPane = new GridPane();
    StackPane stackPane;
    StackPane stackPane1;

    List<String> units = new ArrayList<>();


    public void battlefield(Label lblBoughtF, Label lblBoughtA, Label lblBoughtG, Label lblBoughtI, Label lblBoughtAN) {

        Stage stage = new Stage();
        Scene scene = new Scene(root, 1300, 1000);
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.setTitle("Kotprog goes brr");
        stage.setResizable(false);
        stage.show();

        farmerMaxCount = Integer.parseInt(lblBoughtF.getText());
        archerMaxCount = Integer.parseInt(lblBoughtA.getText());
        griffMaxCount = Integer.parseInt(lblBoughtG.getText());
        inquisitorMaxCount = Integer.parseInt(lblBoughtI.getText());
        angelMaxCount = Integer.parseInt(lblBoughtAN.getText());

        root.getChildren().add(btnNext);
        btnNext.setLayoutX(900);
        btnNext.setLayoutY(600);
        btnNext.setDisable(true);
        btnNext.setOnAction((ActionEvent e) -> {

            nextClickCounter = 1;

            root.getChildren().remove(btnNext);

            Random x = new Random();
            Random y = new Random();
            int count;
            if(controllerDiff.isBEasy()) {
                count = 3;
                while (count != 0) {
                    StackPane stackPane = (StackPane) getNodeFromGridPane(gridPane, x.nextInt(12 - 10) + 10, y.nextInt(10));
                    ObservableList<Node> children = stackPane.getChildren();
                    int size = children.size();
                    if (size + 1 == 2);
                    else {
                        if (count == 3) {
                            lblEnemyUnit1.setText(controllerUnit.farmer.getName());
                            lblEnemyUnit1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit1.setAlignment(Pos.CENTER);
                            lblEnemyUnit1.setTextFill(Color.WHITE);
                            lblUnit1Count.setText(String.valueOf(x.nextInt(51-25)+25));
                            lblUnit1Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit1Count.setAlignment(Pos.CENTER);
                            lblUnit1Count.setTextFill(Color.WHITE);
                            lblUnit1Count.setTranslateY(20);
                            vbUnit1 = new VBox(lblEnemyUnit1, lblUnit1Count);
                            vbUnit1.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit1);
                            count--;
                            unitsOnBoard++;
                            enemyUnit1Exist = true;
                            enemyUnit1MaxHealth = mulHealth(controllerUnit.farmer.getHealth(), Integer.parseInt(lblUnit1Count.getText()));
                            enemyUnit1Health = enemyUnit1MaxHealth;

                        } else if (count == 2) {
                            lblEnemyUnit2.setText(controllerUnit.archer.getName());
                            lblEnemyUnit2.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit2.setAlignment(Pos.CENTER);
                            lblEnemyUnit2.setTextFill(Color.WHITE);
                            lblUnit2Count.setText(String.valueOf(x.nextInt(41-20)+20));
                            lblUnit2Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit2Count.setAlignment(Pos.CENTER);
                            lblUnit2Count.setTextFill(Color.WHITE);
                            lblUnit2Count.setTranslateY(20);
                            vbUnit2 = new VBox(lblEnemyUnit2, lblUnit2Count);
                            vbUnit2.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit2);
                            count--;
                            unitsOnBoard++;
                            enemyUnit2Exist = true;
                            enemyUnit2MaxHealth = mulHealth(controllerUnit.archer.getHealth(), Integer.parseInt(lblUnit2Count.getText()));
                            enemyUnit2Health = enemyUnit2MaxHealth;

                        } else if (count == 1) {
                            lblEnemyUnit3.setText(controllerUnit.griff.getName());
                            lblEnemyUnit3.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit3.setAlignment(Pos.CENTER);
                            lblEnemyUnit3.setTextFill(Color.WHITE);
                            lblUnit3Count.setText(String.valueOf(x.nextInt(21-10)+10));
                            lblUnit3Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit3Count.setAlignment(Pos.CENTER);
                            lblUnit3Count.setTextFill(Color.WHITE);
                            lblUnit3Count.setTranslateY(20);
                            vbUnit3 = new VBox(lblEnemyUnit3, lblUnit3Count);
                            vbUnit3.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit3);
                            count--;
                            unitsOnBoard++;
                            enemyUnit3Exist = true;
                            enemyUnit3MaxHealth = mulHealth(controllerUnit.griff.getHealth(), Integer.parseInt(lblUnit3Count.getText()));
                            enemyUnit3Health = enemyUnit3MaxHealth;
                        }
                    }
                }
            }
            else if(controllerDiff.isBMedium()) {
                count = 4;
                while (count != 0) {
                    StackPane stackPane = (StackPane) getNodeFromGridPane(gridPane, x.nextInt(12 - 10) + 10, y.nextInt(10));
                    ObservableList<Node> children = stackPane.getChildren();
                    int size = children.size();
                    if (size + 1 == 2);
                    else {
                        if (count == 4) {
                            lblEnemyUnit1.setText(controllerUnit.farmer.getName());
                            lblEnemyUnit1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit1.setAlignment(Pos.CENTER);
                            lblEnemyUnit1.setTextFill(Color.WHITE);
                            lblUnit1Count.setText(String.valueOf(x.nextInt(51-25)+25));
                            lblUnit1Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit1Count.setAlignment(Pos.CENTER);
                            lblUnit1Count.setTextFill(Color.WHITE);
                            lblUnit1Count.setTranslateY(20);
                            vbUnit1 = new VBox(lblEnemyUnit1, lblUnit1Count);
                            vbUnit1.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit1);
                            count--;
                            unitsOnBoard++;
                            enemyUnit1Exist = true;
                            enemyUnit1MaxHealth = mulHealth(controllerUnit.farmer.getHealth(), Integer.parseInt(lblUnit1Count.getText()));
                            enemyUnit1Health = enemyUnit1MaxHealth;

                        } else if (count == 3) {
                            lblEnemyUnit2.setText(controllerUnit.archer.getName());
                            lblEnemyUnit2.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit2.setAlignment(Pos.CENTER);
                            lblEnemyUnit2.setTextFill(Color.WHITE);
                            lblUnit2Count.setText(String.valueOf(x.nextInt(41-20)+20));
                            lblUnit2Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit2Count.setAlignment(Pos.CENTER);
                            lblUnit2Count.setTextFill(Color.WHITE);
                            lblUnit2Count.setTranslateY(20);
                            vbUnit2 = new VBox(lblEnemyUnit2, lblUnit2Count);
                            vbUnit2.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit2);
                            count--;
                            unitsOnBoard++;
                            enemyUnit2Exist = true;
                            enemyUnit2MaxHealth = mulHealth(controllerUnit.archer.getHealth(), Integer.parseInt(lblUnit2Count.getText()));
                            enemyUnit2Health = enemyUnit2MaxHealth;

                        } else if (count == 2) {
                            lblEnemyUnit3.setText(controllerUnit.griff.getName());
                            lblEnemyUnit3.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit3.setAlignment(Pos.CENTER);
                            lblEnemyUnit3.setTextFill(Color.WHITE);
                            lblUnit3Count.setText(String.valueOf(x.nextInt(21-10)+10));
                            lblUnit3Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit3Count.setAlignment(Pos.CENTER);
                            lblUnit3Count.setTextFill(Color.WHITE);
                            lblUnit3Count.setTranslateY(20);
                            vbUnit3 = new VBox(lblEnemyUnit3, lblUnit3Count);
                            vbUnit3.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit3);
                            count--;
                            unitsOnBoard++;
                            enemyUnit3Exist = true;
                            enemyUnit3MaxHealth = mulHealth(controllerUnit.griff.getHealth(), Integer.parseInt(lblUnit3Count.getText()));
                            enemyUnit3Health = enemyUnit3MaxHealth;

                        } else if (count == 1) {
                            lblEnemyUnit4.setText(controllerUnit.inquisitor.getName());
                            lblEnemyUnit4.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit4.setAlignment(Pos.CENTER);
                            lblEnemyUnit4.setTextFill(Color.WHITE);
                            lblUnit4Count.setText(String.valueOf(x.nextInt(11-5)+5));
                            lblUnit4Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit4Count.setAlignment(Pos.CENTER);
                            lblUnit4Count.setTextFill(Color.WHITE);
                            lblUnit4Count.setTranslateY(20);
                            vbUnit4 = new VBox(lblEnemyUnit4, lblUnit4Count);
                            vbUnit4.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit4);
                            count--;
                            unitsOnBoard++;
                            enemyUnit4Exist = true;
                            enemyUnit4MaxHealth = mulHealth(controllerUnit.inquisitor.getHealth(), Integer.parseInt(lblUnit4Count.getText()));
                            enemyUnit4Health = enemyUnit4MaxHealth;
                        }
                    }
                }
            }
            else if(controllerDiff.isBHard()) {
                count = 5;
                while (count != 0) {
                    StackPane stackPane = (StackPane) getNodeFromGridPane(gridPane, x.nextInt(12 - 10) + 10, y.nextInt(10));
                    ObservableList<Node> children = stackPane.getChildren();
                    int size = children.size();
                    if (size + 1 == 2);
                    else {
                        if (count == 5) {
                            lblEnemyUnit1.setText(controllerUnit.farmer.getName());
                            lblEnemyUnit1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit1.setAlignment(Pos.CENTER);
                            lblEnemyUnit1.setTextFill(Color.WHITE);
                            lblUnit1Count.setText(String.valueOf(x.nextInt(51-25)+25));
                            lblUnit1Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit1Count.setAlignment(Pos.CENTER);
                            lblUnit1Count.setTextFill(Color.WHITE);
                            lblUnit1Count.setTranslateY(20);
                            vbUnit1 = new VBox(lblEnemyUnit1, lblUnit1Count);
                            vbUnit1.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit1);
                            count--;
                            unitsOnBoard++;
                            enemyUnit1Exist = true;
                            enemyUnit1MaxHealth = mulHealth(controllerUnit.farmer.getHealth(), Integer.parseInt(lblUnit1Count.getText()));
                            enemyUnit1Health = enemyUnit1MaxHealth;


                        } else if (count == 4) {
                            lblEnemyUnit2.setText(controllerUnit.archer.getName());
                            lblEnemyUnit2.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit2.setAlignment(Pos.CENTER);
                            lblEnemyUnit2.setTextFill(Color.WHITE);
                            lblUnit2Count.setText(String.valueOf(x.nextInt(41-20)+20));
                            lblUnit2Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit2Count.setAlignment(Pos.CENTER);
                            lblUnit2Count.setTextFill(Color.WHITE);
                            lblUnit2Count.setTranslateY(20);
                            vbUnit2 = new VBox(lblEnemyUnit2, lblUnit2Count);
                            vbUnit2.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit2);
                            count--;
                            unitsOnBoard++;
                            enemyUnit2Exist = true;
                            enemyUnit2MaxHealth = mulHealth(controllerUnit.archer.getHealth(), Integer.parseInt(lblUnit2Count.getText()));
                            enemyUnit2Health = enemyUnit2MaxHealth;

                        } else if (count == 3) {
                            lblEnemyUnit3.setText(controllerUnit.griff.getName());
                            lblEnemyUnit3.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit3.setAlignment(Pos.CENTER);
                            lblEnemyUnit3.setTextFill(Color.WHITE);
                            lblUnit3Count.setText(String.valueOf(x.nextInt(21-10)+10));
                            lblUnit3Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit3Count.setAlignment(Pos.CENTER);
                            lblUnit3Count.setTextFill(Color.WHITE);
                            lblUnit3Count.setTranslateY(20);
                            vbUnit3 = new VBox(lblEnemyUnit3, lblUnit3Count);
                            vbUnit3.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit3);
                            count--;
                            unitsOnBoard++;
                            enemyUnit3Exist = true;
                            enemyUnit3MaxHealth = mulHealth(controllerUnit.griff.getHealth(), Integer.parseInt(lblUnit3Count.getText()));
                            enemyUnit3Health = enemyUnit3MaxHealth;

                        } else if (count == 2) {
                            lblEnemyUnit4.setText(controllerUnit.inquisitor.getName());
                            lblEnemyUnit4.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit4.setAlignment(Pos.CENTER);
                            lblEnemyUnit4.setTextFill(Color.WHITE);
                            lblUnit4Count.setText(String.valueOf(x.nextInt(11-5)+5));
                            lblUnit4Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit4Count.setAlignment(Pos.CENTER);
                            lblUnit4Count.setTextFill(Color.WHITE);
                            lblUnit4Count.setTranslateY(20);
                            vbUnit4 = new VBox(lblEnemyUnit4, lblUnit4Count);
                            vbUnit4.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit4);
                            count--;
                            unitsOnBoard++;
                            enemyUnit4Exist = true;
                            enemyUnit4MaxHealth = mulHealth(controllerUnit.inquisitor.getHealth(), Integer.parseInt(lblUnit4Count.getText()));
                            enemyUnit4Health = enemyUnit4MaxHealth;


                        } else if (count == 1) {
                            lblEnemyUnit5.setText(controllerUnit.angel.getName());
                            lblEnemyUnit5.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblEnemyUnit5.setAlignment(Pos.CENTER);
                            lblEnemyUnit5.setTextFill(Color.WHITE);
                            lblUnit5Count.setText(String.valueOf(x.nextInt(6-1)+1));
                            lblUnit5Count.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                            lblUnit5Count.setAlignment(Pos.CENTER);
                            lblUnit5Count.setTextFill(Color.WHITE);
                            lblUnit5Count.setTranslateY(20);
                            vbUnit5 = new VBox(lblEnemyUnit5, lblUnit5Count);
                            vbUnit5.setStyle("-fx-background-color: crimson;");
                            stackPane.getChildren().add(vbUnit5);
                            count--;
                            unitsOnBoard++;
                            enemyUnit5Exist = true;
                            enemyUnit5MaxHealth = mulHealth(controllerUnit.angel.getHealth(), Integer.parseInt(lblUnit5Count.getText()));
                            enemyUnit5Health = enemyUnit5MaxHealth;
                        }
                    }
                }
            }


            lblEnemyVirtues.setText("Az ellenfél hősének tulajdonságai:");
            lblEnemyVirtues.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            lblEnemyVirtues.setLayoutX(850);
            lblEnemyVirtues.setLayoutY(50);
            root.getChildren().add(lblEnemyVirtues);

            lblAttack.setText("Támadás:  "+enemyHero.getEnemyAttack());
            lblAttack.setStyle("-fx-font-size: 14px;");
            lblAttack.setLayoutX(850);
            lblAttack.setLayoutY(100);
            root.getChildren().add(lblAttack);

            lblDefence.setText("Védekezés:  "+enemyHero.getEnemyDefence());
            lblDefence.setStyle("-fx-font-size: 14px;");
            lblDefence.setLayoutX(850);
            lblDefence.setLayoutY(120);
            root.getChildren().add(lblDefence);

            lblSpellpower.setText("Varázserő:  "+enemyHero.getEnemySpellpower());
            lblSpellpower.setStyle("-fx-font-size: 14px;");
            lblSpellpower.setLayoutX(850);
            lblSpellpower.setLayoutY(140);
            root.getChildren().add(lblSpellpower);

            lblKnowledge.setText("Tudás:  "+enemyHero.getEnemyKnowledge());
            lblKnowledge.setStyle("-fx-font-size: 14px;");
            lblKnowledge.setLayoutX(850);
            lblKnowledge.setLayoutY(160);
            root.getChildren().add(lblKnowledge);

            lblMorale.setText("Morál:  "+enemyHero.getEnemyMorale());
            lblMorale.setStyle("-fx-font-size: 14px;");
            lblMorale.setLayoutX(850);
            lblMorale.setLayoutY(180);
            root.getChildren().add(lblMorale);

            lblLuck.setText("Szerencse:  "+enemyHero.getEnemyLuck());
            lblLuck.setStyle("-fx-font-size: 14px;");
            lblLuck.setLayoutX(850);
            lblLuck.setLayoutY(200);
            root.getChildren().add(lblLuck);


            switch (enemyHero.boughtSpells) {
                case 0 -> {
                    lblEnemySpells.setText("Az ellenfél hősének nincsenek varázslatai.");
                    lblEnemySpells.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                    lblEnemySpells.setLayoutX(850);
                    lblEnemySpells.setLayoutY(250);
                    root.getChildren().add(lblEnemySpells);
                }
                case 1 -> {
                    lblEnemySpells.setText("Az ellenfél hősének varázslata:");
                    lblEnemySpells.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                    lblEnemySpells.setLayoutX(850);
                    lblEnemySpells.setLayoutY(250);
                    root.getChildren().add(lblEnemySpells);
                    lblSpellOne.setText(controllerHero.one.getName());
                    lblSpellOne.setStyle("-fx-font-size: 14px;");
                    lblSpellOne.setLayoutX(850);
                    lblSpellOne.setLayoutY(300);
                    root.getChildren().add(lblSpellOne);
                }
                case 2 -> {
                    lblEnemySpells.setText("Az ellenfél hősének varázslatai:");
                    lblEnemySpells.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                    lblEnemySpells.setLayoutX(850);
                    lblEnemySpells.setLayoutY(250);
                    root.getChildren().add(lblEnemySpells);
                    lblSpellOne.setText(controllerHero.one.getName());
                    lblSpellOne.setStyle("-fx-font-size: 14px;");
                    lblSpellOne.setLayoutX(850);
                    lblSpellOne.setLayoutY(300);
                    root.getChildren().add(lblSpellOne);
                    lblSpellTwo.setText(controllerHero.two.getName());
                    lblSpellTwo.setStyle("-fx-font-size: 14px;");
                    lblSpellTwo.setLayoutX(850);
                    lblSpellTwo.setLayoutY(320);
                    root.getChildren().add(lblSpellTwo);
                }
                case 3 -> {
                    lblEnemySpells.setText("Az ellenfél hősének varázslatai:");
                    lblEnemySpells.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                    lblEnemySpells.setLayoutX(850);
                    lblEnemySpells.setLayoutY(250);
                    root.getChildren().add(lblEnemySpells);
                    lblSpellOne.setText(controllerHero.one.getName());
                    lblSpellOne.setStyle("-fx-font-size: 14px;");
                    lblSpellOne.setLayoutX(850);
                    lblSpellOne.setLayoutY(300);
                    root.getChildren().add(lblSpellOne);
                    lblSpellTwo.setText(controllerHero.two.getName());
                    lblSpellTwo.setStyle("-fx-font-size: 14px;");
                    lblSpellTwo.setLayoutX(850);
                    lblSpellTwo.setLayoutY(320);
                    root.getChildren().add(lblSpellTwo);
                    lblSpellThree.setText(controllerHero.three.getName());
                    lblSpellThree.setStyle("-fx-font-size: 14px;");
                    lblSpellThree.setLayoutX(850);
                    lblSpellThree.setLayoutY(340);
                    root.getChildren().add(lblSpellThree);
                }
            }
            root.getChildren().add(btnBegin);
            btnBegin.setLayoutX(900);
            btnBegin.setLayoutY(600);

            e.consume();
        });

        btnBegin.setOnAction((ActionEvent e) -> {
            root.getChildren().removeAll(lblEnemyVirtues, lblAttack, lblDefence, lblSpellpower, lblKnowledge, lblMorale, lblLuck,
                    lblEnemySpells, lblSpellOne, lblSpellTwo, lblSpellThree);

            vbFarmer1.setDisable(true);
            vbArcher1.setDisable(true);
            vbGriff1.setDisable(true);
            vbInquisitor1.setDisable(true);
            vbAngel1.setDisable(true);

            vbUnit1.setDisable(true);
            vbUnit2.setDisable(true);
            vbUnit3.setDisable(true);
            vbUnit4.setDisable(true);
            vbUnit5.setDisable(true);

            lblRound.setText(roundCount+". kör");
            lblRound.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            lblRound.setLayoutX(850);
            lblRound.setLayoutY(50);
            lblInit.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
            lblInit.setLayoutX(850);
            lblInit.setLayoutY(100);
            root.getChildren().addAll(lblRound, lblInit);

            int y = 120;
            boolean executed = false;
            boolean executed1 = false;
            boolean executed2 = false;
            boolean executed3 = false;
            boolean executed4 = false;
            boolean executed5 = false;
            boolean executed6 = false;
            boolean executed7 = false;
            boolean executed8 = false;
            boolean executed9 = false;

            Integer[] unitIni = new Integer[unitsOnBoard];

            for (int i = 0; i < unitIni.length; i++) {
                if(!executed && farmerExist){
                    unitIni[i] = controllerUnit.farmer.getInitiative()+controllerHero.getMorale();
                    executed = true;
                }else if(!executed1 && enemyUnit1Exist){
                    unitIni[i] = controllerUnit.farmer.getInitiative()+enemyHero.getEnemyMorale();
                    executed1 = true;
                }else if(!executed2 && archerExist){
                    unitIni[i] = controllerUnit.archer.getInitiative()+controllerHero.getMorale();
                    executed2 = true;
                }else if(!executed3 && enemyUnit2Exist){
                    unitIni[i] = controllerUnit.archer.getInitiative()+enemyHero.getEnemyMorale();
                    executed3 = true;
                }else if(!executed4 && griffExist){
                    unitIni[i] = controllerUnit.griff.getInitiative()+controllerHero.getMorale();
                    executed4 = true;
                }else if(!executed5 && enemyUnit3Exist){
                    unitIni[i] = controllerUnit.griff.getInitiative()+enemyHero.getEnemyMorale();
                    executed5 = true;
                }else if(!executed6 && inquisitorExist){
                    unitIni[i] = controllerUnit.inquisitor.getInitiative()+controllerHero.getMorale();
                    executed6 = true;
                }else if(!executed7 && enemyUnit4Exist){
                    unitIni[i] = controllerUnit.inquisitor.getInitiative()+enemyHero.getEnemyMorale();
                    executed7 = true;
                }else if(!executed8 && angelExist){
                    unitIni[i] = controllerUnit.angel.getInitiative()+controllerHero.getMorale();
                    executed8 = true;
                }else if(!executed9 && enemyUnit5Exist){
                    unitIni[i] = controllerUnit.angel.getInitiative()+enemyHero.getEnemyMorale();
                    executed9 = true;
                }

            }

            Arrays.sort(unitIni, Collections.reverseOrder());

            executed = false;
            executed1 = false;
            executed2 = false;
            executed3 = false;
            executed4 = false;
            executed5 = false;
            executed6 = false;
            executed7 = false;
            executed8 = false;
            executed9 = false;


            for (int i = 0; i < unitsOnBoard; i++) {
                if(unitIni[i] == controllerUnit.griff.getInitiative()+controllerHero.getMorale() && !executed && griffExist) {
                    rank1.setText("Kék griff");
                    units.add(rank1.getText());
                    rank1.setStyle("-fx-font-size: 14px;");
                    rank1.setLayoutX(850);
                    rank1.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank1);
                    executed = true;
                }
                else if(unitIni[i] == controllerUnit.angel.getInitiative()+controllerHero.getMorale() && !executed2 && angelExist) {
                    rank2 = new Label("Kék angyal");
                    units.add(rank2.getText());
                    rank2.setStyle("-fx-font-size: 14px;");
                    rank2.setLayoutX(850);
                    rank2.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank2);
                    executed2 = true;
                }
                else if(unitIni[i] == controllerUnit.inquisitor.getInitiative()+controllerHero.getMorale() && !executed4 && inquisitorExist) {
                    rank3 = new Label("Kék inkvizítor");
                    units.add(rank3.getText());
                    rank3.setStyle("-fx-font-size: 14px;");
                    rank3.setLayoutX(850);
                    rank3.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank3);
                    executed4 = true;
                }
                else if(unitIni[i] == controllerUnit.archer.getInitiative()+controllerHero.getMorale() && !executed6 && archerExist) {
                    rank4 = new Label("Kék íjász");
                    units.add(rank4.getText());
                    rank4.setStyle("-fx-font-size: 14px;");
                    rank4.setLayoutX(850);
                    rank4.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank4);
                    executed6 = true;
                }
                else if(unitIni[i] == controllerUnit.farmer.getInitiative()+controllerHero.getMorale() && !executed8 && farmerExist) {
                    rank5 = new Label("Kék földműves");
                    units.add(rank5.getText());
                    rank5.setStyle("-fx-font-size: 14px;");
                    rank5.setLayoutX(850);
                    rank5.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank5);
                    executed8 = true;
                }
                else if(unitIni[i] == controllerUnit.griff.getInitiative()+enemyHero.getEnemyMorale() && !executed1 && enemyUnit3Exist) {
                    rank6 = new Label("Piros griff");
                    units.add(rank6.getText());
                    rank6.setStyle("-fx-font-size: 14px;");
                    rank6.setLayoutX(850);
                    rank6.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank6);
                    executed1 = true;
                }
                else if(unitIni[i] == controllerUnit.angel.getInitiative()+enemyHero.getEnemyMorale() && !executed3 && enemyUnit5Exist) {
                    rank7 = new Label("Piros angyal");
                    units.add(rank7.getText());
                    rank7.setStyle("-fx-font-size: 14px;");
                    rank7.setLayoutX(850);
                    rank7.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank7);
                    executed3 = true;
                }
                else if(unitIni[i] == controllerUnit.inquisitor.getInitiative()+enemyHero.getEnemyMorale() && !executed5 && enemyUnit4Exist) {
                    rank8 = new Label("Piros inkvizítor");
                    units.add(rank8.getText());
                    rank8.setStyle("-fx-font-size: 14px;");
                    rank8.setLayoutX(850);
                    rank8.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank8);
                    executed5 = true;
                }
                else if(unitIni[i] == controllerUnit.archer.getInitiative()+enemyHero.getEnemyMorale() && !executed7 && enemyUnit2Exist) {
                    rank9 = new Label("Piros íjász");
                    units.add(rank9.getText());
                    rank9.setStyle("-fx-font-size: 14px;");
                    rank9.setLayoutX(850);
                    rank9.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank9);
                    executed7 = true;
                }
                else if(unitIni[i] == controllerUnit.farmer.getInitiative()+enemyHero.getEnemyMorale() && !executed9 && enemyUnit1Exist) {
                    rank10 = new Label("Piros földműves");
                    units.add(rank10.getText());
                    rank10.setStyle("-fx-font-size: 14px;");
                    rank10.setLayoutX(850);
                    rank10.setLayoutY(y);
                    y+=20;
                    root.getChildren().add(rank10);
                    executed9 = true;
                }
            }

            units.add("");
            units.add("");
            units.add("");
            units.add("");
            units.add("");
            units.add("");
            units.add("");
            units.add("");
            units.add("");
            units.add("");


            y+=20;
            lblHero.setText("Hős használata:");
            lblHero.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            lblHero.setLayoutX(850);
            lblHero.setLayoutY(y);
            root.getChildren().add(lblHero);
            y+=40;

            btnHeroAttack.setLayoutX(850);
            btnHeroAttack.setLayoutY(y);
            root.getChildren().add(btnHeroAttack);

            if(controllerHero.boughtSpellOne || controllerHero.boughtSpellTwo || controllerHero.boughtSpellThree) {
                btnHeroSpells.setLayoutX(950);
                btnHeroSpells.setLayoutY(y);
                root.getChildren().add(btnHeroSpells);
            }


            y+=40;
            manna = calcManna(controllerHero.getKnowledge());
            lblHeroManna.setText("Hős mannája: "+manna);
            lblHeroManna.setLayoutX(850);
            lblHeroManna.setLayoutY(y);
            lblHeroManna.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            root.getChildren().add(lblHeroManna);

            btnHeroAttack.setOnAction((ActionEvent e1) -> {
                heroActionDone = 1;

                vbUnit1.setDisable(false);
                vbUnit2.setDisable(false);
                vbUnit3.setDisable(false);
                vbUnit4.setDisable(false);
                vbUnit5.setDisable(false);
                btnHeroAttack.setDisable(true);
                btnHeroSpells.setDisable(true);
                setOnMouseEntered(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                setOnMouseEntered(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                setOnMouseEntered(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                setOnMouseEntered(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                setOnMouseEntered(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                setOnMouseExited(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                setOnMouseExited(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                setOnMouseExited(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                setOnMouseExited(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                setOnMouseExited(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                if(enemyUnit1Exist) {
                    enemyUnit1Health = setOnUsingHeroAttack(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10,
                            enemyUnit1Health, controllerUnit.farmer.getHealth());
                    if(enemyUnit1Health <= 0) {
                        enemyUnit1Exist = false;
                    }
                }

                if(enemyUnit2Exist) {
                    enemyUnit2Health = setOnUsingHeroAttack(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9,
                            enemyUnit2Health, controllerUnit.archer.getHealth());
                    if(enemyUnit2Health <= 0) {
                        enemyUnit2Exist = false;
                    }
                }

                if(enemyUnit3Exist) {
                    enemyUnit3Health = setOnUsingHeroAttack(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6,
                            enemyUnit3Health, controllerUnit.griff.getHealth());
                    if(enemyUnit3Health <= 0) {
                        enemyUnit3Exist = false;
                    }
                }

                if(enemyUnit4Exist) {
                    enemyUnit4Health = setOnUsingHeroAttack(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8,
                            enemyUnit4Health, controllerUnit.inquisitor.getHealth());
                    if(enemyUnit4Health <= 0) {
                        enemyUnit4Exist = false;
                    }
                }
                if(enemyUnit5Exist) {
                    enemyUnit5Health = setOnUsingHeroAttack(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7,
                            enemyUnit5Health, controllerUnit.angel.getHealth());
                    if(enemyUnit5Health <= 0) {
                        enemyUnit5Exist = false;
                    }
                }

                e.consume();
            });


            int y1 = y;
            btnHeroSpells.setOnAction((ActionEvent e2) -> {
                if(manna == 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs több mannád a varázsláshoz!");
                    alert.showAndWait();
                }
                else if(manna <= 4) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég mannád a varázsláshoz!");
                    alert.showAndWait();
                }
                else {
                    btnHeroAttack.setDisable(true);
                    btnHeroSpells.setDisable(true);
                    int y2 = y1 + 60;
                    int x = 850;
                    btnHeroAttack.setDisable(true);
                    btnHeroSpells.setDisable(true);
                    if (controllerHero.boughtSpellOne) {
                        btnSpellOne.setLayoutX(x);
                        btnSpellOne.setLayoutY(y2);
                        btnSpellOne.setPrefWidth(110);
                        x += btnSpellOne.getPrefWidth() + 20;
                        root.getChildren().add(btnSpellOne);
                    }
                    if (controllerHero.boughtSpellTwo) {
                        btnSpellTwo.setLayoutX(x);
                        btnSpellTwo.setLayoutY(y2);
                        btnSpellTwo.setPrefWidth(110);
                        x += btnSpellTwo.getPrefWidth() + 20;
                        root.getChildren().add(btnSpellTwo);
                    }
                    if (controllerHero.boughtSpellThree) {
                        btnSpellThree.setLayoutX(x);
                        btnSpellThree.setLayoutY(y2);
                        btnSpellThree.setPrefWidth(110);
                        root.getChildren().add(btnSpellThree);
                    }
                    e.consume();
                }
            });

            btnSpellOne.setOnAction((ActionEvent e3) -> {
                if(calcNewManna(manna, controllerHero.one.getManaCost()) < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég mannád!");
                    alert.showAndWait();
                }
                else {
                    heroActionDone = 1;

                    vbUnit1.setDisable(false);
                    vbUnit2.setDisable(false);
                    vbUnit3.setDisable(false);
                    vbUnit4.setDisable(false);
                    vbUnit5.setDisable(false);
                    root.getChildren().remove(btnSpellOne);
                    root.getChildren().remove(btnSpellTwo);
                    root.getChildren().remove(btnSpellThree);
                    newManna = calcNewManna(manna, controllerHero.one.getManaCost());
                    manna = newManna;
                    lblHeroManna.setText("Hős mannája: "+manna);

                    setOnMouseEntered(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                    setOnMouseEntered(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                    setOnMouseEntered(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                    setOnMouseEntered(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                    setOnMouseEntered(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                    setOnMouseExited(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                    setOnMouseExited(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                    setOnMouseExited(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                    setOnMouseExited(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                    setOnMouseExited(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                    if(enemyUnit1Exist) {
                        enemyUnit1Health = setOnUsingSpellOne(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                controllerUnit.farmer.getHealth());
                        if(enemyUnit1Health <= 0) {
                            enemyUnit1Exist = false;
                        }
                    }
                    if(enemyUnit2Exist) {
                        enemyUnit2Health = setOnUsingSpellOne(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                controllerUnit.archer.getHealth());
                        if(enemyUnit2Health <= 0) {
                            enemyUnit2Exist = false;
                        }
                    }
                    if(enemyUnit3Exist) {
                        enemyUnit3Health = setOnUsingSpellOne(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                controllerUnit.griff.getHealth());
                        if(enemyUnit3Health <= 0) {
                            enemyUnit3Exist = false;
                        }
                    }
                    if(enemyUnit4Exist) {
                        enemyUnit4Health = setOnUsingSpellOne(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                controllerUnit.inquisitor.getHealth());
                        if(enemyUnit4Health <= 0) {
                            enemyUnit4Exist = false;
                        }
                    }
                    if(enemyUnit5Exist) {
                        enemyUnit5Health = setOnUsingSpellOne(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                controllerUnit.angel.getHealth());
                        if(enemyUnit5Health <= 0) {
                            enemyUnit5Exist = false;
                        }
                    }
                }
                e.consume();
            });

            btnSpellTwo.setOnAction((ActionEvent e3) -> {
                if(calcNewManna(manna, controllerHero.two.getManaCost()) < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég mannád!");
                    alert.showAndWait();
                }
                else {
                    heroActionDone = 1;

                    vbUnit1.setDisable(false);
                    vbUnit2.setDisable(false);
                    vbUnit3.setDisable(false);
                    vbUnit4.setDisable(false);
                    vbUnit5.setDisable(false);
                    root.getChildren().remove(btnSpellOne);
                    root.getChildren().remove(btnSpellTwo);
                    root.getChildren().remove(btnSpellThree);
                    newManna = calcNewManna(manna, controllerHero.two.getManaCost());
                    manna = newManna;
                    lblHeroManna.setText("Hős mannája: "+manna);

                    setOnMouseEntered(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                    setOnMouseEntered(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                    setOnMouseEntered(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                    setOnMouseEntered(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                    setOnMouseEntered(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                    setOnMouseExited(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                    setOnMouseExited(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                    setOnMouseExited(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                    setOnMouseExited(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                    setOnMouseExited(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                    if(enemyUnit1Exist) {
                        enemyUnit1Health = setOnUsingSpellTwo(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                controllerUnit.farmer.getHealth());
                        if(enemyUnit1Health <= 0) {
                            enemyUnit1Exist = false;
                        }
                    }
                    if(enemyUnit2Exist) {
                        enemyUnit2Health = setOnUsingSpellTwo(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                controllerUnit.archer.getHealth());
                        if(enemyUnit2Health <= 0) {
                            enemyUnit2Exist = false;
                        }
                    }
                    if(enemyUnit3Exist) {
                        enemyUnit3Health = setOnUsingSpellTwo(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                controllerUnit.griff.getHealth());
                        if(enemyUnit3Health <= 0) {
                            enemyUnit3Exist = false;
                        }
                    }
                    if(enemyUnit4Exist) {
                        enemyUnit4Health = setOnUsingSpellTwo(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                controllerUnit.inquisitor.getHealth());
                        if(enemyUnit4Health <= 0) {
                            enemyUnit4Exist = false;
                        }
                    }
                    if(enemyUnit5Exist) {
                        enemyUnit5Health = setOnUsingSpellTwo(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                controllerUnit.angel.getHealth());
                        if(enemyUnit5Health <= 0) {
                            enemyUnit5Exist = false;
                        }
                    }
                }
                e.consume();
            });

            btnSpellThree.setOnAction((ActionEvent e3) -> {
                if(calcNewManna(manna, controllerHero.three.getManaCost()) < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég mannád!");
                    alert.showAndWait();
                }
                else {
                    heroActionDone = 1;

                    vbFarmer1.setDisable(false);
                    vbArcher1.setDisable(false);
                    vbGriff1.setDisable(false);
                    vbInquisitor1.setDisable(false);
                    vbAngel1.setDisable(false);
                    root.getChildren().remove(btnSpellOne);
                    root.getChildren().remove(btnSpellTwo);
                    root.getChildren().remove(btnSpellThree);

                    setOnMouseEntered(vbFarmer1, lblFarmer1, lblFarmerC1);
                    setOnMouseEntered(vbArcher1, lblArcher1, lblArcherC1);
                    setOnMouseEntered(vbGriff1, lblGriff1, lblGriffC1);
                    setOnMouseEntered(vbInquisitor1, lblInquisitor1, lblInquisitorC1);
                    setOnMouseEntered(vbAngel1, lblAngel1, lblAngelC1);

                    setOnMouseExitedV2(vbFarmer1, lblFarmer1, lblFarmerC1);
                    setOnMouseExitedV2(vbArcher1, lblArcher1, lblArcherC1);
                    setOnMouseExitedV2(vbGriff1, lblGriff1, lblGriffC1);
                    setOnMouseExitedV2(vbInquisitor1, lblInquisitor1, lblInquisitorC1);
                    setOnMouseExitedV2(vbAngel1, lblAngel1, lblAngelC1);

                    if(farmerExist) {
                        farmerHealth = setOnUsingSpellThree(vbFarmer1, lblFarmerC1, farmerMaxCount, farmerHealth,
                                farmerMaxHealth, controllerUnit.farmer.getHealth());
                    }

                    if(archerExist) {
                        archerHealth = setOnUsingSpellThree(vbArcher1, lblArcherC1, archerMaxCount, archerHealth,
                                archerMaxHealth, controllerUnit.archer.getHealth());
                    }

                    if(griffExist) {
                        griffHealth = setOnUsingSpellThree(vbGriff1, lblGriffC1, griffMaxCount, griffHealth,
                                griffMaxHealth, controllerUnit.griff.getHealth());
                    }

                    if(inquisitorExist) {
                        inquisitorHealth = setOnUsingSpellThree(vbInquisitor1, lblInquisitorC1, inquisitorMaxCount, inquisitorHealth,
                                inquisitorMaxHealth, controllerUnit.inquisitor.getHealth());
                    }

                    if(angelExist) {
                        angelHealth = setOnUsingSpellThree(vbAngel1, lblAngelC1, angelMaxCount, angelHealth,
                                angelMaxHealth, controllerUnit.angel.getHealth());
                    }

                    newManna = calcNewManna(manna, controllerHero.three.getManaCost());
                    manna = newManna;
                    lblHeroManna.setText("Hős mannája: "+manna);
                }
                e.consume();
            });
            root.getChildren().remove(btnBegin);
            root.getChildren().add(btnNextUnit);

            y+=120;

            lblActual.setLayoutX(850);
            lblActual.setLayoutY(y);
            lblActual.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            lblActual.setText(units.get(0)+" használata:");
            root.getChildren().add(lblActual);
            String actual = units.get(0);

            if(actual.contains("Kék")) {
                btnUnitWait.setDisable(false);
                btnUnitAttack.setDisable(false);
                btnHeroAttack.setDisable(false);
                btnHeroSpells.setDisable(false);
                btnNextUnit.setDisable(true);
                btnUnitAttack.setOnAction((ActionEvent e1) -> {
                    btnUnitWait.setDisable(true);
                    btnUnitAttack.setDisable(true);
                    btnHeroAttack.setDisable(true);
                    btnHeroSpells.setDisable(true);

                    vbUnit1.setDisable(false);
                    vbUnit2.setDisable(false);
                    vbUnit3.setDisable(false);
                    vbUnit4.setDisable(false);
                    vbUnit5.setDisable(false);

                    setOnMouseEntered(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                    setOnMouseEntered(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                    setOnMouseEntered(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                    setOnMouseEntered(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                    setOnMouseEntered(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                    setOnMouseExited(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                    setOnMouseExited(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                    setOnMouseExited(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                    setOnMouseExited(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                    setOnMouseExited(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                    switch(actual) {
                        case "Kék földműves" -> {
                            int damage = calcDamage(controllerUnit.farmer.getMinDamage(), controllerUnit.farmer.getMaxDamage(),
                                    Integer.parseInt(lblFarmerC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                            if(enemyUnit1Exist) {
                                enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                        controllerUnit.farmer.getHealth(), damage);
                                if(enemyUnit1Health <= 0) {
                                    enemyUnit1Exist = false;
                                }
                            }
                            if(enemyUnit2Exist) {
                                enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                        controllerUnit.archer.getHealth(), damage);
                                if(enemyUnit2Health <= 0) {
                                    enemyUnit2Exist = false;
                                }
                            }
                            if(enemyUnit3Exist) {
                                enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                        controllerUnit.griff.getHealth(), damage);
                                if(enemyUnit3Health <= 0) {
                                    enemyUnit3Exist = false;
                                }
                            }
                            if(enemyUnit4Exist) {
                                enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                        controllerUnit.inquisitor.getHealth(), damage);
                                if(enemyUnit4Health <= 0) {
                                    enemyUnit4Exist = false;
                                }
                            }
                            if(enemyUnit5Exist) {
                                enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                        controllerUnit.angel.getHealth(), damage);
                                if(enemyUnit5Health <= 0) {
                                    enemyUnit5Exist = false;
                                }
                            }
                        }
                        case "Kék íjász" -> {
                            int damage = calcDamage(controllerUnit.archer.getMinDamage(), controllerUnit.archer.getMaxDamage(),
                                    Integer.parseInt(lblArcherC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                            if(enemyUnit1Exist) {
                                enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                        controllerUnit.farmer.getHealth(), damage);
                                if(enemyUnit1Health <= 0) {
                                    enemyUnit1Exist = false;
                                }

                            }
                            if(enemyUnit2Exist) {
                                enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                        controllerUnit.archer.getHealth(), damage);
                                if(enemyUnit2Health <= 0) {
                                    enemyUnit2Exist = false;
                                }
                            }
                            if(enemyUnit3Exist) {
                                enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                        controllerUnit.griff.getHealth(), damage);
                                if(enemyUnit3Health <= 0) {
                                    enemyUnit3Exist = false;
                                }
                            }
                            if(enemyUnit4Exist) {
                                enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                        controllerUnit.inquisitor.getHealth(), damage);
                                if(enemyUnit4Health <= 0) {
                                    enemyUnit4Exist = false;
                                }
                            }
                            if(enemyUnit5Exist) {
                                enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                        controllerUnit.angel.getHealth(), damage);
                                if(enemyUnit5Health <= 0) {
                                    enemyUnit5Exist = false;
                                }
                            }
                        }
                        case "Kék griff" -> {
                            int damage = calcDamage(controllerUnit.griff.getMinDamage(), controllerUnit.griff.getMaxDamage(),
                                    Integer.parseInt(lblGriffC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                            if(enemyUnit1Exist) {
                                enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                        controllerUnit.farmer.getHealth(), damage);
                                if(enemyUnit1Health <= 0) {
                                    enemyUnit1Exist = false;
                                }
                            }
                            if(enemyUnit2Exist) {
                                enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                        controllerUnit.archer.getHealth(), damage);
                                if(enemyUnit2Health <= 0) {
                                    enemyUnit2Exist = false;
                                }
                            }
                            if(enemyUnit3Exist) {
                                enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                        controllerUnit.griff.getHealth(), damage);
                                if(enemyUnit3Health <= 0) {
                                    enemyUnit3Exist = false;
                                }
                            }
                            if(enemyUnit4Exist) {
                                enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                        controllerUnit.inquisitor.getHealth(), damage);
                                if(enemyUnit4Health <= 0) {
                                    enemyUnit4Exist = false;
                                }
                            }
                            if(enemyUnit5Exist) {
                                enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                        controllerUnit.angel.getHealth(), damage);
                                if(enemyUnit5Health <= 0) {
                                    enemyUnit5Exist = false;
                                }
                            }
                        }
                        case "Kék inkvizítor" -> {
                            int damage = calcDamage(controllerUnit.inquisitor.getMinDamage(), controllerUnit.inquisitor.getMaxDamage(),
                                    Integer.parseInt(lblInquisitorC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                            if(enemyUnit1Exist) {
                                enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                        controllerUnit.farmer.getHealth(), damage);
                                if(enemyUnit1Health <= 0) {
                                    enemyUnit1Exist = false;
                                }
                            }
                            if(enemyUnit2Exist) {
                                enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                        controllerUnit.archer.getHealth(), damage);
                                if(enemyUnit2Health <= 0) {
                                    enemyUnit2Exist = false;
                                }
                            }
                            if(enemyUnit3Exist) {
                                enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                        controllerUnit.griff.getHealth(), damage);
                                if(enemyUnit3Health <= 0) {
                                    enemyUnit3Exist = false;
                                }
                            }
                            if(enemyUnit4Exist) {
                                enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                        controllerUnit.inquisitor.getHealth(), damage);
                                if(enemyUnit4Health <= 0) {
                                    enemyUnit4Exist = false;
                                }
                            }
                            if(enemyUnit5Exist) {
                                enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                        controllerUnit.angel.getHealth(), damage);
                                if(enemyUnit5Health <= 0) {
                                    enemyUnit5Exist = false;
                                }
                            }
                        }
                        case "Kék angyal" -> {
                            int damage = calcDamage(controllerUnit.angel.getMinDamage(), controllerUnit.angel.getMaxDamage(),
                                    Integer.parseInt(lblAngelC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                            if(enemyUnit1Exist) {
                                enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                        controllerUnit.farmer.getHealth(), damage);
                                if(enemyUnit1Health <= 0) {
                                    enemyUnit1Exist = false;
                                }
                            }
                            if(enemyUnit2Exist) {
                                enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                        controllerUnit.archer.getHealth(), damage);
                                if(enemyUnit2Health <= 0) {
                                    enemyUnit2Exist = false;
                                }
                            }
                            if(enemyUnit3Exist) {
                                enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                        controllerUnit.griff.getHealth(), damage);
                                if(enemyUnit3Health <= 0) {
                                    enemyUnit3Exist = false;
                                }
                            }
                            if(enemyUnit4Exist) {
                                enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                        controllerUnit.inquisitor.getHealth(), damage);
                                if(enemyUnit4Health <= 0) {
                                    enemyUnit4Exist = false;
                                }
                            }
                            if(enemyUnit5Exist) {
                                enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                        controllerUnit.angel.getHealth(), damage);
                                if(enemyUnit5Health <= 0) {
                                    enemyUnit5Exist = false;
                                }
                            }
                        }
                    }
                    e1.consume();
                });

            }
            else {
                btnUnitWait.setDisable(true);
                btnUnitAttack.setDisable(true);
                btnHeroSpells.setDisable(true);
                btnHeroAttack.setDisable(true);
                btnNextUnit.setDisable(false);
            }
            y+=60;

            btnUnitWait.setLayoutX(850);
            btnUnitWait.setLayoutY(y);
            btnUnitAttack.setLayoutX(945);
            btnUnitAttack.setLayoutY(y);

            root.getChildren().addAll(btnUnitWait, btnUnitAttack);


            AtomicInteger i = new AtomicInteger(1);
                btnNextUnit.setOnAction((ActionEvent e1) -> {
                    if(units.get(i.get()).equals("")) {
                        heroActionDone = 0;
                        unitActionDone = 0;
                        roundCount++;
                        if(roundCount > 5) {
                            if(!farmerExist && !archerExist && !griffExist && !inquisitorExist && !angelExist) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Game Over");
                                alert.setHeaderText("A játék véget ért, a piros csapat nyert!");
                                alert.showAndWait();
                            }
                            else if(!enemyUnit1Exist && !enemyUnit2Exist && !enemyUnit3Exist && !enemyUnit4Exist && !enemyUnit5Exist) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Game Over");
                                alert.setHeaderText("A játék véget ért, a kék csapat nyert!");
                                alert.showAndWait();
                            }
                            else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Game Over");
                                alert.setHeaderText("A játék véget ért, mindkét csapatnak maradtak egységei, az eredmény döntetlen.");
                                alert.showAndWait();
                            }
                            stage.close();
                        }
                        lblRound.setText(roundCount+". kör");
                        i.set(0);
                        lblActual.setText(units.get(i.get())+" használata:");
                        String actual1 = units.get(i.get());
                        if(actual1.contains("Kék")) {
                            btnUnitWait.setDisable(false);
                            btnUnitAttack.setDisable(false);
                            btnHeroAttack.setDisable(false);
                            btnHeroSpells.setDisable(false);
                            btnNextUnit.setDisable(true);

                            btnUnitAttack.setOnAction((ActionEvent e2) -> {
                                btnUnitWait.setDisable(true);
                                btnUnitAttack.setDisable(true);
                                btnHeroAttack.setDisable(true);
                                btnHeroSpells.setDisable(true);

                                vbUnit1.setDisable(false);
                                vbUnit2.setDisable(false);
                                vbUnit3.setDisable(false);
                                vbUnit4.setDisable(false);
                                vbUnit5.setDisable(false);

                                setOnMouseEntered(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                                setOnMouseEntered(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                                setOnMouseEntered(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                                setOnMouseEntered(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                                setOnMouseEntered(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                                setOnMouseExited(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                                setOnMouseExited(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                                setOnMouseExited(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                                setOnMouseExited(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                                setOnMouseExited(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                                switch(actual1) {
                                    case "Kék földműves" -> {
                                        int damage = calcDamage(controllerUnit.farmer.getMinDamage(), controllerUnit.farmer.getMaxDamage(),
                                                Integer.parseInt(lblFarmerC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }

                                    }
                                    case "Kék íjász" -> {
                                        int damage = calcDamage(controllerUnit.archer.getMinDamage(), controllerUnit.archer.getMaxDamage(),
                                                Integer.parseInt(lblArcherC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }

                                    }
                                    case "Kék griff" -> {
                                        int damage = calcDamage(controllerUnit.griff.getMinDamage(), controllerUnit.griff.getMaxDamage(),
                                                Integer.parseInt(lblGriffC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }

                                    }
                                    case "Kék inkvizítor" -> {
                                        int damage = calcDamage(controllerUnit.inquisitor.getMinDamage(), controllerUnit.inquisitor.getMaxDamage(),
                                                Integer.parseInt(lblInquisitorC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }

                                    }
                                    case "Kék angyal" -> {
                                        int damage = calcDamage(controllerUnit.angel.getMinDamage(), controllerUnit.angel.getMaxDamage(),
                                                Integer.parseInt(lblAngelC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }

                                    }
                                }
                                e2.consume();
                            });
                        }
                        else {
                            btnUnitWait.setDisable(true);
                            btnUnitAttack.setDisable(true);
                            btnHeroSpells.setDisable(true);
                            btnHeroAttack.setDisable(true);
                            btnNextUnit.setDisable(false);
                        }
                        i.getAndIncrement();
                    }
                    else {
                        lblActual.setText(units.get(i.get())+" használata:");
                        String actual1 = units.get(i.get());
                        if(actual1.contains("Kék")) {
                            btnUnitWait.setDisable(false);
                            btnUnitAttack.setDisable(false);
                            if(heroActionDone == 1) {
                                btnHeroSpells.setDisable(true);
                                btnHeroAttack.setDisable(true);
                            }
                            else {
                                btnHeroSpells.setDisable(false);
                                btnHeroAttack.setDisable(false);
                            }
                            btnNextUnit.setDisable(true);

                            btnUnitAttack.setOnAction((ActionEvent e2) -> {
                                btnUnitWait.setDisable(true);
                                btnUnitAttack.setDisable(true);
                                btnHeroAttack.setDisable(true);
                                btnHeroSpells.setDisable(true);

                                vbUnit1.setDisable(false);
                                vbUnit2.setDisable(false);
                                vbUnit3.setDisable(false);
                                vbUnit4.setDisable(false);
                                vbUnit5.setDisable(false);

                                setOnMouseEntered(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                                setOnMouseEntered(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                                setOnMouseEntered(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                                setOnMouseEntered(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                                setOnMouseEntered(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                                setOnMouseExited(vbUnit1, lblEnemyUnit1, lblUnit1Count);
                                setOnMouseExited(vbUnit2, lblEnemyUnit2, lblUnit2Count);
                                setOnMouseExited(vbUnit3, lblEnemyUnit3, lblUnit3Count);
                                setOnMouseExited(vbUnit4, lblEnemyUnit4, lblUnit4Count);
                                setOnMouseExited(vbUnit5, lblEnemyUnit5, lblUnit5Count);

                                switch(actual1) {
                                    case "Kék földműves" -> {
                                        int damage = calcDamage(controllerUnit.farmer.getMinDamage(), controllerUnit.farmer.getMaxDamage(),
                                                Integer.parseInt(lblFarmerC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }
                                    }
                                    case "Kék íjász" -> {
                                        int damage = calcDamage(controllerUnit.archer.getMinDamage(), controllerUnit.archer.getMaxDamage(),
                                                Integer.parseInt(lblArcherC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }
                                    }
                                    case "Kék griff" -> {
                                        int damage = calcDamage(controllerUnit.griff.getMinDamage(), controllerUnit.griff.getMaxDamage(),
                                                Integer.parseInt(lblGriffC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }
                                    }
                                    case "Kék inkvizítor" -> {
                                        int damage = calcDamage(controllerUnit.inquisitor.getMinDamage(), controllerUnit.inquisitor.getMaxDamage(),
                                                Integer.parseInt(lblInquisitorC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }
                                    }
                                    case "Kék angyal" -> {
                                        int damage = calcDamage(controllerUnit.angel.getMinDamage(), controllerUnit.angel.getMaxDamage(),
                                                Integer.parseInt(lblAngelC1.getText()), controllerHero.getAttack(), enemyHero.getEnemyDefence());
                                        if(enemyUnit1Exist) {
                                            enemyUnit1Health = enemyUnitHit(vbUnit1, lblUnit1Count, lblEnemyUnit1, rank10, enemyUnit1Health,
                                                    controllerUnit.farmer.getHealth(), damage);
                                            if(enemyUnit1Health <= 0) {
                                                enemyUnit1Exist = false;
                                            }
                                        }
                                        if(enemyUnit2Exist) {
                                            enemyUnit2Health = enemyUnitHit(vbUnit2, lblUnit2Count, lblEnemyUnit2, rank9, enemyUnit2Health,
                                                    controllerUnit.archer.getHealth(), damage);
                                            if(enemyUnit2Health <= 0) {
                                                enemyUnit2Exist = false;
                                            }
                                        }
                                        if(enemyUnit3Exist) {
                                            enemyUnit3Health = enemyUnitHit(vbUnit3, lblUnit3Count, lblEnemyUnit3, rank6, enemyUnit3Health,
                                                    controllerUnit.griff.getHealth(), damage);
                                            if(enemyUnit3Health <= 0) {
                                                enemyUnit3Exist = false;
                                            }
                                        }
                                        if(enemyUnit4Exist) {
                                            enemyUnit4Health = enemyUnitHit(vbUnit4, lblUnit4Count, lblEnemyUnit4, rank8, enemyUnit4Health,
                                                    controllerUnit.inquisitor.getHealth(), damage);
                                            if(enemyUnit4Health <= 0) {
                                                enemyUnit4Exist = false;
                                            }
                                        }
                                        if(enemyUnit5Exist) {
                                            enemyUnit5Health = enemyUnitHit(vbUnit5, lblUnit5Count, lblEnemyUnit5, rank7, enemyUnit5Health,
                                                    controllerUnit.angel.getHealth(), damage);
                                            if(enemyUnit5Health <= 0) {
                                                enemyUnit5Exist = false;
                                            }
                                        }
                                    }
                                }
                                e2.consume();
                            });
                        }
                        else {
                            btnUnitWait.setDisable(true);
                            btnUnitAttack.setDisable(true);
                            btnHeroSpells.setDisable(true);
                            btnHeroAttack.setDisable(true);
                            btnNextUnit.setDisable(false);
                        }
                        i.getAndIncrement();
                        e1.consume();
                    }
                });

            y+=60;
            btnNextUnit.setLayoutX(850);
            btnNextUnit.setLayoutY(y);

            btnUnitWait.setOnAction((ActionEvent e1) -> {
                btnUnitWait.setDisable(true);
                btnUnitAttack.setDisable(true);
                btnHeroAttack.setDisable(true);
                btnHeroSpells.setDisable(true);
                unitActionDone = 1;
                btnNextUnit.setDisable(false);
            });


        });



        if(farmerMaxCount > 0) {
            lblFarmer.setText(controllerUnit.farmer.getName());
            lblFarmer.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblFarmer.setAlignment(Pos.CENTER);
            lblFarmerC.setText(String.valueOf(farmerMaxCount));
            lblFarmerC.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblFarmerC.setAlignment(Pos.CENTER);
            lblFarmerC.setTranslateY(20);
            vbFarmer = new VBox(lblFarmer, lblFarmerC);
            root.getChildren().add(vbFarmer);
            vbFarmer.setLayoutX(900);
            vbFarmer.setLayoutY(50);
            vbFarmer.setPrefSize(60, 60);
            vbFarmer.setStyle("-fx-border-color: black; -fx-background-color: aqua;");
            setOnDragDetected(vbFarmer, lblFarmer);
            setOnDragDone(vbFarmer, lblFarmer, lblFarmerC);
            count++;
            farmerExist = true;
        }

        if(archerMaxCount > 0) {
            lblArcher.setText(controllerUnit.archer.getName());
            lblArcher.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblArcher.setAlignment(Pos.CENTER);
            lblArcherC.setText(String.valueOf(archerMaxCount));
            lblArcherC.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblArcherC.setAlignment(Pos.CENTER);
            lblArcherC.setTranslateY(20);
            vbArcher = new VBox(lblArcher, lblArcherC);
            root.getChildren().add(vbArcher);
            vbArcher.setLayoutX(900);

            if(farmerExist) {
                vbArcher.setLayoutY(150);
            } else vbArcher.setLayoutY(50);

            vbArcher.setPrefSize(60, 60);
            vbArcher.setStyle("-fx-border-color: black; -fx-background-color: aqua;");
            setOnDragDetected(vbArcher, lblArcher);
            setOnDragDone(vbArcher, lblArcher, lblArcherC);
            count++;
            archerExist = true;

        }

        if(griffMaxCount > 0) {
            lblGriff.setText(controllerUnit.griff.getName());
            lblGriff.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblGriff.setAlignment(Pos.CENTER);
            lblGriffC.setText(String.valueOf(griffMaxCount));
            lblGriffC.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblGriffC.setAlignment(Pos.CENTER);
            lblGriffC.setTranslateY(20);
            vbGriff = new VBox(lblGriff, lblGriffC);
            root.getChildren().add(vbGriff);
            vbGriff.setLayoutX(900);

            if(archerExist && farmerExist) {
                vbGriff.setLayoutY(250);
            } else if(archerExist || farmerExist) {
                vbGriff.setLayoutY(150);
            } else vbGriff.setLayoutY(50);

            vbGriff.setPrefSize(60, 60);
            vbGriff.setStyle("-fx-border-color: black; -fx-background-color: aqua;");
            setOnDragDetected(vbGriff, lblGriff);
            setOnDragDone(vbGriff, lblGriff, lblGriffC);
            count++;
            griffExist = true;

        }

        if(inquisitorMaxCount > 0) {
            lblInquisitor.setText(controllerUnit.inquisitor.getName());
            lblInquisitor.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblInquisitor.setAlignment(Pos.CENTER);
            lblInquisitorC.setText(String.valueOf(inquisitorMaxCount));
            lblInquisitorC.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblInquisitorC.setAlignment(Pos.CENTER);
            lblInquisitorC.setTranslateY(20);
            vbInquisitor = new VBox(lblInquisitor, lblInquisitorC);
            root.getChildren().add(vbInquisitor);
            vbInquisitor.setLayoutX(900);

            if(griffExist && archerExist && farmerExist) {
                vbInquisitor.setLayoutY(350);
            } else if((griffExist && farmerExist) || (griffExist && archerExist) || (farmerExist && archerExist)) {
                vbInquisitor.setLayoutY(250);
            } else if (griffExist || archerExist || farmerExist) {
                vbInquisitor.setLayoutY(150);
            } else vbInquisitor.setLayoutY(50);

            vbInquisitor.setPrefSize(60, 60);
            vbInquisitor.setStyle("-fx-border-color: black; -fx-background-color: aqua;");
            setOnDragDetected(vbInquisitor, lblInquisitor);
            setOnDragDone(vbInquisitor, lblInquisitor, lblInquisitorC);
            count++;
            inquisitorExist = true;

        }

        if(angelMaxCount > 0) {
            lblAngel.setText(controllerUnit.angel.getName());
            lblAngel.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblAngel.setAlignment(Pos.CENTER);
            lblAngelC.setText(String.valueOf(angelMaxCount));
            lblAngelC.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            lblAngelC.setAlignment(Pos.CENTER);
            lblAngelC.setTranslateY(20);
            vbAngel = new VBox(lblAngel, lblAngelC);
            root.getChildren().add(vbAngel);
            vbAngel.setLayoutX(900);

            if(inquisitorExist && griffExist && archerExist && farmerExist) {
                vbAngel.setLayoutY(450);
            } else if((inquisitorExist && griffExist && archerExist) || (inquisitorExist && griffExist && farmerExist)
            || (inquisitorExist && archerExist && farmerExist) || (griffExist && archerExist && farmerExist)) {
                vbAngel.setLayoutY(350);
            } else if ((inquisitorExist && griffExist) || (inquisitorExist && archerExist) || (inquisitorExist && farmerExist)
            || (griffExist && archerExist) || (griffExist && farmerExist) || (archerExist && farmerExist)) {
                vbAngel.setLayoutY(250);
            } else if (inquisitorExist || griffExist || archerExist || farmerExist) {
                vbAngel.setLayoutY(150);
            } else vbAngel.setLayoutY(50);

            vbAngel.setPrefSize(60, 60);
            vbAngel.setStyle("-fx-border-color: black; -fx-background-color: aqua;");
            setOnDragDetected(vbAngel, lblAngel);
            setOnDragDone(vbAngel, lblAngel, lblAngelC);
            count++;
            angelExist = true;
        }

        count1 = count;

        root.getChildren().add(gridPane);
        gridPane.setStyle("-fx-grid-lines-visible: true");


        for (int i = 0; i < 20; i++) {
            stackPane = new StackPane();
            stackPane.setPrefSize(60, 60);
            stackPane.setStyle("-fx-background-color: yellow;");
            setOnDragOver(stackPane);
            setOnDragEntered(stackPane);
            setOnDragDropped(stackPane);
            setOnDragExited(stackPane);
            gridPane.add(stackPane, i / 10, i % 10);
        }

        for (int i = 20; i < 120; i++) {
            stackPane1 = new StackPane();
            stackPane1.setPrefSize(60, 60);
            stackPane1.setStyle("-fx-background-color: yellow;");
            gridPane.add(stackPane1, i / 10, i % 10);
        }

        gridPane.setLayoutX(50);
        gridPane.setLayoutY(50);

        farmerMaxHealth = mulHealth(controllerUnit.farmer.getHealth(), farmerCount);
        farmerHealth = farmerMaxHealth;
        farmerCount = farmerMaxCount;

        archerMaxHealth = mulHealth(controllerUnit.archer.getHealth(), archerCount);
        archerHealth = archerMaxHealth;
        archerCount = archerMaxCount;

        griffMaxHealth = mulHealth(controllerUnit.griff.getHealth(), griffCount);
        griffHealth = griffMaxHealth;
        griffCount = griffMaxCount;

        inquisitorMaxHealth = mulHealth(controllerUnit.inquisitor.getHealth(), inquisitorCount);
        inquisitorHealth = inquisitorMaxHealth;
        inquisitorCount = inquisitorMaxCount;

        angelMaxHealth = mulHealth(controllerUnit.angel.getHealth(), angelCount);
        angelHealth = angelMaxHealth;
        angelCount = angelMaxCount;


    }

    public void setOnMouseEntered(VBox target, Label target1, Label target2) {
        target.setOnMouseEntered((MouseEvent event) -> {
            target.setStyle("-fx-background-color: green;");
            target1.setTextFill(Color.WHITE);
            target2.setTextFill(Color.WHITE);
            event.consume();
        });
    }


    public void setOnMouseExited(VBox target, Label target1, Label target2) {
        target.setOnMouseExited((MouseEvent event) -> {
            target.setStyle("-fx-background-color: crimson;");
            target1.setTextFill(Color.WHITE);
            target2.setTextFill(Color.WHITE);
            event.consume();
        });
    }

    public void setOnMouseExitedV2(VBox target, Label target1, Label target2) {
        target.setOnMouseExited((MouseEvent event) -> {
            target.setStyle("-fx-background-color: aqua;");
            target1.setTextFill(Color.BLACK);
            target2.setTextFill(Color.BLACK);
            event.consume();
        });
    }

    public int setOnUsingHeroAttack(VBox target, Label target1, Label target2, Label target3, int currentHealth, int singleUnitHealth) {
        int heroAttack = controllerHero.getAttack();
        int damage = heroAttack * 10;
        currentHealth -= damage;
        int cHealth1 = currentHealth;
        int count = Integer.parseInt(target1.getText());
        for (int i = singleUnitHealth; i < damage; i+=singleUnitHealth) {
            count--;
        }
        int newCount = count;
        target.setOnMousePressed((MouseEvent event) -> {
            if(Integer.parseInt(target1.getText()) == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Ez az egység már megsemmisült!");
                alert.showAndWait();
            }
            else {
                if (newCount <= 0 || cHealth1 <= 0) {
                    target1.setText(String.valueOf(0));
                    String temp = target3.getText();
                    root.getChildren().remove(target3);
                    units.remove(temp);
                } else {
                    target1.setText(String.valueOf(newCount));
                }
                vbUnit1.setDisable(true);
                vbUnit2.setDisable(true);
                vbUnit3.setDisable(true);
                vbUnit4.setDisable(true);
                vbUnit5.setDisable(true);
            }
            event.consume();
        });
        return currentHealth;
    }


    public int setOnUsingSpellOne(VBox target, Label target1, Label target2, Label target3, int currentHealth, int singleUnitHealth) {
        int heroSpellpower = controllerHero.getSpellpower();
        int damage = heroSpellpower * 30;
        currentHealth -= damage;
        int cHealth1 = currentHealth;
        int count = Integer.parseInt(target1.getText());
        for (int i = singleUnitHealth; i < damage; i+=singleUnitHealth) {
            count--;
        }
        int newCount = count;
        target.setOnMousePressed((MouseEvent event) -> {
            if(Integer.parseInt(target1.getText()) == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Ez az egység már megsemmisült!");
                alert.showAndWait();
            }
            else {
                if (newCount <= 0 || cHealth1 <= 0) {
                    target1.setText(String.valueOf(0));
                    String temp = target3.getText();
                    root.getChildren().remove(target3);
                    units.remove(temp);
                } else {
                    target1.setText(String.valueOf(newCount));
                }
                vbUnit1.setDisable(true);
                vbUnit2.setDisable(true);
                vbUnit3.setDisable(true);
                vbUnit4.setDisable(true);
                vbUnit5.setDisable(true);
            }
            event.consume();
        });
        return currentHealth;
    }

    public int setOnUsingSpellTwo(VBox target, Label target1, Label target2, Label target3, int currentHealth, int singleUnitHealth) {
        int heroSpellPower = controllerHero.getSpellpower();
        int damage = heroSpellPower * 20;
        currentHealth -= damage;
        int cHealth1 = currentHealth;
        int count = Integer.parseInt(target1.getText());
        for (int i = singleUnitHealth; i < damage; i+=singleUnitHealth) {
            count--;
        }
        int newCount = count;
        target.setOnMousePressed((MouseEvent event) -> {
            if(Integer.parseInt(target1.getText()) == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Ez az egység már megsemmisült!");
                alert.showAndWait();
            }
            else {
                if (newCount <= 0 || cHealth1 <= 0) {
                    target1.setText(String.valueOf(0));
                    String temp = target3.getText();
                    root.getChildren().remove(target3);
                    units.remove(temp);
                } else {
                    target1.setText(String.valueOf(newCount));
                }
                vbUnit1.setDisable(true);
                vbUnit2.setDisable(true);
                vbUnit3.setDisable(true);
                vbUnit4.setDisable(true);
                vbUnit5.setDisable(true);
            }
            event.consume();
        });
        return currentHealth;
    }


    public int setOnUsingSpellThree(VBox target, Label target1, int maxCount, int currentHealth, int maxHealth, int singleUnitHealth) {
        int currentHealth1 = currentHealth;
        int heroSpellpower = controllerHero.getSpellpower();
        int healing = heroSpellpower * 50;
        currentHealth += healing;
        if(currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
        int count = Integer.parseInt(target1.getText());
        for (int i = singleUnitHealth; i < healing; i+=singleUnitHealth) {
            count++;
        }
        int temp;
        if(maxCount <= count) {
            temp = maxCount;
        }
        else {
            temp = count;
        }
        int retCount = temp;

        target.setOnMousePressed((MouseEvent event) -> {
            if(maxHealth == currentHealth1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Ennek az egységnek maximális az életereje! manna wasted, xd");
                alert.showAndWait();
            } else {
                target1.setText(String.valueOf(retCount));
            }
            vbFarmer1.setDisable(true);
            vbArcher1.setDisable(true);
            vbGriff1.setDisable(true);
            vbInquisitor1.setDisable(true);
            vbAngel1.setDisable(true);
            event.consume();
        });
        return currentHealth;
    }


    public void setOnDragDetected(VBox source, Label source1) {
        source.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(source1.getText());
            db.setContent(content);
            event.consume();
        });
    }

    public void setOnDragDone(VBox source, Label source1, Label source2) {
        source.setOnDragDone((DragEvent event) -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                source1.setText("");
                source2.setText("");
                source.setDisable(true);
                source.setStyle("fx-border-color: none;");
            }
            event.consume();
        });
    }

    public void setOnDragOver(StackPane target) {
        target.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });
    }

    public void setOnDragEntered(StackPane target) {
        target.setOnDragEntered((DragEvent event) -> {
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                target.setStyle("-fx-background-color: green;");
            }
            event.consume();
        });
    }

    public void setOnDragExited(StackPane target) {
        target.setOnDragExited((DragEvent event) -> {
            target.setStyle("-fx-background-color: yellow;");
            event.consume();
        });
    }

    public void setOnDragDropped(StackPane target) {

        ObservableList<Node> children = target.getChildren();

        target.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            Label temp = new Label(db.getString());
            if(temp.getText().equals("Földműves")) {
                lblFarmer1.setText(temp.getText());
                lblFarmer1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblFarmer1.setAlignment(Pos.CENTER);
                lblFarmerC1.setText(lblFarmerC.getText());
                lblFarmerC1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblFarmerC1.setAlignment(Pos.CENTER);
                lblFarmerC1.setTranslateY(20);
                vbFarmer1 = new VBox(lblFarmer1, lblFarmerC1);
                vbFarmer1.setStyle("-fx-background-color: aqua;");
                int size = children.size();
                if (size + 1 == 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Ide már elhelyeztél egy egységet!");
                    alert.showAndWait();
                } else {
                    target.getChildren().add(vbFarmer1);
                    count--;
                    unitsOnBoard++;
                    if (count == 0) {
                        btnNext.setDisable(false);
                    }
                    success = true;
                }
            }
            if(temp.getText().equals("Íjász")) {
                lblArcher1.setText(temp.getText());
                lblArcher1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblArcher1.setAlignment(Pos.CENTER);
                lblArcherC1.setText(lblArcherC.getText());
                lblArcherC1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblArcherC1.setAlignment(Pos.CENTER);
                lblArcherC1.setTranslateY(20);
                vbArcher1 = new VBox(lblArcher1, lblArcherC1);
                vbArcher1.setStyle("-fx-background-color: aqua;");
                int size = children.size();
                if (size + 1 == 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Ide már elhelyeztél egy egységet!");
                    alert.showAndWait();
                } else {
                    target.getChildren().add(vbArcher1);
                    count--;
                    unitsOnBoard++;
                    if (count == 0) {
                        btnNext.setDisable(false);
                    }
                    success = true;
                }
            }
            if(temp.getText().equals("Griff")) {
                lblGriff1.setText(temp.getText());
                lblGriff1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblGriff1.setAlignment(Pos.CENTER);
                lblGriffC1.setText(lblGriffC.getText());
                lblGriffC1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblGriffC1.setAlignment(Pos.CENTER);
                lblGriffC1.setTranslateY(20);
                vbGriff1 = new VBox(lblGriff1, lblGriffC1);
                vbGriff1.setStyle("-fx-background-color: aqua;");
                int size = children.size();
                if (size + 1 == 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Ide már elhelyeztél egy egységet!");
                    alert.showAndWait();
                } else {
                    target.getChildren().add(vbGriff1);
                    count--;
                    unitsOnBoard++;
                    if (count == 0) {
                        btnNext.setDisable(false);
                    }
                    success = true;
                }
            }
            if(temp.getText().equals("Inkvizítor")) {
                lblInquisitor1.setText(temp.getText());
                lblInquisitor1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblInquisitor1.setAlignment(Pos.CENTER);
                lblInquisitorC1.setText(lblInquisitorC.getText());
                lblInquisitorC1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblInquisitorC1.setAlignment(Pos.CENTER);
                lblInquisitorC1.setTranslateY(20);
                vbInquisitor1 = new VBox(lblInquisitor1, lblInquisitorC1);
                vbInquisitor1.setStyle("-fx-background-color: aqua;");
                int size = children.size();
                if (size + 1 == 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Ide már elhelyeztél egy egységet!");
                    alert.showAndWait();
                } else {
                    target.getChildren().add(vbInquisitor1);
                    count--;
                    unitsOnBoard++;
                    if (count == 0) {
                        btnNext.setDisable(false);
                    }
                    success = true;
                }
            }
            if(temp.getText().equals("Angyal")) {
                lblAngel1.setText(temp.getText());
                lblAngel1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblAngel1.setAlignment(Pos.CENTER);
                lblAngelC1.setText(lblAngelC.getText());
                lblAngelC1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                lblAngelC1.setAlignment(Pos.CENTER);
                lblAngelC1.setTranslateY(20);
                vbAngel1 = new VBox(lblAngel1, lblAngelC1);
                vbAngel1.setStyle("-fx-background-color: aqua;");
                int size = children.size();
                if (size + 1 == 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Ide már elhelyeztél egy egységet!");
                    alert.showAndWait();
                } else {
                    target.getChildren().add(vbAngel1);
                    count--;
                    unitsOnBoard++;
                    if (count == 0) {
                        btnNext.setDisable(false);
                    }
                    success = true;
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }
    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public int calcManna(int knowledge) {
        return knowledge * 10;
    }

    public int calcNewManna(int manna, int mannaCost) {
        return manna - mannaCost;
    }

    public int mulHealth(int singleUnitHealth, int bought) {
        return singleUnitHealth * bought;
    }

    public int enemyUnitHit(VBox target, Label target1, Label target2, Label target3,
                            int currentHealth, int singleUnitHealth, int damage) {

        int critChance = 0;
        boolean crit = false;
        switch (controllerHero.getLuck()) {
            case 1 -> critChance = 5;
            case 2 -> critChance = 10;
            case 3 -> critChance = 15;
            case 4 -> critChance = 20;
            case 5 -> critChance = 25;
            case 6 -> critChance = 30;
            case 7 -> critChance = 35;
            case 8 -> critChance = 40;
            case 9 -> critChance = 45;
            case 10 -> critChance = 50;
        }

        Random x = new Random();
        int rand = x.nextInt(101-1)+1;
        if(rand <= critChance) {
            damage*=2;
            crit = true;
        }
        currentHealth -= damage;
        int cHealth1 = currentHealth;
        boolean crit1 = crit;
        int count = Integer.parseInt(target1.getText());
        for (int i = singleUnitHealth; i < damage; i+=singleUnitHealth) {
            count--;
        }
        int newCount = count;
        target.setOnMousePressed((MouseEvent event) -> {
            if(Integer.parseInt(target1.getText()) == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Ez az egység már megsemmisült!");
                alert.showAndWait();
            }
            else {
                if ((newCount <= 0 || cHealth1 <= 0) && crit1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("wow");
                    alert.setHeaderText("Kritikus sebzés!");
                    alert.showAndWait();
                    target1.setText(String.valueOf(0));
                    String temp = target3.getText();
                    root.getChildren().remove(target3);
                    units.remove(temp);
                } else if (newCount <= 0 || cHealth1 <= 0) {
                    target1.setText(String.valueOf(0));
                    String temp = target3.getText();
                    root.getChildren().remove(target3);
                    units.remove(temp);
                } else if (crit1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("wow");
                    alert.setHeaderText("Kritikus sebzés!");
                    alert.showAndWait();
                    target1.setText(String.valueOf(newCount));
                } else {
                    target1.setText(String.valueOf(newCount));
                }

                vbUnit1.setDisable(true);
                vbUnit2.setDisable(true);
                vbUnit3.setDisable(true);
                vbUnit4.setDisable(true);
                vbUnit5.setDisable(true);
                unitActionDone = 1;
                btnNextUnit.setDisable(false);
            }
            event.consume();
        });


        return currentHealth;
    }

    public int calcDamage(int minDamage, int maxDamage, int unitCount, int heroAttack, int enemyHeroDefence) {
        Random x = new Random();
        int singleDamage = x.nextInt(maxDamage+1-minDamage)+minDamage;
        double unitDamage = unitCount*singleDamage;
        switch (heroAttack) {
            case 1 -> unitDamage *= 1.1;
            case 2 -> unitDamage *= 1.2;
            case 3 -> unitDamage *= 1.3;
            case 4 -> unitDamage *= 1.4;
            case 5 -> unitDamage *= 1.5;
            case 6 -> unitDamage *= 1.6;
            case 7 -> unitDamage *= 1.7;
            case 8 -> unitDamage *= 1.8;
            case 9 -> unitDamage *= 1.9;
            case 10 -> unitDamage *= 2;
        }
        switch (enemyHeroDefence) {
            case 1 -> unitDamage *= 0.95;
            case 2 -> unitDamage *= 0.9;
            case 3 -> unitDamage *= 0.85;
            case 4 -> unitDamage *= 0.8;
            case 5 -> unitDamage *= 0.75;
            case 6 -> unitDamage *= 0.7;
            case 7 -> unitDamage *= 0.65;
            case 8 -> unitDamage *= 0.6;
            case 9 -> unitDamage *= 0.55;
            case 10 -> unitDamage *= 0.5;
        }

        return (int)Math.ceil(unitDamage);
    }

}