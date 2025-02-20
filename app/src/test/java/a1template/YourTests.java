// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    //make sure spaces are unchanged
    @Test
    public void checkNonLetterCharactersTest() {
        // this test makes sure that the cipher can handle non-letter characters by leaving them unchanged
        CaesarCipher classUnderTest = new CaesarCipher(4);
        assertEquals("pdeo eo iu yeldan!",classUnderTest.encode("this is my cipher!"));
        assertEquals("this is my cipher!",classUnderTest.decode("pdeo eo iu yeldan!"));
        assertEquals("pkzwu e sehh xqu: acco, iehg, xnawz.",classUnderTest.encode("today i will buy: eggs, milk, bread."));
        assertEquals("today i will buy: eggs, milk, bread.", classUnderTest.decode("pkzwu e sehh xqu: acco, iehg, xnawz."));
    }

    public void lateAlphabetTest() {
        // this test ensures that letters that would "wrap around" the cipher are dealt with
        CaesarCipher classUnderTest = new CaesarCipher(4);
        assertEquals("stuv",classUnderTest.encode("wxyz"));
        assertEquals("wxyz",classUnderTest.decode("stuv"));
        assertEquals("sdepa tuhkldkja uahhks vellan",classUnderTest.encode("white xylophone yellow zipper"));
        assertEquals("white xylophone yellow zipper", classUnderTest.decode("sdepa tuhkldkja uahhks vellan"));
    }

}