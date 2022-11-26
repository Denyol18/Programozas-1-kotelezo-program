module com.kotprog.game {
    requires javafx.controls;
    requires javafx.fxml;
    exports com.kotprog.game;
    opens com.kotprog.game to javafx.fxml;
    exports com.kotprog.game.entities;
    opens com.kotprog.game.entities to javafx.fxml;
}