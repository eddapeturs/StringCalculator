package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	@Test
	public void testMultipleSplit(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testdDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void testNegatives(){
		try {
			Calculator.add("-1,2");
			}
		catch (RuntimeException ex){
			 assertEquals("Negatives not allowed: -1",ex.getMessage());
			}
		}
	@Test
	public void overThousand(){
		assertEquals(2, Calculator.add("1001,2"));
	}
	@Test
	public void longDelimiter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void manyDelimiters(){
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void manyLongDel(){
		assertEquals(6, Calculator.add("//[***][%%%]\n1***2%%%3"));
	}
	@Test
	public void manyWeirdLongDels(){
		assertEquals(6, Calculator.add("//[++++][****][...][%%%][&&&]\n1++++1****1...1%%%2&&&"));
	}

}
