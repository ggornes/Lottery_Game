import static org.junit.Assert.*;
import org.junit.Test;
import sample.Controller;
import sample.StringUtils;

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
        String result = StringUtils.concat(p1,p2);
        //assert
        assertEquals(expected,result);

    }

    @Test
    public void testDefaultIfNull() {
        String result = StringUtils.getDefaultIfNull(null, "world");
        assertNotNull(result);
        assertEquals("world", result);
    }



*/



    @Test
    public void testConvertToInt() {
        // arrange
        String myStr = "11";
        int expected = 11;
        // act
        int result = StringUtils.convertToInt(myStr);
        // assert
        assertEquals(expected, result);


    }

    @Test
    public void testValidation() {
        String [] myStrArray = new String [] {"1","2","3"};

        boolean result = StringUtils.validateNumbers(myStrArray);
        boolean expected = true;
        assertEquals(expected,result);


    }

}

