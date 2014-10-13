package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//")){
			return sum(delimiter(text));
		}
		if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] delimiter(String numbers){	
		int indexN = numbers.indexOf('\n');
		String d = numbers.substring(2, indexN);
		numbers  = numbers.substring(indexN + 1, numbers.length());
		return numbers.split(d);	
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}
