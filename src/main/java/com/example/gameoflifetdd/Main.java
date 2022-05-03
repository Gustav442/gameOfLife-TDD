package com.example.gameoflifetdd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        View view = new View();
        Scene scene = new Scene(view, 640, 480);
        stage.setScene(scene);
        stage.show();

        view.drawCells();
    }

    public static void main(String[] args) {
        launch();
    }
}