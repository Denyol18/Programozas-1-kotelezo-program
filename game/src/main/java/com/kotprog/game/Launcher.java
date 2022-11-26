package com.kotprog.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * A Launcher osztály.
 *
 * Itt található a main illetve a start függvény, tehát minden ami a futtatáshoz szükséges,
 * illetve betölti a difficulty.fxml fájlt.
 *
 */

public class Launcher extends Application {

    /**
     * A main függvény.
     *
     * Meghívja a launch metódust, ami elindítja a JavaFX applikációt.
     *
     * Ez a Java programunk belépési pontja.
     * @param args a parancssori argumentumok.
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * A start függvény.
     *
     * Ez a JavaFX applikáció belépési pontja.
     * Betölti a difficulty.fxml fájlt.
     *
     * @param stage a JavaFX container felső szintje.
     * @throws IOException kivétel, ami akkor dobódik, amikor egy i/o művelet elbukik.
     */

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("difficulty.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kotprog goes brr");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}