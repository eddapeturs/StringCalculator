package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//")){
			return sum(delimiter(text));
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
		/*	String[] negatives = new String[10];
			//for(int i = 0; i < numbers.length(); i++){
			//int kanban = numbers.indexOf('-');
			negatives
			for(String number : numbers){
				if(toInt(number) < 0){
					negatives
			}
			negatives = splitNum

			}
			
			string bla = numbers.substring(1);
			negative = Integer.par*/
		String neg = "";
		for(String number : numbers){
			if(toInt(number) < 0){
			neg = neg.concat(number + ",");
			}
		}
		
		if(!neg.equals(""))	throw new RuntimeException("Negatives not allowed: " + neg.substring(0,neg.length()-1));
		
		return 0;
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
