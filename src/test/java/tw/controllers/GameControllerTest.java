package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController;
    private AnswerGenerator answerGenerator;
    private InputCommand inputGuess;
    private Answer answer;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public final void before() throws OutOfRangeAnswerException {
        Answer actualAnswer = new Answer();
        actualAnswer.setNumList(Arrays.asList("1","2","3","4"));
        answerGenerator = mock(AnswerGenerator.class);
        inputGuess = mock(InputCommand.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        gameController = new GameController(new Game(answerGenerator),new GameView());
        System.setOut(new PrintStream(outContent));
        answer = new Answer();
    }

    private String systemOut() { return outContent.toString(); }

    @Test
    public void should_print_beginMsg_when_beginGame() throws IOException {
        gameController.beginGame();
        assertThat(systemOut().startsWith("------Guess Number Game, You have 6 chances to guess!  ------")).isTrue();
    }

    @Test
    public void should_print_GuessHistory_and_fail_when_guess_is_all_wrong() throws IOException {
        answer.setNumList(Arrays.asList("5","6","7","8"));
        when(inputGuess.input()).thenReturn(answer);
        gameController.play(inputGuess);
        assertThat(systemOut().contains(
                "[Guess Numbers: 5 6 7 8, Guess Result: 0A0B]\n" +
                "[Guess Numbers: 5 6 7 8, Guess Result: 0A0B]\n" +
                "[Guess Numbers: 5 6 7 8, Guess Result: 0A0B]\n" +
                "[Guess Numbers: 5 6 7 8, Guess Result: 0A0B]\n" +
                "[Guess Numbers: 5 6 7 8, Guess Result: 0A0B]\n" +
                "[Guess Numbers: 5 6 7 8, Guess Result: 0A0B]\n" +
                "Game Status: fail")).isTrue();
    }
}