package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	public static int add(final String numbers) {

		String delimiter = ",|\n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);	
		}
		return add(numbersWithoutDelimiter, delimiter);
	}
	
	private static int add(final String numbers, final String delimiter) {

		int valueToReturn = 0;
		String[] numbersArray = numbers.split(delimiter);
		List<Integer> numbersLowerThanZero = new ArrayList<Integer>();

		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				int numberInt = Integer.parseInt(number.trim());
				if (numberInt < 0) {
					numbersLowerThanZero.add(numberInt);
				} else if (numberInt <= 1000) {	
					valueToReturn += numberInt;
				}
			}
		}
		if (numbersLowerThanZero.size() > 0) {
			throw new RuntimeException("Numbers cannot be lower than 0: " + numbersLowerThanZero.toString());
		}
		return valueToReturn;		
	}
	
}