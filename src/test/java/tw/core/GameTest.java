package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Game game;
    private AnswerGenerator answerGenerator;
    private Answer inputAnswer;

    @Before
    public final void before() throws OutOfRangeAnswerException {
        Answer actualAnswer = new Answer();
        actualAnswer.setNumList(Arrays.asList("1","2","3","4"));
        answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
        inputAnswer = new Answer();
    }

    @Test
    public void should_guess_result_be_0A0B_when_inputNumbers_all_wrong() {
        inputAnswer.setNumList(Arrays.asList("5","6","7","8"));
        GuessResult guessResult = game.guess(inputAnswer);
        assertEquals("0A0B", guessResult.getResult());
        assertEquals(inputAnswer.toString(), guessResult.getInputAnswer().toString());
    }

    @Test
    public void should_guess_result_be_4A0B_when_inputNumbers_all_right() {
        inputAnswer.setNumList(Arrays.asList("1","2","3","4"));
        GuessResult guessResult = game.guess(inputAnswer);
        assertEquals("4A0B", guessResult.getResult());
        assertEquals(inputAnswer.toString(), guessResult.getInputAnswer().toString());
    }

    @Test
    public void should_guess_result_be_0A4B_when_inputNumbers_all_in_wrong_positions() {
        inputAnswer.setNumList(Arrays.asList("4","3","2","1"));
        GuessResult guessResult = game.guess(inputAnswer);
        assertEquals("0A4B", guessResult.getResult());
        assertEquals(inputAnswer.toString(), guessResult.getInputAnswer().toString());
    }

    @Test
    public void should_guess_result_be_2A1B_when_inputNumbers_3_right_numbers_but_1_in_wrong_positions() {
        inputAnswer.setNumList(Arrays.asList("1","2","5","3"));
        GuessResult guessResult = game.guess(inputAnswer);
        assertEquals("2A1B", guessResult.getResult());
        assertEquals(inputAnswer.toString(), guessResult.getInputAnswer().toString());
    }
}
