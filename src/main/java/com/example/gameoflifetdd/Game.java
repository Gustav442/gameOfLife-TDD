package com.example.gameoflifetdd;

public class Game {

    int cellWidth, cellHeight;
    public int[][] board;
    public Game(int width, int height) {
        this.cellWidth = width;
        this.cellHeight = height;
        this.board = new int[width][height];
    }
    public void setCellAlive(int x, int y) {
        this.board[x][y] = Cell.ALIVE;
    }
    public void nextBoard() {
        int[][] newBoard = new int[cellWidth][cellHeight];

        for (int y = 0; y < cellHeight; y++) {
            for (int x = 0; x < cellWidth; x++) {
                int aliveNeighbours = aliveNeighbours(x, y);

                if (getState(x, y) == Cell.ALIVE) {
                    if (aliveNeighbours < 2)
                        newBoard[x][y] = Cell.DEAD;
                    else if (aliveNeighbours > 3)
                        newBoard[x][y] = Cell.DEAD;
                    else
                        newBoard[x][y] = Cell.ALIVE;
                }else
                if (aliveNeighbours == 3 )
                    newBoard[x][y] = Cell.ALIVE;
            }
        }
        this.board = newBoard;
    }
    public int aliveNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }
    public int getState(int x, int y) {
        if (x < 0 || x >= cellWidth)
            return 0;
        if (y < 0 || y >= cellHeight)
            return 0;

        return this.board[x][y];
    }
}
