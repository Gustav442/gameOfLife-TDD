import com.example.gameoflifetdd.Cell;
import com.example.gameoflifetdd.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game = new Game(10,10);

    @Test
    public void aliveCellDiesWithNoLivingNeighbors(){

        game.setCellAlive(1,4);
        game.nextBoard();

        assertEquals(Cell.DEAD, game.board[1][4]);
    }

    @Test
    public void aliveCellDiesWithOneLivingNeighbour(){

        game.setCellAlive(1,4);
        game.setCellAlive(1,5);
        game.nextBoard();

        assertEquals(Cell.DEAD, game.board[1][4]);
    }

    @Test
    public void aliveCellDiesWithMoreThanThreeLivingNeighbours(){

        game.setCellAlive(1,2);
        game.setCellAlive(1,3);
        game.setCellAlive(2,2);
        game.setCellAlive(2,3);
        game.setCellAlive(2,4);
        game.nextBoard();


        assertEquals(Cell.DEAD, game.board[1][3]);
    }

    @Test
    public void aliveCellStaysAliveWithTwoLivingNeighbours(){

        game.setCellAlive(1,3);
        game.setCellAlive(2,2);
        game.setCellAlive(2,3);
        game.nextBoard();

        assertEquals(Cell.ALIVE, game.board[1][3]);
    }

    @Test
    public void aliveCellStaysAliveWithThreeLivingNeighbours(){

        game.setCellAlive(1,4);
        game.setCellAlive(1,5);
        game.setCellAlive(2,3);
        game.setCellAlive(2,4);
        game.nextBoard();

        assertEquals(Cell.ALIVE, game.board[1][4]);
    }
}
