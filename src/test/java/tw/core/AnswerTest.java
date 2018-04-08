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
}