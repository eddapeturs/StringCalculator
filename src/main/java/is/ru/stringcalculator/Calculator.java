package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//")){
			if(text.contains("][")){
				return sum(multiDel(text));
			}
			else{
			return sum(delimiter(text));
			}
		}
		if(text.contains("-")){
			return negatives(splitNumbers(text));	
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
	private static int negatives(String[] numbers){
		String neg = "";
		for(String number : numbers){
			if(toInt(number) < 0){
			neg = neg.concat(number + ",");
			}
		}
		
		if(!neg.equals(""))	throw new RuntimeException("Negatives not allowed: " + neg.substring(0,neg.length()-1));
		
		return 0;
	}
	private static String[] multiDel(String numbers){
		int indexN = numbers.indexOf('\n');
		int first = numbers.indexOf(']');
		String d = numbers.substring(2, first);
		for (int i = first; i < indexN; i++){
			if(numbers.charAt(i) == '['){
				d += "|\\" + numbers.substring(i+1, numbers.indexOf(']', i));
			}
		}
		numbers = numbers.substring(indexN + 1);
		return numbers.split(d + "]");

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
			if(number.equals("")) continue;
			if(toInt(number) <= 1000){
		    total += toInt(number);
			}
		}
		return total;
    }


}
