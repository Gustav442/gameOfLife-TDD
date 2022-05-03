package com.example.gameoflifetdd;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class View extends VBox {
    private Button nextGenerationButton;
    private Canvas canvas;
    private Affine affine;
    private Game game;
    GraphicsContext graphicsContext;
    public View() {
        nextGenerationButton();

        this.canvas = new Canvas(400, 400);
        this.graphicsContext = this.canvas.getGraphicsContext2D();

        this.getChildren().addAll(this.nextGenerationButton, this.canvas);

        this.affine = new Affine();
        this.affine.appendScale(400 / 12f, 400 / 12f);
        newGame();
    }
    public void nextGenerationButton() {
        this.nextGenerationButton = new Button("Next Generation");
        this.nextGenerationButton.setOnAction(actionEvent -> {
            game.nextBoard();
            drawCells();
        });
    }
    public void newGame() {
        this.game = new Game(12, 12);
        game.setCellAlive(5,4);
        game.setCellAlive(5,5);
        game.setCellAlive(5,6);
        game.setCellAlive(5,7);
        game.setCellAlive(5,8);
    }

    public void drawCells() {
        graphicsContext.setTransform(this.affine);

        graphicsContext.setFill(Color.LIGHTGRAY);
        graphicsContext.fillRect(0, 0, 450, 450);

        graphicsContext.setFill(Color.BLACK);
        for (int x = 0; x < this.game.cellWidth; x++) {
            for (int y = 0; y < this.game.cellHeight; y++) {
                if (this.game.getState(x, y) == Cell.ALIVE) {
                    graphicsContext.fillRect(x, y, 1, 1);
                }
            }
        }
        drawLines();
    }
    public void drawLines() {
        graphicsContext.setStroke(Color.GRAY);
        graphicsContext.setLineWidth(0.05);
        for (int x = 0; x <= this.game.cellWidth; x++) {
            graphicsContext.strokeLine(x, 0, x, 12);
        }
        for (int y = 0; y <= this.game.cellHeight; y++) {
            graphicsContext.strokeLine(0, y, 12, y);
        }
    }
}

