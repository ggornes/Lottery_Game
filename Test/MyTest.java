import static org.junit.Assert.*;
import org.junit.Test;
import sample.Controller;
import sample.TestUtils;
import java.util.Arrays;

public class MyTest {


    @Test
    public void testValidation() {
        String [] myStrArray = new String [] {"1","2","3"};

        boolean result = TestUtils.validateNumbers(myStrArray);
        boolean expected = true;
        assertEquals(expected,result);


    }

    @Test
    public void testDuplicates() {
        int nums [] = new int [] {1,2,3,4,5}; //sorted array
        boolean result = TestUtils.duplicateNumbers(nums);
        boolean expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void testLotteryResult() {
        int [] userNumbers = new int [] {11,22,33,44};
        int [] winningNumbers = new int [] {11,22,33,44};
        int result = TestUtils.lotteryResult(userNumbers, winningNumbers);
        int expected = 4;
        assertEquals(expected, result);

    }

}

