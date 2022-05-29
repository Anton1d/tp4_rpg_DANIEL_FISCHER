package com.example.tp4_rpg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("RPG Lite 3000");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Game jeu = new Game();
        jeu.playGame();
        launch();

    }
    public static String text(){
        String text = "Le combat commence !";
        return text;
    }
}