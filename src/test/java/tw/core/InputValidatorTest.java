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
}
