package is.ru.stringCal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringCal.CalTest");
    }

	@Test
	public void testNullString() {
		assertEquals(0, Cal.add(""));
	}

	@Test
	public void testNumber1() {
		assertEquals(1, Cal.add("1"));
	}

	@Test
	public void testNumbers2(){
		assertEquals(3, Cal.add("1,2"));
	}

	@Test
    public void testNumbers3(){
    	assertEquals(6, Cal.add("1,2,3"));
    }

    @Test
    public void testNLine(){
    	assertEquals(6, Cal.add("1\n2,3"));
    }

    @Test
    public void testNegNUM(){
    	try {
			Cal.add("-1,2");
		}
		catch (IllegalArgumentException ex){
			assertEquals(ex.getMessage(), "Negatives are impermissible: -1");
		}

		try {
			Cal.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException ex){
			assertEquals(ex.getMessage(), "Negatives are not permitted: -4,-5");
		}
    }

    @Test
    public void testOver1000(){
    	assertEquals(2, Cal.add("1000,2"));
    }

    @Test
    public void testOtherDeli(){
    	assertEquals(3, Cal.add("//;\n1;2"));
    }
}