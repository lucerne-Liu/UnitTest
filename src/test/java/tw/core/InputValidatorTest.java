package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tw.validator.InputValidator;
import static org.junit.Assert.*;
/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;

    @Before
    public final void before() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_false_when_input_less_than_4_numbers() {
        assertFalse(inputValidator.validate("1 2 3"));
    }

    @Test
    public void should_return_false_when_inputNumber_greater_than_9() {
        assertFalse(inputValidator.validate("10 1 2 3"));
    }

    @Test
    public void should_return_false_when_input_has_same_numbers() {
        assertFalse(inputValidator.validate("1 1 2 3"));
    }
}
