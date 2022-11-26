package com.kotprog.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * A ControllerDiff osztály.
 *
 * Ez az osztály irányítja a difficulty.fxml fájlt, illetve ez az osztály felel
 * a nehézésgi fokozat kiválasztásáért és a hero.fxml fájl betöltéséért is.
 */


public class ControllerDiff {

    @FXML Label lblGold;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int gold;
    private String goldStr;

    static boolean bEasy = false;
    static boolean bMedium = false;
    static boolean bHard = false;

    /**
     * Az easy függvény
     *
     * Feladata, hogy a könnyű gombra való kattintás után beállítsa a megfelelő mennyiségű aranyat, majd
     * betölti a hero.fxml fájlt.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     * @throws IOException kivétel, ami akkor dobódik, amikor egy i/o művelet elbukik.
     */

    public void easy(ActionEvent e) throws IOException{
        setGold(1300);
        goldStr = String.valueOf(getGold());
        lblGold.setText(goldStr);
        setBEasy(true);

        String goldStr1 = lblGold.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hero.fxml"));
        root = loader.load();

        ControllerHero controllerHero = loader.getController();
        controllerHero.setHeroShop(goldStr1);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * A medium függvény.
     *
     * Feladata, hogy a közepes gombra való kattintás után beállítsa a megfelelő mennyiségű aranyat, majd
     * betölti a hero.fxml fájlt.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     * @throws IOException kivétel, ami akkor dobódik, amikor egy i/o művelet elbukik.
     */

    public void medium(ActionEvent e) throws IOException{
        setGold(1000);
        goldStr = String.valueOf(getGold());
        lblGold.setText(goldStr);
        setBMedium(true);

        String goldStr1 = lblGold.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hero.fxml"));
        root = loader.load();

        ControllerHero controllerHero = loader.getController();
        controllerHero.setHeroShop(goldStr1);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * A hard függvény.
     *
     * Feladata, hogy a nehéz gombra való kattintás után beállítsa a megfelelő mennyiségű aranyat, majd
     * betölti a hero.fxml fájlt.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     * @throws IOException kivétel, ami akkor dobódik, amikor egy i/o művelet elbukik.
     */

    public void hard(ActionEvent e) throws IOException{
        setGold(700);
        goldStr = String.valueOf(getGold());
        lblGold.setText(goldStr);
        setBHard(true);

        String goldStr1 = lblGold.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hero.fxml"));
        root = loader.load();

        ControllerHero controllerHero = loader.getController();
        controllerHero.setHeroShop(goldStr1);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * A setGold függvény.
     *
     * Módosítja a gold értékét a paraméterben kapott értékre.
     *
     * @param gold a paraméterül kapott gold változó értéke.
     */

    public void setGold(int gold) {
        this.gold = gold;
    }


    /**
     * A getGold függvény.
     *
     * Lekérdezi a gold változó értékét, majd visszatér vele.
     *
     * @return a gold értéke.
     */

    public int getGold() {
        return this.gold;
    }


    /**
     * Az isBEasy függvény.
     *
     * Lekérdezi az bEasy változó értékét, majd visszatér vele.
     *
     * @return a bEasy értéke.
     */

    public boolean isBEasy() {
        return this.bEasy;
    }


    /**
     * Az isBMedium függvény.
     *
     * Lekérdezi a bMedium változó értékét, majd visszatér vele.
     *
     * @return a bMedium értéke.
     */

    public boolean isBMedium() {
        return this.bMedium;
    }


    /**
     * Az isBHard függvény.
     *
     * Lekérdezi a bHard változó értékét, majd visszatér vele.
     *
     * @return a bHard értéke.
     */

    public boolean isBHard() {
        return this.bHard;
    }


    /**
     * A setBEasy függvény.
     *
     * Módosítja a bEasy értékét a paraméterben kapott értékre.
     *
     * @param bEasy a paraméterül kapott bEasy változó értéke.
     */

    public void setBEasy(boolean bEasy) {
        this.bEasy = bEasy;
    }


    /**
     * A setBMedium függvény.
     *
     * Módosítja a bMedium értékét a paraméterben kapott értékre.
     *
     * @param bMedium a paraméterül kapott bMedium változó értéke.
     */

    public void setBMedium(boolean bMedium) {
        this.bMedium = bMedium;
    }


    /**
     * A setBHard függvény.
     *
     * Módosítja a bHard értékét a paraméterben kapott értékre.
     *
     * @param bHard a paraméterül kapott bHard változó értéke.
     */

    public void setBHard(boolean bHard) {
        this.bHard = bHard;
    }
}