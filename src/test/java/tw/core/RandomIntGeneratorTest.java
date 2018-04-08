package tw.core;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;
import static org.junit.Assert.*;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private RandomIntGenerator randomIntGenerator;

    @Before
    public final void before() {
        randomIntGenerator = new RandomIntGenerator();
    }
    
    @Test
    public void should_throw_IllegalArgumentException_when_digitmax_less_than_numbersOfNeed(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Can't ask for more numbers than are available");
        randomIntGenerator.generateNums(2, 4);
    }

    @Test
    public void should_generate_length_equals_numbersOfNeed() {
        String generateNums = randomIntGenerator.generateNums(9, 5);
        assertEquals(5, generateNums.split(" ").length);
    }
}