package p.sda.kik;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    @Test(expected = RuntimeException.class)

    public void shouldThrowExceptionWhenMoveIsBeyondLefttBoundary() {
        // given
        int x = 0;
        int y = 2;
        // when
        new TicTacToe().play(x, y);

        // then

    }

    public void shouldThrowExceptionWhenMoveIsBeyondLowerBoundary() {
        // given
        int x = 2;
        int y = 4;
        // when
        new TicTacToe().play(x, y);

        // then

    }

    public void shouldThrowExceptionWhenMoveIsBeyondUpperBoundary() {
        // given
        int x = 0;
        int y = 1;
        // when
        new TicTacToe().play(x, y);

        // then

    }

    public void shouldThrowExceptionWhenMoveIsBeyondRightBoundary() {
        // given
        int x = 4;
        int y = 2;
        // when
        new TicTacToe().play(x, y);

        // then

    }

    @Test
    public void shouldBeAbleToMoveOnEmptyField() {
        // given
        int x = 2;
        int y = 2;
        // when
        new TicTacToe().play(x, y);
        // then
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToMoveOnUsedField() {
        // given
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 2);
        // when

        // then
    }

    @Test
    public void shouldReturnXplayerOnFirstRound() {
        TicTacToe ticTacToe = new TicTacToe();
        char currentPlayerSymbol = ticTacToe.getCurrentPlayer();
        assertEquals('X', currentPlayerSymbol);
    }

    @Test
    public void shouldChangePlayerAfterMove() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(3, 2);
        char currentPlayerSymbol = ticTacToe.getCurrentPlayer();
        assertEquals('O', currentPlayerSymbol);
    }

    @Test
    public void shouldChangePlayerToTheFirstOne() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        char currentPlayerSymbol = ticTacToe.getCurrentPlayer();
        assertEquals('X', currentPlayerSymbol);

    }

    @Test
    public void shouldReturnEmptyOptionalIfThereIsNoWinner() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(2, 2);
        Optional<Character> winnerPlayer = ticTacToe.getWinner();
        assertEquals(Optional.empty(), winnerPlayer);
    }

    @Test
    public void shouldReturnWinnerIfRowIsFilledByOnePlayer() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(1, 2); //X
        ticTacToe.play(2, 1); //O
        ticTacToe.play(2, 2); //X
        ticTacToe.play(2, 3); //O
        ticTacToe.play(3, 2); //X
        Optional<Character> winner = ticTacToe.getWinner();
        assertEquals((Character) 'X', winner.orElse(' '));
    }

    @Test
    public void shouldReturnWinnerIfColumnIsFilledByOnePlayer() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(2, 2); //X
        ticTacToe.play(3, 1); // O
        ticTacToe.play(1, 1); // X
        ticTacToe.play(3, 3); // o
        ticTacToe.play(1, 3); //X
        ticTacToe.play(3, 2); //O
        Optional<Character> winner = ticTacToe.getWinner();
        assertEquals((Character) 'O', winner.orElse(' '));
    }

    @Test
    public void shouldReturnWinnerIfDiagonalIsFilledByOnePlayer() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(1,1); //X
        ticTacToe.play(2,1); //O
        ticTacToe.play(2,2); //X
        ticTacToe.play(3,1); //O
        ticTacToe.play(3,3); //X
        Optional<Character> winner = ticTacToe.getWinner();
        assertEquals((Character) 'X', winner.orElse(' '));
    }

    /*
     * powinno dac sie wykonaca ruch
     *  - ruch powinien byc prawidlowy - > ruch powinien byc oddany na plansze
     *
     *  czy ruch nie wykracza poza prawy bok planszy
     *  czy ruch nie wykracza poza lewy bok planszy
     *  czy ruch nie wykacza poza gorny bok planszy
     *  czy ruch nie wykracza poza dolny bok planszy
     *
     *  nie mozna wykonac ruchu dwa razy na to samo pole
     *  mozna wykonac ruch na puste pole
     *
     *  gracze powinni się zmieniać po każdym ruchu
     *
     *  1st graczem powinien być X
     *  czy gracz zmienia sie po wykonaniu ruchu - > czy drugim graczem jest O
     *
     *  kiedy gra sie konczy?
     *  czy ostatni ruch spowodował wygraną?
     *  jezeli ruch nie spowodowal wygranej to nie ma wygrywajacego
     *  jezeli gracz ulozyl caly wiersz to ten gracz wygral
     *  jezeli gracz ulozyl cala kolumne to ten gracz wygral
     *  jezeli gracz ulozyl przekatna to ten gracz wygral
     *  remis? - > jezeli po ostatnim ruchu nie ma wolnych pol to remis
     * */
}
