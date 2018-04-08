package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;
import static org.junit.Assert.*;
/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Answer answer;
    private Answer rightAnswer = new Answer();
    {
        rightAnswer.setNumList(Arrays.asList("1","2","3","4"));
    }

    @Before
    public final void before() {
        answer = new Answer();
    }

    @Test
    public void should_createAnswer_return_answer_when_input_string() {
        Answer result = new Answer();
        result.setNumList(Arrays.asList("1","2","3","4"));
        assertEquals(result.toString(), answer.createAnswer("1 2 3 4").toString());
    }

    @Test
    public void should_validate_throw_OutOfRangeAnswerException_when_answer_contains_same_numbers() throws OutOfRangeAnswerException {
        answer.setNumList(Arrays.asList("1", "2", "3","1"));
        exception.expect(OutOfRangeAnswerException.class);
        exception.expectMessage("Answer format is incorrect");
        answer.validate();
    }

    @Test
    public void should_validate_throw_OutOfRangeAnswerException_when_answer_contains_number_greater_than_9() throws OutOfRangeAnswerException {
        exception.expect(OutOfRangeAnswerException.class);
        exception.expectMessage("Answer format is incorrect");
        answer.setNumList(Arrays.asList("1", "2", "3","10"));
        answer.validate();
    }

    @Test
    public void should_check_return_record_in_0_and_0_when_inputAnswer_all_wrong() {
        int[] result = new int[]{0,0};
        answer.setNumList(Arrays.asList("5","6","7","8"));
        assertArrayEquals(result, rightAnswer.check(answer).getValue());
    }

    @Test
    public void should_check_return_record_in_4_and_0_when_inputAnswer_all_right() {
        int[] result = new int[]{4,0};
        answer.setNumList(Arrays.asList("1","2","3","4"));
        assertArrayEquals(result, rightAnswer.check(answer).getValue());
    }

    @Test
    public void should_check_return_record_in_0_and_4_when_inputAnswer_all_in_wrong_positions() {
        int[] result = new int[]{0,4};
        answer.setNumList(Arrays.asList("4","3","2","1"));
        assertArrayEquals(result, rightAnswer.check(answer).getValue());
    }
}