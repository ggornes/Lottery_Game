import static org.junit.Assert.*;
import org.junit.Test;
import sample.Controller;
import sample.TestUtils;
import java.util.Arrays;

public class MyTest {

/*

    @Test
    public void firstTest() {
        assertTrue(true);
    }

    @Test
    public void TestConcatWith2Params(){
        //arrange
        String p1 = "Hello ";
        String p2 = "World";
        String expected = p1+p2;
        // act
        String result = TestUtils.concat(p1,p2);
        //assert
        assertEquals(expected,result);

    }

    @Test
    public void testDefaultIfNull() {
        String result = TestUtils.getDefaultIfNull(null, "world");
        assertNotNull(result);
        assertEquals("world", result);
    }



*/

/*

    @Test
    public void testConvertToInt() {
        // arrange
        String myStr = "11";
        int expected = 11;
        // act
        int result = TestUtils.convertToInt(myStr);
        // assert
        assertEquals(expected, result);


    }
*/



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

