package is.ru.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public final void addTwoNumbers() {
		Calculator.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void addNonNumber() {
		Calculator.add("1,X");
	}
	
	@Test
	public final void addEmptyString() {
		Assert.assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public final void addOneNumber() {
		Assert.assertEquals(5, Calculator.add("5"));
	}

	@Test
	public final void addTwoNumbersReturnsSum() {
		Assert.assertEquals(4+1, Calculator.add("4,1"));
	}
	
	@Test
	public final void addAnyNumberOfNumbers() {
		Assert.assertEquals(6+7+8+9+10+11, Calculator.add("6,7,8,9,10,11"));
	}

	@Test
	public final void addNumbersWithLinesBetween() {
		Assert.assertEquals(1,2,3, Calculator.add("1,2\n3"));
	}

	@Test
	public final void AddNumbersWithDelemiter() {
		Assert.assertEquals(4+5+6, Calculator.add("//;\n4;5;6"));
	}
	
	@Test(expected = RuntimeException.class)
	public final void addNegativeNumber() {
		Calculator.add("1,-2,3,4,5,6");
	}

	@Test
	public final void addNumberGreaterThan1000() {
		Assert.assertEquals(1+1000+2, Calculator.add("1,1000,1010,2,1009"));
	}

}